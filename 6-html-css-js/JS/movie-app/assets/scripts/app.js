// capture the add-modal element
const addMovieModal = document.getElementById('add-modal'); // also could have used querySelector('#add-modal');

// we will need to add functionality to this button so we should capture it first
const startAddMovieButton = document.querySelector('header button'); // this is a CSS query tag select which selects the button
                                                                     // element within the header element. (lines 53 - 56)

// (3)
const backdrop = document.getElementById('backdrop');

// (3) challenge - separate function out so that I can re-use it later
const toggleBackdrop = () => {
    backdrop.classList.toggle('visible');
}


/** add an event listener to the startAddMovieButton and define a function to occur upon a click
 *  (1) first define arrow function
 * */
const toggleMovieModel = () => {
    // toggle the addMovieModal's class and change it to 'visible' with classList.toggle();
    // Example: https://www.w3schools.com/jsref/prop_element_classlist.asp
    addMovieModal.classList.toggle('visible');
    // (3) challenge
    toggleBackdrop();
}

// (2) then add an eventListener so that when someone clicks on the button, we execute the above function
startAddMovieButton.addEventListener('click', toggleMovieModel); // --- THEN CHECK IT! ---

// (3) === CHALLENGE === Darken the back drop when the button is clicked.



