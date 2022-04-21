'use strict'

import * as DOM from "./dom.js"

// --- Form manipulation ---

// Hides all elements in the form
function cleanForm() {
    DOM.form.forEach(element => {
        element.style.display = "none";
    });
}

function createForm() {
    cleanForm();
    DOM.inputTitle.style.display = "block";
    DOM.inputAuthor.style.display = "block";
    DOM.inputGenre.style.display = "block";
    DOM.inputPublicationYear.style.display = "block";
    DOM.createContainer.style.display = "block";
}

// read all form further down as it makes an API call

function readByForm() {
    cleanForm();
    DOM.searchButtons.style.display = "block";
}

function readIDForm() {
    readByForm();
    DOM.inputID.style.display = "block";
    DOM.searchIDContainer.style.display = "block";
}

function readTitleForm() {
    readByForm();
    DOM.inputTitle.style.display = "block";
    DOM.searchTitleContainer.style.display = "block";
}

function readAuthorForm() {
    readByForm();
    DOM.inputAuthor.style.display = "block";
    DOM.searchAuthorContainer.style.display = "block";
}

function readGenreForm() {
    readByForm();
    DOM.inputGenre.style.display = "block";
    DOM.searchGenreContainer.style.display = "block";
}

function readPublicationYearForm() {
    readByForm();
    DOM.inputPublicationYear.style.display = "block";
    DOM.searchPublicationYearContainer.style.display = "block";
}

function updateForm() {
    cleanForm();
    DOM.inputID.style.display = "block";
    DOM.inputTitle.style.display = "block";
    DOM.inputAuthor.style.display = "block";
    DOM.inputGenre.style.display = "block";
    DOM.inputPublicationYear.style.display = "block";
    DOM.updateContainer.style.display = "block";
}


function deleteForm() {
    cleanForm();
    DOM.inputID.style.display = "block";
    DOM.deleteContainer.style.display = "block";
}



// --- API calls ---
function createBook() {
    let newTitle = DOM.title.value;
    let newAuthor = DOM.author.value;
    let newGenre = DOM.genre.value;
    let newPublicationYear = DOM.publicationYear.value;
    try{
        axios.post(`http://localhost:8080/create`, {
            "title" : `${newTitle}`,
            "author" : `${newAuthor}`,
            "genre" : `${newGenre}`,
            "publication_year" : newPublicationYear
        });
    } catch(err) {
        console.error(err);
    }
}

// Inputs

// --- Buttons ---

// Form Selection Buttons
DOM.createButton.onclick = () => createForm();
// readall in API call buttons
DOM.readByButton.onclick = () => readByForm();
DOM.updateButton.onclick = () => updateForm();
DOM.deleteButton.onclick = () => deleteForm();

// Read By Form Selection Buttons
DOM.readIDButton.onclick = () => readIDForm();
DOM.readTitleButton.onclick = () => readTitleForm();
DOM.readAuthorButton.onclick = () => readAuthorForm();
DOM.readGenreButton.onclick = () => readGenreForm();
DOM.readPublicationYearButton.onclick = () => readPublicationYearForm();

// API call buttons
DOM.createConfirmButton.onclick = () => createBook();
DOM.readAllButton.onclick = () => readAll();
DOM.searchIDConfirmButton.onclick = () => searchID();
DOM.searchTitleConfirmButton.onclick = () => searchTitle();
DOM.searchAuthorConfirmButton.onclick = () => searchAuther();
DOM.searchGenreConfirmButton.onclick = () => searchGenre();
DOM.searchPublicationYearConfirmButton.onclick = () => searchPublicationYear();
DOM.updateConfirmButton.onclick = () =>  updateBook();
DOM.deleteConfirmButton.onclick = () => deleteBook();
