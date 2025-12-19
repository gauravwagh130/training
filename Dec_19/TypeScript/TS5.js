"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Employ_1 = require("./Employ");
var employs = [
    new Employ_1.Employ(1, "Gaurav", 100000),
    new Employ_1.Employ(2, "Ram", 99999),
    new Employ_1.Employ(3, "Akay", 95885),
];
employs.forEach(function (x) {
    console.log("Employ no: " + x.empno + " Employ name: " + x.name + " salary: " + x.salary);
});
