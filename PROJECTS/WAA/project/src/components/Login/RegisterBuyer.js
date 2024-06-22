import React, { useRef, useState } from 'react';
import "../../layouts/Styles/SiteStyles.css";
import { useDispatch } from 'react-redux';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import { authActions } from '../../store/index';

const BuyerRegister = (props) => {
  const navigate = useNavigate();
  const location = useLocation();
  const from = "/login";
  const dispatch = useDispatch();
  const formData = useRef();
  const errRef = useRef();
  const [errMsg, setErrMsg] = useState('');
  const [successMsg, setSuccessMsg] = useState('');

  const registerHandler = async (e) => {
    e.preventDefault();
    setErrMsg(''); // Reset error message
    setSuccessMsg(''); // Reset success message
    const form = formData.current;
    const username = form['username'].value;
    const email = form['email'].value;
    const password = form['password'].value;
    const repeatPassword = form['repeat-password'].value;
    const shippingAddress = form['shipping-address'].value;
    const billingAddress = form['billing-address'].value;

    if (password !== repeatPassword) {
      setErrMsg('Passwords do not match');
      return;
    }

    const buyerData = {
      username,
      email,
      password,
      phoneNumber: "123-456-7890", // Example data, you might want to get this from a form input
      firstname: "John", // Example data, you might want to get this from a form input
      lastname: "Doe", // Example data, you might want to get this from a form input
      shippingAddress,
      billingAddress
    };

    try {
      const res = await axios.post('http://localhost:8081/api/buyers/register', buyerData);

      const { id, username: registeredUsername, email: registeredEmail, role } = res.data;

      // dispatch(authActions.loginSuccessful());
      // setSuccessMsg('Registration successful!');
      setTimeout(() => {
        navigate(from, { replace: true });
      }, 2000);

    } catch (err) {
      if (!err?.response) {
        setErrMsg('No Server Response');
      } else if (err.response?.status === 400) {
        setErrMsg('Missing Username or Password');
      } else if (err.response?.status === 401) {
        setErrMsg('Unauthorized');
      } else {
        setErrMsg('Registration Failed');
      }
    }
  };

  return (
    <div className="login-container" style={loginStyle}>
      <div className="card border-secondary mb-5" style={{ width: 500 }}>
        <div className="card-header bg-secondary border-0">
          <h4 className="font-weight-semi-bold m-0">Buyer Registration</h4>
        </div>
        <div className="card-body">
          <form ref={formData} onSubmit={registerHandler}>
            <div className="form-group">
              <label htmlFor='username'>Username</label>
              <input type='text' id='username' className="form-control" required />
            </div>
            <div className="form-group">
              <label htmlFor='email'>Email</label>
              <input type='email' id='email' className="form-control" required />
            </div>
            <div className="form-group">
              <label htmlFor='password'>Password</label>
              <input type='password' id='password' className="form-control" required />
            </div>
            <div className="form-group">
              <label htmlFor='repeat-password'>Repeat Password</label>
              <input type='password' id='repeat-password' className="form-control" required />
            </div>
            <div className="form-group">
              <label htmlFor='shipping-address'>Shipping Address</label>
              <input type='text' id='shipping-address' className="form-control" required />
            </div>
            <div className="form-group">
              <label htmlFor='billing-address'>Billing Address</label>
              <input type='text' id='billing-address' className="form-control" required />
            </div>
            <button className="btn btn-primary btn-block">Register</button>
            {errMsg && <p ref={errRef} className="error-message">{errMsg}</p>}
            {successMsg && <p ref={errRef} className="success-message">{successMsg}</p>}
          </form>
        </div>
      </div>
    </div>
  );
};

const loginStyle = {
  display: "flex",
  justifyContent: "center",
  alignItems: "center",
  height: "90vh"
}

export default BuyerRegister;
