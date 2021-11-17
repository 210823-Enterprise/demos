const unchangeableWord = "Never"; // you can decalre the string data type with "" or '' 
let changeableWord = 'Maybe';

console.log(unchangeableWord + " " + changeableWord);

// EcmaScript 6 introduced a NEW way of decalring strings (Enter the TEMPLATE LITERALS)

let templateLiteral = ``; // defined with 2 `` (under esc key)

templateLiteral = ` This is a multi-line

comment, and I expect
this format to persist

when I print it out.`;

console.log(templateLiteral);

// the old way of concatenating BEFORE string interppolation
let age = 97;
let sentence = "Hello, I am " + age + " years old";


console.log(sentence);

templateLiteral = `Now I am ${age + 1} years old`;

console.log(templateLiteral);

console.log(`${400 * 3}`);

// again, why are let & const so great? If we used var everywhere, that would defeat the prupose of scoping 



