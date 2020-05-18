import React, { Component } from 'react';
import AuthenticationService from '../../helper/AuthenticationService';
import { getAllSubjects } from '../../actions/subjectAction';
import { connect } from 'react-redux'
import { getUniversity } from '../../actions/universityAction';

class AboutComponent extends Component {

    constructor() {
        super();
        this.state = {
            universityName: "",
            universityCode: "",
            subjects: []
        }
    }

    componentDidMount() {
        AuthenticationService.setupAxiosInterceptorForJWT();
        this.props.getAllSubjects();
        this.props.getUniversity();
    }
    render() {
        const { subjects } = this.props.subjects;
        const {university} = this.props.university;
        return (
            <div>
                <h1>About University Of Computer Science</h1>
                <div>
                    <div>
                        <h3>University Name:</h3>
                        <p>{university.universityName}</p>
                        <h3>University Code:</h3>
                        <p>{university.universityCode}</p>
                        <h3>University Subjects:</h3>
                        {
                            subjects.map(subject => {
                                return (
                                    <div key={subject.id}>
                                        <h4>Subject Code:</h4>
                                        <p>{subject.subjectCode}</p>
                                        <h4>Subject Name:</h4>
                                        <p>{subject.subjectName}</p>
                                    </div>
                                )
                            })
                        }
                    </div>
                </div>
            </div>
        );
    }
}


const mapStateToProps = (state) => ({
    subjects: state.subjects,
    university: state.university
})

export default connect(mapStateToProps, { getAllSubjects, getUniversity })(AboutComponent);