import React, { useState } from 'react';
import '../../../layouts/AdminStyles.css';
import Header from '../../../layouts/Header/Header';
import CartDetails from '../Cart/CartDetails';
import Cookies from 'js-cookie';
import jsPDF from 'jspdf';

const Checkout = () => {
  const [parentTotal, setParentTotal] = useState(0);
  const [products, setProducts] = useState([]);
  const [cartItems, setCartItems] = useState([]);
  const [billingDetails, setBillingDetails] = useState({
    name: '',
    address: '',
    city: '',
    state: '',
    zip: ''
  });

  const [paymentDetails, setPaymentDetails] = useState({
    cardNumber: '',
    expirationDate: '',
    cvv: ''
  });

  const handleBillingChange = (e) => {
    const { name, value } = e.target;
    setBillingDetails(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handlePaymentChange = (e) => {
    const { name, value } = e.target;
    setPaymentDetails(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // Collect all order details
    const orderDetails = {
      buyerId: JSON.parse(Cookies.get("user")).id, // Assuming you have the buyerId available
      billingAddress: JSON.stringify(billingDetails),
      shippingAddress: JSON.stringify(billingDetails),
      paymentDetails,
      total: parentTotal + 10, // Assuming an additional fixed charge (like shipping)
      orderItems: products.map(product => ({
        productId: product.id,
        quantity: product.quantity
      }))
    };

    try {
      const response = await fetch('http://localhost:8081/api/buyers/orders', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(orderDetails),
      });

      if (response.ok) {
        alert('Order placed successfully');
        // Handle success (e.g., show a success message, redirect to a confirmation page, etc.)
        generatePDF(orderDetails); // Call generatePDF on successful order placement
      } else {

        alert('Failed to place order');
        // Handle error (e.g., show an error message)
      }
    } catch (error) {
       alert('Error placing order:');
    }
  };

  const generatePDF = (orderDetails) => {
    const doc = new jsPDF();
    doc.text('Order Receipt', 10, 10);
    doc.text(`Name: ${billingDetails.name}`, 10, 20);
    doc.text(`Address: ${billingDetails.address}`, 10, 30);
    doc.text(`City: ${billingDetails.city}`, 10, 40);
    doc.text(`State: ${billingDetails.state}`, 10, 50);
    doc.text(`ZIP: ${billingDetails.zip}`, 10, 60);
    doc.text(`Total: $${(parentTotal + 10).toFixed(2)}`, 10, 70);
    doc.text('Order Items:', 10, 80);
    cartItems.forEach((product, index) => {
      doc.text(`${product.name} - Quantity: ${product.quantity}`, 10, 90 + (index * 10));
    });
    doc.save('receipt.pdf');
  };

  if (Cookies.get('role') !== 'BUYER') {
    window.location.replace("/");
    return <>Redirecting......</>
  }

  return (
    <>
      <Header />
      <div className="container-fluid pt-5">
        <div className="row px-xl-5">
          <div className="col-lg-8">
            <div className="mb-4">
              <h4 className="font-weight-semi-bold mb-4">Billing Address</h4>
              <div className="row">
                {[
                  { label: "First Name", name: "name" },
                  { label: "Address Line", name: "address" },
                  { label: "City", name: "city" },
                  { label: "State", name: "state" },
                  { label: "ZIP Code", name: "zip" }
                ].map((field, index) => (
                  <div className="col-md-6 form-group" key={index}>
                    <label>{field.label}</label>
                    <input
                      className="form-control"
                      type="text"
                      name={field.name}
                      value={billingDetails[field.name]}
                      onChange={handleBillingChange}
                    />
                  </div>
                ))}
              </div>
            </div>

            <div className="mb-4">
              <h4 className="font-weight-semi-bold mb-4">Payment Details</h4>
              <div className="row">
                {[
                  { label: "Card Number", name: "cardNumber" },
                  { label: "Expiration Date", name: "expirationDate" },
                  { label: "CVV", name: "cvv" }
                ].map((field, index) => (
                  <div className="col-md-6 form-group" key={index}>
                    <label>{field.label}</label>
                    <input
                      className="form-control"
                      type="text"
                      name={field.name}
                      value={paymentDetails[field.name]}
                      onChange={handlePaymentChange}
                    />
                  </div>
                ))}
              </div>
            </div>

            <div className="mb-4">
              <h4 className="font-weight-semi-bold mb-4">Order Total</h4>
              <div className="d-flex justify-content-between">
                <h6 className="font-weight-medium">Total:</h6>
                <h6 className="font-weight-medium">${(parentTotal + 10).toFixed(2)}</h6>
              </div>
              <button className="btn btn-primary w-100 mt-3" onClick={handleSubmit}>
                Place Order
              </button>
            </div>
          </div>

          <div className="col-lg-4">
            <div className="card border-secondary mb-5">
              <div className="card-header bg-secondary border-0">
                <h4 className="font-weight-semi-bold m-0">Cart Summary</h4>
              </div>
              <div className="card-body col-12">
                <CartDetails setParentTotal={setParentTotal} setProducts={setProducts} setCartItemsFromCh={setCartItems} />
              </div>
              <div className="card-footer border-secondary bg-transparent">
                <div className="d-flex justify-content-between mt-2">
                  <h5 className="font-weight-bold">Total</h5>
                  <h5 className="font-weight-bold">${(parentTotal + 10).toFixed(2)}</h5>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Checkout;
