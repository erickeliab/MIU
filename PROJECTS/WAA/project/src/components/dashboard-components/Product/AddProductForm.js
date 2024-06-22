import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Modal.css';
import Cookies from 'js-cookie';
import PropTypes from 'prop-types';

const AddProductForm = ({ formVisible, onProductAdded, setFormVisible }) => {
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [price, setPrice] = useState('');
    const [stockQuantity, setStockQuantity] = useState('');
    const [category, setCategory] = useState('');
    const [subcategory, setSubcategory] = useState('');
    const [brand, setBrand] = useState('');
    const [selectedImage, setSelectedImage] = useState('');
    const [images, setImages] = useState([]);
    const [error, setError] = useState(null);

    const handleSubmit = (event) => {
        event.preventDefault();

        const newProduct = {
            name,
            description,
            price: parseFloat(price),
            stockQuantity: parseInt(stockQuantity, 10),
            category,
            subcategory,
            brand,
            imageId: parseInt(selectedImage),
            sellerId: JSON.parse(Cookies.get('user')).id,
            discount: 20.0,
            rating: 4,
            onSale: true,
            newArrival: false,
            bestSeller: true,
            color: "NOT SET",
            size: "NOT SET",
            material: "NOT SET",
            features: "NOT SET",
            compatibility: "NOT SET",
            model: "NOT SET",
            year: 2023
        };

        axios.post('http://localhost:8081/api/sellers/products', newProduct)
            .then(response => {
                
                setName('');
                setDescription('');
                setPrice('');
                setStockQuantity('');
                setCategory('');
                setSubcategory('');
                setBrand('');
                setSelectedImage('');
                setFormVisible(false);

                onProductAdded(newProduct);
            })
            .catch(error => {
                alert('You need to be Approved');
                setError("Failed to add product. Please try again.");
            });
    };

    const fetchImages = () => {
        axios.get('http://localhost:8081/api/products/images')
            .then(response => {
                setImages(response.data);
            })
            .catch(error => {
                //alert(error.message);
            });
    };

    useEffect(() => {
        fetchImages();
    }, []);

    const handleSelectChange = (e) => {
        setSelectedImage(e.target.value);
    };

    return (
        <div>
            {formVisible && (
                <div className="modal d-flex justify-content-center align-items-center">
                    <div className="modal-content p-4 rounded bg-light">
                        <span className="close" onClick={() => setFormVisible(false)}>&times;</span>
                        <form onSubmit={handleSubmit}>
                            {error && <div className="alert alert-danger">{error}</div>}
                            <div className="form-group">
                                <label htmlFor="name">Product Name:</label>
                                <input
                                    type="text"
                                    id="name"
                                    className="form-control"
                                    value={name}
                                    onChange={(e) => setName(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="description">Description:</label>
                                <input
                                    type="text"
                                    id="description"
                                    className="form-control"
                                    value={description}
                                    onChange={(e) => setDescription(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="price">Product Price:</label>
                                <input
                                    type="number"
                                    id="price"
                                    className="form-control"
                                    value={price}
                                    onChange={(e) => setPrice(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="stockQuantity">Stock Quantity:</label>
                                <input
                                    type="number"
                                    id="stockQuantity"
                                    className="form-control"
                                    value={stockQuantity}
                                    onChange={(e) => setStockQuantity(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="category">Category:</label>
                                <input
                                    type="text"
                                    id="category"
                                    className="form-control"
                                    value={category}
                                    onChange={(e) => setCategory(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="subcategory">Sub Category:</label>
                                <input
                                    type="text"
                                    id="subcategory"
                                    className="form-control"
                                    value={subcategory}
                                    onChange={(e) => setSubcategory(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="brand">Brand:</label>
                                <input
                                    type="text"
                                    id="brand"
                                    className="form-control"
                                    value={brand}
                                    onChange={(e) => setBrand(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="image">Choose Image:</label>
                                <div className="custom-dropdown">
                                    <select
                                        id="image"
                                        className="form-control"
                                        onChange={handleSelectChange}
                                        value={selectedImage}
                                        required
                                    >
                                        <option value="">Select an image</option>
                                        {images.map(img => (
                                            <option key={img.id} value={img.id}>
                                                {`Image ${img.id}`}
                                            </option>
                                        ))}
                                    </select>
                                    {selectedImage && (
                                        <div className="image-preview mt-3">
                                            <img
                                                src={images.find(img => img.id === parseInt(selectedImage)).link}
                                                alt={`Image ${selectedImage}`}
                                                width="200"
                                                height="200"
                                            />
                                        </div>
                                    )}
                                </div>
                            </div>
                            <button type="submit" className="btn btn-primary mt-3">Add Product</button>
                        </form>
                    </div>
                </div>
            )}
        </div>
    );
};

AddProductForm.propTypes = {
    formVisible: PropTypes.bool.isRequired,
    onProductAdded: PropTypes.func.isRequired,
    setFormVisible: PropTypes.func.isRequired,
};

export default AddProductForm;
