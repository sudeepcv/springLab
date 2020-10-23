import React, { useState, useEffect } from 'react'
import TodoService from '../../api/todo/TodoService'
import AuthenticationService from './AuthenticationService'
import moment from 'moment'
import Footer from './Footer'
import Header from './Header'

const ToDoList = ({history}) => {

    // const [todos, setTodos] = useState([
    //     { id: 1, description: "test1", done: false, targetDate: new Date() },
    //     { id: 2, description: "test2", done: false, targetDate: new Date() }
    // ])

    const [todos, setTodos] = useState([])
    const [message, setMessage] = useState("")

    useEffect(() => {
  
        
        let user = AuthenticationService.getLoggedInUser()
        TodoService.getAllTodos(user).then(({ data }) => {
            setTodos(data)
        }).catch(err => {
            console.log("something went wrong while fetching to do data", err)
        })
        return () => {
            // cleanup
        }
    }, [])


    return (
        <>

        <Header />
        <main role="main" className="flex-shrink-0">
            <div className="container" style={{ "paddingTop": "60px" }}>

        <div className="container">
            {message&& <div className="alert alert-warning">{message}</div>}

            <button onClick={()=>{
                                    history.push(`/todos/-1`)

                                }}  className="btn btn-success float-right">create</button>

            <table className="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Description</th>
                        <th>Target date</th>
                        <th>is Done</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    {todos.map(todo => {
                        return (
                            <tr key={todo.id}>
                                <td>{todo.id}</td>
                                <td>{todo.description}</td>
                                <td>{moment(todo.targetDate).format('YYYY-MM-DD')}</td>
                                <td>{todo.done.toString()}</td>
                                <td><button onClick={()=>{
                                    let user = AuthenticationService.getLoggedInUser()
                                    TodoService.deleteTodoById(user,todo.id).then(data=>{
                                        console.log(data)
                                        setMessage(`Todo with id: ${todo.id} has been deleted`)
                                        TodoService.getAllTodos(user).then(({ data }) => {
                                            setTodos(data)
                                        }).catch(err => {
                                            console.log("something went wrong while fetching to do data", err)
                                        })
                                    })
                                }} className="btn btn-warning">Delete</button></td>

                                <td><button className="btn btn-success" onClick={()=>{
                                    history.push(`/todos/${todo.id}`)

                                }} >Update</button></td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
           
             

            
        </div>



</div>
</main>
<Footer />
</>

    )
}

export default ToDoList
