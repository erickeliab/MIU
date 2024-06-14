// PostContext.js
import React, { createContext, useState } from 'react';

const PostContext = createContext();

export const PostProvider = ({ children }) => {
    const [currentPost, setCurrentPost] = useState(null);

    return (
        <PostContext.Provider value={{ currentPost, setCurrentPost }}>
            {children}
        </PostContext.Provider>
    );
};

export default PostContext;
