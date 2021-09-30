// AJAX, Fetch

// capture the elements we need to grab data from
let pokeId = document.getElementById('poke-id');
let pokemonName = document.getElementById('name');
let renderedId = document.getElementById('id');
let btn = document.getElementById('btn');

// add event listener to the button, pass a callback function
btn.addEventListener("click", ajaxCall);


// define our callback function
function ajaxCall() {

    // here is where we open up the XMLHttpRequest Object to fetch data from a server (or post)
    let idNum = pokeId.value;

    // 1 attain XMLHttpRequest Object to send the request
    let xhr = new XMLHttpRequest();


    /**
     * 0. UNSENT: open() method has not been called 
     * 1. OPENED: open() method has been called
     * 2. HEADERS_REQUEST: send() method has been called and the ehaders + status code of the HTTP response are available
     * 3. LOADING: downloading the full response from the server
     * 4. DONE: entire operation is complete and now we have a server response.
     */
    xhr.onreadystatechange = function () {

        // check that the ready state is 4 and that the status code is 200
        if (this.readyState == 4 && this.status == 200) {

            // if it is, grab the data and PARSE it from a string to an object
            let receivedPokemon = JSON.parse(xhr.responseText);

            console.log(receivedPokemon);
            // call the render HTML method and render the received JSON
            renderHTML(receivedPokemon);
        }
    }

    xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${idNum}`)

    xhr.send();
}

function renderHTML(data) {

    pokemonName.innerHTML = "Name: " + data.name;
    renderedId.innerHTML = "ID: " + data.id;

    let image = document.getElementById('sprite');
    image.setAttribute("src", data.sprites.front_default);
    // image.src

    image.setAttribute("height", 300);

}