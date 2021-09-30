// in 2017 EcmaScript 8 was released and with it came the async and await keywords
// We use the async keyword to define functions that handle asynchronous operations

async function sayHi() {
    return 'Hi'; // implicitylyt returning a Promise
}

// Asynchronous fucntions always return a promise. 
sayHi().then(console.log);

// Aysnchronous functions execurte asynchronouslyvia the event loop.

async function sayHi2(){

    // explicitly stating that we're reutnring a promise
    return Promise.resolve('Hi');
}

let sayHi3 = async function() {
    return 'Hi';
}

let sayHi4 = async () => 'Hi';

async function display() {

    // the await keyword can ONLY be used within an asynchronous function
   try {
    let result = await sayHi();
    console.log(result); // imagine that the promise state was rejected
   } catch (error) {
       console.log(error);
   }

}
