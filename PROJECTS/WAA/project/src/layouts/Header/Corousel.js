import React from 'react';
import './header.css';
import { useDispatch, useSelector } from 'react-redux';
import { authActions } from '../../store/index';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router';

const Corousel = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const isAuthenticated = useSelector(state => state.auth.isAuthenticated); 

  const logoutHandler = () => {
    dispatch(authActions.logout());
    navigate('/login');
  };


  const template = (
    <>
      <div id="header-carousel" className="carousel slide" data-ride="carousel">
              <div className="carousel-inner">
                <div className="carousel-item active" style={{ height: '410px' }}>
                  <img className="img-fluid" src="img/carousel-1.jpg" alt="Image" />
                  <div className="carousel-caption d-flex flex-column align-items-center justify-content-center">
                    <div className="p-3" style={{ maxWidth: '700px' }}>
                      <h4 className="text-light text-uppercase font-weight-medium mb-3">10% Off Your First Order</h4>
                      <h3 className="display-4 text-white font-weight-semi-bold mb-4">Fashionable Dress</h3>
                      <a href="" className="btn btn-light py-2 px-3">Shop Now</a>
                    </div>
                  </div>
                </div>
                <div className="carousel-item" style={{ height: '410px' }}>
                  <img className="img-fluid" src="img/carousel-2.jpg" alt="Image" />
                  <div className="carousel-caption d-flex flex-column align-items-center justify-content-center">
                    <div className="p-3" style={{ maxWidth: '700px' }}>
                      <h4 className="text-light text-uppercase font-weight-medium mb-3">10% Off Your First Order</h4>
                      <h3 className="display-4 text-white font-weight-semi-bold mb-4">Reasonable Price</h3>
                      <a href="" className="btn btn-light py-2 px-3">Shop Now</a>
                    </div>
                  </div>
                </div>
              </div>
              <a className="carousel-control-prev" href="#header-carousel" data-slide="prev">
                <div className="btn btn-dark" style={{ width: '45px', height: '45px' }}>
                  <span className="carousel-control-prev-icon mb-n2"></span>
                </div>
              </a>
              <a className="carousel-control-next" href="#header-carousel" data-slide="next">
                <div className="btn btn-dark" style={{ width: '45px', height: '45px' }}>
                  <span className="carousel-control-next-icon mb-n2"></span>
                </div>
              </a>
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

export default Corousel;
