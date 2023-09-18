// Import the HTTP module
const http = require("http");

// Define the hostname and port for your server
const hostname = "127.0.0.1";

const port = 3000;

// Create an HTTP server
const server = http.createServer((req, res) => {
  // Set the response header
  res.statusCode = 200;
  res.setHeader("Content-Type", "text/plain");

  // Send a response to the client
  res.end("Hello, World!\n");
});

// Start the server and listen on the specified hostname and port
server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
