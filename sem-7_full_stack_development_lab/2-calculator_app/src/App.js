import React, { Component } from 'react'; 
import "./App.css";

class App extends Component {
  constructor() {
    super();
    this.state = {
      res: "0",
      val1: null,
      op: null,
      isCalculating: false,
    };
  }

  handleDigitClick = (digit) => {
    const { res, isCalculating } = this.state;

    if (isCalculating) {
      this.setState({
        res: digit,
        isCalculating: false,
      });
    } else {
      this.setState({
        res: res === "0" ? digit : res + digit,
      });
    }
  };

  handleOpClick = (op) => {
    const { res } = this.state;

    this.setState({
      val1: parseFloat(res),
      op,
      isCalculating: true,
    });
  };

  handleEqualClick = () => {
    const { val1, op, res } = this.state;

    if (val1 !== null && op !== null) {
      const val2 = parseFloat(res);

      let result = 0;

      switch (op) {
        case "+":
          result = val1 + val2;
          break;

        case "-":
          result = val1 - val2;
          break;

        case "*":
          result = val1 * val2;
          break;

        case "/":
          result = val1 / val2;
          break;

        default:
          break;
      }

      this.setState({
        res: result.toString(),
        val1: null,
        op: null,
        isCalculating: false,
      });
    }
  };

  handleClearClick = () => {
    this.setState({
      res: "0",
      val1: null,
      op: null,
      isCalculating: false,
    });
  };

  render() {
    const { res } = this.state;

    return (
      <div className="calculator">
        <div className="display">{res}</div>

        <div className="button-row">
          <button onClick={() => this.handleDigitClick("7")}>7</button>

          <button onClick={() => this.handleDigitClick("8")}>8</button>

          <button onClick={() => this.handleDigitClick("9")}>9</button>

          <button onClick={() => this.handleOpClick("+")}>+</button>
        </div>

        <div className="button-row">
          <button onClick={() => this.handleDigitClick("4")}>4</button>

          <button onClick={() => this.handleDigitClick("5")}>5</button>

          <button onClick={() => this.handleDigitClick("6")}>6</button>

          <button onClick={() => this.handleOpClick("-")}>-</button>
        </div>

        <div className="button-row">
          <button onClick={() => this.handleDigitClick("1")}>1</button>

          <button onClick={() => this.handleDigitClick("2")}>2</button>

          <button onClick={() => this.handleDigitClick("3")}>3</button>

          <button onClick={() => this.handleOpClick("*")}>*</button>
        </div>

        <div className="button-row">
          <button onClick={() => this.handleDigitClick("0")}>0</button>

          <button onClick={this.handleClearClick}>C</button>

          <button onClick={this.handleEqualClick}>=</button>

          <button onClick={() => this.handleOpClick("/")}>/</button>
        </div>
      </div>
    );
  }
}

export default App;
