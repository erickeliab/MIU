import React, { useState } from 'react';

export default function ChangeTitle({ onSubmit }) {
    const [title, setTitle] = useState("");

    const handleChange = (event) => {
        setTitle(event.target.value);
    };

    const handleSubmit = () => {
        onSubmit(title);
    };

    return (
        <section>
            <h5>Change Title of the first</h5>
            <input
                type="text"
                name="title"
                value={title}
                onChange={handleChange}
            />
            <input
                type="submit"
                onClick={handleSubmit}
                value="Submit"
            />
        </section>
    );
}
