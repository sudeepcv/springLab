import React, { useState } from 'react'
import {
    Link,
    NavLink
} from "react-router-dom";
import AuthenticationService from './AuthenticationService'
const Header = (props) => {
    const isUserLoggedIn = AuthenticationService.isUserLoggedIn()
    const [isLoggedIn, setIsLoggedIn] = useState(isUserLoggedIn)
    
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <Link className="navbar-brand" to="/">Todo app</Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon" />
                </button>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item">
                            {isUserLoggedIn && <Link className="nav-link" to="/ToDoList">Todos</Link>}
                        </li>
                    </ul>
                    <ul className="nav justify-content-end">
                        <li className="nav-item">
                            {!isLoggedIn && <NavLink className="nav-link" to="/">Login</NavLink>}
                        </li>
                        <li className="nav-item">
                            {isUserLoggedIn && <NavLink className="nav-link" to="/Logout" onClick={() => { AuthenticationService.logout(); setIsLoggedIn(false) }}>Logout</NavLink>}
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    )
}
export default Header