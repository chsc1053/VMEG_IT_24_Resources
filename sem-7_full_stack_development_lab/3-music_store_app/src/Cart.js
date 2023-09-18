import React from "react";

const Cart = ({ cartItems }) => {
  const cartTotal = cartItems.reduce((total, album) => total + album.price, 0);

  return (
    <div>
      <h2>Shopping Cart</h2>

      <ul className="list-group">
        {cartItems.map((album, index) => (
          <li key={index} className="list-group-item">
            {album.title} - ${album.price}
          </li>
        ))}
      </ul>

      <p>Total: ${cartTotal}</p>
    </div>
  );
};

export default Cart;
