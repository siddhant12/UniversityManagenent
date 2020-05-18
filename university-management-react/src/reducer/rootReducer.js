import {combineReducers} from 'redux'
import subjectReducer from './subjectReducer';
import universityReducer from './universityReducer';
import studentReducer from './studentReducer';

export default combineReducers({
    subjects: subjectReducer,
    university: universityReducer,
    students: studentReducer
})