const Music = require('../models/music');

exports.getAll = (req, res) => {
    res.status(200).json(Music.getAll());
};

exports.getPlaylist = ( req, res, next ) => {
    res.status(200).json(Music.getPlaylist());
}

exports.addToPlaylist = (req, res, next) => {
    
    
    res.status(200).json(Music.addToPlaylist(req.body.ISBN));
}

exports.getById = (req, res, next) => {
    res.status(200).json(Music.getMusicById(parseInt(req.params.id)));
}

exports.save = (req, res, next) => {
    const newBook = new Book(null, req.body.title, req.body.ISBN, req.body.publishedDate, req.body.author).save();
    res.status(201).json(newBook);
}

exports.deleteById = (req, res, next) => {
    res.status(200).json(Music.deleteFromPlaylist(parseInt(req.params.id)));
}

exports.updateById = (req, res, next) => {
    new Music(null, req.body.title, req.body.ISBN, req.body.publishedDate, req.body.author)
        .update(parseInt(req.params.id));
    res.status(204).end();
}