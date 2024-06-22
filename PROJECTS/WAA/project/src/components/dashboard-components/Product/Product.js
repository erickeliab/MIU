import React, { useState } from "react";
import ProductDetailModal from "./ProductDetailModal";

const DashProduct = ({ id, name, category, price, stock, onDelete }) => {
    const [detailModal, showDetailModal] = useState(false);

    const product = { id, name, category, price, stock, description: "This is a sample product description." };

    const handleDelete = async () => {
        try {
            const response = await fetch(`http://localhost:8081/api/sellers/products/${id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            if (response.ok) {
                // Notify parent component about the deletion
                onDelete(id);
                alert(`Product ${id} deleted successfully`);
            } else {
                alert('Product has already been purchased')
               
            }
        } catch (error) {
             alert('Error:', error);
        }
    };

    return (
        <>
            <tr>
                <td>{name}</td>
                <td>{category}</td>
                <td>${price}</td>
                <td>{stock}</td>
                <td>
                    <span className={`badge ${stock > 0 ? 'badge-success' : 'badge-danger'}`}>
                        {stock > 0 ? 'Available' : 'Out of Stock'}
                    </span>
                </td>
                <td>
                {stock > 0 ? <button className="btn btn-md btn-danger m-1" onClick={handleDelete}>Delete</button> : 
                
                <button className="btn btn-md btn-danger m-1" disabled>Delete</button>}
                    
                    <button className="btn btn-md btn-secondary" onClick={() => showDetailModal(true)}>Details</button>
                </td>
            </tr>
            {detailModal && (
                <ProductDetailModal product={product} onClose={() => showDetailModal(false)} />
            )}
        </>
    );
}

export default DashProduct;
