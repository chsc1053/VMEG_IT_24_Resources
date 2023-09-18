import React from "react";
import Album from "./Album";

const albums = [
  { id: 1, title: "Album 1", artist: "Artist 1", price: 10 },
  { id: 2, title: "Album 2", artist: "Artist 2", price: 12 },
  { id: 3, title: "Album 3", artist: "Artist 3", price: 15 },
];

const AlbumList = ({ addToCart }) => {
  return (
    <div>
      <h2>Albums</h2>

      <ul className="list-group">
        {albums.map((album) => (
          <Album key={album.id} album={album} addToCart={addToCart} />
        ))}
      </ul>
    </div>
  );
};

export default AlbumList;
