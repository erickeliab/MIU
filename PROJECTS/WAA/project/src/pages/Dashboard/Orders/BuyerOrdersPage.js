import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../../../layouts/Styles/SiteStyles.css';
import Header from '../../../layouts/Header/Header';
import { Link } from 'react-router-dom';
import Cookies from 'js-cookie';

const BuyerOrdersPage = () => {
  const [orders, setOrders] = useState([
    {
      orderNumber: '123456',
      price: 150,
      totalProducts: 3,
      status: 'Processing',
      id: 1
    },
    {
      orderNumber: '654321',
      price: 200,
      totalProducts: 5,
      status: 'Shipped',
      id: 2
    }
  ]);



  const [totalPrice, setTotalPrice] = useState(130); // Sample total price

  useEffect(() => {
    const fetchOrders = async () => {
      try {
        const response = await axios.get('http://localhost:8081/api/buyers/orders?buyerId='+JSON.parse(Cookies.get("user")).id);
        setOrders(response.data);
      } catch (error) {
        alert('Failed to fetch orders:', error);
      }
    };

    fetchOrders();
    
  }, []);


  const handleCancelOrder = async (id) => {
    try {
      await axios.put(`http://localhost:8081/api/buyers/orders/${id}/cancel`, { orderStatus: "CANCELLED" });
      window.location.reload();
    } catch (error) {
      console.error(error.message);
      setError('Failed to update order status to CANCELLED.');
    }
  };

  if (Cookies.get('role') !== 'BUYER') {
    history.replace('/');
    return <>Redirecting...</>;
  }


  if (Cookies.get('role') !== 'BUYER') {
        
    window.location.replace("/")

    return <>Redirecting......</>
}


  return (
    <>
      <Header />

      <div className='container'><h3>Order History</h3></div>
      <div className="container-fluid pt-5">
        <div className="row px-xl-5">
          <div className="col-lg-10 table-responsive mb-5">
            <table className="table table-bordered text-center mb-0">
              <thead className="bg-secondary text-dark">
                <tr>
                  <th>Order Number</th>
                  <th>Price</th>
                  <th>Total Products</th>
                  <th>Status</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                {orders.map((order, index) => (
                  <tr key={index}>
                    <td className="align-middle">{order.id}</td>
                    <td className="align-middle">${order.totalPrice}</td>
                    <td className="align-middle">
                            {order.orderItems?.reduce((acc, orderItem) => acc + orderItem.quantity, 0)}
                            </td>

                    <td className="align-middle">{order.orderStatus}</td>
                    <td className="align-middle">
                        {order.orderStatus == 'PENDING' ? <button className="btn btn-sm btn-primary" onClick={() => handleCancelOrder(order.id)}>Cancel Order</button> : <button className="btn btn-sm btn-primary" disabled>Cancel Order</button>}
                      
                      <Link to={`/buyer/orders/${order.id}`}>
                        <button className="btn btn-sm btn-primary m-1">Details</button>
                      </Link>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    
    </>
  );
};

export default BuyerOrdersPage;
