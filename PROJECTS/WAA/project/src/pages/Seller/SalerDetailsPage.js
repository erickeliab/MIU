import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Reviews from '../../components/Review/Reviews';
import Products from '../../components/Product/Products';
import Header from '../../layouts/Header/Header';
import "../../layouts/Styles/SiteStyles.css";


export default function SalerDetails() {
    
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);


  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const response = await axios.get(`http://localhost:8081/api/sellers/${id}`);
        const sampleProd = { 
            "id": 1, 
            "name": "John's Electronics", 
            "description": "A trusted seller of quality electronic products.", 
            "location": "New York, USA", 
            "rating": 4.5, 
            "totalSales": 2500 
        }
          
        setProduct(response.data.data);
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
      <Header />
      <div className='container'>
        <h1>{product.storeName}</h1>
      <p>{product.storeDescription}</p>
      {/* <p>Location: {product.location}</p>
      <p>Total Sales: ${product.totalSales}</p> */}
      </div>
      
      
      {/* <Reviews productId="1" /> */}
      <Products salerId="1" />
    </div>
  );
}
