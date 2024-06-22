
import { createSlice} from '@reduxjs/toolkit';

const initialCounterState = { counter: 0, showCounter: true };

const  cartSlice = createSlice(
    {
        name: 'counter',
        initialState: initialCounterState,
        reducers: {
            increment(state) {
                state.counter++;
            },
            decrement(state) {
                state.counter--;
            },
            increase(state, action) {
                state.counter = state.counter + action.payload;
            },
            setInitial(state, action) {
                state.counter = action.payload;
            }
        }
    }
);

export default cartSlice;