import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Reviews from '../../../components/Review/Reviews';
import DashProducts from '../../../components/dashboard-components/Product/Products';
import DashSalers from '../../../components/dashboard-components/Seller/Salers';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';


export default function DashboardSalerDetails() {
    
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);


  useEffect(() => {
    const fetchProduct = async () => {
      try {
        // const response = await axios.get(`http://localhost:8080/api/v1/products/${id}`);
        const sampleProd = { 
            "id": 1, 
            "name": "John's Electronics", 
            "description": "A trusted seller of quality electronic products.", 
            "location": "New York, USA", 
            "rating": 4.5, 
            "totalSales": 2500 
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
    <>
    <AdminHeader />
     Dashboard
      <h1>{product.name}</h1>
      <p>{product.description}</p>
      <p>Location: {product.location}</p>
      <p>Total Sales: ${product.totalSales}</p>
      
      {/* <Reviews productId="1" /> */}
      <DashProducts salerId="1" />
    </>
  );
}
