import React, { useRef } from 'react';
import axios from 'axios';

export default function NewPost({ onSubmit }) {
    const titleRef = useRef();
    const authorRef = useRef();
    const contentRef = useRef();

    const handleSubmit = (event) => {
        event.preventDefault();

        const newPost = {
            title: titleRef.current.value,
            author: authorRef.current.value,
            content: contentRef.current.value
        };

        axios.post('http://localhost:8080/api/posts', newPost, {
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(response => {
            onSubmit(response.data);  
        })
        .catch(err => {
            console.error(err);
        });
    };

    return (
        <section>
            <h2>Add Post</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Title</label>
                    <input
                        type="text"
                        name="title"
                        ref={titleRef}
                    />
                </div>
                <div>
                    <label>Author</label>
                    <input
                        type="text"
                        name="author"
                        ref={authorRef}
                    />
                </div>
                <div>
                    <label>Content</label>
                    <input
                        type="text"
                        name="content"
                        ref={contentRef}
                    />
                </div>
                <input
                    type="submit"
                    value="Submit"
                />
            </form>
        </section>
    );
}
