import React from 'react'
import { useState } from 'react';
import {
    Link,
  
} from "react-router-dom";
import HelloWorldService from '../../api/todo/HelloWorldService'

const Home = (props) => {

    const [message, setMessage] = useState("")

    const welcomeMessage=()=>{
        // console.log("test")
        HelloWorldService.executeHelloWorld().then((data)=>{
            console.log("request",data)
            setMessage(data.data)

        }).catch((error)=>{
            console.log("something went wrong",error)
        })
    }
    return (
        <div>
            <h1>Hi, {props.match.params.name}</h1>

            <div className="container">
                you can mange your todos <Link to="/ToDoList">here</Link>
            </div>

            <div className="container">
                Welcome message <button className="btn btn-success" onClick={welcomeMessage}>welcomeMessage</button>
    <div>{message}</div>
            </div>


        </div>
    )
}
export default Home