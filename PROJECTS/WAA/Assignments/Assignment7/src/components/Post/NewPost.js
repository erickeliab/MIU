import React, { useState } from 'react';
import axios from 'axios';

export default function NewPost({ onSubmit }) {
    const [title, setTitle] = useState("");
    const [author, setAuthor] = useState("");
    const [content, setContent] = useState("");

    const handleChange = (event) => {
        switch (event.target.name) {
            case "title":
                setTitle(event.target.value);
                break;
            case "author":
                setAuthor(event.target.value);
                break;
            case "content":
                setContent(event.target.value);
                break;
            default:
                break;
        }
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        const newPost = {
            title, author, content
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
                        value={title}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Author</label>
                    <input
                        type="text"
                        name="author"
                        value={author}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Content</label>
                    <input
                        type="text"
                        name="content"
                        value={content}
                        onChange={handleChange}
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
