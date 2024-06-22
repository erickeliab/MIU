import React from 'react';
import DashOrders from '../../../components/dashboard-components/Order/Orders';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';
import Cookies from 'js-cookie';


export default function DashboardOrdersPage() {

    if (Cookies.get('role') !== 'SELLER') {
        
        window.location.replace("/dashboard")
    
        return <>Redirecting......</>
    }
  return (
    <>
    <AdminHeader />

    <div class="content">
    <h2>Manage Orders</h2>
    <div class="card mt-4">
        <div class="card-body">
            <h4 class="mt-4">Your Orders</h4>
            <DashOrders />
        </div>
    </div>
</div>


    {/* {template} */}

   
    </>
  )
}
