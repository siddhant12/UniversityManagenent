import React from 'react'
import AuthenticationService from '../../helper/AuthenticationService';
import { connect } from 'react-redux'
import { getAllStudents } from '../../actions/studentAction';
import './Dashboard.css'

class Dashboard extends React.Component {

    constructor() {
        super();
        this.state = {
            firstName: "",
            lastName: ""
        }
    }

    componentDidMount() {
        AuthenticationService.setupAxiosInterceptorForJWT();
        const username = this.props.match.params.username;
        console.log(username);
        AuthenticationService.getUserByUsername(username).then((response) => {
            this.setState({
                firstName: response.data.firstName,
                lastName: response.data.lastName
            })
        });
        this.props.getAllStudents();
    }

    render() {
        const {students} = this.props.students;
        console.log(students)
        return (
            <div>
                <h1>{"Welcome " + this.state.firstName + " " + this.state.lastName}</h1>
                <div>
                    <h3>You can see Information About....</h3>
                    <div id = "information-container">
                        <ul id= "information-list-container">
                            <li id="information-li">Teacher</li>
                            <li id="information-li">Students</li>
                            <li id="information-li">Subjects</li>
                        </ul>
                    </div>
                </div>
            </div>
        );
    };
}

const mapStateToProps = (state) => ({
    students: state.students
})



export default connect(mapStateToProps,{getAllStudents})(Dashboard);