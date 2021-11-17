// initialize a counter
// let counter = 0;

// function to incrememntthe counter
function add1() {

    let counter = 0;

    function plus() {
        counter += 1;    
    }

    plus();

    return counter;
}

const add = (function () { // the variable add is assigned to the return value of a self-invoking function

    let counter = 0;

    return function () {
        counter+=1;
        return counter; // this is what add() returns
    }
})();

add();
add();
console.log(add()); // return 3

// Why do we use closure? We use it so that functions can have "private" global variables
// the counter variable is protected by the scope of the anonymous function
// and can only be changed by using the add function.

