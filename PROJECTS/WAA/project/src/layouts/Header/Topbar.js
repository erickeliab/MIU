import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import axios from 'axios';
import { cartCountsActions } from '../../store';
import Cookies from 'js-cookie';

export default function Topbar() {
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [cartItemsDetails, setCartItemsDetails] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

    const dispatch = useDispatch();
    const cartItems = useSelector(state => state.cart.counter);

    const buyerId = 5; 

    const navigate = useNavigate();

    const fetchCartItems = async () => {
        setLoading(true);
        setError(null);

        try {
            const response = await axios.get(`http://localhost:8081/api/buyers/cart?buyerId=${JSON.parse(Cookies.get('user')).id}`);
            const cartData = response.data.cartItems;
            const productIds = cartData.map(item => item.productId);
            const productResponse = await axios.get('http://localhost:8081/api/products');
            const productData = productResponse.data.filter(product => productIds.includes(product.id));

            const cartItemsWithDetails = cartData.map(cartItem => {
                const product = productData.find(p => p.id === cartItem.productId);
                return {
                    ...cartItem,
                    name: product.name,
                    price: product.price,
                    image: product.image,
                };
            });

            setCartItemsDetails(cartItemsWithDetails);
            dispatch(cartCountsActions.setInitial(
                cartData.reduce((acc, item) => acc + item.quantity, 0)
              ));
            setLoading(false);
        } catch (error) {
            setError('Failed to fetch cart items');
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchCartItems();
    }, [Cookies.get('user')]);

    const handleSubmit = (event) => {
        event.preventDefault();
        if (searchTerm.trim()) {
            navigate(`/products?filter=${encodeURIComponent(searchTerm.trim())}`);
        }
    };

    return (
        <div className="container-fluid">
            <div className="row bg-secondary py-2 px-xl-5">
                <div className="col-lg-6 d-none d-lg-block">
                    <div className="d-inline-flex align-items-center">
                        <a className="text-dark" href="">FAQs</a>
                        <span className="text-muted px-2">|</span>
                        <a className="text-dark" href="">Help</a>
                        <span className="text-muted px-2">|</span>
                        <a className="text-dark" href="">Support</a>
                    </div>
                </div>
                <div className="col-lg-6 text-center text-lg-right">
                    <div className="d-inline-flex align-items-center">
                        <a className="text-dark px-2" href="">
                            <i className="fab fa-facebook-f"></i>
                        </a>
                        <a className="text-dark px-2" href="">
                            <i className="fab fa-twitter"></i>
                        </a>
                        <a className="text-dark px-2" href="">
                            <i className="fab fa-linkedin-in"></i>
                        </a>
                        <a className="text-dark px-2" href="">
                            <i className="fab fa-instagram"></i>
                        </a>
                        <a className="text-dark pl-2" href="">
                            <i className="fab fa-youtube"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div className="row align-items-center py-3 px-xl-5">
                <div className="col-lg-3 d-none d-lg-block">
                    <a href="" className="text-decoration-none">
                        <h1 className="m-0 display-5 font-weight-semi-bold">
                            <span className="text-primary font-weight-bold border px-3 mr-1">MIU</span>
                            E Market
                        </h1>
                    </a>
                </div>
                <div className="col-lg-6 col-6 text-left">
                    <form onSubmit={handleSubmit}>
                        <div className="input-group">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Search for products"
                                value={searchTerm}
                                onChange={(e) => setSearchTerm(e.target.value)}
                            />
                            <div className="input-group-append">
                                <span className="input-group-text bg-transparent text-primary">
                                    <i className="fa fa-search"></i>
                                </span>
                            </div>
                        </div>
                    </form>
                </div>
                <div className="col-lg-3 col-6 text-right">
                    <a href="" className="btn border">
                        <Link to="/buyer/cart">
                            <i className="fas fa-shopping-cart text-primary"></i>
                        </Link>
                        <span className="badge">{cartItems}</span>
                    </a>
                </div>
            </div>
        </div>
    );
}
