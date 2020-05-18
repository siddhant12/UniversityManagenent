import SubjectService from '../helper/SubjectService';
import { GET_SUBJECTS} from './types';

export const getAllSubjects = () => async dispatch => {
        const res = await SubjectService.getAllSubject();
        dispatch({
            type: GET_SUBJECTS,
            payload: res.data
        })
}