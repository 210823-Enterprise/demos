/**
 * What is THIS?
 * 
 * In JS, the "this" keyword refers to the object that it belongs to.
 * 
 * - alone, this refers to the global object
 * - in a FUNCTION, this still refers to the global object
 * - In a METHOD (a method is a functino that belongs to an object) this refers to the owner object
 * - in strict mode, this in a function returns undefined
 */
// 'use strict'

console.log(this); // wehn we call the global object in Node, since we're outside of a browser, it just calls an empty obj {}

function foo() {

    console.log(this); // retunrs undefined in strict mode

}

foo();

x = "hi"; // declaring a variable like this is equivlent to decalring it with var in not-strict mode
console.log(x);

// obj literal
const person = {

    // JSON is SIMILAR but not exactly the same
    firstName: "John",
    lastName: "Doe",
    id: 1234,
    fullName: function() { // this is a method (a function as a property of an object)
        return this.firstName + this.lastName;
    }

}

console.log(person.fullName());

this.cat = "Finn"; // here we're setting a property to the global object 

console.log(this.cat); 

// in the browser, the global object is the Window object














