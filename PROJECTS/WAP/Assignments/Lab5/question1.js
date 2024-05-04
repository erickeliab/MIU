

// calculating sum of elements in array that are greater than 20

function sum(arr) {
    let total = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > 20) {
            total += arr[i];
        }
    }
    return total;
}


const numbers = [10, 25, 30, 15, 5, 40];

// getting the result
console.log(sum(numbers));