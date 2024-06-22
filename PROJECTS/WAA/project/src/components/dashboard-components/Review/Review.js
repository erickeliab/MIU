import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function DashReview({ review, onDelete }) {
  const [product, setProduct] = useState(null);
  const [buyer, setBuyer] = useState(null);
  const [loadingProduct, setLoadingProduct] = useState(true);
  const [loadingBuyer, setLoadingBuyer] = useState(true);
  const [errorProduct, setErrorProduct] = useState(null);
  const [errorBuyer, setErrorBuyer] = useState(null);

  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const productResponse = await axios.get(`http://localhost:8081/api/products/${review.productId}`,
          {
              headers: {
                  'Content-Type': 'application/json',
                  'Authorization': 'Bearer ' + Cookies.get('token')
              }
          });
        setProduct(productResponse.data);
      } catch (err) {
        setErrorProduct(err);
      } finally {
        setLoadingProduct(false);
      }
    };

    const fetchBuyer = async () => {
      try {
        const buyerResponse = await axios.get(`http://localhost:8081/api/buyers/${review.buyerId}`,
          {
              headers: {
                  'Content-Type': 'application/json',
                  'Authorization': 'Bearer ' + Cookies.get('token')
              }
          });
        setBuyer(buyerResponse.data);
      } catch (err) {
        setErrorBuyer(err);
      } finally {
        setLoadingBuyer(false);
      }
    };

    fetchProduct();
    fetchBuyer();
  }, [review.productId, review.buyerId]);

  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8081/api/admin/reviews/${review.id}`);
      onDelete(review.id);
    } catch (error) {
      alert('Error deleting review:', error);
    }
  };

  if (loadingProduct || loadingBuyer) return <tr><td colSpan="7">Loading...</td></tr>;

  return (
    <tr>
      <td>{review.id}</td>
      <td>{product ? product.name : 'N/A'}</td>
      <td>{buyer ? buyer.name : 'N/A'}</td>
      <td>{review.rating}</td>
      <td>{review.create_at}</td>
      <td>{review.comment}</td>
      <td>
        <button className="btn btn-danger btn-sm" onClick={handleDelete}>Delete</button>
      </td>
    </tr>
  );
}
