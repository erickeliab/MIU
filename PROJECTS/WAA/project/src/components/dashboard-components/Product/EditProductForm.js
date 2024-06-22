import React, { useState } from 'react';
import axios from 'axios';

const EditProductForm = ({ product, onProductUpdated, onCancel }) => {
  const [name, setName] = useState(product.name);
  const [price, setPrice] = useState(product.price);
  const [description, setDescription] = useState(product.description);

  const handleEditSubmit = async (event) => {
    event.preventDefault();

    const updatedProduct = {
      ...product,
      name: name,
      price: parseFloat(price),
      description: description
    };

    try {
      // const response = await axios.put(`http://localhost:8080/api/v1/products/${product.id}`, updatedProduct);
      const response = { data: updatedProduct }; // Mock response for demo purposes
      onProductUpdated(response.data);
    } catch (error) {
      //alert(error.message);
    }
  };

  return (
    <form onSubmit={handleEditSubmit}>
      <div>
        <label htmlFor="editName">Product Name:</label>
        <input
          type="text"
          id="editName"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
      </div>
      <div>
        <label htmlFor="editPrice">Product Price:</label>
        <input
          type="number"
          id="editPrice"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
          required
        />
      </div>
      <div>
        <label htmlFor="editDescription">Product Description:</label>
        <textarea
          id="editDescription"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          required
        />
      </div>
      <button type="submit">Save</button>
      <button type="button" onClick={onCancel}>Cancel</button>
    </form>
  );
};

export default EditProductForm;
