// Run the following in your BROWSER!

let names = {
    fname: "Dillion",
    lname: "Megida"
}
console.log(names.fname);
console.log(names.hasOwnProperty("mname"));
// Expected Output
// Dillion
// false

/**
 * The object variable names has only two properties - fname and lname . No methods at all.

So where does hasOwnProperty come from?

Well, it comes from the Object prototype.

Try logging the contents of the variable to the console:
 * 
 */

console.log(names);
// Notice the last property - __proto__? Try expanding it:

/**
 * You'll see a set of properties under the Object constructor. All these properties are coming from the global Object prototype. If you look closely, you'll also notice our hidden hasOwnProperty .

In other words, all objects have access to the Object's prototype. They do not possess these properties, but are granted access to the properties in the prototype.
 */


/**
 * 
 * Modifying the __proto__ property
This property can be modified by explicitly stating that it should refer to another prototype. The following methods are used to achieve this:

Object.create()
 */
function DogObject(name, age) {
    let dog = Object.create(constructorObject);
    dog.name = name;
    dog.age = age;
    return dog;
}
let constructorObject = {
    speak: function(){
        return "I am a dog"
    }
}
let bingo = DogObject("Bingo", 54);
console.log(bingo);

// new Keyword

function DogObject(name, age) {
    this.name = name;
    this.age = age;
}
DogObject.prototype.speak = function() {
    return "I am a dog";
}
let john = new DogObject("John", 45);

/**
 * john's __proto__ property is directed to DogObject's prototype. But remember, DogObject's prototype is an object (key and value pair), hence it also has a __proto__ property which refers to the global Object protoype.

This technique is referred to as PROTOTYPE CHAINING.
 */

// The following example is a general usage of a class in JavaScript:

class Animals {
    constructor(name, specie) {
        this.name = name;
        this.specie = specie;
    }
    sing() {
        return `${this.name} can sing`;
    }
    dance() {
        return `${this.name} can dance`;
    }
}
let bingo = new Animals("Bingo", "Hairy");
console.log(bingo);



