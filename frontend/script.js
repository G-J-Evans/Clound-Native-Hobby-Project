'use strict'

import * as DOM from "./dom.js"

// --- Form manipulation ---

// Hides all elements in the form
function cleanForm() {
    DOM.form.forEach(element => {
        element.style.display = "none";
    });
    DOM.id.value = '';
    DOM.title.value = '';
    DOM.author.value = '';
    DOM.genre.value = '';
    DOM.publicationYear.value = '';
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

// --- Return handling ---

// cleans output space
function clearOutput() {
    DOM.output.innerHTML = '';
}

// Converts a JSON into a displayable table row and displays it
function displayBook(book) {
    if(!book.id) {
        return;
    }
    // create row elements
    const tableRow = document.createElement(`tr`);
    const id = document.createElement(`th`);
    const title = document.createElement(`td`);
    const author = document.createElement(`td`);
    const genre = document.createElement(`td`);
    const publicationYear = document.createElement('td');
    // add data to row elements
    id.scope = "row";
    id.innerHTML = book.id;
    title.innerHTML = book.title;
    author.innerHTML = book.author;
    genre.innerHTML = book.genre ?? 'no genre';
    publicationYear.innerHTML = book.publicationYear ?? 'no publication year';
    // create row
    tableRow.appendChild(id);
    tableRow.appendChild(title);
    tableRow.appendChild(author);
    tableRow.appendChild(genre);
    tableRow.appendChild(publicationYear);
    // add row to the output table.
    DOM.output.appendChild(tableRow);
} 

// same for list
function displayBookList(bookList) {
    bookList.forEach(book => displayBook(book));
}

// --- API calls ---
async function createBook() {
    clearOutput();
    let newTitle = DOM.title.value;
    let newAuthor = DOM.author.value;
    let newGenre = DOM.genre.value;
    let newPublicationYear = parseInt(DOM.publicationYear.value);
    try{
        const createdBook = await axios.post(`http://localhost:8080/create`, {
            "title" : `${newTitle}`,
            "author" : `${newAuthor}`,
            "genre" : `${newGenre}`,
            "publicationYear" : newPublicationYear
        });
        displayBook(createdBook.data);
    } catch(err) {
        console.error(err);
    }
}

async function readAll() {
    cleanForm();
    clearOutput();
    try {
        const bookList = await axios.get(`http://localhost:8080/getAll`);
        displayBookList(bookList.data);
    } catch(err) {
        console.error(err);
    }
}

async function searchID() {
    clearOutput();
    let id = parseInt(DOM.id.value);
    console.log(id);
    try {
        const book = await axios.get(`http://localhost:8080/id/${id}`);
        displayBook(book.data);
    } catch(err){
        console.error(err);
    }
}

async function searchTitle() {
    clearOutput();
    let title = DOM.title.value;
    try {
        const bookList = await axios.get(`http://localhost:8080/title/${title}`);
        displayBookList(bookList.data);
    } catch(err){
        console.error(err);
    }
}

async function searchAuthor() {
    clearOutput();
    let author = DOM.author.value;
    try {
        const bookList = await axios.get(`http://localhost:8080/author/${author}`);
        displayBookList(bookList.data)
    } catch(err){
        console.error(err);
    }
}

async function searchGenre() {
    clearOutput();
    let genre = DOM.genre.value;
    try {
        const bookList = await axios.get(`http://localhost:8080/genre/${genre}`);
        displayBookList(bookList.data)
    } catch(err){
        console.error(err);
    }
}

async function searchPublicationYear() {
    clearOutput();
    let publicationYear = parseInt(DOM.publicationYear.value);
    try {
        const bookList = await axios.get(`http://localhost:8080/year/${publicationYear}`);
        displayBookList(bookList.data)
    } catch(err){
        console.error(err);
    }
}

async function randomBook() {
    clearOutput();
    readByForm();
    try {
        const randomBook = await axios.get(`http://localhost:8080/random`);
        displayBook(randomBook.data);
    } catch(err){
        console.error(err);
    }
}

async function updateBook() {
    clearOutput();
    let id = DOM.id.value;
    let newTitle = DOM.title.value;
    let newAuthor = DOM.author.value;
    let newGenre = DOM.genre.value;
    let newPublicationYear = DOM.publicationYear.value;
    try {
        const updatedBook = await axios.put(`http://localhost:8080/replace/${id}`, {
            "title" : `${newTitle}`,
            "author" : `${newAuthor}`,
            "genre" : `${newGenre}`,
            "publicationYear" : newPublicationYear
        });
        displayBook(updatedBook.data);
    } catch(err) {
        console.error(err);
    }
}

async function deleteBook() {
    clearOutput();
    let id = DOM.id.value;
    try {
        await axios.delete(`http://localhost:8080/remove/${id}`);
    } catch(err) {
        console.error(err);
    }
    readAll();
    deleteForm();
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
// readRandom in API call

// API call buttons
DOM.createConfirmButton.onclick = () => createBook();
DOM.readAllButton.onclick = () => readAll();
DOM.searchIDConfirmButton.onclick = () => searchID();
DOM.searchTitleConfirmButton.onclick = () => searchTitle();
DOM.searchAuthorConfirmButton.onclick = () => searchAuthor();
DOM.searchGenreConfirmButton.onclick = () => searchGenre();
DOM.searchPublicationYearConfirmButton.onclick = () => searchPublicationYear();
DOM.readRandomButton.onclick = () => randomBook();
DOM.updateConfirmButton.onclick = () =>  updateBook();
DOM.deleteConfirmButton.onclick = () => deleteBook();