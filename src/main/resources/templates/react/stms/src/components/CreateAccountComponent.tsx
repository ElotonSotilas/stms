import React, {Component} from 'react';
import AccountService from "../services/AccountService";
import {Navigate} from "react-router";

class CreateAccountComponent extends Component <{},
    {first_name: string, last_name: string, email: string}> {

    constructor(props: any) {
        super(props);

        this.state = {
            first_name: '',
            last_name: '',
            email: ''
        }

        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.addAccount = this.addAccount.bind(this)
    }

    changeFirstNameHandler = (event: any) => {
        this.setState({
            first_name: event.target.value
        })
    }

    changeLastNameHandler = (event: any) => {
        this.setState({
            last_name: event.target.value
        })
    }

    changeEmailHandler = (event: any) => {
        this.setState({
            email: event.target.value
        })
    }

    addAccount = (event: any) => {
        event.preventDefault()
        let account = {
            first_name: this.state.first_name,
            last_name: this.state.last_name,
            email: this.state.email
        };
        console.log("account = " + JSON.stringify(account))

        AccountService.newAccount(account).then(_res => {
            <Navigate to="account" replace={true}/>
        })
    }

    render() {
        return (
            <div className="Container">
                <br/>
                <div className="Row">
                    <div className="card col-md-6 offset-md-3">
                        <h3 className="text-center">Account Wizard</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label>First Name</label>
                                    <input type="text" placeholder="First Name" name="first_name" className="form-control"
                                           defaultValue={this.state.first_name} onChange={this.changeFirstNameHandler}/>
                                </div>

                                <div className="form-group">
                                    <label>Last Name</label>
                                    <input type="text" placeholder="Last Name" name="last_name" className="form-control"
                                           defaultValue={this.state.last_name} onChange={this.changeLastNameHandler}/>
                                </div>

                                <div className="form-group">
                                    <label>Email</label>
                                    <input type="email" placeholder="Email" name="email" className="form-control"
                                           defaultValue={this.state.email} onChange={this.changeEmailHandler}/>
                                </div>

                                <button className="btn btn-success" onClick={this.addAccount}>Add Account</button>
                                <button className="btn btn-danger" onClick={(e) => {
                                    e.preventDefault();
                                    window.location.href="account"
                                }} style={{marginLeft: "10px"}}>Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateAccountComponent;