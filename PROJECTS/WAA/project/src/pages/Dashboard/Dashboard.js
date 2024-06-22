import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import '../../layouts/AdminStyles.css'
import AdminHeader from '../../layouts/Header/AdminHeaader';
import DashSalers from '../../components/dashboard-components/Seller/Salers';
import DashReviews from '../../components/dashboard-components/Review/Reviews';
import Cookies from 'js-cookie';
import DashProducts from '../../components/dashboard-components/Product/Products';
// import { useHistory } from 'react-router-dom';



const Dashboard = () => {
    const [counts, setCounts] = useState({
        ordersCount: 0,
        productsCount: 0,
        sellersCount: 0,
        reviewsCount: 0
    });

   

    useEffect(() => {
        const fetchData = async () => {
            try {
                // Fetch orders count
                const ordersResponse = await axios.get('http://localhost:8081/api/sellers/orders/count?sellerId='+JSON.parse(Cookies.get('user')).id);
                const ordersCount = ordersResponse.data.data.count || 0;

                // Fetch products count
                const productsResponse = await axios.get('http://localhost:8081/api/products/count');
                const productsCount = productsResponse.data.count || 0;

                // Fetch sellers count
                const sellersResponse = await axios.get('http://localhost:8081/api/sellers/count');
                const sellersCount = sellersResponse.data.data.count || 0;

                // Fetch reviews count
                const reviewsResponse = await axios.get('http://localhost:8081/api/products/1/reviews/count');
                const reviewsCount = reviewsResponse.data.count || 0;

                setCounts({
                    ordersCount,
                    productsCount,
                    sellersCount,
                    reviewsCount
                });
            } catch (error) {
                // console.error('Failed to fetch counts:', error);
                setCounts({
                    ordersCount: 2,
                    productsCount: 0,
                    sellersCount: 0,
                    reviewsCount: 0
                });
            }
        };

        fetchData();
    }, []);
    
    if (Cookies.get('role') !== 'SELLER' && Cookies.get('role') !== 'ADMIN') {
        
        window.location.replace("/")

        return <>Redirecting......</>
    }

    if (Cookies.get('role') == 'SELLER') {
        
        return <>
        <AdminHeader />

            
          <div class="content">
        <h2>Seller Dashboard</h2>
        <div class="row">
            <div class="col-lg-3 col-md-6 mb-4">
                <Link to="">
                <div class="card text-white bg-info h-100">
                    <div class="card-body">
                        <h5 class="card-title"> Inventory</h5>
                        <p class="card-text"></p>
                    </div>
                </div>
                </Link>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
            <Link to="/seller/products">
                <div class="card text-white bg-success h-100">
                    <div class="card-body">
                        <h5 class="card-title"> Products</h5>
                        <p class="card-text"></p>
                    </div>
                </div>
                </Link>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
            <Link to="/seller/orders">
                <div class="card text-white bg-warning h-100">
                    <div class="card-body">
                        <h5 class="card-title"> Orders</h5>
                        <p class="card-text"></p>
                    </div>
                </div>
                </Link>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
            <Link to="/admin/reviews">
                <div class="card text-white bg-danger h-100">
                    <div class="card-body">
                        <h5 class="card-title"> Reviews</h5>
                        <p class="card-text"></p>
                    </div>
                </div>
                </Link>
            </div>
        </div>
        

        <DashProducts />
        
       
    </div>
        </>
    }
    
    
    return (
        <>

        <AdminHeader />
       
         

          
          <div class="content">
        <h2>Admin Dashboard</h2>
        <div class="row">
            <div class="col-lg-3 col-md-6 mb-4">
                <Link to="">
                <div class="card text-white bg-info h-100">
                    <div class="card-body">
                        <h5 class="card-title">Total Salers</h5>
                        <p class="card-text">{counts.sellersCount}</p>
                    </div>
                </div>
                </Link>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
            <Link to="/seller/products">
                <div class="card text-white bg-success h-100">
                    <div class="card-body">
                        <h5 class="card-title">All Products</h5>
                        <p class="card-text">{counts.productsCount}</p>
                    </div>
                </div>
                </Link>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
            <Link to="/seller/orders">
                <div class="card text-white bg-warning h-100">
                    <div class="card-body">
                        <h5 class="card-title">Total Orders</h5>
                        <p class="card-text">{counts.ordersCount}</p>
                    </div>
                </div>
                </Link>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
            <Link to="/admin/reviews">
                <div class="card text-white bg-danger h-100">
                    <div class="card-body">
                        <h5 class="card-title">Total Reviews</h5>
                        <p class="card-text">{counts.reviewsCount}</p>
                    </div>
                </div>
                </Link>
            </div>
        </div>
        <h4 class="mt-4">Pending Sellers Registration</h4>

        <DashSalers />
        
        <br />

        <h4 class="mt-4">Recent Reviews</h4>
        <DashReviews productId={'1'}/>
    </div>
          
        </>
    );
};

export default Dashboard;
