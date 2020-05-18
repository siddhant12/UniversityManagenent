import React, { Component } from 'react';
import '../LoginComponent/LoginComponent.css'
import AuthenticationService from '../../helper/AuthenticationService';

class LoginComponent extends Component {
    constructor() {
        super();
        this.state = {
            username: "",
            password: ""
        }
    }

    onChange = (event) => {
        const { name, value } = event.target;
        this.setState({
            [name]: value
        })
    }

    onSubmit = (event) => {
        event.preventDefault();
        AuthenticationService.loginUser(this.state.username, this.state.password).then(respone => {
            AuthenticationService.setUserInSessionStorage(this.state.username, respone.data.token);
            this.props.history.push(`dashboard/${this.state.username}`);
        })
    }
    render() {
        return (
            <div className="container">
                <h2>LOGIN FORM</h2>
                <form id="form" onSubmit={this.onSubmit}>
                    <div>
                        <label for="name">Username:</label>
                        <input id="name" type="text"
                            name="username"
                            value={this.state.username}
                        placeholder="username"
                        onChange = {this.onChange}
                        />

                    </div>
                    <div>
                        <label for="password"> Password:</label>
                        <input id="password" type="password"
                            name="password"
                            value={this.state.password}
                            placeholder="password"
                            onChange={this.onChange}
                        />
                    </div>
                    <div>
                        <button className="login">Login</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default LoginComponent;