import axios from 'axios'
import { API_URL } from '../Constants/Constant';

class UniversitService {
    getUniversity(){
        return axios.get(API_URL + '/university/ucs');
    }
}

export default new UniversitService();