import React, { Component } from 'react';
import HeaderComponent from '../HeaderComponent/HeaderComponent';
import { Route } from 'react-router-dom';
import Dashboard from '../Dashboard/Dashboard';
import LoginComponent from '../LoginComponent/LoginComponent';
import SignupController from '../SignupController/SignupController';
import WelcomeComponent from '../WelcomeComponent/WelcomeComponent';
import AboutComponent from '../AboutComponent/AboutComponent';

class HomeComponent extends Component {
    render() {
        return (
            <div>
                <HeaderComponent />
                <Route exact path="/" component={WelcomeComponent} />
                <Route exact path="/login" component={LoginComponent} />
                <Route exact path="/signup" component={SignupController} />
                <Route exact path = "/dashboard/:username" component = {Dashboard} />
                <Route exact path = "/about" component = {AboutComponent} />
            </div>
        );
    }
}

export default HomeComponent;