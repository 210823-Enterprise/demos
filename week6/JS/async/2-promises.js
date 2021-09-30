// To avoid the callback hell issue, Es6 introduced Promised
// to allow you write asycnchronous code in more manageable ways

// A Promise is an object that MAY produce a single value at some point in the future, either resolved or rejected (rejected due to some network error)

// A Promise may be in 1 of 3 possible states:
// 1 . Fulfilled
// 2. Rejected
// 3. Pending

function getUser(userId) {
    return new Promise((resolve, reject) => {
        console.log('Get User from the Database.')

        setTimeout(() => {
            resolve({
                userId: userId,
                username: 'John'
            })
        }, 1000)
    })

}

function getServices(user) {
    return new Promise((resolve, reject) => {

        console.log(`Get services of ${user.username} from the API`)

        setTimeout(() => {
            resolve(['Email', 'VPN', 'CDN'])
        }, 2 * 1000)

    })
}

function getServiceCost(services, callback) {

    return new Promise((resolve, reject) => {

        console.log(`Calculate service costs of ${services}.`)

        setTimeout(() => {
            resolve(services.length * 100);
        }, 3 * 1000)

    })
}

// chain
getUser(103)
    .then(getServices)
    .then(getServiceCost)
    .then(console.log);



