// JavaScript is Single Threaded! Can only do ONE thing a certain point in time.

/**
 * JS Engine executes a script from the top of a file.
 * 
 * Creates the execution contexts and pushes and pops functions onto and off the call stack in the execution process.
 * 
 * If a function takes too long to complete, you can't interact with the web browser and it becomes a blocking function.
 * A blocking function could be like downloading a file from a server.
 */

function task(message) {

    // emulate a time consuming task
    let n = 10000000000;
    while (n > 0) {
        n--;
    }
    // when it finishes we'll log a message'
    console.log(message);
}

// console.log("Start script...");
// task("Download complete.")
// console.log("Done!");

// Callbacks to the rescue!!!!
console.log("Start script...");

setTimeout(() => {
// a callback function is a function passed as a parameter to another function
    task('Download complete.')

}, 1000);

console.log("Done!");


console.log('Hi');

setTimeout(() => {

    console.log('Execute imediately!')
    // this will only execute after all other functions have been removed from the stack
    // It hangs out in the callback queue until the call stack is free AND its timer has expired

}, 500) // we are not setting any amount of time restraints on it being executed

console.log('Bye')






















