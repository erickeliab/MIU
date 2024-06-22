import DashInventory from './Inventory';
import { useEffect, useState } from 'react'
import axios from 'axios'; 
import React from "react";
import InventoryFilter from "./InventoryFilter";
import Cookies from 'js-cookie';

const DashInventories = () => {

    const [productsState, setProductsState] = useState(
        [
            
        ]
    );

    const fetchProducts = () => {
        axios.get('localhost:8081/api/sellers/products?sellerId='+JSON.parse(Cookies.get("user")).id)
            .then(response => {
                setProductsState(response.data);
            })
            .catch(error => {
                // alert(error.message)
            })
    }

    useEffect(() => {
        fetchProducts()
    },
        [])


    const products = productsState.map(product => {
        return (
            <>


            <DashInventory
                key={product.id}
                id={product.id}
                name={product.name}
                category={product.category}
                price={product.price}
                stock={product.stockQuantity}
                image={product.image}
                description={product.description}
                subcategory={product.subcategory}
                brand={product.brand}
               
            />
            </>

          

        )
    });

    return (<>
    
   
    <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Status</th>
                       
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    
                    {products}
                </tbody>
            </table>
    </>
        
    )


}

export default DashInventories;