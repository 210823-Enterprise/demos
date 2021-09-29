/**
 * JS has a special way of coercing all different types to a boolean value of either true or false
 * 
 * There are only 6 Falsey Values and everything else is Truthy
 * 
 * - 0
 * - null
 * - empty string
 * - false
 * - NaN
 * - undefined
 * 
 * !! double bang operator will check for a variables truthy or falsey value
 */

function checkTruthy(input) {
    console.log(`

        input is ${input} and is of type ${typeof(input)}
        It has a truthy value of ${!!input}
    `)
}

let username = "";
let age = 0;

// is username truthy or falsey?
checkTruthy(username);
checkTruthy(age); // falsey
checkTruthy('apple' * 15); // falsey! --> produces a number which is NaN (NaN itself is number but it's a property of the global object thrown to inform
// that we indeed don't have a number we can use)

checkTruthy({}); // truthy!
checkTruthy([]); // truthy!