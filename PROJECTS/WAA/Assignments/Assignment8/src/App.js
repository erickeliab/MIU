import logo from './logo.svg';
import './App.css';
import Posts from './components/Post/Posts';
import Dashboard from './components/Dashboard';
import { PostProvider } from './context/PostContext';

function App() {
  return (
    <PostProvider>
        <Dashboard />
    </PostProvider>
);
}

export default App;
