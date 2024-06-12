import axios from 'axios';
import React, { useEffect, useState } from 'react';

export default function PostDetails({ post, removePost }) {
    const [showAlert, setShowAlert] = useState(false);
    const [alert, setAlert] = useState("");
    const [currentPost, setCurrentPost] = useState(null);

    const handleFetch = () => {
        axios.get(`http://localhost:8080/api/posts/${post.id}`, {
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(response => {
            setCurrentPost(response.data);
            setAlert("Success");
            setShowAlert(true);
            setTimeout(() => setShowAlert(false), 3000);  // Clear alert after 3 seconds
        })
        .catch(err => {
            setAlert("Oops! Failed to fetch this post");
            setShowAlert(true);
            setTimeout(() => setShowAlert(false), 3000);  // Clear alert after 3 seconds
        });
    };

    const handleDelete = () => {
        axios.delete(`http://localhost:8080/api/posts/${post.id}`, {
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(response => {
            setAlert("Post deleted successfully");
            setShowAlert(true);
            setCurrentPost(null);
            removePost();
            setTimeout(() => setShowAlert(false), 3000);  
        })
        .catch(err => {
            setAlert("Oops! Failed to delete this post");
            setShowAlert(true);
            setTimeout(() => setShowAlert(false), 3000);  
        });
    };

    useEffect(() => {
        if (post) {
            handleFetch();
        }
    }, [post]);  

    if (!post) {
        return <div>Select a post to see details</div>;
    }

    if (!currentPost) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            {showAlert && <div className="alert">{alert}</div>}
            <h2>{currentPost.title}</h2>
            <p>Author: {currentPost.author}</p>
            <p>{currentPost.content}</p>
            {currentPost.comments?.map((comment, index) => <div key={index}>{comment.name}</div>)}
            <div className='row'>
                <button onClick={handleDelete}>Delete Post</button>
            </div>
        </div>
    );
}
