import React, {useEffect, useState} from 'react';
import AccountService from "../services/AccountService";
import {useNavigate} from "react-router";

function UpdateAccountComponent() {
    const id = window.location.pathname.split('/').at(2);

    let [state, setState] = useState({
        first_name: '',
        last_name: '',
        email: ''
    });

    let navigate = useNavigate();

    useEffect(() => {
        AccountService.getAccountById(id).then((res) => {
            let account = res.data;
            let s = {
                first_name: account.first_name,
                last_name: account.last_name,
                email: account.email
            }
            setState(s);
        })
    }, [id])

    const changeFirstNameHandler = (event) => {
        let s = {
            first_name: event.target.value,
            last_name: state.last_name,
            email: state.email
        }
        setState(s)
    }

    const changeLastNameHandler = (event) => {
        let s = {
            first_name: state.first_name,
            last_name: event.target.value,
            email: state.email
        }
        setState(s)
    }

    const changeEmailHandler = (event) => {
        let s = {
            first_name: state.first_name,
            last_name: state.last_name,
            email: event.target.value
        }
        setState(s)
    }

    const updateAccount = () => {
        let account = {
            first_name: state.first_name,
            last_name: state.last_name,
            email: state.email
        }

        AccountService.modifyAccount(id, account).then((res) => {
            let data = res.data;
            let s = {
                first_name: data.first_name,
                last_name: data.last_name,
                email: data.email
            }
            setState(s)

            return navigate("/account", {replace: true});
        })
    }

    return (
        <div className="Container">
            <br/>
            <div className="Row">
                <div className="card col-md-6 offset-md-3 bg-transparent border-0">
                    <h3 className="text-center">Account Wizard » Update Account [{window.location.pathname.split('/').at(2)}]</h3>
                    <div className="card-body">
                        <form>
                            <div className="form-group">
                                <label className="required">First Name</label>
                                <input type="text" placeholder="First Name" name="first_name" className="form-control"
                                       defaultValue={state.first_name} onChange={changeFirstNameHandler}/>
                            </div>

                            <div className="form-group">
                                <label className="required">Last Name</label>
                                <input type="text" placeholder="Last Name" name="last_name" className="form-control"
                                       defaultValue={state.last_name} onChange={changeLastNameHandler}/>
                            </div>

                            <div className="form-group">
                                <label className="required">Email</label>
                                <input type="email" placeholder="Email" name="email" className="form-control"
                                       defaultValue={state.email} onChange={changeEmailHandler}/>
                            </div>

                            <button className="btn btn-success" type={"button"} onClick={updateAccount}>Update Account</button>
                            <button className="btn btn-danger" onClick={() => {
                                navigate("/account", {replace: true})}}
                                    style={{marginLeft: "10px"}}>Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default UpdateAccountComponent;