import React, {Component} from 'react';
import {useNavigate} from "react-router";

// @ts-ignore
function Heading() {
    let navigate = useNavigate();

    return (
        <div className="navbar-brand">
            <a onClick={() => navigate("/")} className="unselectable">Simple Task Management System</a>
        </div>
    )
}

class HeaderComponent extends Component {
    constructor(props: any) {
        super(props);

        this.state = {
            query: ""
        }
    }

    render() {
        return (
            <div>
                <header className="header">
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <Heading/>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;