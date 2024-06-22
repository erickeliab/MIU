import Seller from './Saler';
import { useEffect, useState } from 'react'
import axios from 'axios'; 
import React from "react";
import DashSaler from './Saler';

const DashSalers = () => {

    const [salersState, setSellersState] = useState(
        [ 
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
        ]
    );

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

    const sellers = salersState.map(product => {
        return (
            <>

            
            <DashSaler
                name={product.storeName}
                description={product.storeDescription}
                approval={product.approved}
                id={product.id}
                key={product.id}
                username = {product.username}
                email = {product.email}
                phoneNumber =  {product.phoneNumber}
                firstname =  {product.firstname}
                lastname  =  {product.lastname}
                createdAt =  {product.createdAt}
                updatedAt =  {product.updatedAt}
            />
            </>

          

        )
    });

    return (
        <table class="table table-hover">
        <thead>
            <tr>
                <th>Seller ID</th>
              
                <th>Store Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Status</th>
                <th>Join Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
           
           
            {sellers}
        </tbody>
    </table>
    )

   

}

export default DashSalers;