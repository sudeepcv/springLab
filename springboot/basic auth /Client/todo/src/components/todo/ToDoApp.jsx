import React from 'react'

import {
    BrowserRouter as Router,
    Switch,
    Route,
} from "react-router-dom";

import AuthenticatedRoute from './AuthenticatedRoute'
import ToDoList from './ToDoList'
import Logout from './Logout'

import Home from './Home'

import ErrorComponent from './ErrorComponent'
import Login from './Login'
import Todo from './Todo'

const ToDoApp = props => {
    return (
        <Router>
        
                    <Switch>
                        <AuthenticatedRoute path="/home/:name" component={Home} />
                        <Route exact path="/" component={Login} />
                        <AuthenticatedRoute path="/ToDoList" component={ToDoList} />
                        <AuthenticatedRoute path="/todos/:id" component={Todo} />

                        <Route path="/Logout" component={Logout} />

                        <Route path="*">
                            <ErrorComponent />
                        </Route>
                    </Switch>
        
        </Router>
    )
}
export default ToDoApp