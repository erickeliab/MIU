'use strict';

var message = "Hello World";

function sayHi(){

  console.log(this);
//  console.log(this.message);

}


let thecall = sayHi.bind();
thecall()