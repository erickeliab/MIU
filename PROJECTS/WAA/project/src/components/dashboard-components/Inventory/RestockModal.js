import React, { useState } from "react";

const RestockModal = ({ product, onClose, onRestock, stock }) => {
    const [quantity, setQuantity] = useState(1); // Start with 1 as a default value

    const handleSubmit = (e) => {
        e.preventDefault();
       onRestock(quantity)
    };
    useState(()=>{
        setQuantity(stock)
    })

    
    return (
        <div className="modal mt-5" style={{ display: onClose ? "block" : "none" }}>
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title">Restock {product.name}</h5>
                        <button type="button" className="close" onClick={onClose}>
                            &times;
                        </button>
                    </div>
                    <div className="modal-body">
                        <form onSubmit={handleSubmit}>
                            <div className="form-group">
                                <label htmlFor="quantity">Restock Quantity</label>
                                <input
                                    type="number"
                                    className="form-control"
                                    id="quantity"
                                    value={quantity}
                                    onChange={(e) => setQuantity(parseInt(e.target.value))}
                                    min="1"
                                    required
                                />
                            </div>
                            <button type="submit" className="btn btn-primary">Restock</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default RestockModal;
