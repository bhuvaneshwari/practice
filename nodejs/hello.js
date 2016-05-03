var js = 'hello';
console.log(js);
console.log('nodejs');
const http=require('http');

http.createServer((request,response)=>{
  response.writeHead(200,{'Content-Type':'text/plain'});
  response.end('Hello World\n');
}).listen(8124);

console.log('server running at http://127.0.0.1:8124');
