//create an event listener for the button, so that when it's clicked, it invokes a method
document.getElementById('add-student').addEventListener("click", addStudent);

// now we create the function addStudent()
function addStudent() {

    // 1. grab the input element AND its field values from the  student name & major
    let nameField = document.getElementById('student-name').value;
    let majorField = document.getElementById('student-major').value;

    // 2. check that they're truthy!
    if (!!nameField && !!majorField) {

        // 3. Create a row element
        let row = document.createElement('tr'); // tr is html for a table row element

        // 4. Create a table cell element for the Id
        let idCell = document.createElement('td');
        // 5. Create a table cell element for the Name
        let nameCell = document.createElement('td');
        // 6. Create a table cell element for the Major
        let majorCell = document.createElement('td');

        // 7. append the cells to the row
        row.appendChild(idCell);
        row.appendChild(nameCell);
        row.appendChild(majorCell);

        // 8. capture the preexisting table and append the row to the preexisting table
        document.getElementById('student-table-body').appendChild(row);

        // 9. set the inner text of each cell to the inromation we initially captured in step 1 
        idCell.innerText = idGenerator().next().value;
        nameCell.innerText = nameField;
        majorCell.innerText = majorField;

        // 10. clear out the input tfor the fields so that furture input can be provided
        document.getElementById('student-name').value = '';
        document.getElementById('student-major').value = '';

    }
}

let counter = 1;
// generator functions introdue in ES6 
function* idGenerator() {
    yield counter++;
}

