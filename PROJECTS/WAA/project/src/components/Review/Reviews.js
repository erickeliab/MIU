import React, { useEffect, useState } from 'react';
import Review from './Review';
import AddReview from './AddReview';
import { Link } from 'react-router-dom';

export default function Reviews({ productId, setTotalReviews }) {
  const [reviews, setReviews] = useState([]);

  useEffect(() => {
    const fetchReviews = async () => {
      try {
        const response = await fetch(`http://localhost:8081/api/products/${productId}/reviews`);
        const data = await response.json();
        setReviews(data);
        setTotalReviews(data.length);
      } catch (error) {
        alert("Failed to fetch reviews:", error);
      }
    };
  
    fetchReviews();
  }, [productId]);

  const handleReviewAdded = (newReview) => {
    // Update the reviews state with the newly added review
    setReviews(prevReviews => [...prevReviews, newReview]);
  };
  setTotalReviews(reviews.length)
  return (
    <div className="row px-xl-5">
      <div className="col">
        <div className="tab-content">
          <div className="tab-pane fade show active" id="tab-pane-3">
            <div className="row">
              <div className="col-md-6">
                <h4 className="mb-4">Reviews for This Product</h4>
                {reviews.length > 0 ? (
                  reviews.map(review => (
                    <Review review={review}/>
                  ))
                ) : (
                  <p>No reviews yet.</p>
                )}
              </div>
            </div>
          </div>
        </div>
      </div>
      <AddReview productId={productId} onReviewAdded={handleReviewAdded} />
    </div>
  );
}
