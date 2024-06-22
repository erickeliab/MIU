import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../../../layouts/Styles/SiteStyles.css';
import Header from '../../../layouts/Header/Header';
import { useDispatch } from 'react-redux';
import { cartCountsActions } from '../../../store';
import { Link } from 'react-router-dom';
import Cookies from 'js-cookie';

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [shownQuantities, setShownQuantities] = useState({});

  const buyerId = JSON.parse(Cookies.get('user')).id; // Use buyerId from Cookies
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
          stockQuantity: product.stockQuantity
        };
      });

      setCartItems(cartItemsWithDetails);
      setShownQuantities(cartItemsWithDetails.reduce((acc, item) => {
        acc[item.productId] = item.quantity;
        return acc;
      }, {}));
      setLoading(false);
    } catch (error) {
      setError('Failed to fetch cart items');
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchCartItems();
  }, [buyerId]);

  useEffect(() => {
    calculateTotal(cartItems);
  }, [cartItems]);

  const calculateTotal = (items) => {
    const total = items.reduce((acc, item) => acc + item.price * item.quantity, 0);
    setTotalPrice(total);
  };

  const updateCartItem = async (productId, newQuantity) => {
    try {
      const response = await fetch(`http://localhost:8081/api/buyers/cart/items/${productId}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ buyerId, productId, quantity: newQuantity }),
      });

      if (response.ok) {
        setCartItems(prevItems => 
          prevItems.map(item => 
            item.productId === productId ? { ...item, quantity: newQuantity } : item
          )
        );
        newQuantity > 0 ? incrementHandler() : decrementHandler();
      }
    } catch (error) {
      alert('Failed to update item in cart:', error);
    }
  };

  const handleRemoveItem = async (itm) => {
    try {
      const response = await axios.delete(`http://localhost:8081/api/buyers/cart/items/${itm.id}`, {
        headers: { 'Content-Type': 'application/json' },
        params: { buyerId },
      });
      if (response.status === 200) {
        setCartItems(cartItems => cartItems.filter(item => item.productId !== itm.productId));
        setShownQuantities(prevQuantities => {
          const newQuantities = { ...prevQuantities };
          delete newQuantities[itm.productId];
          return newQuantities;
        });
        decrementHandler();
      }
    } catch (error) {
      alert('Failed to remove item from cart:');
    }
  };

  const handleQuantityChange = (id, change) => {
    const item = cartItems.find(item => item.productId === id);
    if (!item) return;

    const newQuantity = item.quantity + change;
    if (newQuantity > item.stockQuantity) {
      alert("Quantity exceeds stock availability");
      return;
    }

    if (newQuantity < 1) {
      handleRemoveItem(item);
    } else {
      setShownQuantities(prevQuantities => ({
        ...prevQuantities,
        [id]: newQuantity
      }));
      updateCartItem(item.id, newQuantity);
    }
  };

  if (loading) {
    return <p>Loading...</p>;
  }

  if (Cookies.get('role') !== 'BUYER') {
    window.location.replace("/");
    return <>Redirecting......</>;
  }

  return (
    <>
      <Header />
      <div className="container-fluid pt-5">
        <div className="row px-xl-5">
          <div className="col-lg-8 table-responsive mb-5">
            <table className="table table-bordered text-center mb-0">
              <thead className="bg-secondary text-dark">
                <tr>
                  <th>Products</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>Total</th>
                  <th>Remove</th>
                </tr>
              </thead>
              <tbody className="align-middle">
                {cartItems.map((item) => (
                  <tr key={item.productId}>
                    <td className="align-middle">{item.name}</td>
                    <td className="align-middle">${item.price.toFixed(2)}</td>
                    <td className="align-middle">
                      <div className="input-group quantity mx-auto" style={{ width: '100px' }}>
                        <div className="input-group-btn">
                          <button className="btn btn-sm btn-primary btn-minus" onClick={() => handleQuantityChange(item.productId, -1)}>
                            <i className="fa fa-minus"></i>
                          </button>
                        </div>
                        <div className="form-control form-control-sm bg-secondary text-center">{shownQuantities[item.productId]}</div>
                        <div className="input-group-btn">
                          <button className="btn btn-sm btn-primary btn-plus" onClick={() => handleQuantityChange(item.productId, 1)}>
                            <i className="fa fa-plus"></i>
                          </button>
                        </div>
                      </div>
                    </td>
                    <td className="align-middle">${(item.price * item.quantity).toFixed(2)}</td>
                    <td className="align-middle">
                      <button className="btn btn-sm btn-primary" onClick={() => handleRemoveItem(item)}>
                        <i className="fa fa-times"></i>
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          <div className="col-lg-4">
            <div className="card border-secondary mb-5">
              <div className="card-header bg-secondary border-0">
                <h4 className="font-weight-semi-bold m-0">Cart Summary</h4>
              </div>
              <div className="card-body">
                <div className="d-flex justify-content-between mb-3 pt-1">
                  <h6 className="font-weight-medium">Subtotal</h6>
                  <h6 className="font-weight-medium">${totalPrice.toFixed(2)}</h6>
                </div>
                <div className="d-flex justify-content-between">
                  <h6 className="font-weight-medium">Shipping</h6>
                  <h6 className="font-weight-medium">$10.00</h6>
                </div>
              </div>
              <div className="card-footer border-secondary bg-transparent">
                <div className="d-flex justify-content-between mt-2">
                  <h5 className="font-weight-bold">Total</h5>
                  <h5 className="font-weight-bold">${(totalPrice + 10).toFixed(2)}</h5>
                </div>
                <Link to="/buyer/checkout">
                  <button className="btn btn-block btn-primary my-3 py-3">Proceed To Checkout</button>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Cart;
