import React from 'react';
import DashSalers from '../../../components/dashboard-components/Seller/Salers';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';
import Cookies from 'js-cookie';

export default function DashboardSellersPage() {
    if (Cookies.get('role') !== 'ADMIN') {
        
        window.location.replace("/dashboard")
    
        return <>Redirecting......</>
    }
    

  return (
    <>
    <AdminHeader />
     
    <div class="content">
    <h2>Manage Sellers</h2>
    <div class="card mt-4">
        <div class="card-body">
            
            
            <h4 class="mt-4">Your Sellers</h4>
           
            <DashSalers />
        </div>
    </div>
</div>
     
    </>
  )
}
