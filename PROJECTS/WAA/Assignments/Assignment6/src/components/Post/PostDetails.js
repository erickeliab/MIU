import React from 'react';

export default function PostDetails({ post }) {
    if (!post) {
        return <div>Select a post to see details</div>;
    }

    return (
        <div>
            <h2>{post.Title}</h2>
            <p>Author: {post.Author}</p>
            <p>{post.Content}</p>
            <div className='row'>
                 <button>Edit Post</button>  <button>Delete Post</button>
            </div>
        </div>
    );
}
