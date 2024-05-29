const uuid = require("uuid");

let books = [
    { id: uuid.v4(), title: 'How to create JS classes', ISBN: 32544, publishedDate: '09-11-2007', author: 'Erick Emmanuel' },
    { id: uuid.v4(), title: 'Magic Hands', ISBN: 98812, publishedDate: '14-09-2000', author: 'Ben Carson' },
    { id: 3, title: 'Will', ISBN: 43211, publishedDate: '28-02-2022', author: 'Will Smith' },
];


module.exports = class Book {

    constructor(id, title, ISBN, publishedDate, author) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.publishedDate = publishedDate;
        this.author = author;
    }

    static getAll() {
        return books;
    }

    static getBooksById(id) {
        const book = books.find(b => b.id === id);
        if (book) {
            return book;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }

    save() {
        this.id = uuid.v4();
        books.push(this);
        return this;
    }

    static deleteById(id) {
        const index = books.findIndex(b => b.id === id);
        if (index > -1) {
          
            const temp = books[index];
            books.splice(index, 1);
            return temp;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }

    update(id) {
        const index = books.findIndex(p => p.id === id);
        if (index > -1) {
            this.id = id;
            books[index] = this;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }

}