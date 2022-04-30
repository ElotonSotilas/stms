import React, {Component} from 'react';
import AccountService from "../services/AccountService";
import {Navigate} from "react-router";
import DangerButton from "../templates/DangerButton";

class UpdateAccountComponent extends Component <{},
    {id: any, first_name: string, last_name: string, email: string}> {

    constructor(props: any) {
        super(props);

        this.state = {
            id: '',
            first_name: '',
            last_name: '',
            email: ''
        }

        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.updateAccount = this.updateAccount.bind(this)
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

    updateAccount = (event: any) => {
        event.preventDefault()
        let account = {
            id: this.state.id,
            first_name: this.state.first_name,
            last_name: this.state.last_name,
            email: this.state.email
        }

        AccountService.modifyAccount(this.state.id, account).then((res) => {
            let account = res.data;
            this.setState({
                id: account.id,
                first_name: account.first_name,
                last_name: account.last_name,
                email: account.email
            })
        })

        return (<Navigate to="/account"/>)
    }

    componentDidMount() {
        AccountService.getAccountById(this.state.id).then((res) => {
            let account = res.data;
            this.setState({
                id: account.id,
                first_name: account.first_name,
                last_name: account.last_name,
                email: account.email
            })
        })
    }

    render() {
        document.body.classList.add("removeSearch");
        return (
            <div className="Container">
                <br/>
                <div className="Row">
                    <div className="card col-md-6 offset-md-3 bg-transparent border-0">
                        <h3 className="text-center">Account Wizard » Update Account {this.state.id}</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label className="required">First Name</label>
                                    <input type="text" placeholder="First Name" name="first_name" className="form-control"
                                           value={this.state.first_name} onChange={this.changeFirstNameHandler}/>
                                </div>

                                <div className="form-group">
                                    <label className="required">Last Name</label>
                                    <input type="text" placeholder="Last Name" name="last_name" className="form-control"
                                           value={this.state.last_name} onChange={this.changeLastNameHandler}/>
                                </div>

                                <div className="form-group">
                                    <label className="required">Email</label>
                                    <input type="email" placeholder="Email" name="email" className="form-control"
                                           value={this.state.email} onChange={this.changeEmailHandler}/>
                                </div>

                                <button className="btn btn-success" onClick={this.updateAccount}>Update Account</button>
                                <DangerButton screenName="/account" text="Cancel"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default UpdateAccountComponent;