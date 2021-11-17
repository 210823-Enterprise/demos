/**
 * Equality and equals operator
 * 
 * = is an assignemnt operator
 * 
 * == compares an object on either side VALUE, but performs something calle dtype coercion
 * 2 == '2' // true
 * 
 * === is a struct equals operator which compares type
 * 2 === '2' false
 */

console.log(2 == '2'); // true
console.log(2 === '2'); // false

// Goal declare a function designed to take in 2 parameters and compare their type
// compare in 2 differnt ways (with type coercion, & without type coercion) are they == ? are they === ?

function compare(first, second) {

    console.log(`

        first param = ${first}, and is of type ${typeof(first)}
        second param = ${second}, and is of type ${typeof(second)}

        Is first == second? : ${first == second}
        is first === second? : ${first === second}

    `);

}

compare(2, '2'); // true, false
compare("two", '2'); // false, false
compare({}, {}); // false, false In JS 2 empty objects are still itnerpreted as 2 totally differnt object instances and not equal in any fashion 
compare([], null); // false, false

let coolString = `He said "hello there!"`; // template literals allow us to write quotes without escape sequences.
console.log(coolString);