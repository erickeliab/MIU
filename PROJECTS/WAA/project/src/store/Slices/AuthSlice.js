import { createSlice } from '@reduxjs/toolkit';

// Function to load the initial state from localStorage
const loadStateFromLocalStorage = () => {
  try {
    const serializedState = localStorage.getItem('authState');
    if (serializedState === null) {
      return { isAuthenticated: false };
    }
    return JSON.parse(serializedState);
  } catch (err) {
    console.error("Could not load state from localStorage", err);
    return { isAuthenticated: false };
  }
};

// Function to save the current state to localStorage
const saveStateToLocalStorage = (state) => {
  try {
    const serializedState = JSON.stringify(state);
    localStorage.setItem('authState', serializedState);
  } catch (err) {
    console.error("Could not save state to localStorage", err);
  }
};

const initialAuthState = loadStateFromLocalStorage();

const authSlice = createSlice({
  name: 'authentication',
  initialState: initialAuthState,
  reducers: {
    loginSuccessful(state) {
      state.isAuthenticated = true;
      saveStateToLocalStorage(state);
    },
    logout(state) {
      state.isAuthenticated = false;
      saveStateToLocalStorage(state);
    },
  },
});

export const { loginSuccessful, logout } = authSlice.actions;
export default authSlice;
