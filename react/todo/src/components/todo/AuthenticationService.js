class AuthenticationService{
registerSuccessfulLogin(username,password){
    console.log("register")
    sessionStorage.setItem('authenticatedUser',username)
}
logout(){
    sessionStorage.removeItem("authenticatedUser");
}
isUserLoggedIn(){
    let user=sessionStorage.getItem("authenticatedUser")
    return (user===null) ?false:true
}

getLoggedInUser(){
    let user=sessionStorage.getItem("authenticatedUser")
    return (user===null) ?"":user

}
}
export default new AuthenticationService()