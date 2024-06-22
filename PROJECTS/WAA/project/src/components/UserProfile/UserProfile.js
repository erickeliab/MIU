import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useSelector } from 'react-redux';
import './userProfile.css';

const UserProfile = () => {
  const counter = useSelector(state => state.counter.counter);
  const [userDetails, setUserDetails] = useState({
    name: 'Erick',
    address: 'Iowa, Fairfield'
  });

  useEffect(() => {
    const fetchUserProfile = async () => {
      try {
        const response = await axios.get('/user/profile');
        setUserDetails({
          name: response.data.name,
          address: response.data.address
        });
      } catch (error) {
        alert('Failed to fetch user profile:', error);
        // Handle error appropriately
      }
    };

    fetchUserProfile();
  }, []);

  return (
    <React.Fragment>
      <main className="card">
        <h2>My User Profile</h2>
        {/* <p>Your current count is: {counter}</p> */}
        <h3>User Details</h3>
        <p>Name: {userDetails.name}</p>
        <p>Address: {userDetails.address}</p>
        {/* <Products products={productsState} /> */}
      </main>
    </React.Fragment>
  );
};

export default UserProfile;
