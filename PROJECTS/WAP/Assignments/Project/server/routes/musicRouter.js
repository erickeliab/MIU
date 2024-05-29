
const express = require('express');
const musicController = require('../controllers/musicController');

const router = express.Router();

router.get('/', musicController.getAll);

router.get('/playlist', musicController.getPlaylist);
router.get('/:id', musicController.getById);
router.post('/playlist', musicController.addToPlaylist);
router.delete('/playlist/:id', musicController.deleteById);
router.put('/:id', musicController.updateById);

module.exports = router;