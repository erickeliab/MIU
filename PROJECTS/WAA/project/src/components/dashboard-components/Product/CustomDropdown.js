import React, { useState } from 'react';

const CustomDropdown = ({ images }) => {
    const [selectedImage, setSelectedImage] = useState(images[0]?.id);

    const handleSelectChange = (event) => {
        setSelectedImage(event.target.value);
    };

    return (
        <div className="custom-dropdown">
            <select onChange={handleSelectChange} value={selectedImage}>
                {images.map(img => (
                    <option key={img.id} value={img.id}>
                        {`Image ${img.id}`}
                    </option>
                ))}
            </select>
            <div className="image-preview">
                {images.map(img => (
                    img.id === selectedImage && (
                        <img key={img.id} src={img.link} alt={`Image ${img.id}`} width="200" height="200" />
                    )
                ))}
            </div>
        </div>
    );
};

export default CustomDropdown;
