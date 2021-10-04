// We will create a class that represents an Observable
class MousePositionObservable { // An Observable is subscribed to by Observers

    constructor() {
        this.subsciptions = []; // array of callbacks
        window.addEventListener('mousemove', this.handleMouseMove)
    }

    handleMouseMove = (e) => {
        this.subsciptions.forEach(sub => {
            sub(e.clientX, e.clientY)
        })
    }

    // expose a subscribe method which observers will call to subscribe to the change
    subscribe(callback) {
    
        this.subsciptions.push(callback);

        return () => {
            this.subsciptions = this.subsciptions.filter(cb => cb !== callback);
            // this logic is necessary to make sure we don't have repeat callbacks
        }

    }
}

// instnatiate an observable object
const mouseObservable = new MousePositionObservable();

mouseObservable.subscribe( (x, y) => {
    // Here I am passing a callback as a subscription (adding observers)
    const board = document.querySelector('.mouse-position')

    board.innerHTML = `
        <div>
            <div>ClientX: ${x} </div>
            <div>ClientY: ${y} </div>
        </div>
    `
});

/**
 * What is the Observer Subscriber pattern?
 * 
 * It's a pattern that offers a subscription model in which objects subscribe to an event and get
 * notified when the event occurs.  This is essentially the corner stone of event driven programming in JS.
 * 
 * The Subject (what observers subscribe to) maintains a list of the the objects that depend on it (observers).
 */





