export class Person {
  name: string;
  age: number;

  constructor(name: string, age: number) {
    this.name = name;
    this.age = age;
  }

  show(): string {
    return `Hello  ${this.name} and Age is ${this.age} Years old...`;
  }
}
