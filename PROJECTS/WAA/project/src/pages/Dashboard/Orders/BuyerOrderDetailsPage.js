import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../../../layouts/Styles/SiteStyles.css';

import Header from '../../../layouts/Header/Header';
import { Link, useParams } from 'react-router-dom';
import Cookies from 'js-cookie';

const BuyerOrderDetailsPage = () => {
  const [order, setOrder] = useState(null);
  const [totalPrice, setTotalPrice] = useState(0);
  const { id } = useParams();

  useEffect(() => {
    const buyerId = JSON.parse(Cookies.get('user')).id;
    axios.get(`http://localhost:8081/api/buyers/orders?buyerId=${buyerId}`)
      .then(response => {
        const orderDetails = response.data.find(order => order.id === parseInt(id));
        setOrder(orderDetails);
        calculateTotalPrice(orderDetails.orderItems);
      })
      .catch(error => {
        alert('There was an error fetching the order items!');
      });
  }, [id]);

  // Calculate total price
  const calculateTotalPrice = (items) => {
    const total = items.reduce((acc, item) => acc + item.price * item.quantity, 0);
    setTotalPrice(total);
  };

  // Handle quantity change
  const handleQuantityChange = (index, newQuantity) => {
    const updatedItems = [...order.orderItems];
    updatedItems[index].quantity = newQuantity;
    setOrder(prevOrder => ({ ...prevOrder, orderItems: updatedItems }));
    calculateTotalPrice(updatedItems);
  };

  // Handle remove item
  const handleRemoveItem = (index) => {
    const updatedItems = order.orderItems.filter((_, i) => i !== index);
    setOrder(prevOrder => ({ ...prevOrder, orderItems: updatedItems }));
    calculateTotalPrice(updatedItems);
  };

  if (Cookies.get('role') !== 'BUYER') {
    window.location.replace("/dashboard");
    return <>Redirecting......</>;
  }

  if (!order) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <Header />
      <div className="container-fluid pt-5">
        <div className="row px-xl-5">
          <div className="col-lg-10 table-responsive mb-5">
            <table className="table table-bordered text-center mb-0">
              <thead className="bg-secondary text-dark">
                <tr>
                  <th>Product No</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>Total</th>
                </tr>
              </thead>
              <tbody className="align-middle">
                {order.orderItems.map((item, index) => (
                  <tr key={index}>
                    <td className="align-middle">{index+1}</td>
                    <td className="align-middle">${item.price}</td>
                    <td className="align-middle">
                      <div className="input-group quantity mx-auto" style={{ width: '100px' }}>
                        <input 
                          type="text" 
                          className="form-control form-control-sm bg-secondary text-center" 
                          value={item.quantity} 
                          readOnly 
                        />
                      </div>
                    </td>
                    <td className="align-middle">${item.price * item.quantity}</td>
                  </tr>
                ))}
              </tbody>
            </table>
            <div className="row justify-content-end mt-3">
              <div className="col-lg-4">
                <h5>Total: ${totalPrice}</h5>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default BuyerOrderDetailsPage;
