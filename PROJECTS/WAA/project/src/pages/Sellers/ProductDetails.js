import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Reviews from '../../components/Review/Reviews';


export default function ProductDetails() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProduct = async () => {
      try {
        // const response = await axios.get(`http://localhost:8080/api/v1/products/${id}`);
        const sampleProd = {
            "id": 101,
            "name": "Wireless Headphones",
            "description": "High-quality wireless headphones with noise cancellation and 20-hour battery life.",
            "price": 99.99,
            "stockQuantity": 150,
            "category": "Electronics",
            "subcategory": "Audio",
            "brand": "SoundMagic",
            "sellerId": 202
          }
          
        setProduct(sampleProd);
      } catch (error) {
        setError(error.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProduct();
  }, [id]);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  if (!product) {
    return <div>No product found</div>;
  }

  return (
    <div>
      <h1>{product.name}</h1>
      <p>{product.description}</p>
      <p>Price: ${product.price}</p>
      
      <Reviews productId="1" />
    </div>
  );
}
