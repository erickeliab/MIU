

// getting array with elements with length >= 5 and with 'a'

const getNewArray = function(arr) {

    return arr.filter(str => str.length >= 5 && str.includes('a'));

}


const myArray = ["apple", "banana", "orange", "grape", "kiwi"];


console.log(getNewArray(myArray));
