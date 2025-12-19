"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Animal = void 0;
var Animal = /** @class */ (function () {
    function Animal(name, age, species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }
    Animal.prototype.toString = function () {
        return "Name : ".concat(this.name, " Age ").concat(this.age, " species : ").concat(this.species, " ");
    };
    return Animal;
}());
exports.Animal = Animal;
