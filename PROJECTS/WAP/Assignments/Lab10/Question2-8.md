
### 2. The output will be
    start
    end
    nextTick 1
    nextTick 2
    Promise...1
    Promise...2
    timeout 1
    timeout 2
    nextTick 3
    timeout 3


### 3. The output is :
    timeout
    readFile....
    Immediate


### 4. The output in Node environment vs in Browser
    In both cases it result to undefined since in Node keyword this refers to
    the global object which doesnt have message property where in browser (this) 
    keyword refers to window object which doesnt have message property either
    
    However, in strict mode it will give Type Error in both cases.
    (Tested in node v19.9.0 and Google Chrome Browser)


### 5. The output:
    After executing the code there will be TypeError: getName is not a function
    because getName is not export default and it is accessed without distructuring
    it out of the object.

### 6. The output:
    After executing the code there will be Error could not find the module pattern2
    because there is no pattern2.js file in the folder that exports the module.

### 7. The output:
    After executing the code there will be Error could not find the module pattern2
    because there is no pattern2.js file in the folder that exports the module.

### 8. The output:
    
    { firstname: 'John', lastname: 'Smith' }
