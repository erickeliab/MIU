import React from 'react';
import { Link } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { authActions } from '../../store';
import { useNavigate } from 'react-router-dom';
import Cookies from 'js-cookie';
export default function Navbar() {


    const dispatch = useDispatch();
    const navigate = useNavigate();
    const isAuthenticated = useSelector(state => state.auth.isAuthenticated); 


    const logoutHandler = () => {
        dispatch(authActions.logout());
        navigate('/login');
      };

    
  return (
    <nav className="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
      <Link to="/" className="text-decoration-none d-block d-lg-none">
        <h1 className="m-0 display-5 font-weight-semi-bold">
          <span className="text-primary font-weight-bold border px-3 mr-1">Book</span>
          Shop
        </h1>
      </Link>
      <button type="button" className="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse justify-content-between" id="navbarCollapse">
        <div className="navbar-nav mr-auto py-0">
          <Link to="/" className="nav-item nav-link active">Home</Link>
          <Link to="/products" className="nav-item nav-link">Products</Link>
          <Link to="/salers" className="nav-item nav-link">Sellers</Link>
          <Link to="/about" className="nav-item nav-link">About</Link>
          
          <Link to="/contact" className="nav-item nav-link">Contact</Link>
          </div>


          {(isAuthenticated && Cookies.get('role') == 'SELLER') || (isAuthenticated && Cookies.get('role') == 'ADMIN')  ? <> <div className="navbar-nav mr-auto py-0">
          <Link to="/dashboard" className="dropdown-item">Dashboard</Link>
          
        </div>
        <div className="navbar-nav ml-auto py-0">
          <Link onClick={logoutHandler} className="nav-item nav-link">Logout</Link>
        
        </div></>  : 
        <></>}

          {isAuthenticated && Cookies.get('role') == 'BUYER' ? <> <div className="navbar-nav mr-auto py-0">
          <Link to="/buyer/cart" className="dropdown-item">Shopping Cart</Link>
          
          <Link to="/buyer/checkout" className="dropdown-item">Checkout</Link>
     
        <Link to="/buyer/orders" className="dropdown-item">Orders</Link>
        
        </div>
        <div className="navbar-nav ml-auto py-0">
          <Link onClick={logoutHandler} className="nav-item nav-link">Logout</Link>
        
        </div></>  : <></>
        }
          

          {!isAuthenticated ? <div className="navbar-nav ml-auto py-0">
          <Link to="/login" className="nav-item nav-link">Login</Link>
          <Link to="/register" className="nav-item nav-link">Register</Link>
          <Link to="/seller-register" className="nav-item nav-link">Register Shop</Link>
        </div>  : 
        <></>}
          
      </div>
    </nav>
  );
}
