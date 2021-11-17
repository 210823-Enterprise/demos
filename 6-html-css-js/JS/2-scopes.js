/**
 * 4 main scopes in JavaScript
 * 
 * - Global Scope - variables declared here are accessible from ANYWHERE
 * 
 * - Functional/Local Scope -> variables accessible within a function and NOT outside of it
 * 
 * - Block Scope -> variables restricted to a block scope like a for loop or while loop
 * 
 * - Lexical scope -> when we functions within a nother function and we create an environment of variables are
 *   accessible to the functions nested within the outer function (concept called Closure) 
 */

let name = "Charles"; // I can access this within any function or method belonging to an object 

function funScope() {

    let x = 100;
    console.log(x);

}

// this function is immediately invoked because we're invoking it on the global object
funScope()

// we can't reach x declared in the function
let x; // oif we declare a variable without initializing its value, its primitive type automatically becomes undefined
console.log(x);

const d = "dolphin"; // globally declared

function blockScope() {

    const c = "cat";
    var m = "mary";

    if (true) {

        // I've opened up a block scope here
        console.log(c);
        console.log(m);

        // let & const restricted to block scope
        let d = "dog";
        // var d = "dog" will make this accessible outside of the block scope! 

        if (true) {
            console.log(d); // now we can access the variable bound to block scope with let in the enclosing function
        }

    }

    console.log(d); // this will return "dolphin"
}

blockScope();
