import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../../../layouts/Styles/SiteStyles.css';

import { useDispatch } from 'react-redux';
import { cartCountsActions } from '../../../store';
import Cookies from 'js-cookie';

const CartDetails = ({ setParentTotal, setProducts, setCartItemsFromCh }) => {
  const [cartItems, setCartItems] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const buyerId = JSON.parse(Cookies.get('user')).id;
  const dispatch = useDispatch();

  const incrementHandler = () => {
    dispatch(cartCountsActions.increment());
  };

  const decrementHandler = () => {
    dispatch(cartCountsActions.decrement());
  };

  const fetchCartItems = async () => {
    setLoading(true);
    setError(null);

    try {
      const response = await axios.get(`http://localhost:8081/api/buyers/cart?buyerId=${buyerId}`);
      const cartData = response.data.cartItems;

      const productIds = cartData.map(item => item.productId);
      const productResponse = await axios.get('http://localhost:8081/api/products');
      const productData = productResponse.data.filter(product => productIds.includes(product.id));

      const cartItemsWithDetails = cartData.map(cartItem => {
        const product = productData.find(p => p.id === cartItem.productId);
        return {
          ...cartItem,
          name: product.name,
          price: product.price,
          image: product.image,
          stock: product.stock
        };
      });

      setCartItems(cartItemsWithDetails);
      setCartItemsFromCh(cartItemsWithDetails);
      setProducts(cartItemsWithDetails.map(item => ({ id: item.productId, quantity: item.quantity })));

      const total = cartItemsWithDetails.reduce((sum, item) => sum + item.price * item.quantity, 0);
      setTotalPrice(total);
      setParentTotal(total);

      setLoading(false);
    } catch (error) {
        alert('Error fetching cart items:');
      setError('Error fetching cart items. Please try again later.');
      setLoading(false);
    }
  };

  const updateCart = async (productId, quantity) => {
    try {
      const response = await axios.post(`http://localhost:8081/api/buyers/cart`, {
        buyerId,
        productId,
        quantity
      });

      if (response.data.success) {
        fetchCartItems();
        if (quantity > 0) incrementHandler();
        else decrementHandler();
      }
    } catch (error) {
        alert('Error updating cart:');
      setError('Error updating cart. Please try again later.');
    }
  };

  const handleQuantityChange = (productId, quantity) => {
    updateCart(productId, quantity);
  };

  const handleRemoveItem = (productId) => {
    updateCart(productId, 0);
  };

  useEffect(() => {
    fetchCartItems();
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>{error}</p>;
  }

  return (
    <div>
      <div className="card-body">
        {cartItems.map(item => (
          <div key={item.productId} className="d-flex justify-content-between align-items-center mb-4">
            <div className="d-flex align-items-center">
              <img src={item.image} alt={item.name} style={{ width: '50px', marginRight: '10px' }} />
              <div>
                <h6>{item.name}</h6>
                <p>${item.price}</p>
              </div>
            </div>
            <div className="d-flex align-items-center">
              
            </div>
          </div>
        ))}
      </div>
      <div className="card-footer border-secondary bg-transparent">
        <div className="d-flex justify-content-between mt-2">
          <h5 className="font-weight-bold">Total</h5>
          <h5 className="font-weight-bold">${totalPrice.toFixed(2)}</h5>
        </div>
      </div>
    </div>
  );
};

export default CartDetails;
