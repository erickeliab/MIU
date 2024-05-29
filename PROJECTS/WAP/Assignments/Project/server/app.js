const express = require('express');
const cors = require('cors');
const path = require('path');
const bookRouter = require('./routes/bookRouter');
const musicRouter = require('./routes/musicRouter');
const app = express();


app.use(cors());
app.use(express.json());

// app.use('/', (req,res,next) => {
//     res.send(1);
// })
app.use('/dashboard', express.static(path.join(__dirname,'..','client')))
app.use('/css', express.static(path.join(__dirname,'resources','songs')))
app.use('/js', express.static(path.join(__dirname,'resources','songs')))


app.use('/songs', express.static(path.join(__dirname,'resources','songs')))
app.use('/books', bookRouter);
app.use('/music', musicRouter);
app.use('/songs', express.static(path.join(__dirname,'resources','songs')))


app.use((error, req, res, next) => {
    if (error.message.startsWith('No book')) {
        res.status(404).json({ success: false, message: error.message });
    } else {
        next('#');
    }

})

app.use((error, req, res, next) => {
    res.status(500).json({ success: false, message: error.message });
})

app.listen(3000, () => console.log('listen on 3000'));