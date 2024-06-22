import React from 'react';
import DashProducts from '../../../components/dashboard-components/Product/Products';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';
import { useState } from 'react';
import Cookies from 'js-cookie';


export default function DashboardProductsPage() {
    const [formVisible, setFormVisible] = useState(false);


    if (Cookies.get('role') !== 'SELLER') {
        
        window.location.replace("/dashboard")
    
        return <>Redirecting......</>
    }
    
  return (
    <>
    <AdminHeader />
    
    <div class="content">
    <h2>Manage Products</h2>
    <div class="card mt-4">
        <div class="card-body">
           <h4 class="mt-4">Quick Actions</h4>
            <div class="row">
                <div class="col-md-4">
                    <a href="#addProduct" class="btn btn-primary btn-block" onClick={() => setFormVisible(true)}>Add New Product</a>
                </div>
                <div class="col-md-4">
                    <a href="/seller/orders" class="btn btn-secondary btn-block">View Orders</a>
                </div>
            
            </div>

            <DashProducts setFormVisible={setFormVisible} formVisible={formVisible}/>
           
        </div>
    </div>
</div>

    {/* {template} */}

     
    </>
  )
}
