const express = require('express');

const bookRouter = require('./routes/bookRouter');
const app = express();

app.use(express.json());

app.use('/books', bookRouter);

const first = (req, res, next) => {console.log(2); next("route");}
const second = (req, res, next) => {console.log(3); next()}
app.use('/test', (req,res,next) => {
    console.log('1');
    next("route")
}, first, second)

app.use('/kk',(req,res,next) => {
    console.log('1 ji');
   
})


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