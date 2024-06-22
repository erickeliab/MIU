import React, { useEffect, useState } from "react";
import axios from 'axios'; 
import DashOrder from './Order';
import DashOrderFilter from './OrderFilter';
import Cookies from "js-cookie";

const DashOrders = () => {
    const [productsState, setProductsState] = useState([]);

    const fetchProducts = () => {
        axios.get('http://localhost:8081/api/sellers/orders?sellerId='+JSON.parse(Cookies.get("user")).id)
            .then(response => {
                setProductsState(response.data.data);
            })
            .catch(error => {
                //alert(error.message);
            });
    }

    useEffect(() => {
        fetchProducts();
    }, []);

    return (
        <>
            <table className="table table-hover">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Customer Name</th>
                        <th>Quantity</th>
                        <th>Shipping Address</th>
                        <th>Total Price</th>
                        <th>Order Status</th>
                        <th>Action</th>
                    </tr>
                </thead>

                
                <tbody>
                    {productsState.map(product => (
                        <DashOrder
                            key={product.id}
                            id={product.id}
                            name={product.name}
                            price={product.totalPrice}
                            status={product.orderStatus}
                            buyerid={product.buyerId}
                            address={JSON.parse(product.shippingAddress).address}
                            quantity={product.orderItems?.reduce((acc, curr) => acc + curr.quantity, 0) || 0}
                        />
                    ))}
                </tbody>
            </table>
        </>
    );
}

export default DashOrders;
