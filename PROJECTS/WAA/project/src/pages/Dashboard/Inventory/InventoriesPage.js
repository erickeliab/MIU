import React from 'react';
import DashInventories from '../../../components/dashboard-components/Inventory/Inventories';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';
import DashProducts from '../../../components/dashboard-components/Product/Products';

import Cookies from 'js-cookie';
export default function DashboardInventoriesPage() {

  const template = ( <div class="content">
    <h2>Manage Inventory</h2>
    <div class="card mt-4">
        <div class="card-body">
            <h4 class="mt-4">Quick Actions</h4>
            <div class="row">
                <div class="col-md-4">
                    <a href="#addProduct" class="btn btn-primary btn-block">Add New Product</a>
                </div>
                <div class="col-md-4">
                    <a href="#viewOrders" class="btn btn-secondary btn-block">View Orders</a>
                </div>
                <div class="col-md-4">
                    <a href="#salesReport" class="btn btn-success btn-block">View Sales Report</a>
                </div>
            </div>
            <h4 class="mt-4">Your Products</h4>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Status</th>
                        <th>Supplier</th>
                        <th>SKU</th>
                        <th>Reorder Level</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1001</td>
                        <td>Product 1</td>
                        <td>Electronics</td>
                        <td>$500</td>
                        <td>10</td>
                        <td><span class="badge badge-success">Available</span></td>
                        <td>Supplier A</td>
                        <td>SKU12345</td>
                        <td>5</td>
                    </tr>
                    <tr>
                        <td>1002</td>
                        <td>Product 2</td>
                        <td>Clothing</td>
                        <td>$80</td>
                        <td>0</td>
                        <td><span class="badge badge-danger">Out of Stock</span></td>
                        <td>Supplier B</td>
                        <td>SKU67890</td>
                        <td>10</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
)
if (Cookies.get('role') !== 'SELLER') {
        
    window.location.replace("/dashboard")

    return <>Redirecting......</>
}

  return (
    <>
    <AdminHeader />
    
    <div class="content">
    <h2>Manage Inventory</h2>
    <div class="card mt-4">
        <div class="card-body">
           
            
            <DashInventories />
        </div>
    </div>
</div>

    {/* {template} */}

    
    </>
  )
}
