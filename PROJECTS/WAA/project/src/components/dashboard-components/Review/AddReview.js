import React, { useState } from 'react';
import axios from 'axios';
import Cookies from 'js-cookie';

export default function DashAddReview({ productId, onReviewAdded }) {
  const [rating, setRating] = useState('');
  const [comment, setComment] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    // Create a new review object
    const newReview = {
      rating: parseInt(rating),
      comment,
      productId,
      buyerId: Cookies.get('user').id
    };

    try {
      // Send the new review to the mock API
    //   const response = await axios.post('http://localhost:5000/reviews', newReview);
      
      // Clear the form
      setRating('');
      setComment('');
      
      // Call the onReviewAdded callback to notify the parent component
      if (onReviewAdded) {
        onReviewAdded(newReview);
      }
    } catch (error) {
      alert('Error adding review:', error);
    }
  };

  return (
    <div>
      <h2>Add a Review</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            Rating:
            <input
              type="number"
              value={rating}
              onChange={(e) => setRating(e.target.value)}
              min="1"
              max="5"
              required
            />
          </label>
        </div>
        <div>
          <label>
            Comment:
            <textarea
              value={comment}
              onChange={(e) => setComment(e.target.value)}
              required
            />
          </label>
        </div>
        <button type="submit">Submit Review</button>
      </form>
    </div>
  );
}
