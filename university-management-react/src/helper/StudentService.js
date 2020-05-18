import axios from 'axios'
import { API_URL } from '../Constants/Constant';

class StudentService {
    getAllStudents(){
        return axios.get(API_URL + '/student/all');
    }
}

export default new StudentService();