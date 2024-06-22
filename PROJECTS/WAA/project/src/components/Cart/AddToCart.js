import React from 'react';
import { useDispatch } from 'react-redux';
import { cartCountsActions } from '../../store';
import Cookies from 'js-cookie';

export default function AddToCart({ productId }) {
  const dispatch = useDispatch();

  const handleAddToCart = async () => {
    try {
      const response = await fetch('http://localhost:8081/api/buyers/cart/items', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          buyerId: JSON.parse(Cookies.get('user')).id,
          productId: productId,
          quantity: 1, // assuming we're adding 1 item at a time
        }),
      });

      if (response.ok) {
        const result = await response.json();
        dispatch(cartCountsActions.increment());
        alert('Item added to cart: ' + result.message);
      } else {
        const errorData = await response.json();
        alert('Error adding item to cart: ' + JSON.parse(Cookies.get('user')).id);
      }
    } catch (error) {
      alert('Error adding item to cart: ' + JSON.parse(Cookies.get('user')).id);
    }
  };

  if (Cookies.get('role') === 'SELLER' || Cookies.get('role') === 'ADMIN') {
    return (
      <button className="btn btn-sm text-dark p-0" disabled>
        <i className="fas fa-shopping-cart text-primary mr-1"></i>
        Add To Cart
      </button>
    );
  }

  return (
    <button onClick={handleAddToCart} className="btn btn-sm text-dark p-0">
      <i className="fas fa-shopping-cart text-primary mr-1"></i>
      Add To Cart
    </button>
  );
}
