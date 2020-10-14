import React,{useState,useCallback} from 'react'
import CounterButton from './CounterButton'
import './Counter.css'
export default function Counter() {

    const [count, setCount] = useState(0)

    // const increment=(by)=> {
    //     setCount(count+by)
    // }

    // const decrement=(by)=> {
    //     setCount(count-by)
    // }

    const increment = useCallback(
        (by) => {
            setCount(c=>c+by)
        },
        [],
      );

      const decrement = useCallback(
        (by) => {
            setCount(c=>c-by)
        },
        [],
      );


    


    return (
        <div className="counter">
        <CounterButton by={1} increment={increment} decrement= {decrement}/>
        <CounterButton by={5} increment={increment} decrement= {decrement}/>
        <CounterButton by={10} increment={increment} decrement= {decrement}/>
        <span className="count">{count}</span>
        <div ><button className="reset" >Reset</button> </div>

    </div>
    )




}
