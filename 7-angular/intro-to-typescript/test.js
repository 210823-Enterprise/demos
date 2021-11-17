function doSomething() {
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }
    // can I access the i variable outside of the loop?
    console.log("i is " + i);
}
doSomething();
