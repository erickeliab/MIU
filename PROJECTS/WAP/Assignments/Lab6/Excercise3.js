


let printNumbers = (from, to) => {
    let current = from;
    const interval_key = setInterval(function() {

        console.log(current);


        if (current === to) {
            clearInterval(interval_key);
        }
        current++;
    }, 1000);
}


printNumbers(1, 5);