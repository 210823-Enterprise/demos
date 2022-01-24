// capture the add-modal element
const addMovieModal = document.getElementById('add-modal'); // also could have used querySelector('#add-modal');
// we will need to add functionality to this button so we should capture it first
const startAddMovieButton = document.querySelector('header button'); // this is a CSS query tag select which selects the button
                                                                     // element within the header element. (lines 53 - 56)

// (3)
const backdrop = document.getElementById('backdrop');
// (5a) capture the parent element and query the element with the .btn--passive class
const cancelAddMovieButton = addMovieModal.querySelector('.btn--passive')
// (6a)
const confirmAddMovieButton = cancelAddMovieButton.nextElementSibling;
// (6c) create a collection object that represents all of the input fiels in addMovieModal
const userInputs = addMovieModal.querySelectorAll('input'); // or .getElementsByTagName('input')
// (9b)
const entryTextSection = document.getElementById('entry-text');

// (7a)
const movies = []; // then build movie template literal;

// (9a)
const updateUI = () => {
    // (9c)
    if (movies.length === 0) {
        entryTextSection.style.display = 'block';
      } else {
          // this removes the block
        entryTextSection.style.display = 'none'; // then add to confirmAddMovieHandler() (9d)
      }
}

// (10) create function to generate object that represents userInput
const renderNewMovieElement = (id, title, imageUrl, rating) => {
    const newMovieElement = document.createElement('li');
    newMovieElement.className = 'movie-element';
    newMovieElement.innerHTML = `
      <div class="movie-element__image">
        <img src="${imageUrl}" alt="${title}">
      </div>
      <div class="movie-element__info">
        <h2>${title}</h2>
        <p>${rating}/5 stars</p>
      </div>
    `;
    const listRoot = document.getElementById('movie-list');
    listRoot.append(newMovieElement); // (10b) call in confirmAddMovieHandler() before updateUI()
}

// (3) challenge - separate function out so that I can re-use it later
const toggleBackdropHandler = () => {
    backdrop.classList.toggle('visible');
}

// (4a) method for when we click backdrop
const backdropClickHandler = () => {
    toggleMovieModal(); // take away the 'visible' class
}

// (5b) method for when we click the cancel button on modal
const cancelAddMovieHandler = () => {
    toggleMovieModal();
    /* (8b) */ clearMovieInput(); // after 8 move to (9) Render Movie Item to Screen
}

// (8a) method for clearing the movie input
const clearMovieInput = () => {
    for (const usrInput of userInputs) {    
        usrInput.value = ''; // also call this method in cancelMovieHandler()
    }
};

// (6b) first create userInputs const in 6c aboe, then complete
const confirmAddMovieHandler = () => {
    const titleValue = userInputs[0].value; // selecting the first element from that array
    const imageUrlValue = userInputs[1].value; 
    const ratingValue = userInputs[2].value;

    // add a little input validation
    if (
        titleValue.trim() === '' || 
        imageUrlValue.trim() === '' || 
        ratingValue.trim() == '' || 
        +ratingValue < 1 || 
        +ratingValue > 5 
        ) {
        alert('Please enter valid values (rating must be between 1 and 5)')
        return;
    }

    // (7) Build a movies array to which we can add movies generated by the user
    // (7b)
    const newMovie = {
        title: titleValue,
        image: imageUrlValue,
        rating: ratingValue
    };

    // (7c) then append (push) the object to the movies array
    movies.push(newMovie);
    console.log(movies);

    // (7d) close the modal
    toggleMovieModal(); // then add (8) clearMovieInput() to clear the value
    clearMovieInput();
    /* 10b*/ renderNewMovieElement(newMovie.id, newMovie.title, newMovie.image, newMovie.rating)
    updateUI(); // (9d) -> then 10 renderNewMovieElement();
};

/** add an event listener to the startAddMovieButton and define a function to occur upon a click
 *  (1) first define arrow function
 * */
const toggleMovieModal = () => {
    // toggle the addMovieModal's class and change it to 'visible' with classList.toggle();
    // Example: https://www.w3schools.com/jsref/prop_element_classlist.asp
    addMovieModal.classList.toggle('visible');
    // (3) challenge
    toggleBackdropHandler();
}

// (2) then add an eventListener so that when someone clicks on the button, we execute the above function
startAddMovieButton.addEventListener('click', toggleMovieModal); // --- THEN CHECK IT! ---
// --- NOTE! --- The second param of addEventListener expects a function REFERENCE not invocation with ().
/**
 * A callback is a function that is passed into another function as an 
 * argument to be executed later.
 * (Developers say you “call” a function when you execute a function, 
 * which is why callbacks are named callbacks).
 * */

// (3) === CHALLENGE === Darken the back drop when the button is clicked.

// (4) Add "Click Backdrop and Cancel Modal Functionality" before "Add Cancel and Add Button Functionality"
// First add the method above <(4a)>, then add the evenListener:
backdrop.addEventListener('click', toggleMovieModal);

// (5) Add the same event listener to the cancel button on the Modal
// (5a) declare const above then move to the following: (5b) - method, then (5c) below:
cancelAddMovieButton.addEventListener('click', cancelAddMovieHandler);

// (6) Add confirmAddMovieModal button functionality
confirmAddMovieButton.addEventListener('click', confirmAddMovieHandler)



