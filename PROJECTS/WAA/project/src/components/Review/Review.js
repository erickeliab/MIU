
import React, { useEffect, useState } from 'react';

export default function Review({ review }) {

  const [buyer, setBuyer] = useState({})


  useEffect(() => {
    const fetchReviews = async () => {
      try {
        const response = await fetch(`http://localhost:8081/api/buyers/${review.buyerId}`);
        const data = await response.json();
        setBuyer(data);
      
      } catch (error) {
        alert("Failed to fetch reviews:", error);
      }
    };
  
   
  }, [review.buyerId]);


  console.log(buyer)
  return (
    <div className="media mb-4" key={review.id}>
                  
                      <div className="media-body">
                        <h6>{buyer.name}<small> - <i>{review.date}</i></small></h6>
                        <div className="text-primary mb-2">
                          {[...Array(5)].map((_, index) => (
                            <i key={index} className={index < review.rating ? "fas fa-star" : "far fa-star"}></i>
                          ))}
                        </div>
                        <p>{review.comment}</p>
                      </div>
                    </div>
  );
}
