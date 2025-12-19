export class Animal {
  public name: string;
  public age: number;
  protected species: string;

  constructor(name: string, age: number, species: string) {
    this.name = name;
    this.age = age;
    this.species = species;
  }

  toString(): string {
    return `Name : ${this.name} Age ${this.age} species : ${this.species} `;
  }
}
