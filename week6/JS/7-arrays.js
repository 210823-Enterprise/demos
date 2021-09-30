let scores = new Array(10); // Array Constructor
// JS Arrays are dyanmic, so we expand and contractthem how we need

console.log(scores); // you can store any type of data type inside this array, mix and match

let colors = ['red', 'blue', 'green'];
console.log(colors);

// access elemtns within an array
console.log(colors[1]); // return 'blue'
colors[1] = 'yellow'; // reassign an element
console.log(colors[1]);

// capturse its size
let size = colors.length;

// add elements to an array
colors.push('purple');
console.log(colors);

console.log(colors.pop()); // removes the last element (purple)

// if you want to remove the first element instead, you call shift()
console.log(colors.shift()); // removes the first element (red)...now there's only a few colors left

console.log(colors.indexOf('red')); // returns -1
console.log(colors.indexOf('green'))

/**
 * In JS an Array is an ordered list of values and each value is called an element specified by an index
 * An Array Can hold values of mixed types
 * JS arrays are dynamic ( can change size)
 */

let myArr = [1, 2, 3];
myArr.push(4);

// Array functions in JS filter(), map(), reduce()

//  use map to returne a new array representing all q   uared values
let squaredValues = myArr.map(val => {

    return Math.pow(val, 2);

}) // a callback function is a function that is passed as a parameter by a notehr function

console.log(myArr);
console.log(squaredValues);

let a = "ten";
let b = 10;
let c = true;
let d = {};
let e = null;
let f = "";
let g = 0;
let h = [];
let i = function(){}; // a function is a first-class object means that we can assign it to a variable, we can
                        // pass it as a parameter to another function


const list = [a, b, c, d, e, f, g, h, i];
// list = 66; // we can't do this!

// 2 types of for loops: 

// 1.) basic for loop
for (let j=0; j<list.length; j++) {
    // printing our the element that is at that index!
    console.log(list[j]);
}

for (let elmIndex in list) {    

    console.log(`index is ${elmIndex}
                value is ${list[elmIndex]}`);

}

console.log("------------------------------------------")

list.forEach(el => { // arrow functions make life easier....thanks to ES6
    console.log(el)
})
// 2 ways of doing the same thing (arrow function vs. anonymous function )
list.forEach(
    function(value) {
        console.log(value);
    } // this is a callback because we're passing a function as a param to another function
)










