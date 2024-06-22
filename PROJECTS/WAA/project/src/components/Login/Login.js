import React, { useRef, useState } from 'react';
import "../../layouts/Styles/SiteStyles.css";
import { useDispatch } from 'react-redux';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import Cookies from 'js-cookie';
import { authActions } from '../../store/index';

const Login = (props) => {

  const navigate = useNavigate();
  const location = useLocation();
  
  const from = "/dashboard";

  const dispatch = useDispatch();
  const formData = useRef();

  const errRef = useRef();
  const [errMsg, setErrMsg] = useState('');

  const loginHandler = async (e) => {
    e.preventDefault();
    try {
      const form = formData.current
      const userCredentials = { email: form['user'].value, password: form['password'].value };
     
      const res = await axios.post('http://localhost:8081/api/v1/authenticate', userCredentials);
      const accessToken = res.data.accessToken;
      dispatch(authActions.loginSuccessful());
      Cookies.set('token', accessToken);
      Cookies.set('role', res.data.roles[0]);
      // Assuming res.data is an object
      Cookies.set('user', JSON.stringify(res.data));
       alert("Log in Succesfully")

      navigate(from, { replace: true });

    } catch (err) {
      if (!err?.response) {
        setErrMsg('No Server Response');
      } else if (err.response?.status === 400) {
        setErrMsg('Missing Username or Password');
      } else if (err.response?.status === 401) {
        setErrMsg('Unauthorized');
      } else {
        setErrMsg('Login Failed');
      }
      // errRef.current.focus();
    }
  };

  return (
    <div className="login-container" style={loginStyle}>
      <div className="card border-secondary mb-5" style={{width:500}}>
        <div className="card-header bg-secondary border-0">
          <h4 className="font-weight-semi-bold m-0">Login</h4>
        </div>
        <div className="card-body">
          <form ref={formData} onSubmit={loginHandler}>
            <div className="form-group">
              <label htmlFor='user'>User</label>
              <input type='text' id='user' className="form-control" />
            </div>
            <div className="form-group">
              <label htmlFor='password'>Password</label>
              <input type='password' id='password' className="form-control" />
            </div>
            <button className="btn btn-primary btn-block">Login</button>
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

export default Login;
