import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import axios from 'axios';

const DashOrder = ({ buyerid, id, quantity, address, price, status }) => {
    const [buyer, setBuyer] = useState({});
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');
    const [showModal, setShowModal] = useState(false);

    const fetchBuyer = async () => {
        try {
            const response = await axios.get(`http://localhost:8081/api/buyers/${buyerid}`);
            setBuyer(response.data);
            setLoading(false);
        } catch (error) {
            // alert(error.message);
            setError('Failed to fetch buyer data.');
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchBuyer();
    }, [buyerid]);

    const shipProduct = async () => {
        try {
            await axios.put(`http://localhost:8081/api/sellers/orders/${id}/status`, { orderStatus: "SHIPPED" });
            window.location.reload(); // Refresh page to reflect status change
        } catch (error) {
            // alert(error.message);
            setError('Failed to update order status to SHIPPED.');
        }
    };

    const wayProduct = async () => {
        try {
            await axios.put(`http://localhost:8081/api/sellers/orders/${id}/status`, { orderStatus: "ON_THE_WAY" });
            window.location.reload(); // Refresh page to reflect status change
        } catch (error) {
            // alert(error.message);
            setError('Failed to update order status to SHIPPED.');
        }
    };


    const deliverProduct = async () => {
        try {
            await axios.put(`http://localhost:8081/api/sellers/orders/${id}/status`, { orderStatus: "DELIVERED" });
            window.location.reload(); // Refresh page to reflect status change
        } catch (error) {
            // alert(error.message);
            setError('Failed to update order status to SHIPPED.');
        }
    };

    const cancelProduct = async () => {
        try {
            await axios.put(`http://localhost:8081/api/sellers/orders/${id}/status`, { orderStatus: "CANCELLED" });
            window.location.reload(); // Refresh page to reflect status change
        } catch (error) {
            // alert(error.message);
            setError('Failed to update order status to CANCELLED.');
        }
    };

    const showDetailsModal = () => setShowModal(true);
    const closeDetailsModal = () => setShowModal(false);

    if (loading) return <tr><td colSpan="7">Loading...</td></tr>;
    // if (error) return <tr><td colSpan="7">{error}</td></tr>;

    return (
        <>
            <tr>
                <td>{id}</td>
                <td>{buyer.firstname +" " + buyer.lastname || 'Unknown'}</td>
                <td>{quantity}</td>
                <td>{address}</td>
                <td>${price.toFixed(2)}</td>
                <td><span className={`badge ${status === 'SHIPPED' ? 'badge-success' : 'badge-warning'}`}>{status}</span></td>
                <td>
                {status === 'PENDING' && (
                    <>
                        <button onClick={cancelProduct} className="btn btn-danger m-1 btn-sm">Cancel</button>
                        <button onClick={shipProduct} className="btn btn-primary btn-sm m-1">Ship</button>
                        <button onClick={wayProduct} className="btn btn-primary btn-sm m-1">On The Way</button>
                        <button onClick={deliverProduct} className="btn btn-primary btn-sm m-1">Delivered</button>
                    </>
                )}
                {status === 'SHIPPED' && (
                    <>
                        <button onClick={wayProduct} className="btn btn-primary btn-sm m-1">On The Way</button>
                        <button onClick={deliverProduct} className="btn btn-primary btn-sm m-1">Delivered</button>
                    </>
                )}
                {status === 'ON_THE_WAY' && (
                    <>
                        <button onClick={deliverProduct} className="btn btn-primary btn-sm m-1">Delivered</button>
                    </>
                )}
                <button onClick={showDetailsModal} className="btn btn-info m-1 btn-sm">Details</button>
            </td>


                
            </tr>

            {showModal && (
                <div className="modal m-5" style={{ display: 'block' }}>
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title">Order Details</h5>
                                <button type="button" className="close" onClick={closeDetailsModal}>
                                    <span>&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <p><strong>Order ID:</strong> {id}</p>
                                <p><strong>Buyer Name:</strong> {buyer.name || 'Unknown'}</p>
                                <p><strong>Quantity:</strong> {quantity}</p>
                                <p><strong>Address:</strong> {address}</p>
                                <p><strong>Price:</strong> ${price.toFixed(2)}</p>
                                <p><strong>Status:</strong> {status}</p>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" onClick={closeDetailsModal}>Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
};

DashOrder.propTypes = {
    buyerid: PropTypes.number.isRequired,
    id: PropTypes.number.isRequired,
    quantity: PropTypes.number.isRequired,
    address: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    status: PropTypes.string.isRequired
};

export default DashOrder;
