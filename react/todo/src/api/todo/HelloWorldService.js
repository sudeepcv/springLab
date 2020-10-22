import axios from 'axios'
class HelloWorldService {

    executeHelloWorld() {
        return axios.get("http://localhost:8085/")
    }

    // executeHelloWorld() {
    //     let username = "sudeep"
    //     let password = "sudeep"
    //     let basicHeaderAuthorization = 'Basic ' + window.btoa(username + ":" + password)
    //     return axios.get("http://localhost:8085/",
    //         {
    //             headers: {
    //                 authorization: basicHeaderAuthorization
    //             }
    //         }
    //     )
    // }


}
export default new HelloWorldService()