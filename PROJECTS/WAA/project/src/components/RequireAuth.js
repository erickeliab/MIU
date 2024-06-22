import { useSelector } from "react-redux";
import { useLocation, Navigate, Outlet } from "react-router-dom";
import React from "react";

const RequireAuth = () => {
    const isAuthenticated = useSelector(state => state.auth.isAuthenticated); // put the name of the slice
    const location = useLocation();

    return (
        isAuthenticated
            ? <Outlet />
            : <Navigate to="/login" state={{ from: location }} replace />
    );
}

export default RequireAuth;