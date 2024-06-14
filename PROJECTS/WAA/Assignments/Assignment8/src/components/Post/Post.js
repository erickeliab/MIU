import React, { useState } from 'react';

export default function Post({ post, onClick }) {

    if (!post) {
        <p>NO POST</p>
    }

    return (
        <div onClick={onClick} className='container card' style={{ cursor: 'pointer', border: '1px solid #ccc', padding: '10px', margin: '10px' }}>
            <ul>
                <li>id: {post.id}</li>
                <li>Title: {post.title}</li>
                <li>Author: {post.author}</li>
            </ul>
        </div>
    );
}
