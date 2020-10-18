import axios from 'axios'
class HelloWorldService{

    executeHelloWorld(){
        console.log("executing helloWorld")
        return axios.get("http://localhost:8085/")


    }
}
export default new HelloWorldService()