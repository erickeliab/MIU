import React, { useState } from 'react';
import axios from 'axios';
import Cookies from 'js-cookie';

export default function AddReview({ productId, onReviewAdded }) {
  const [rating, setRating] = useState('');
  const [comment, setComment] = useState('');
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    const newReview = {
      rating: parseInt(rating),
      comment,
      productId,
      buyerId: 4, 
      name,
      email
    };

    try {
      const response = await axios.post('http://localhost:8081/api/buyers/reviews', newReview);
      
      // Clear the form
      setRating('');
      setComment('');
      setName('');
      setEmail('');
      
      // Call the onReviewAdded callback to notify the parent component
      if (onReviewAdded) {
        onReviewAdded(newReview);
      }
    } catch (error) {
      alert('Error adding review:', error);
      if (onReviewAdded) {
        onReviewAdded(newReview); // Inform parent component of the failure
      }
    }
  };

  return (
    <div className="col-md-6">
      <h4 className="mb-4">Leave a review</h4>
      <small>Your email address will not be published. Required fields are marked *</small>
      <div className="d-flex my-3">
        <p className="mb-0 mr-2">Your Rating * :</p>
        <div className="text-primary">
          {[...Array(5)].map((_, index) => (
            <i
              key={index}
              className={index < rating ? "fas fa-star" : "far fa-star"}
              onClick={() => setRating(index + 1)}
              style={{ cursor: 'pointer' }}
            ></i>
          ))}
        </div>
      </div>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="message">Your Review *</label>
          <textarea
            id="message"
            cols="30"
            rows="5"
            className="form-control"
            value={comment}
            onChange={(e) => setComment(e.target.value)}
            required
          ></textarea>
        </div>
        <div className="form-group">
          <label htmlFor="name">Your Name *</label>
          <input
            type="text"
            className="form-control"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="email">Your Email *</label>
          <input
            type="email"
            className="form-control"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        
        <div className="form-group mb-0">
        {Cookies.get('role') == 'BUYER' ? <input
            type="submit"
            value="Leave Your Review"
            className="btn btn-primary px-3"
          />: <input
          type="submit"
          value="Leave Your Review"
          disabled
          className="btn btn-primary px-3"
        />}
          
        </div>
      </form>
    </div>
  );
}
