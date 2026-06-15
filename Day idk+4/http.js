import http from 'http';

const server = http.createServer((req, res) => {
  if (req.url === '/') {
    res.writeHead(200, { 'Content-Type': 'text/html' });
    res.write('<h1>Welcome to the Home Page</h1>');
    res.end();
  } 
  
  else if (req.url === '/about') {
    res.writeHead(200, { 'Content-Type': 'text/html' });
    res.write('<h1>About Us</h1><p>This is a simple server.</p>');
    res.end();
  } 
  
  else if (req.url === '/api/data') {
    res.writeHead(200, { 'Content-Type': 'application/json' });
    
    const myData = { name: 'Rui', age: 24 };
    res.write(JSON.stringify(myData));
    res.end();
  } 
  
  else {
    res.writeHead(404, { 'Content-Type': 'text/plain' });
    res.write('404 Page Not Found');
    res.end();
  }

});

server.listen(3000, () => {
  console.log('Server is running on port 3000,http://localhost:3000');
});