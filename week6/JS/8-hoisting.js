// Javascript Execution Context
// EVery time a JS engine executes a script, an Execution Context is built
// This execution context has 2 phases: creation, execution

let x = 10; // declared! (initalized AND assigned a value)

function timesTen(a) {
    return a * 10;
}

let y = timesTen(x);

console.log(y);

/**
 * Creation Phase (STEP 1)
 * 
 * 1. Create the GLobal Object - web browser (window) -> Node = global object
 * 
 * 2. Bind "this" to the Global Object
 * 
 * 3. Setup a memory heap for storing variables and function references.
 * 
 * 4. store the function declarations in the memory heap and store variables within the global execution context
 * as undefined (initialized but not declared)
 */

/**
 * Execution Phase
 * 
 * JavaScript engine executes the code line by line.  In this phase, it assigns values to variables
 * and executes the function calls.
 */

// Variable hoisting occurs during the execution phase of the script
// this is when declared variables are "moved to the top" of the script as INITIALIZED
// but not declared
// as if we just did this 
// var a;
console.log(a); // so this will return  undefined.
var a = 1;

console.log(b);
let b = 1; 

// are variables declared with let & const hoisted?
// All declarations are hoisted in JavaScript...

/**
 * While VAR variables are insitliazed, they remain undefined,
 * but let & const remain ininitialized; --> so they throw an error
 */





