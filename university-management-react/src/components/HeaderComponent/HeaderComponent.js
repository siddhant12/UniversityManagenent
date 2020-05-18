import React, { Component } from 'react';
import './HeaderComponent.css'
import { Link } from 'react-router-dom';
import { USER_NAME_SESSION_ATTRIBUTE, JWT_TOKEN } from '../../Constants/Constant';
import { withRouter } from 'react-router'
import AuthenticationService from '../../helper/AuthenticationService';

class HeaderComponent extends Component {
    logout = () => {
        sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE)
        sessionStorage.removeItem(JWT_TOKEN);
        this.props.history.push("/");
    }
    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return (
            <div>
                <ul className="listContainer">
                    <Link to="/"><li className = "listItem">UCS</li></Link>
                    <Link to="/about"><li className = "listItem">About</li></Link>
                    <li className = "listItem">Contact</li>
                    {isUserLoggedIn && <Link to="/logout" onClick={this.logout}><li className = "listItem" style={{ float: "right" }}>Logout</li></Link>}
                    {!isUserLoggedIn && <Link to="/signup"><li className = "listItem" style={{ float: "right" }}>Sign Up</li></Link>}
                    {!isUserLoggedIn && <Link to="/login"><li className = "listItem" style={{ float: "right" }}>Login</li></Link>}
                </ul>
            </div>
        );
    }
}

export default withRouter(HeaderComponent);