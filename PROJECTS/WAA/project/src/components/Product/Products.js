import Product from "../../components/Product/Product";
import { useEffect, useState } from 'react';
import axios from 'axios'; 
import React from "react";
import { useLocation } from 'react-router-dom';
import ProductFilter from "./ProductFilter";

const Products = ({ sellerId }) => {
    const [productsState, setProductsState] = useState([]);
    const location = useLocation();

    // Function to get the query parameter
    const getCategoryFilter = () => {
        const params = new URLSearchParams(location.search);
        return params.get('filter');
    }

    const fetchProducts = () => {
        axios.get('http://localhost:8081/api/products')
            .then(response => {
                const categoryFilter = getCategoryFilter();
                if (categoryFilter) {
                    const filteredProducts = response.data.filter(product => product.category === categoryFilter);
                    setProductsState(filteredProducts);
                } else {
                    setProductsState(response.data);
                }
            })
            .catch(error => {
                alert(error.message);
            });
    }

    useEffect(() => {
        fetchProducts();
    }, [location.search]); // Depend on location.search to refetch when query param changes

    return (
        <div className="container-fluid pt-5">
            <div className="row px-xl-5 pb-3">
                {productsState.map(product => (
                    <Product
                        name={product.name}
                        price={product.price}
                        image={product.image}
                        id={product.id}
                        key={product.id}
                    />
                ))}
            </div>
        </div>
    );
}

export default Products;
