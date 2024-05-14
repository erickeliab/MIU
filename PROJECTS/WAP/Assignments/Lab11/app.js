const express = require('express');
const app = express();
const fs = require("fs");
const path = require("path");
const PORT = process.env.PORT || 3000;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use('/resources', express.static(path.join(__dirname, 'resources')));


const router = express.Router();

router.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'resources', 'users.html'));
});

router.get('/create', (req, res) => {
    res.sendFile(path.join(__dirname, 'resources', 'userform.html'));
});

router.post('/', (req, res) => {
    console.log(req.body);
  const { username, email } = req.body;

  if (!username || !email) {
    return res.status(400).send('Username and email are required');
  }

  res.redirect('/users');
});

const router2 = express.Router();

router2.get('/', (req, res) => {
   res.sendFile(path.join(__dirname, 'resources', 'products.html'));
});

router2.get('/create', (req, res) => {
    res.sendFile(path.join(__dirname, 'resources', 'productform.html'));
});

router2.post('/', (req, res) => {
  const { pname, supplier } = req.body;

  if (!pname || !supplier) {
    return res.status(400).send('Name and supplier are required');
  }

  res.redirect('/products');
});

app.use('/users', router);
app.use('/products', router2);

app.get('/', (req, res, next) => {
  res.sendFile(path.join(__dirname, 'resources', 'index.html'));
});



app.use((req, res, next) => {
  res.status(404).sendFile(path.join(__dirname, 'resources', '404notfound.html'));
});

app.use((err, req, res, next) => {
  console.log(err);
  res.status(500).sendFile(path.join(__dirname, 'resources', '404notfound.html'));
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
