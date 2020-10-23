import axios from 'axios';
class AuthenticationService {
    registerSuccessfulLogin(username, password) {
        console.log("register")
        sessionStorage.setItem('authenticatedUser', username)
        this.setupAxiosInterceptors()

    }

    registerSuccessfulLoginJWT(username,token){
        sessionStorage.setItem('authenticatedUser', token)
        this.setupAxiosInterceptors(token)

    }
    logout() {
        sessionStorage.removeItem("authenticatedUser");
    }
    isUserLoggedIn() {
        let user = sessionStorage.getItem("authenticatedUser")
        return (user === null) ? false : true
    }

    getLoggedInUser() {
        let user = sessionStorage.getItem("authenticatedUser")
        return (user === null) ? "" : user

    }
    setupAxiosInterceptors(token) {
  
        axios.interceptors.request.use((config) => {
            if (this.isUserLoggedIn()) {
                config.headers.authorization = token
            }
            return config;
        }, function (error) {
            // Do something with request error
            return Promise.reject(error);
        });
    }


    // setupAxiosInterceptors() {
    //     console.log("setupAxiosInterceptors-----")
    //     let username = "sudeep"
    //     let password = "sudeep"
    //     let basicHeaderAuthorization = 'Basic ' + window.btoa(username + ":" + password)
    //     axios.interceptors.request.use((config) => {
    //         if (this.isUserLoggedIn()) {
    //             config.headers.authorization = basicHeaderAuthorization
    //         }
    //         return config;
    //     }, function (error) {
    //         // Do something with request error
    //         return Promise.reject(error);
    //     });
    // }
    
    executeBasicAuthenticationService(username, password) {
        return axios.get(`http://localhost:8085/basicauth`,
            { headers: { authorization: this.createBasicAuthToken(username, password)} })
    }

    executeJWTAuthenticationService(username, password) {
        return axios.post(`http://localhost:8085/authenticate`,
            { username, password })
    }


    createBasicAuthToken(username, password) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }

    createJWTToken(token) {
        return 'Bearer ' + token
    }


}
export default new AuthenticationService()