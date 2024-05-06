
### Question 02.


Given a function
```javascript

let i = 0;

setTimeout(() => console.log(i), 100); // ?

// assume that the time to execute this function is >100ms

for(let j = 0; j < 100000000; j++) {

  i++;

}

```
### Answers:

#### The scheduled function will be run After the loop.

#### The output will be the last value of i which will be 100000000 since the setTimeout will wait for loop to finish operation