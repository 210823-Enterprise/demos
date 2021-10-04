// TypeScript is a SUPER SET of JavaScript (all JS is valid TS)
/**
 * - TS is OOP -> it allows for mnore OOP features (interfaces, classes, generics)
 * - We get a TS compiler!
 * - TS is strongly typed!
 */
function logIt(message) {
    console.log(message);
}
var myMessage = 'Hello world'; // typescript transpiles TS -> JS -> EcmaScript 5
logIt(myMessage);
/**
 * 2 Steps to run this code
 *
 * 1. Call the typescript compiler to transpile our TS -> JS
 * 2. Run the JS file
 */
