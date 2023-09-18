// Import the Express framework
const express = require("express");

// Create an instance of the Express application
const app = express();

// Define a route for the homepage
app.get("/", (req, res) => {
  res.send("Welcome to my basic Express website!");
});

// Start the server and listen on a port
const port = process.env.PORT || 3000;

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
