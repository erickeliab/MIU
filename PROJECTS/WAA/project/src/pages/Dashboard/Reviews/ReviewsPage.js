import React from 'react'
import DashReviews from '../../../components/dashboard-components/Review/Reviews';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';
import Cookies from 'js-cookie';

export default function DashboardReviewsPage() {


  const template = ( <div class="content">
    <h2>Manage Product Reviews</h2>
    <div class="card mt-4">
        <div class="card-body">
            <h4 class="mt-4">Your Product Reviews</h4>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Review ID</th>
                        <th>Product Name</th>
                        <th>Reviewer Name</th>
                        <th>Rating</th>
                        <th>Review Date</th>
                        <th>Review Text</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>3001</td>
                        <td>Product 1</td>
                        <td>Alice Johnson</td>
                        <td>5</td>
                        <td>2024-06-15</td>
                        <td>Excellent product!</td>
                        <td>
                            <button class="btn btn-danger btn-sm">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td>3002</td>
                        <td>Product 2</td>
                        <td>Bob Brown</td>
                        <td>3</td>
                        <td>2024-06-16</td>
                        <td>Good, but could be better.</td>
                        <td>
                            <button class="btn btn-danger btn-sm">Delete</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
)


if (Cookies.get('role') !== 'ADMIN') {
        
    window.location.replace("/dashboard")

    return <>Redirecting......</>
}

  return (
    <>
    <AdminHeader />

    <div class="content">
    <h2>Manage Product Reviews</h2>
    <div class="card mt-4">
        <div class="card-body">
            <h4 class="mt-4">Your Product Reviews</h4>
           
            <DashReviews productId={'1'}/>
        </div>
    </div>
</div>
   
 
    </>
    
  )
}
