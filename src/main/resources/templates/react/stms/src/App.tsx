import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import ListAccountComponent from "./components/ListAccountComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CreateAccountComponent from "./components/CreateAccountComponent";

function App() {
  return (
    <div>
        <Router>
            <HeaderComponent/>
            <div className="container">
                <Routes>
                    <Route path="/" element={<ListAccountComponent/>} />
                    <Route path="account" element={<ListAccountComponent/>} />
                    <Route path="add-account" element={<CreateAccountComponent/>} />
                </Routes>
            </div>
            <FooterComponent/>
        </Router>
    </div>
  );
}

export default App;
