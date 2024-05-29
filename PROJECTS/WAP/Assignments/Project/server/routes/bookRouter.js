
const express = require('express');
const bookController = require('../controllers/bookController');

const router = express.Router();

router.get('/', bookController.getAll);
router.get('/:id', bookController.getById);
router.post('/', bookController.save);
router.delete('/:id', bookController.deleteById);
router.put('/:id', bookController.updateById);

module.exports = router;