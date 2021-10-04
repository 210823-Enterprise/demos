var count = 5;
// count = 'apples' // you can't reassign a number variable to a string!

/** TS is STATICALLY typed! You can't reassign a variable of different type */

let x = 10; // we are implicityl assigning it a number type.
// x = 'ten'; // same thing!

let a: number; // initializing the variable a and its type;
a = 100;
a = 1000;
// a = 'apples'; // can't do this!

let b: boolean = true; // full initialization
let c: string = 'kiwi';
let d: any;
d = 'dog';
d = 1444; // The any type in TypeScript allows me redeclare the value to any type in TS
let e : any[] = ['one', 1, false, 'apple'];
let f : number[] = [10, 20, 30, 40];

console.log(e[2]) // will return the boolean value false which is the third element

// Enums allow us to define named constant (like in Java)

// old way:
const ColorRed = 0;
const ColorBlue = 1;
const ColorGreen = 2;

enum Color {Red, Blue, Green}; // this will be very funky in JS

let backgroundColor = Color.Blue;

