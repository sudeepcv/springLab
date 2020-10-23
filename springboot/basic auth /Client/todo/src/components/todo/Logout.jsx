import React from 'react'
import Footer from './Footer'
import Header from './Header'

const Logout = () => {
    return (
        <>

        <Header />
        <main role="main" className="flex-shrink-0">
            <div className="container" style={{ "paddingTop": "60px" }}>

        <div>
            <hr />
            your are logged out
        </div>

        </div>
            </main>
            <Footer />
            </>
    )
}
export default Logout