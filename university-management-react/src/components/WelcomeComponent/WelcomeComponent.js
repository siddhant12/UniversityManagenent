import React, { Component } from 'react';
import './WelcomeComponent.css'

class WelcomeComponent extends Component {
    render() {
        return (
            <div>
                <div id="firstDiv">
                    <p>Hello</p>
                </div>
                <div>
                    hello how are you <p>this is para</p>
                </div>
                <h1 id="heading">First Heading</h1>
                
                <ul id="socialContainer">
                    <li className="socialItem">Facebook</li>
                    <li className="socialItem">Twitter</li>
                    <li className="socialItem">WhatsApp</li>
                    <li className="socialItem">Zoom</li>
                    <li className="socialItem">Skype</li>
                </ul>
            </div>

        );
    }
}

export default WelcomeComponent;