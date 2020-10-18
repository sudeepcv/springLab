import React from 'react'

import {
    BrowserRouter as Router,
    Switch,
    Route,
} from "react-router-dom";

import AuthenticatedRoute from './AuthenticatedRoute'
import ToDoList from './ToDoList'
import Logout from './Logout'
import Footer from './Footer'
import Home from './Home'
import Header from './Header'
import ErrorComponent from './ErrorComponent'
import Login from './Login'
import Todo from './Todo'

const ToDoApp = props => {
    return (
        <Router>
            <Header />
            <main role="main" className="flex-shrink-0">
                <div className="container" style={{ "paddingTop": "60px" }}>
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
                </div>
            </main>
            <Footer />
        </Router>
    )
}
export default ToDoApp