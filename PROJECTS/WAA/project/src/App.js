import React from 'react';
import { BrowserRouter } from 'react-router-dom';

import axios from 'axios'; 
import Main from './layouts/Main';

const App = () => {

  axios.defaults.baseURL='http://localhost:8080';


  return (
    <BrowserRouter>
      <Main/>
    </BrowserRouter>
  );
}

export default App;
