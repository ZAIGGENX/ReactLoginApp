import React from "react";
import "./App.css";
import { BrowserRouter as Router, Routes, Route }
    from "react-router-dom";
import LoginComponent from "./components/LoginComponent";
import Register from "./components/Register";
import Home from "./components/Home";
 
function App() {
    return (
        <Router>
            <Routes>
                <Route path="/login" element={<LoginComponent />} />
                <Route path="/register" element={<Register />} />
                <Route path="/home" element={<Home />} />
                <Route path="/" element={<LoginComponent />} />
            </Routes>
        </Router>
    );
}
 
export default App;
