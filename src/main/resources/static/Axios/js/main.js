"use strict";

//SELECTORS

//DIVS

//INPUTS

//BUTTONS
let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");

//FUNCTIONS

// Get All
let getAll = () => {
    axios.get("http://localhost:8080/animal/getAll")
    .then(res => {
        console.log(res.data);
    }).catch(err => console.log(err));
}

// Create
let create = () => {
    
    let obj = {
        "commonName": "Fox",
        "genus": "Vulpis",
        "size": 50,
        "type_Genus": "Canidae"
    }
    axios.post("http://localhost:8080/animal/create", obj)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

// Update
let update = () => {
        let obj = {
            "commonName": "Wolf",
            "genus": "Lupis",
            "size": 90,
            "type_Genus": "Canidae"
        }
    axios.put("http://localhost:8080/animal/update/4", obj)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

// Delete
let del = () => {
    axios.delete("http://localhost:8080/animal/delete/1")
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

// EVENT LISTENERS
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);

