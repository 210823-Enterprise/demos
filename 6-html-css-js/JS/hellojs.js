// We can make a single comment like this

/**
 * 
 * This is a multiline comment
 */

console.log("Hello world!")

/**
 * PIRMITIVE DATATYPES
 * 
 * - boolean
 * - number
 * - string
 * - null
 * - undefined
 * 
 * REFERENCE DATATYPES
 * - objects
 * - arrays
 * - functions (it's an object)
 */

// Up until 2015 every variable was declared with var
var num = 5;
console.log(num);

num = "Orange";
console.log(num);

// EcmaScript 6 -> introduced new ways of declaring variables: LET and CONST

// we can always reassign the value of a variable declared with let
let fruit = 'apple';
fruit = 'orange';

const letter = 'a';
// letter = 'b'; you cannot reassign a value to a variable declared with const

// this won't run if we redeclar a const variable
console.log(letter);


// var declares variables on a global scope








