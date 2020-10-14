import React, { Component } from 'react'
import './Counter.css'
import propsTypes from 'prop-types'

export default class Counter extends Component {
    constructor() {
        super()
        this.state = {
            counter: 0
        }
        this.increment = this.increment.bind(this)
        this.decrement = this.decrement.bind(this)
        this.reset=this.reset.bind(this)
    }

    render() {
        return (
            <div className="counter">
                <CounterButton by={1} increment={this.increment} decrement= {this.decrement}/>
                <CounterButton by={5} increment={this.increment} decrement= {this.decrement} />
                <CounterButton by={10} increment={this.increment} decrement= {this.decrement} />
                <span className="count">{this.state.counter}</span>
                <div ><button className="reset" onClick={this.reset}>Reset</button> </div>

            </div>
        );
    }

    increment(by) {
        console.log(`increment by: ${by}`)
        this.setState(
            (prevState) => {
                return { counter: prevState.counter + by }
            }
        )
    }

    decrement(by) {
        console.log(`decrement by: ${by}`)
        this.setState(
            (prevState) => {
                return { counter: prevState.counter - by }
            }
        )
    }
    reset(){
        this.setState({counter:0})
    }


}

class CounterButton extends React.PureComponent {
    constructor() {
        super()
        this.increment=this.increment.bind(this)
        this.decrement=this.decrement.bind(this)
    }
    render() {
        console.log(`counter button with by: ${this.props.by}`)
        return (
            <div className="counter">
                <button onClick={this.increment}>+{this.props.by}</button>
                <button onClick={this.decrement}>-{this.props.by}</button>
            </div>
        )

    }


    increment(){
        this.props.increment(this.props.by)

    }
    decrement(){
        this.props.decrement(this.props.by)

    }


}
CounterButton.defaultProps = {
    by: 1
}
CounterButton.propTypes = {
    by: propsTypes.number
}



