window.onload = function() {
    console.log('fetch.js is loaded')

    // this is an outdated pattern ( we don't typically throw code in here)
    
    // It's unneccessary to capture the event immediately when the window loads
    document.getElementById('btn').addEventListener("click", fetchCall);
}

function fetchCall(){

    // capture the user's input in the element with id poke-id
    let idNum = document.getElementById('poke-id').value;

    fetch(`https://pokeapi.co/api/v2/pokemon/${idNum}`)
        .then((response) => response.json())
        .then((data) => {

            console.log(data);

            // set the src attrbiute of the img element
            document.getElementById('sprite').src = data.sprites.front_default;

        }, (err) => {
            console.error(`Error is: ${err}`)
        } )

}