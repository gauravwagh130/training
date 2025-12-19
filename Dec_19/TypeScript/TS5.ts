import { Employ } from "./Employ";

const employs = [
  new Employ(1, "Gaurav", 100000),
  new Employ(2, "Ram", 99999),
  new Employ(3, "Akay", 95885),
];
employs.forEach((x) => {
  console.log(
    "Employ no: " + x.empno + " Employ name: " + x.name + " salary: " + x.salary
  );
});
