
// extracting elements and concatinating them to a array

const concat = (str, arr1, arr2) => {
    const result = str.split('');
    result.push(...arr1);
    result.push(...arr2);
    return result;
}

console.log(concat('hi', [1,2,3], ['Hello','world'])); 
