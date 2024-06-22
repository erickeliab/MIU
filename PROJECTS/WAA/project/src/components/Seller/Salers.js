import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import React from "react";
import Saler from './Saler';

const Salers = () => {
    const [salersState, setSellersState] = useState([
        {
            "id": 1,
            "name": "John's Electronics",
            "description": "A trusted seller of quality electronic products.",
            "location": "New York, USA",
            "rating": 4.5,
            "totalSales": 2500
        },
        {
            "id": 2,
            "name": "Furniture World",
            "description": "Stylish and affordable furniture for your home.",
            "location": "San Francisco, USA",
            "rating": 4.7,
            "totalSales": 1500
        },
        {
            "id": 3,
            "name": "Fashion Hub",
            "description": "Trendy fashion apparel for all ages.",
            "location": "Los Angeles, USA",
            "rating": 4.3,
            "totalSales": 3200
        }
    ]);

    const fetchSalers = () => {
        axios.get('http://localhost:8081/api/sellers')
            .then(response => {
                setSellersState(response.data.data);
            })
            .catch(error => {
                //alert(error.message);
            });
    }

    useEffect(() => {
        fetchSalers();
    }, []);

    const template = (
        <div className="container-fluid offer pt-5">
            <div className="row px-xl-5">
            {salersState.map(product => (
                    <Saler
                        storeName={product.storeName}
                        description={product.description}
                        location={product.location}
                        rating={product.rating}
                        totalSales={product.totalSales}
                        id={product.id}
                        key={product.id}
                    />
                ))}
                
            </div>
           
        </div>
    );

    return template;
}

export default Salers;
