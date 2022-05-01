import React, {Component} from 'react';
import AccountService from "../services/AccountService";
import NavigationButton from "../templates/NavigationButton";
import {useNavigate} from "react-router";

let result;

class ListAccountComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            accounts: []
        }
    }

    componentDidMount() {
        AccountService.getAccounts().then((res) => {
            this.setState({
                accounts: res.data
            })
        })
    }

    render() {
        return (
            <div>
                <br/>
                <h2 className="text-center">Accounts List</h2>
                <div style={{
                    justifyContent: "stretch",
                    display: "inline-flex",
                    paddingBlockEnd: 12
                }}>
                    <NavigationButton screenName="/add-account" text="Create an Account"/>
                    <button className="align-update invisible-button" onClick={() => {
                        AccountService.getAccounts().then((res) => {
                            this.setState({
                                accounts: res.data
                            })
                        })
                    }}>🔄</button>
                </div>
                <br/>

                <div className="row">
                    <table className="beautiful-table">
                        <thead>
                        <tr>
                            <th>Account ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Created At</th>
                            <th>Updated At</th>
                            <th>Actions</th>
                        </tr>
                        </thead>

                        <tbody>
                        {
                            this.state.accounts.map(
                                (account) => <tr key={account.id}>
                                    <td>{account.account_id}</td>
                                    <td>{account.first_name}</td>
                                    <td>{account.last_name}</td>
                                    <td>{account.email}</td>
                                    <td>{account.created_at}</td>
                                    <td>{account.updated_at}</td>
                                    <td>
                                        <UpdateAccountButton id={account.account_id}/>
                                        <DeleteAccountButton id={account.account_id}/>
                                    </td>
                                </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

function UpdateAccountButton({id}) {
    let navigate = useNavigate();
    let page = "/update-account/" + id;
    return (
        <button onClick={
            () => {
                navigate(page, {replace: true})
            }
        } className="invisible-button">⚙️</button>
    )
}

function DeleteAccountButton({id}) {
    return (
        <button onClick={
            () => {
                AccountService.dropAccount(id).then((res) => {
                    result = res;
                })
            }
        } className="invisible-button">🗑️</button>
    )
}

export default ListAccountComponent;