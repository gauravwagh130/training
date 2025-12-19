import { User } from "./User";

let user = new User();

const show = (user: User): void => {
  console.log(`Hello... ${user.userName ?? "Guest"}`);

  if (user.userName === undefined) {
    user.utype = "Anonymous User...";
  } else {
    user.utype = "Authorized User...";
  }

  console.log(user.utype);
};

show(user);
