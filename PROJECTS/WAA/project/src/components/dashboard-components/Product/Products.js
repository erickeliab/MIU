import React, { useEffect, useState } from 'react';
import axios from 'axios'; 
import ProductFilter from "./ProductFilter";
import AddProductForm from "./AddProductForm";
import DashProduct from './Product';
import Cookies from 'js-cookie';

const DashProducts = ({ formVisible, setFormVisible }) => {
    const [productsState, setProductsState] = useState([]);

    const fetchProducts = () => {
        axios.get('localhost:8081/api/sellers/products?sellerId='+JSON.parse(Cookies.get("user")).id)
            .then(response => {
                setProductsState(response.data);
            })
            .catch(error => {
                // alert(error.message);
            });
    }

    useEffect(() => {
        fetchProducts();
    }, []);

    const handleProductAdded = (newProduct) => {
        setProductsState([...productsState, newProduct]);
    };

    const handleProductDeleted = (deletedProductId) => {
        setProductsState(productsState.filter(product => product.id !== deletedProductId));
    };

    const products = productsState.map(product => (
        <DashProduct
            key={product.id}
            id={product.id}
            name={product.name}
            category={product.category}
            price={product.price}
            stock={product.stockQuantity}
            image={product.image}
            onDelete={handleProductDeleted}
        />
    ));

    return (
        <div>
            <h4 className="mt-4">Your Products</h4>
            <table className="table table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {products}
                </tbody>
            </table>
            <AddProductForm setFormVisible={setFormVisible} formVisible={formVisible} onProductAdded={handleProductAdded} />
        </div>
    );
}

export default DashProducts;
