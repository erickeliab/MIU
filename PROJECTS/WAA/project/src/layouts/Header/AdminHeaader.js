import React from 'react';
import './header.css';
import { useDispatch, useSelector } from 'react-redux';
import { authActions } from '../../store/index';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router';
import Cookies from 'js-cookie';

const AdminHeader = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const isAuthenticated = useSelector(state => state.auth.isAuthenticated); 

  const logoutHandler = () => {
    dispatch(authActions.logout());
    navigate('/login');
  };



  const guestLinks = (
    <>
      
        <Link to="/login">Login</Link>
    
    
        <Link to="/register">Register</Link>
    
    
        <Link to="/seller-register">Seller Register</Link>
     
    </>
  );

  const authLinks = (
    <>
      
        <Link to="/dashboard">Dashboard</Link>
      
      {/* <li>
        <Link to="/counter">Counter</Link>
      </li> */}
      {(Cookies.get('role') == 'SELLER') ? <>  <Link to="/seller/products"> Products</Link>
     
     <Link to="/seller/orders"> Orders</Link>
 
     <Link to="/seller/inventory"> Inventory</Link> </> :  <> </>}
       
      

     {(Cookies.get('role') == 'ADMIN') ? <> <Link to="/admin/salers"> Salers</Link>
      
      <Link to="/admin/reviews"> Reviews</Link> </> :  <> </>}
        
     
     
    
        <li className='mt-4'>
        <button onClick={logoutHandler}>Logout</button>
        </li>
        
    
    </>
  );


  const template = (
    <>

<nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a className="navbar-brand" href="#">E commerce <small className='tag bg-warning text-light p-1'>{Cookies.get('role')}</small></a>
    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon">  </span>
    </button>
    <div className="collapse navbar-collapse" id="navbarResponsive">
      <ul className="navbar-nav ml-auto">
        <li className="nav-item">
          <Link className="nav-link" to="/">Home</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link" to="/products">Products</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link" to="/salers">Salers</Link>
        </li>
   
      </ul>
    </div>
  </nav>

    <div class="sidebar">

        {isAuthenticated ? authLinks : guestLinks}
    </div>

   
    </>
  )

 
  return (
    template

  );
};

export default AdminHeader;
