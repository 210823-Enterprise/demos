function doSomething() {

    for (let i=0; i<5; i++) {
        console.log(i);
    }

    // can I access the i variable outside of the loop?
    console.log("i is " + i); // The TypeScript compiler will to warn us, but at the end of the day,
                              // all of our code is still transpiled to ES5 (not 6), so block scoped variables.
}

doSomething();