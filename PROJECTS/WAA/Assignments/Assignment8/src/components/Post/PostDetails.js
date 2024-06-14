// PostDetails.js
import axios from 'axios';
import React, { useEffect, useState, useContext } from 'react';
import PostContext from '../../context/PostContext';

export default function PostDetails({ removePost }) {
    const { currentPost } = useContext(PostContext);
    const [showAlert, setShowAlert] = useState(false);
    const [alert, setAlert] = useState("");
    const [fetchedPost, setFetchedPost] = useState(null);

    const handleFetch = () => {
        axios.get(`http://localhost:8080/api/posts/${currentPost.id}`, {
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(response => {
            setFetchedPost(response.data);
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
        axios.delete(`http://localhost:8080/api/posts/${currentPost.id}`, {
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(response => {
            setAlert("Post deleted successfully");
            setShowAlert(true);
            setFetchedPost(null);
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
        if (currentPost) {
            handleFetch();
        }
    }, [currentPost]);  

    if (!currentPost) {
        return <div>Select a post to see details</div>;
    }

    if (!fetchedPost) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            {showAlert && <div className="alert">{alert}</div>}
            <h2>{fetchedPost.title}</h2>
            <p>Author: {fetchedPost.author}</p>
            <p>{fetchedPost.content}</p>
            {fetchedPost.comments?.map((comment, index) => <div key={index}>{comment.name}</div>)}
            <div className='row'>
                <button onClick={handleDelete}>Delete Post</button>
            </div>
        </div>
    );
}
