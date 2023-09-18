import React from "react";

const Album = ({ album, addToCart }) => {
  return (
    <li className="list-group-item">
      {album.title} - {album.artist} (${album.price})
      <button
        className="btn btn-primary btn-sm float-right"
        onClick={() => addToCart(album)}
      >
        Add to Cart
      </button>
    </li>
  );
};

export default Album;
