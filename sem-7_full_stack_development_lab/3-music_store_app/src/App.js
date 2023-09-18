import React, { Component } from "react";
import Header from "./Header";
import AlbumList from "./AlbumList";
import Cart from "./Cart";
import "./App.css";

class App extends Component {
  constructor() {
    super();
    this.state = {
      cartItems: [],
    };
  }

  // Add album to the cart
  addToCart = (album) => {
    this.setState((prevState) => ({
      cartItems: [...prevState.cartItems, album],
    }));
  };

  render() {
    return (
      <div className="App">
        <Header />

        <main className="container">
          <div className="row">
            <div className="col-md-8">
              <AlbumList addToCart={this.addToCart} />
            </div>

            <div className="col-md-4">
              <Cart cartItems={this.state.cartItems} />
            </div>
          </div>
        </main>
      </div>
    );
  }
}

export default App;
