import React, { useEffect, useState } from 'react';
import DashReview from './Review';
import axios from 'axios';

export default function DashReviews() {
  const [reviews, setReviews] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProductsAndReviews = async () => {
      try {
        const productsResponse = await axios.get('http://localhost:8081/api/products');
        const products = productsResponse.data;

        const reviewsPromises = products.map(product =>
          axios.get(`http://localhost:8081/api/products/${product.id}/reviews`)
        );

        const reviewsResponses = await Promise.all(reviewsPromises);
        const allReviews = reviewsResponses.flatMap(response => response.data);

        setReviews(allReviews);
      } catch (error) {
        setError(error.message);
        alert('Error fetching products or reviews:', error.message);
      }
    };

    fetchProductsAndReviews();
  }, []);

  const handleDelete = (deletedReviewId) => {
    setReviews(reviews.filter(review => review.id !== deletedReviewId));
  };

  return (
    <div>
      {error && <p>Error: {error}</p>}
      <table className="table table-hover">
        <thead>
          <tr>
            <th>Review ID</th>
            <th>Product Name</th>
            <th>Reviewer Name</th>
            <th>Rating</th>
            <th>Review Date</th>
            <th>Review Text</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {reviews.length > 0 ? (
            reviews.map(review => (
              <DashReview key={review.id} review={review} onDelete={handleDelete} />
            ))
          ) : (
            <tr>
              <td colSpan="7">No reviews yet.</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}
