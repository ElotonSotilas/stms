import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import ListAccountComponent from "./components/ListAccountComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CreateAccountComponent from "./components/CreateAccountComponent";
import UpdateAccountComponent from "./components/UpdateAccountComponent";

function App() {
  return (
    <div>
        <Router>
            <HeaderComponent/>
            <div className="container">
                <Routes>
                    // Account routing (including root path)
                    <Route path="/" element={<ListAccountComponent/>} />
                    <Route path="/account" element={<ListAccountComponent/>} />
                    <Route path="/add-account" element={<CreateAccountComponent/>} />
                    <Route path="/update-account/:id" element={<UpdateAccountComponent/>} />

                    // Project
                    <Route path="/project" element={<ListAccountComponent/>} />
                    <Route path="/add-project" element={<CreateAccountComponent/>} />
                    <Route path="/update-project/:id" element={<UpdateAccountComponent/>} />

                    // Board
                    <Route path="/board" element={<ListAccountComponent/>} />
                    <Route path="/add-board" element={<CreateAccountComponent/>} />
                    <Route path="/update-board/:id" element={<UpdateAccountComponent/>} />

                    // Task
                    <Route path="/task" element={<ListAccountComponent/>} />
                    <Route path="/add-task" element={<CreateAccountComponent/>} />
                    <Route path="/update-task/:id" element={<UpdateAccountComponent/>} />
                </Routes>
            </div>
            <FooterComponent/>
        </Router>
    </div>
  );
}

export default App;
