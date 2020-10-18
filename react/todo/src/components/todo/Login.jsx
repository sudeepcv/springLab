import React, { useState } from 'react'
import AuthenticationService from './AuthenticationService'
const Login = props => {

    const [username, setUsername] = useState("sudeepcv")
    const [password, setPassword] = useState("sudeepcv")
    const [isError, setError] = useState(false)
    const [isLoginSuccess, setLoginSuccess] = useState(false)

    const onChangeUserName = (event) => {
        setUsername(event.target.value)

    }

    const onChangePassword = (event) => {
        setPassword(event.target.value)

    }

    const loginClick = () => {
        if (username === "sudeepcv" && password === "sudeepcv") {
            AuthenticationService.registerSuccessfulLogin("sudeepcv", "sudeepcv")
            setLoginSuccess(true)
            setError(false)

            props.history.push(`/home/${'sudeepcv'}`)
            window.location.reload(false)

            // props.history.pushState(null, `/home/${'sudeepcv'}`);
        } else {
            setError(true)
            setLoginSuccess(false)
        }

    }
    return (
        <div>
            <h1> Login</h1>
            <div className="container" >
                {isError && <div className="alert alert-warning">Invalid credential</div>}
                {isLoginSuccess && <div>Login successful</div>}
            User Name: <input type="text" name="username" value={username} onChange={onChangeUserName} />
            Password : <input type="password" name="password" value={password} onChange={onChangePassword} />
                <div style={{ marginTop: "10px" }}>
                    <button className="btn btn-success" onClick={loginClick}>Login</button>
                </div>
            </div>
        </div>
    )
}
export default Login