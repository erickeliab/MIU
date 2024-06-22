import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';
import Cookies from 'js-cookie';

const Billing = () => {
  const [billingInfo, setBillingInfo] = useState({
    charges: [],
    paymentMethod: '',
    billingAddress: '',
  });

  const template = (<div class="content">
    <h2>Checkout</h2>
    <div class="card mt-4">
        <div class="card-body">
            <h4>Billing Details</h4>
            <form id="checkoutForm">
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" class="form-control" id="fullName" required/>
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" class="form-control" id="email" required/>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" required/>
                </div>
                <div class="form-group">
                    <label for="city">City</label>
                    <input type="text" class="form-control" id="city" required/>
                </div>
                <div class="form-group">
                    <label for="zipCode">Zip Code</label>
                    <input type="text" class="form-control" id="zipCode" required/>
                </div>
                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="text" class="form-control" id="phone" required/>
                </div>
                <div class="form-group">
                    <label for="paymentMethod">Payment Method</label>
                    <select class="form-control" id="paymentMethod" required>
                        <option value="">Select Payment Method</option>
                        <option value="creditCard">Credit Card</option>
                        <option value="paypal">PayPal</option>
                        <option value="bankTransfer">Bank Transfer</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">Place Order</button>
            </form>
        </div>
    </div>
</div>
)

  useEffect(() => {
    const fetchBillingInfo = async () => {
      try {
        const response = await axios.get('/user/billing');
        setBillingInfo({
          charges: response.data.charges,
          paymentMethod: response.data.paymentMethod,
          billingAddress: response.data.billingAddress,
        });
      } catch (error) {
        alert('Failed to fetch billing info:', error);
        // Handle error appropriately
      }
    };

    fetchBillingInfo();
  }, []);



  if (Cookies.get('role') !== 'BUYER') {
        
    window.location.replace("/dashboard")

    return <>Redirecting......</>
}

  return (
    <>
    <AdminHeader />
    {template}
    {/* <div className="billing-page">
      <h2>Billing</h2>
      <section className="billing-summary">
        <h3>Summary of Charges</h3>
        <ul>
          {billingInfo.charges.map((charge, index) => (
            <li key={index}>
              <span>{charge.description}: </span>
              <span>${charge.amount.toFixed(2)}</span>
            </li>
          ))}
        </ul>
      </section>
      <section className="payment-method">
        <h3>Payment Method</h3>
        <p>{billingInfo.paymentMethod}</p>
      </section>
      <section className="billing-address">
        <h3>Billing Address</h3>
        <p>{billingInfo.billingAddress}</p>
      </section>
    </div> */}
    </>
  );
};

export default Billing;
