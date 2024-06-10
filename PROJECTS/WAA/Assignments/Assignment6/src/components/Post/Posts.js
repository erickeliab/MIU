import React, { useState } from 'react';
import Post from './Post';
import PostDetails from './PostDetails';
import ChangeTitle from './ChangeTitle';

export default function Posts() {
    const [currentPost, setCurrentPost] = useState(null);
    const [posts, setPosts] = useState([
        {
            id: 1,
            Title: "Reactjs",
            Author: "Erick",
            Content: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
        },
        {
            id: 2,
            Title: "Angularjs",
            Author: "Emmanuel",
            Content: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
        },
        {
            id: 3,
            Title: "Vuejs",
            Author: "Mgongo",
            Content: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
        },
    ]);

    const onSubmit = (title) => {
        const updatedPosts = posts.map((post, index) =>
            index === 0 ? { ...post, Title: title } : post
        );
        setPosts(updatedPosts);
    };

    const handlePostClick = (post) => {
        setCurrentPost(post)
    }

    return (
        <div className='container'>
            <div className='row'>
                {posts.map(post => (
                    <Post post={post} key={post.id} onClick={() => handlePostClick(post)} />
                ))}
            </div>

            <div className='container'>
                <ChangeTitle onSubmit={onSubmit} />
                <PostDetails post={currentPost} />
            </div>
        </div>
    );
}
