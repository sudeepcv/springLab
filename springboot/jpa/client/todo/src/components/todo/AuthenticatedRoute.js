import React from 'react'
import {
    Route,
    Redirect
} from "react-router-dom";
import AuthenticationService from './AuthenticationService'

const AuthenticatedRoute = (props) => {
    console.log("authenticated route")
    if(AuthenticationService.isUserLoggedIn()){
        return (
            <Route {...props} />
       
            )

    }else{
        return (
            <Redirect to="/" />
       
            )

    }


  
}

export default AuthenticatedRoute
