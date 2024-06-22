import React, { useState } from "react";
import axios from "axios";
import ProductDetailModal from "../Product/ProductDetailModal";
import RestockModal from "./RestockModal"; // Import the new modal

const DashInventory = ({ id, name, description, price, category, subcategory, brand, image, stock, setSelected }) => {
    const [detailModal, showDetailModal] = useState(false);
    const [restockModal, showRestockModal] = useState(false);

    const handleRestock = async (quantity) => {
        try {
            const response = await axios.put(`http://localhost:8081/api/sellers/products/${id}`, {
                name,
                description,
                price: parseFloat(price),
                stockQuantity: parseInt(quantity),
                category,
                subcategory,
                brand,
                imageId: parseInt(image),
                sellerId: 1
              
            });
            showRestockModal(false); // Close the modal
        } catch (error) {
            // Handle error, e.g., show an error message
            alert("Restock failed");
            alert("Failed to restock the product. Please try again later.");
        }
    };

    const product = {
        id,
        name,
        category,
        price,
        stock,
        description,
        subcategory,
        brand,
        image
    };

    return (
        <>
            <tr onClick={() => setSelected(id)}>
                <td>{id}</td>
                <td>{name}</td>
                <td>{category}</td>
                <td>${price.toFixed(2)}</td>
                <td>{stock}</td>
                <td>
                    <span className={`badge ${stock > 0 ? 'badge-success' : 'badge-danger'}`}>
                        {stock > 0 ? 'Available' : 'Out of Stock'}
                    </span>
                </td>
                <td>
                    <button className="btn btn-md btn-warning m-1" onClick={(e) => { e.stopPropagation(); showRestockModal(true); }}>Restock</button>
                    <button className="btn btn-md btn-secondary" onClick={(e) => { e.stopPropagation(); showDetailModal(true); }}>Details</button>
                </td>
            </tr>
            {detailModal && (
                <ProductDetailModal product={product} onClose={() => showDetailModal(false)} />
            )}
            {restockModal && (
                <RestockModal product={product} stock={stock} onClose={() => showRestockModal(false)} onRestock={handleRestock} />
            )}
        </>
    );
};

export default DashInventory;
