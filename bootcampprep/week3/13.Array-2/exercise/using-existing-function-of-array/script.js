function exercise1() {
  let myColor = ["Red", "Green", "White", "Black"];
  console.log(myColor.toString());
}

function exercise2() {
  let num = window.prompt();
  let str = num.toString();
  let result = [str[0]];
  for (let x = 1; x < str.length; x++) {
    if (str[x - 1] % 2 === 0 && str[x] % 2 === 0) {
      result.push("-", str[x]);
    } else {
      result.push(str[x]);
    }
  }
  console.log(result.join(""));
}

function exercise3() {
  let str = "c";
  let UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  let LOWER = "abcdefghijklmnopqrstuvwxyz";
  let result = [];

  for (let x = 0; x < str.length; x++) {
    if (UPPER.indexOf(str[x]) !== -1) {
      result.push(str[x].toLowerCase());
    } else if (LOWER.indexOf(str[x]) !== -1) {
      result.push(str[x].toUpperCase());
    } else {
      result.push(str[x]);
    }
  }
  console.log(result.join(""));
}
