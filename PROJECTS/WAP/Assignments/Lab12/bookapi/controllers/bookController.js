const Book = require('../models/book');

exports.getAll = (req, res) => {
    res.status(200).json(Book.getAll());
};

exports.getById = (req, res, next) => {
    try {
        const book = Book.getBookById(parseInt(req.params.id));
        res.status(200).json(book);
    } catch (error) {
        res.status(404).json({ message: error.message });
    }
};

exports.save = (req, res, next) => {
    const { title, author } = req.body;
    const newBook = new Book(null, title, author.authorId, author.firstname, author.lastname).save();
    res.status(201).json(newBook);
};

exports.deleteById = (req, res, next) => {
    try {
        const book = Book.deleteById(parseInt(req.params.id));
        res.status(200).json(book);
    } catch (error) {
        res.status(404).json({ message: error.message });
    }
};

exports.updateById = (req, res, next) => {
    const { title, author } = req.body;
    try {
        new Book(null, title, author.authorId, author.firstname, author.lastname)
            .update(parseInt(req.params.id));
        res.status(204).end();
    } catch (error) {
        res.status(404).json({ message: error.message });
    }
};




