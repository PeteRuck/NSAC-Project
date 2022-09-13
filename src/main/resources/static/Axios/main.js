"use strict";

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
    axios.create("http://localhost:8080/animal/create", obj)
    .then(res => {
        console.log(res.data);
    }).catch(err => console.log(err));
}

// Update
let update = () => {
    axios.get("http://localhost:8080/animal/getAll")
    .then(res => {
        console.log(res.data);
    }).catch(err => console.log(err));
}

// Delete
let del = () => {
    axios.get("http://localhost:8080/animal/getAll")
    .then(res => {
        console.log(res.data);
    }).catch(err => console.log(err));
}