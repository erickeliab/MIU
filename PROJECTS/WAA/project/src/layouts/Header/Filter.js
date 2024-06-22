import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function Filter() {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    fetchCategories();
  }, []); // Run only once

  const fetchCategories = async () => {
    try {
      const response = await axios.get("http://localhost:8081/api/products");
      const uniqueCategories = Array.from(new Set(response.data.map(product => product.category)));
      setCategories(uniqueCategories);
    } catch (error) {
      console.error("Error fetching categories:", error);
    }
  };

  return (
    <div className="col-lg-3 d-none d-lg-block">
      <a className="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style={{ height: '65px', marginTop: '-1px', padding: '0 30px' }}>
        <h6 className="m-0">Categories</h6>
        <i className="fa fa-angle-down text-dark"></i>
      </a>
      <nav className="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
        <div className="navbar-nav w-100 overflow-hidden" style={{ height: '410px' }}>
          {categories.map(category => (
            <a key={category} href={"/products?filter="+category} className="nav-item nav-link">{category}</a>
          ))}
        </div>
      </nav>
    </div>
  );
}
