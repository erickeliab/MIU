
import {  configureStore } from '@reduxjs/toolkit';
import counterSlice from './Slices/CounterSlice';
import authSlice from './Slices/AuthSlice'
import cartSlice from './Slices/CartCountSlice';

const store = configureStore({
    reducer: {
        counter: counterSlice.reducer,
        auth: authSlice.reducer,
        cart: cartSlice.reducer
    }
});

export const counterActions = counterSlice.actions;
export const authActions = authSlice.actions;
export const cartCountsActions = cartSlice.actions;

export default store;
