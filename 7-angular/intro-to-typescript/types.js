var count = 5;
// count = 'apples' // you can't reassign a number variable to a string!
/** TS is STATICALLY typed! You can't reassign a variable of different type */
var x = 10; // we are implicityl assigning it a number type.
// x = 'ten'; // same thing!
var a; // initializing the variable a and its type;
a = 100;
a = 1000;
// a = 'apples'; // can't do this!
var b = true; // full initialization
var c = 'kiwi';
var d;
d = 'dog';
d = 1444; // The any type in TypeScript allows me redeclare the value to any type in TS
var e = ['one', 1, false, 'apple'];
var f = [10, 20, 30, 40];
console.log(e[2]); // will return the boolean value false which is the third element
// Enums allow us to define named constant (like in Java)
// old way:
var ColorRed = 0;
var ColorBlue = 1;
var ColorGreen = 2;
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Blue"] = 1] = "Blue";
    Color[Color["Green"] = 2] = "Green";
})(Color || (Color = {}));
; // this will be very funky in JS
var backgroundColor = Color.Blue;
