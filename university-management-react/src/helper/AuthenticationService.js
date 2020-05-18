import axios from 'axios'
import { API_URL, USER_NAME_SESSION_ATTRIBUTE, JWT_TOKEN } from '../Constants/Constant';

class AuthenticationService {
    registerUser(user){
        return axios.post(API_URL+ '/user/register',user);
    }

    loginUser(username,password){
        return axios.post(API_URL+'/user/login',{
            username,
            password
        });
    }

    isUserLoggedIn(){
        const user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE);
        if(user != null)
            return true;
        else
            return false;
    }

    getUserByUsername(username){
        return axios.get(API_URL+`/user/id/${username}`)
    }

    setUserInSessionStorage(username,token){
        console.log(token)
        sessionStorage.removeItem(JWT_TOKEN)
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE,username);
        sessionStorage.setItem(JWT_TOKEN,token)
        this.setupAxiosInterceptorForJWT();
    }

    setupAxiosInterceptorForJWT(){
        axios.interceptors.request.use(
            (config) => {
                if(this.isUserLoggedIn()){
                    console.log('logged in');
                    config.headers.authorization = sessionStorage.getItem(JWT_TOKEN);
                }
                return config
            }
        )
    }
}

export default new AuthenticationService();