import { GET_STUDENTS } from "../actions/types";

const initalState = {
    students: [],
    student: {}
}

export default function(state = initalState,action){
    switch(action.type){
        case GET_STUDENTS:
            return {
                ...state, students: action.payload
            }
        default:
            return state;
    }
}