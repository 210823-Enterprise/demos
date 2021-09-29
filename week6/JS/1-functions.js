// 4 main ways to declare a function

// 1 . classic function declaration
function divide1(x, y) {
    return x/y;
}

console.log(divide1(10, 5)); // just printing the returned value here!

// 2. Function Expression - assigning an anonymous function to a variable called divide2
const divide2 = function(x, y) {
    return x/y;
}

console.log(divide2(100,10))

// 3. Arrow function expression (introduced in ES6 ecmaScript 6 2015)
const divide3 = (a, b) => {
    return a/b;
}

// 4. conciuse arrow function expression
const divide4 = (a, b) => a/b;
