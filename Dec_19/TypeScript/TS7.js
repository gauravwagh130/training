"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var User_1 = require("./User");
var user = new User_1.User();
var show = function (user) {
    var _a;
    console.log("Hello... ".concat((_a = user.userName) !== null && _a !== void 0 ? _a : "Guest"));
    if (user.userName === undefined) {
        user.utype = "Anonymous User...";
    }
    else {
        user.utype = "Authorized User...";
    }
    console.log(user.utype);
};
show(user);
