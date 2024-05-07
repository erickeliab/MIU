

const Student = function(firstName, lastName){

    this.firstName = firstName;
    this.lastName = lastName;
    this.grades = [];

    this.inputGrades = function(marks){

        this.grades.push({
            "Marks": marks,
            "Grade" : this.getGrade(marks)
        });

    };

    this.computeAverage = function(){

        if (this.grades.length === 0) return 0;

        let avg = this.grades.reduce((acc, curr) => acc + curr.Marks, 0) / this.grades.length;

        return {
        "Average Marks" : avg,
        "Average Grade" : this.getGrade(avg)
        }
    };

    this.getGrade = function(marks){
        switch (true) {
                   case marks >= 93:
                       return 'A';
                       break;
                   case marks >= 83:
                       return 'B';
                       break;
                   case marks >= 73:
                       return 'C';
                       break;
                   case marks >= 63:
                       return 'D';
                       break;
                   default:
                       return 'F';
             }
    }
};


const student1 = new Student('John', 'Doe');
student1.inputGrades(85);
student1.inputGrades(72);
student1.inputGrades(95);
console.log(student1.computeAverage());
