"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Person = void 0;
var Person = /** @class */ (function () {
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }
    Person.prototype.show = function () {
        return "Hello  ".concat(this.name, " and Age is ").concat(this.age, " Years old...");
    };
    return Person;
}());
exports.Person = Person;
