import { GET_SUBJECTS } from "../actions/types";

const initialState = {
    subjects: [],
    subject: {}
}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_SUBJECTS:
            return {
                ...state, subjects: action.payload
            };
        default:
            return state
    }
}