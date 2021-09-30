// Introduction to JavaScript async/await
// Star from Zero: Life before Promises

/**
 * In the past when you wanted to deal with asynchronous operations, you have to use callback functions.
 * When you nest multiple callback functions, the code becomes very difficult to maintains.
 * This very issue is called callback hell.
 * 
 * Suppose you want you want to perform 3 asynchronous ops:
 * 
 * 1. Select a USer from a database
 * 2. Get services of the User (we're checking what internet services the user has used)
 * 3. Calculate the service cost based on the services that the user has used
 */

// getUser
function getUser(userId, callback) {
    console.log('Get user from the database.')

    setTimeout(() => {
        callback({
            userId: userId,
            username: 'John'
        })
    }, 1000) // first in line in the callback queue
}

// getService
function getServices(user, callback) {

    console.log(`Get services of ${user.username} from the API`)
    
    setTimeout(() => {
        callback(['Email', 'VPN', 'CDN'])
    }, 2 * 1000)
}

// getServiceCost 
function getServiceCost(services, callback) {

    console.log(`Calculate service costs of ${services}.`)

    setTimeout(() => {
        callback(services.length * 100);
    }, 3 * 1000)
}

// nested services to get the final cost that the User owes for services borrowed
getUser(104, (user) => {
    // the "2nd parameter is a function (callback function)"
    getServices(user, (services) => { // implementing callback as 2nd param for getServices();
        getServiceCost(services, (cost) => { // implementing callback as 2nd param for getServiceCost();
            console.log(`The service cost is ${cost}`) 
        })
    })

})
