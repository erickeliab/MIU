
## Callback Queues in Node.js

### There are 6
        NextTick Queue
        Promise Queue
        Timer Queue
        I/O Queue
        Check Queue
        Close Queue

#### NextTick Queue:
    Stores callbacks added by process.nextTick(). These Callbacks in this queue are being run in between before event loop continues to the new event.
    Example:

    process.nextTick(() => {
        console.log("Hello");
    });

#### Promise Queue:
    Stores callbacks added when a new Promise is created . Gets the second priority after the nextTick queue.
    
    Example:

    new Promise(resolve => resolve('Hi'))
    .then(() => console.log("this is Promise.resolve 1"));


#### Timer Queue:
    Is used to manage callbacks created by setTimeout() and setInterval() functions, they run after the time set in the function. 
   
    Example:

  
    setTimeout(() => {
    console.log("Running callback...");
    }, 1000);

#### I/O Queue : 
    Contains callbacks for I/O operations, such as reading from or writing to files using fs module.
    
    Example:
   
    const fs = require('fs');
    
    fs.readFile('samplefile.json', (err, res) => {
    if (err) throw err;
        console.log(res);
    });

#### Check Queue: 
    Has callbacks that are scheduled using the setImmediate function and they execute after nexttick, promise, timer and I/O callbacks completes.
    
    Example:

    setImmediate(() => {
    console.log("Callback created by SetImmediate...");
    });

#### Close Queue: 
    This queue contain callbacks that are associated with "close" events, like close a stream after reading a file.
    Example:

    const fs = require("fs");

    const readableStream = fs.createReadStream('hello.txt');

    readableStream.close();

    readableStream.on("close", () => {

    console.log("Callback from close event running...");
    
    });



