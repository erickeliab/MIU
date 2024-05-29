//const add = (a,b)=>{
// for(let i=0; i<9e27; i++){}
// console.log(a+b);
//}
//console.log('start');
//const A = add(1,2);
//const B = add(2,3);
//const C = add(3,4);
//console.log('end');
//


//const add = (a,b)=>{
// setTimeout(()=>{
// for(let i=0; i<9e27; i++){}
// console.log(a+b);
// }, 5000);
//}
//console.log('start');
//const A = add(1,2);
//const B = add(2,3);
//const C = add(3,4);
//console.log('end');


//setTimeout(function () {
// console.log("world");
// }, 2000);
//  console.log("hello");


//const fs = require('fs');
//console.log('first');
//fs.readFile('hello.txt', () => console.log('second'));
//console.log('third');


//new Promise(resolve => resolve('Hi'))
//.then(() => console.log("this is Promise.resolve 1"));
//process.nextTick(() => console.log("this is process.nextTick 1"));
//
//
//new Promise((resolve, reject) => {
//console.log("start");
// resolve('Hi');
//})
//.then(() => console.log("this is Promise.resolve 2"));
//process.nextTick(() => console.log("this is process.nextTick 2"));


//setTimeout(() => console.log("this is setTimeout 1"), 0);
//setTimeout(() => {
//console.log("this is setTimeout 2");
//process.nextTick(() =>
//console.log("this is inner nextTick inside setTimeout")
//);
//}, 0);
//setTimeout(() => console.log("this is setTimeout 3"), 0);
//new Promise(resolve => resolve('Hi')).then(() => console.log("this is Promise.resolve 1"));
//new Promise(resolve => resolve('Hi')).then(() => console.log("this is Promise.resolve 2"));
//process.nextTick(() => console.log("this is process.nextTick 1"));
//process.nextTick(() => console.log("this is process.nextTick 2"));


//const fs = require('fs');
//fs.readFile('hello.txt', () => console.log('this is readFile 1'));
//new Promise(resolve => resolve('Hi')).then(() => console.log("this is Promise.resolve 1"));
//process.nextTick(() => console.log("this is process.nextTick 1"));


//const fs = require('fs');
//fs.readFile('hello.txt', () => console.log('this is readFile 1'));
//setTimeout(() => console.log("this is setTimeout 1"), 0);


//const fs = require('fs');
//fs.readFile('hello.txt', () => console.log('this is readFile 1'));
//new Promise(resolve => resolve('Hi')).then(() => console.log("this is Promise.resolve 1"));
//process.nextTick(() => console.log("this is process.nextTick 1"));
//setTimeout(() => console.log("this is setTimeout 1"), 0);
//setImmediate(() => console.log("this is setImmediate 1"));
//for (let i = 0; i < 2000000000; i++) {}



//const fs = require("fs");
//
//fs.readFile('hello.txt', () => {
//
//console.log("this is readFile 1");
//setImmediate(() => console.log("this is setImmediate 1"));
//
//process.nextTick(() =>
//console.log("this is inner process.nextTick inside readFile")
//
//);
//Promise.resolve().then(() =>
//console.log("this is inner Promise.resolve inside readFile")
//);
//});
//process.nextTick(() => console.log("this is process.nextTick 1"));
//Promise.resolve().then(() => console.log("this is Promise.resolve 1"));
//setTimeout(() => console.log("this is setTimeout 1"), 0);
//for (let i = 0; i < 2000000000; i++) {}


//const fs = require("fs");
//const readableStream = fs.createReadStream('hello.txt');
//readableStream.close();
//readableStream.on("close", () => {
//console.log("this is from readableStream close event callback");
//});
//setImmediate(() => console.log("this is setImmediate 1"));
//setTimeout(() => console.log("this is setTimeout 1"), 0);
//Promise.resolve().then(() => console.log("this is Promise.resolve 1"));
//process.nextTick(() => console.log("this is process.nextTick 1"));



const fs = require('fs');
const path = require('path');
// Reading from a file:
fs.readFile(path.join(__dirname, 'hello.txt'), { encoding: 'utf8' }, (err, data) => {
if (err) throw err;
console.log(data);
});
// Writing to a file:
fs.writeFile('hello.txt', 'Hello World!', (err) => {
if (err) throw err;
console.log('Done');
});


// const jsonString = `
// {
// "window": {
// "title":"Sample Widget",
// "width":500,
// "height":500
// },
// "image":{
// "src":"images/logo.png",
// "coords": [250,150,350,400],
// "alignment": "center"
// },
// "messages":[
// {"text": "Save",
//  "offset": [10, 30]
//  },
// {"text": "Help", "offset":[0, 50]},
// {"text": "Quit", "offset":[30, 10]},
// {"text": "Quit", "offset":[30, 60]}
// ],
// "debug":"true"
// }
// `;
// const data = JSON.parse(jsonString);

// console.log(data)
