import { GET_UNIVERSITY } from "../actions/types";

const initalState = {
    university: {}
}

export default function (state = initalState, action) {
    switch (action.type) {
        case GET_UNIVERSITY:
            return {
                ...state, university: action.payload
            }
        default:
            return state;
    }

}

