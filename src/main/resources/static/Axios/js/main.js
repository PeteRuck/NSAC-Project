"use strict";

// SELECTORS

// DIVS
let resultsDiv = document.querySelector("#results-div");

// INPUTS
let cNameInput = document.querySelector("#cNameInput");
let genusInput = document.querySelector("#genusInput");
let sizeInput = document.querySelector("#sizeInput");
let gTypeInput = document.querySelector("#gTypeInput");


// BUTTONS
let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");

// FUNCTIONS
let printResults = (result) => {
    let entryParent = document.createElement("div");
    entryParent.setAttribute("class", "entry-parent");

    let entryDiv = document.createElement("div");
    entryDiv.setAttribute("class", "entry-div");
    entryDiv.textContent = `${result.id} --|-- ${result.commonName} --|-- ${result.genus} --|-- ${result.size} --|-- ${result.typeGenus}`;

   

    entryParent.appendChild(entryDiv);
    resultsDiv.appendChild(entryParent);
}

// Get All
let getAll = () => {
    axios.get("http://localhost:8080/animal/getAll")
    .then(res => {
        resultsDiv.innerHTML = "";

        let results = res.data;
        
        for (let result of results) {
            printResults(result);
        }
    }).catch(err => console.log(err));
}

// Create
let create = () => {

    let obj = {
        "commonName": cNameInput.value,
        "genus": genusInput.value,
        "size": sizeInput.value,
        "typeGenus": gTypeInput.value
    }
    axios.post("http://localhost:8080/animal/create", obj)
    .then(res => {
        getAll();
    }).catch(err => {console.log(err);});
}

// Update
let update = () => {
    let obj = {
        "commonName": cNameInput.value,
        "genus": genusInput.value,
        "size": sizeInput.value,
        "typeGenus": gTypeInput.value
    }
    axios.put(`http://localhost:8080/animal/update/${idInput.value}`, obj)
    .then((resp) => {
        getAll();
    }).catch(err => console.error(err));
}

// Delete
let del = (id) => {
    axios.delete(`http://localhost:8080/animal/delete/${idInput.value}`)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

let validateInputs = () => {
    if (cNameInput.value === "" || genusInput.value === "" || sizeInput.value === "" || gTypeInput.value) {
        return false;
    } else {
        return true;
    }
}

// EVENT LISTENERS
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);

