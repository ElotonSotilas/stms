import React, {useState} from 'react';
import AccountService from "../services/AccountService";
import {useNavigate} from "react-router";

function CreateAccountComponent() {
    let [first_name, setFirst_name] = useState('');
    let [last_name, setLast_name] = useState('');
    let [email, setEmail] = useState('');
    let navigate = useNavigate();

    const changeFirstNameHandler = (event) => {
        setFirst_name(event.target.value)
    }

    const changeLastNameHandler = (event) => {
        setLast_name(event.target.value)
    }

    const changeEmailHandler = (event) => {
        setEmail(event.target.value)
    }

    let addAccount = (event) => {
        event.preventDefault()
        let account = {
            first_name: first_name,
            last_name: last_name,
            email: email
        }

        AccountService.newAccount(account).then(() => {
            navigate("/account", {replace: true});
        })
    }

    return (
        <div className="Container">
            <br/>
            <div className="Row">
                <div className="card col-md-6 offset-md-3 bg-transparent border-0">
                    <h3 className="text-center">Account Wizard</h3>
                    <div className="card-body">
                        <form>
                            <div className="form-group">
                                <label className="required">First Name</label>
                                <input type="text" placeholder="First Name" name="first_name" className="form-control"
                                       defaultValue={first_name} onChange={changeFirstNameHandler}/>
                            </div>

                            <div className="form-group">
                                <label className="required">Last Name</label>
                                <input type="text" placeholder="Last Name" name="last_name" className="form-control"
                                       defaultValue={last_name} onChange={changeLastNameHandler}/>
                            </div>

                            <div className="form-group">
                                <label className="required">Email</label>
                                <input type="email" placeholder="Email" name="email" className="form-control"
                                       defaultValue={email} onChange={changeEmailHandler}/>
                            </div>

                            <button className="btn btn-success" onClick={addAccount}>Add Account</button>
                            <button className="btn btn-danger" onClick={() => {
                                navigate("/account", {replace: true})}}
                                    style={{marginLeft: "10px"}}>Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default CreateAccountComponent;