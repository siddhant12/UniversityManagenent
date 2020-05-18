import UniversityService from "../helper/UniversityService";
import { GET_UNIVERSITY} from './types';

export const getUniversity = () => async dispatch => {
    const res = await UniversityService.getUniversity();
    dispatch({
        type: GET_UNIVERSITY,
        payload: res.data
    })
}