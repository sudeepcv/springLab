import React,{useEffect,useState} from 'react'
import moment from 'moment'
import {ErrorMessage, Field, Form, Formik} from 'formik'
import TodoService  from '../../api/todo/TodoService'
import AuthenticationService from './AuthenticationService'

const Todo = ({history,match:{params:{id}}}) => {
    

    const [formData, setFormData] = useState({})
     useEffect(() => {

        if(id!==-1){
            console.log("inside use effect")
            let user = AuthenticationService.getLoggedInUser()
   
           TodoService.getTodoById(user,id).then(({data})=>{
               console.log(data)
               const {description,targetDate}=data;
   
               setFormData({description,targetDate:moment(targetDate).format('YYYY-MM-DD')})
   
           }).catch(error=>{
               console.log("something went wrong while fetching to do data",error)
           })

        }
     
        return () => {
            // cleanup
        }

     }, [id])
     console.log("formData==>",formData)


    const validate= (values)=>{
        let errors={}
        if(!values.description){
            errors.description="Enter a description"
        }else if(values.description.length<5){
            errors.description="the description must have at least 5 char"
        }

        if(!moment(values.targetDate).isValid()){
            errors.targetDate="date is not valid"
        }
        console.log(values)
        return errors;

    }
    return (
        <div>
            <h1>Todo</h1>
            <div className="container">
                <Formik
                initialValues={formData}
                validateOnBlur={false}
                validateOnChange={false}
                onSubmit={(values)=>{
                    let user = AuthenticationService.getLoggedInUser()
                    if(id!==-1){
                        values.id=id;
                        TodoService.updateTodo(user,values,id).then((data)=>{
                            history.push(`/ToDoList`)
                        })
                    }else{
                        TodoService.createTodo(user,values).then((data)=>{
                            history.push(`/ToDoList`)
                        })
                    }
                }}
                validate={validate}
                enableReinitialize={true}
                >
                    {
                        (props)=>{
                             return (
                                 <Form>
                                     <ErrorMessage name="description" component="div" className="alert alert-warning"/>
                                     <fieldset className="form-group">
                                         <label>Description</label>
                                         <Field className="form-control" type="text" name="description"/>
                                     </fieldset>
                                     <ErrorMessage name="targetDate" component="div" className="alert alert-warning"/>
                                     <fieldset className="form-group">
                                         <label>Target date</label>
                                         <Field className="form-control" type="date" name="targetDate"/>
                                     </fieldset>

                                     <button className="btn btn-success" type="submit">save</button>

                                 
                                 

                                 </Form>
                                
                            )
                        }
                    }

                </Formik>

            </div>
        </div>
    )
}

export default Todo
