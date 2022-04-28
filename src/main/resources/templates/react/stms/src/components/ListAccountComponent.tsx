import React, {Component} from 'react';
import AccountService from "../services/AccountService";

class ListAccountComponent extends Component {
    constructor(props: any) {
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

                <div className="ui-button">
                    <button className="btn btn-primary" onClick={(e) => {
                        e.preventDefault();
                        window.location.href="add-account"
                    }}>Create an Account</button>
                </div>
                <br/>

                <div className="row">
                    <table className="table table-striped table-bordered">
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
                            // @ts-ignore
                            this.state.accounts.map (
                                (account: any) => <tr key = {account.id}>
                                    <td>{account.account_id}</td>
                                    <td>{account.first_name}</td>
                                    <td>{account.last_name}</td>
                                    <td>{account.email}</td>
                                    <td>{account.created_at}</td>
                                    <td>{account.updated_at}</td>
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

export default ListAccountComponent;