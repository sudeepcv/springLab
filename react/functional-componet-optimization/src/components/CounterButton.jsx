import React,{useCallback} from 'react'


//  const CounterButton = ({by,increment,decrement}) => {

//     console.log(`counter button with by: `)
//     return (
//         <div className="counter">
//             <button onClick={()=>increment(by)}>+{by}</button>
//             <button onClick={()=>decrement(by)}>-{by}</button>
//         </div>
//     )
// }

// export default React.memo(CounterButton, ({by:byOld},{by:byNew})=>{

//   // console.log("byOld:",byOld)
//   // console.log("byNew:",byNew)
//   // console.log("byNew:",(byOld===byNew))
//   return byOld===byNew


// })
 



   const CounterButton = React.memo(function CounterButton({by,increment,decrement}){
    console.log(`counter button with by: ${by}`)

    const incrementCall =useCallback(()=>{
        increment(by)

    },[by,increment])
    const decrementCall=useCallback(()=>{
        decrement(by)

    },[by,decrement])
    return (
        <div className="counter">
            <button onClick={incrementCall}>+{by}</button>
            <button onClick={decrementCall}>-{by}</button>
        </div>
    )

  }, ({by:byOld},{by:byNew})=>{

    // console.log("byOld:",byOld)
    // console.log("byNew:",byNew)
    // console.log("byNew:",(byOld===byNew))
    return byOld===byNew


  });

  export default CounterButton