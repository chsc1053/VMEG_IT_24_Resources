import React, { Component } from 'react'; 
import "./App.css";

class App extends Component {
  constructor() {
    super();
    this.state = {
      displayValue: "0",
      operand1: null,
      operator: null,
      isCalculating: false,
    };
  }

  handleDigitClick = (digit) => {
    const { displayValue, isCalculating } = this.state;

    if (isCalculating) {
      this.setState({
        displayValue: digit,
        isCalculating: false,
      });
    } else {
      this.setState({
        displayValue: displayValue === "0" ? digit : displayValue + digit,
      });
    }
  };

  handleOperatorClick = (operator) => {
    const { displayValue } = this.state;

    this.setState({
      operand1: parseFloat(displayValue),
      operator,
      isCalculating: true,
    });
  };

  handleEqualClick = () => {
    const { operand1, operator, displayValue } = this.state;

    if (operand1 !== null && operator !== null) {
      const operand2 = parseFloat(displayValue);

      let result = 0;

      switch (operator) {
        case "+":
          result = operand1 + operand2;
          break;

        case "-":
          result = operand1 - operand2;
          break;

        case "*":
          result = operand1 * operand2;
          break;

        case "/":
          result = operand1 / operand2;
          break;

        default:
          break;
      }

      this.setState({
        displayValue: result.toString(),
        operand1: null,
        operator: null,
        isCalculating: false,
      });
    }
  };

  handleClearClick = () => {
    this.setState({
      displayValue: "0",
      operand1: null,
      operator: null,
      isCalculating: false,
    });
  };

  render() {
    const { displayValue } = this.state;

    return (
      <div className="calculator">
        <div className="display">{displayValue}</div>

        <div className="button-row">
          <button onClick={() => this.handleDigitClick("7")}>7</button>

          <button onClick={() => this.handleDigitClick("8")}>8</button>

          <button onClick={() => this.handleDigitClick("9")}>9</button>

          <button onClick={() => this.handleOperatorClick("+")}>+</button>
        </div>

        <div className="button-row">
          <button onClick={() => this.handleDigitClick("4")}>4</button>

          <button onClick={() => this.handleDigitClick("5")}>5</button>

          <button onClick={() => this.handleDigitClick("6")}>6</button>

          <button onClick={() => this.handleOperatorClick("-")}>-</button>
        </div>

        <div className="button-row">
          <button onClick={() => this.handleDigitClick("1")}>1</button>

          <button onClick={() => this.handleDigitClick("2")}>2</button>

          <button onClick={() => this.handleDigitClick("3")}>3</button>

          <button onClick={() => this.handleOperatorClick("*")}>*</button>
        </div>

        <div className="button-row">
          <button onClick={() => this.handleDigitClick("0")}>0</button>

          <button onClick={this.handleClearClick}>C</button>

          <button onClick={this.handleEqualClick}>=</button>

          <button onClick={() => this.handleOperatorClick("/")}>/</button>
        </div>
      </div>
    );
  }
}

export default App;
