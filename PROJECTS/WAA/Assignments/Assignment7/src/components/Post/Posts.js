import React, { useEffect, useState, useCallback } from 'react';
import Post from './Post';
import PostDetails from './PostDetails';
import ChangeTitle from './ChangeTitle';
import axios from 'axios';
import NewPost from './NewPost';

export default function Posts() {
    const [currentPost, setCurrentPost] = useState(null);
    const [posts, setPosts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        handleFetch();
    }, []);

    const handleFetch = useCallback(async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/posts', {
                headers: {
                    "Content-Type": "application/json"
                }
            });
            setPosts(response.data);
        } catch (error) {
            setError(error.message);
        } finally {
            setLoading(false);
        }
    }, []);

    const onSubmit = useCallback((title) => {
        const updatedPosts = posts.map((post, index) =>
            index === 0 ? { ...post, title } : post
        );
        setPosts(updatedPosts);
    }, [posts]);

    
    const addPost = (newPost) => {
        console.log(newPost)
        setPosts((posts) => [...posts, newPost]);
    };
    

    const removePost = () => {
        const updatedPosts = posts.filter(post => post.id != currentPost.id);
        setPosts(updatedPosts);
    }

    const handlePostClick = useCallback((post) => {
        setCurrentPost(post);
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div className='container'>
            <div className='row'>
                {posts.length > 0 ? posts.map(post => (
                    <Post post={post} key={post?.id} onClick={() => handlePostClick(post)} />
                )) : <div>No posts available</div>}
            </div>
            <div className='container'>
                <NewPost onSubmit={addPost} />
            </div>
            <div className='container'>
                <ChangeTitle onSubmit={onSubmit} />
                {currentPost && <PostDetails post={currentPost} removePost={removePost} />}
            </div>
        </div>
    );
}
