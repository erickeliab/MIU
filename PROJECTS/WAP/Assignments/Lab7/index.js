
//Solving using the arrow function
let group1 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {

        this.students.forEach((student) => {

            console.log(this.title + ": " + student

            );

        });

    }

};



// Solving using the capturing of this

let group2 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {

        let temp = this;

        this.students.forEach(function (student) {

            console.log(temp.title + ": " + student

            );

        });

    }

};


// Solving by binding this to the callback fn

let group3 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {

        this.students.forEach(function (student) {

            console.log(this.title + ": " + student

            );

        }.bind(this));

    }

};



// Solving by Array prototype apply func the this
let group4 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {

        Array.prototype.forEach.apply(this.students, [function (student) {

            console.log(this.title + ": " + student);

        }, this]);

    }
};

group4.showList();



// Solve by direct bind of this

let group5 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {

        this.students.forEach(function (student) {

            console.log(this.title + ": " + student

            );

        }, this);

    }

};



group1.showList();
group2.showList();
group3.showList();
group4.showList();
group5.showList();




