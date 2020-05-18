import React, { Component } from 'react';
import AuthenticationService from '../../helper/AuthenticationService';
import './SignupController.css'

class SignupController extends Component {
    constructor() {
        super();
        this.state = {
            firstName: "",
            lastName: "",
            username: "",
            password: "",
            confirmPassword: "",
            dob: ""
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
        const user = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            username: this.state.username,
            password: this.state.password,
            confirmPassword: this.state.confirmPassword,
            dob: this.state.dob
        }
        console.log(user)
        AuthenticationService.registerUser(user).then((response) => {
            console.log(response.data)
            this.props.history.push(`/login`)
        }).catch(err => {
            console.log(err)
        })
    }
    render() {
        return (
            <div>
                <h1>Sign up Form</h1>
                <form onSubmit={this.onSubmit} id="signup-form">
                    <div className="signup-fields">
                        <label for="firstName">First Name:</label>
                        <input type="text"
                            id="firstName"
                            name="firstName"
                            placeholder="First Name"
                            value={this.state.firstName}
                            onChange={this.onChange}
                        />
                    </div>

                    <div className="signup-fields">
                        <label for="lastName">Last Name:</label>
                        <input type="text"
                            id="lastName"
                            name="lastName"
                            placeholder="Last Name"
                            value={this.state.lastName}
                            onChange={this.onChange}
                        />
                    </div>

                    <div className="signup-fields"> 
                        <label for="email">Email:</label>
                        <input type="text"
                            id="email"
                            name="username"
                            placeholder="Username"
                            value={this.state.username}
                            onChange={this.onChange}
                        />
                    </div>

                    <div className="signup-fields">
                        <label for="password">Password:</label>
                        <input type="password"
                            id="password"
                            name="password"
                            placeholder="Password"
                            value={this.state.password}
                            onChange={this.onChange}
                        />
                    </div>

                    <div className="signup-fields">
                        <label for="confirmPassword">Confirm Password:</label>
                        <input type="password"
                            id="confirmPassword"
                            name="confirmPassword"
                            placeholder="ConfirmPassword"
                            value={this.state.confirmPassword}
                            onChange={this.onChange}
                        />
                    </div>

                    <div className="signup-fields">
                        <label for="date">Date:</label>
                        <input type="date"
                            id="date"
                            name="dob"
                            placeholder="Date Of Birth"
                            value={this.state.dob}
                            onChange={this.onChange}
                        />
                    </div>

                    <div>
                        <button id="signup-button">Sign Up</button>
                    </div>

                </form>
            </div>
        );
    }
}

export default SignupController;