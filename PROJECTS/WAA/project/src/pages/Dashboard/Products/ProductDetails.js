import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import DashReviews from '../../../components/dashboard-components/Review/Reviews';
import EditProductForm from '../../../components/dashboard-components/Product/EditProductForm';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';

export default function DashboardProductDetails() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [isEditFormVisible, setIsEditFormVisible] = useState(false);

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
        };
        
        setProduct(sampleProd);
      } catch (error) {
        setError(error.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProduct();
  }, [id]);

  const handleProductUpdated = (updatedProduct) => {
    setProduct(updatedProduct);
    setIsEditFormVisible(false);
  };

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
    <>
    <AdminHeader />
      <h1>{product.name}</h1>
      <p>{product.description}</p>
      <p>Price: ${product.price}</p>

      <button onClick={() => setIsEditFormVisible(!isEditFormVisible)}>
        {isEditFormVisible ? 'Cancel' : 'Edit Product'}
      </button>

      {isEditFormVisible && (
        <EditProductForm
          product={product}
          onProductUpdated={handleProductUpdated}
          onCancel={() => setIsEditFormVisible(false)}
        />
      )}

      <DashReviews productId={product.id.toString()} />
    </>
  );
}
