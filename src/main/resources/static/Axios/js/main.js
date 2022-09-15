"use strict";

// SELECTORS

// DIVS

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
    entryDiv.textContent = `${result.id} | ${result.commonName} | ${result.genus} | ${result.size} | ${result.typeGenus}`;

    let delBtn = document.createElement("button");
    delBtn.textContent = "Delete";
    delBtn.type = "button";
    delBtn.setAttribute("Class", "btn btn-danger btn-sm");
    delBtn.setAttribute("onClick", `del(${result.id})`);

    entryParent.appendChild(entryDiv);
    entryParent.appendChild(delBtn);
    resultsDiv.appendChild(entryparent);
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

    if(!validateInputs()){
        alert("All fields nee a value!");
        return
    }

    let obj = {
        "commonName": cNameInput.value,
        "genus": genusInput.value,
        "size": sizeInput.value,
        "type_Genus": gTypeInput.value
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
        "type_Genus": gTypeInput.value
    }
    axios.put(`http://localhost:8080/animal/update/${idInput.value}`, obj)
    .then((resp) => {
        getAll();
    }).catch(err => console.error(err));
}

// Delete
let del = (id) => {
    axios.delete(`http://localhost:8080/animal/delete/${id}`)
    .then(resp => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

let validateDelete = () => {
    if (idInput.value === "") {
        alert("ID is needed for this to work");
        return false;
    } else {
        return true;
}}

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

