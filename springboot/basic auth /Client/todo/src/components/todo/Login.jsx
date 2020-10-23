import React, { useState } from 'react'
import AuthenticationService from './AuthenticationService'
import Footer from './Footer'
import Header from './Header'
const Login = props => {

    const [username, setUsername] = useState("sudeep")
    const [password, setPassword] = useState("sudeep")
    const [isError, setError] = useState(false)
    const [isLoginSuccess, setLoginSuccess] = useState(false)

    const onChangeUserName = (event) => {
        setUsername(event.target.value)

    }

    const onChangePassword = (event) => {
        setPassword(event.target.value)

    }

    const loginClick = () => {

        AuthenticationService.executeBasicAuthenticationService(username,password).then(
            ()=>{
                AuthenticationService.registerSuccessfulLogin(username, password)
                setLoginSuccess(true)
                setError(false)
                props.history.push(`/home/${'sudeepcv'}`)

            }
        ).catch(err=>{console.log("something went wrong while login")

        setError(true)
            setLoginSuccess(false)
    })


        // if (username === "sudeepcv" && password === "sudeepcv") {
        //     AuthenticationService.registerSuccessfulLogin(username, password)
        //     setLoginSuccess(true)
        //     setError(false)

        //     props.history.push(`/home/${'sudeepcv'}`)
        //     // window.location.reload(false)

        //     // props.history.pushState(null, `/home/${'sudeepcv'}`);
        // } else {
        //     setError(true)
        //     setLoginSuccess(false)
        // }

    }
    return (

        <>

        <Header />
        <main role="main" className="flex-shrink-0">
            <div className="container" style={{ "paddingTop": "60px" }}>

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

        </div>
            </main>
            <Footer />
            </>

    )
}
export default Login