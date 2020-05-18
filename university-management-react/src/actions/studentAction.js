import StudentService from "../helper/StudentService";
import { GET_STUDENTS } from "./types";

export const getAllStudents = () => async dispatch => {
    const res = await StudentService.getAllStudents();
    dispatch({
        type: GET_STUDENTS,
        payload: res.data
    })
}