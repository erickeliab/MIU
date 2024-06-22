import React from 'react';
import SearchForm from '../../components/Product/SearchForm';
import Products from '../../../components/Product/Products';
import AdminHeader from '../../../layouts/Header/AdminHeaader';

export default function DashboardInventoriesSearch() {
  return (
    <>
    <AdminHeader />
      Dashboard
        <SearchForm />
        <Products />
    </>
  )
}
