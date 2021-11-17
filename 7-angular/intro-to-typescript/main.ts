// TypeScript is a SUPER SET of JavaScript (all JS is valid TS)
/**
 * - TS is OOP -> it allows for mnore OOP features (interfaces, classes, generics)
 * - We get a TS compiler! 
 * - TS is strongly typed!
 */

function logIt(message) {

    console.log(message);

}

let myMessage = 'Hello world';
logIt(myMessage);

/**
 * 2 Steps to run this code
 * 
 * 1. Call the typescript compiler to transpile our TS -> JS: tsc main.ts
 * 2. Run the JS file  : node main.js
 */
