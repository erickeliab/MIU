import React from 'react';
import './header.css';
import { useDispatch, useSelector } from 'react-redux';
import { authActions } from '../../store/index';
import { Link } from 'react-router-dom';
import { useLocation, useNavigate } from 'react-router';
import Topbar from './Topbar';
import Navbar from './Navbar';
import Filter from './Filter';
import Corousel from './Corousel';

const Header = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const isAuthenticated = useSelector(state => state.auth.isAuthenticated); 
  const location = useLocation();
  const logoutHandler = () => {
    dispatch(authActions.logout());
    navigate('/login');
  };


  const template = (
    <>
      
    <Topbar />
      <div className="container-fluid mb-5">
        <div className="row border-top px-xl-5">
        {(location.pathname == '/') &&  <Filter />}
        
          <div className="col-lg-9">
            
            <Navbar />
            {location.pathname == '/' && <Corousel />}
          </div>
        </div>
      </div>
    </>
  );

  

  const guestLinks = (
    <>
      <li>
        <Link to="/login">Login</Link>
      </li>
      <li>
        <Link to="/register">Register</Link>
      </li>
      <li>
        <Link to="/seller-register">Seller Register</Link>
      </li>
    </>
  );

  const authLinks = (
    <>
      <li>
        <Link to="/dashboard">Dashboard</Link>
      </li>
      {/* <li>
        <Link to="/counter">Counter</Link>
      </li> */}
      <li>
        <Link to="/profile">Profile</Link>
      </li>
      <li>
        <Link to="/seller/products">Seller Products</Link>
      </li>
      <li>
        <Link to="/seller/orders">Seller Orders</Link>
      </li>
      <li>
        <Link to="/seller/inventory">Seller Inventory</Link>
      </li>
      <li>
        <Link to="/admin/salers">Admin Salers</Link>
      </li>
      <li>
        <Link to="/admin/reviews">Admin Review</Link>
      </li>
      <li>
        <Link to="/buyer/orders">Buyer Orders</Link>
      </li>
      <li>
        <Link to="/buyer/cart">Buyer Cart</Link>
      </li>
      <li>
        <Link to="/buyer/checkout">Buyer Checkout</Link>
      </li>
      <li>
        <Link to="/buyer/billing">Buyer Billing</Link>
      </li>
      <li>
        <button onClick={logoutHandler}>Logout</button>
      </li>
    </>
  );

  return template;

  return (
    <nav>
      <header className="header">
        <h1>Ecommerce</h1>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/products">Products</Link>
          </li>
          <li>
            <Link to="/salers">Salers</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
          {isAuthenticated ? authLinks : guestLinks}
        </ul>
      </header>
    </nav>
  );
};

export default Header;
