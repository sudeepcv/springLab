import axios from 'axios'
class TodoService{

    getAllTodos(user){
    return axios.get(`http://localhost:8085/users/${user}/todos`)
    }

    getTodoById(user,id){
        return axios.get(`http://localhost:8085/users/${user}/todos/${id}`)
        }

    deleteTodoById(user,id){
        return axios.delete(`http://localhost:8085/users/${user}/todos/${id}`)
    }

    updateTodo(user,todo,id){
        return axios.put(`http://localhost:8085/users/${user}/todos/${id}`,todo)
    }

    createTodo(user,todo){
        return axios.post(`http://localhost:8085/users/${user}/todos`,todo)
    }

}
export default new TodoService();