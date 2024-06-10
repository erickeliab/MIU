import React from 'react';

export default function Post({ post, onClick }) {
    return (
        <div onClick={onClick} className='container card' style={{ cursor: 'pointer', border: '1px solid #ccc', padding: '10px', margin: '10px' }}>
            <ul>
                <li>id: {post.id}</li>
                <li>Title: {post.Title}</li>
                <li>Author: {post.Author}</li>
            </ul>
        </div>
    );
}
