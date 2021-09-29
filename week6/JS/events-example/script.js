// I want to provide the functionality so that when I click the button, the text changes


// 1. create a fucntion called changeText()
function changeText() {

    // 2. identify the elemtn that we want to be changed (paragraph element with the special )
    let element = document.getElementById("my_paragraph")

    // 3. change that element's text to something like Bazinga or somehting
    element.innerHTML = "Bazinga!"; // change the Content of the element we're grabbing
}

// 4. grab the button element and add an event listener so that whern it's clicked, it tirggers that funcino above 
let btn = document.querySelector("input") // will find whatever element we've defined aas an input element

// 5. add the event listener
btn.addEventListener("click", changeText) // a funciton wihtout () is a refernce to the function


/**
 * What are the ways you can query an element from the dom?
 * -= document.getElementById
 * - docuyment.getElem,entsByClassName
 * document.querySelector
 * 
 */
