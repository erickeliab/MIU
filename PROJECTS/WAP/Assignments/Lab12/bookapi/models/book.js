
const uuid = require('uuid');

let books = [
    {
        bookId: 1,
        title: "Node.js",
        author: {
            authorId: 303,
            firstname: "Edward",
            lastname: "Jack",
        }
    },
    {
        bookId: 2,
        title: "Angular.js",
        author: {
            authorId: 308,
            firstname: "John",
            lastname: "Smith",
        }
    }
];



module.exports = class Book {
    constructor(id, title, authorId, firstname, lastname) {
        this.bookId = id;
        this.title = title;
        this.author = {
            authorId: authorId,
            firstname: firstname,
            lastname: lastname,
        };
    }

    static getNextId(){

        return books.length < 1 ? 0 : books[books.length-1].bookId+1;
    }

    static getAll() {
        return books;
    }

    static getBookById(id) {
        const book = books.find(b => b.bookId === id);
        if (book) {
            return book;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }

    save() {
        this.bookId = Book.getNextId();
        books.push(this);
        return this;
    }

    static deleteById(id) {
        const index = books.findIndex(b => b.bookId === id);
        if (index > -1) {
            const [deletedBook] = books.splice(index, 1);
            return deletedBook;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }

    update(id) {
        const index = books.findIndex(p => p.bookId === id);
        if (index > -1) {
            this.bookId = id;
            books[index] = this;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }
}
