import React from 'react';
import SearchForm from '../../components/Product/SearchForm';
import Products from '../../../components/Product/Products';
import '../../../layouts/AdminStyles.css'
import AdminHeader from '../../../layouts/Header/AdminHeaader';

export default function DashboardProductSearch() {
  return (
    <>
    <AdminHeader />
      Dashboard
        <SearchForm />
        <Products />
    </>
  )
}
