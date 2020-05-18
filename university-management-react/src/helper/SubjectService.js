import axios from 'axios';
import { API_URL } from '../Constants/Constant';

class SubjectService {

    getAllSubject(){
        return axios.get(API_URL + '/subject/all');
    }

}

export default new SubjectService();