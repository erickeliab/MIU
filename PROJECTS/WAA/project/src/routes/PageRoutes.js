
import { Routes, Route } from "react-router";
import Login from '../components/Login/Login'
import UserProfile from '../components/UserProfile/UserProfile'
import Counter from '../components/Counter/Counter'
import React from 'react';
import RequireAuth from "../components/RequireAuth";
import Missing from "../components/Missing";
import Products from "../components/Product/Products";
import Home from "../pages/General/Home";
import ProductDetails from "../pages/Product/ProductDetails";
import ReviewsPage from "../pages/Reviews/ReviewsPage";
import BuyerRegister from "../pages/Auth/BuyerRegister";
import SellerRegister from "../pages/Auth/SellerRegister";
import SellersPage from "../pages/Seller/SalersPage";
import SalerDetails from "../pages/Seller/SalerDetailsPage";
import About from "../pages/General/About";
import ProfilePage from "../pages/Profile/ProfilePage";
import Dashboard from "../pages/Dashboard/Dashboard";
import DashboardProductsPage from "../pages/Dashboard/Products/ProductsPage";
import DashboardProductDetails from "../pages/Dashboard/Products/ProductDetails";
import DashboardReviewsPage from "../pages/Dashboard/Reviews/ReviewsPage";
import DashboardSellersPage from "../pages/Dashboard/Seller/SalersPage";
import DashboardSalerDetails from "../pages/Dashboard/Seller/SalerDetailsPage";
import DashboardInventoriesDetails from "../pages/Dashboard/Inventory/InventoryDetails";
import DashboardInventoriesPage from "../pages/Dashboard/Inventory/InventoriesPage";
import DashboardOrdersDetails from "../pages/Dashboard/Orders/OrdersDetails";
import DashboardOrdersPage from "../pages/Dashboard/Orders/OrdersPage";
import Cart from "../pages/Dashboard/Cart/Cart";
import Billing from "../pages/Dashboard/Billing/Billing";
import Checkout from "../pages/Dashboard/Checkout/Checkout";
import ProductsPage from "../pages/Product/ProductsPage";
import BuyerOrdersPage from "../pages/Dashboard/Orders/BuyerOrdersPage";
import BuyerOrderDetailsPage from "../pages/Dashboard/Orders/BuyerOrderDetailsPage";



export default function PageRoutes() {
    return (
        <Routes>
            {/* public pages */}
            <Route path='/' element={<Home />} />
            <Route path='/login' element={<Login />} />
            <Route path='/register' element={<BuyerRegister />} />
            <Route path='/seller-register' element={<SellerRegister />} />
            <Route path='/products' element={<ProductsPage />} />
            <Route path='/products/:id' element={<ProductDetails />} />
            <Route path='/products/:id/reviews' element={<ReviewsPage />} />
            <Route path='/salers' element={<SellersPage />} />
            <Route path='/salers/:id' element={<SalerDetails />} />
            <Route path='/search' element={<Products />} />
            <Route path='/about' element={<About />} />

            {/* protected pages */}
            <Route element={<RequireAuth />}>

                <Route path='/dashboard' element={<Dashboard />} />
                <Route path='/profile' element={<ProfilePage />} />
                {/* <Route path='/user' element={<UserProfile />} /> */}
                {/* <Route path='/counter' element={<Counter />} /> */}

                <Route path='/seller/products' element={<DashboardProductsPage />} />
                <Route path='/seller/products/:id' element={<DashboardProductDetails />} />
                <Route path='/seller/orders' element={<DashboardOrdersPage />} />
                <Route path='/seller/orders/:id' element={<DashboardOrdersDetails />} />
                <Route path='/seller/inventory' element={<DashboardInventoriesPage />} />
                <Route path='/seller/inventory/:id' element={<DashboardInventoriesDetails />} />


                <Route path='/buyer/orders' element={<BuyerOrdersPage />} />
                <Route path='/buyer/orders/:id' element={<BuyerOrderDetailsPage />} />
                <Route path='/buyer/cart' element={<Cart />} />
                <Route path='/buyer/checkout' element={<Checkout />} />
                {/* <Route path='/buyer/billing' element={<Billing />} /> */}


                <Route path='/admin/salers' element={<DashboardSellersPage />} />
                <Route path='/admin/salers/:id' element={<DashboardSalerDetails />} />
                <Route path='/admin/reviews' element={<DashboardReviewsPage />} />

            </Route>

            {/* catch all  */}
            <Route path="*" element={<Missing />} />
        </Routes>
    )
}