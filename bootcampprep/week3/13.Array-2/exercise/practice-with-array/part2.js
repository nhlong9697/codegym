function exercise1() {
  let a = [
    [1, 2, 1, 24],
    [8, 11, 9, 4],
    [7, 0, 7, 27],
    [7, 4, 28, 14],
    [3, 10, 26, 7],
  ];
  for (let i in a) {
    console.log("row" + i);
    for (let j in a[i]) {
      console.log(" " + a[i][j]);
    }
  }
}

function exercise2(array) {
  let reverse = "";
  for (let i = array.length; i > 0; i--) {
    reverse += array[i];
  }
}

function exercise3() {
  let array = [2, 3, "something"];
  let length = 0;
  for (let i in array) {
    if (typeof i == "number") {
      length += 1;
    }
  }
  return length;
}

function exercise4(string) {
  array = string.split(" ");
  return array.length;
}

function exercise5(firstString, secondString) {
  if (firstString === secondString) {
    return true;
  }
  return false;
}

function exercise6(array) {
  for (let i in array) {
    if (i === "-") {
      i = "_";
    }
  }
}
