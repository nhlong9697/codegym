function exercise1() {
  let n = prompt("Enter number of fibonacci");
  let firstNumber = 1;
  let secondNumber = 1;
  alert(firstNumber);
  alert(secondNumber);
  let fib;
  let counter = 3;
  while (counter <= n) {
    fib = firstNumber + secondNumber;
    firstNumber = secondNumber;
    secondNumber = fib;
    counter += 1;
    alert(secondNumber);
  }
}

function exercise2() {
  let n = prompt("Enter factorial");
  let factorial = 1;
  for (let i = 1; i <= n; i++) {
    factorial *= i;
  }
  alert(factorial);
}

function exercise3() {
  let side = 5;
  for (let i = 1; i <= side; i++) {
    for (let j = 1; j <= i; j++) {
      document.write("*");
    }
    document.write("<br>");
  }
  document.write("<br>");
  for (let i = 1; i <= side; i++) {
    for (let j = 1; j <= side + 1 - i; j++) {
      document.write("*");
    }
    document.write("<br>");
  }
  document.write("<br>");
  for (let i = 1; i <= side; i++) {
    for (let k = 1; k <= side + 1 - i; k++) {
      document.write(" ");
    }
    for (let j = 1; j <= i; j++) {
      document.write("*");
    }
    document.write("<br>");
  }
  document.write("<br>");
  for (let i = 1; i <= side; i++) {
    for (let k = 1; k <= side + 1 - i; k++) {
      document.write("*");
    }
    for (let j = 1; j <= i; j++) {
      document.write(" ");
    }
    document.write("<br>");
  }
}
function exercise4() {
  let width = prompt("Enter width");
  let height = prompt("Enter height");
  for (let i = 1; i <= width; i++) {
    document.write("*");
  }
  document.write("<br>");
  for (let j = 1; j <= height - 2; j++) {
    document.write("*");
    for (let k = 1; k <= width - 2; k++) {
      document.write("*");
    }
    document.write("*");
    document.write("<br>");
  }
  for (let i = 1; i <= width; i++) {
    document.write("*");
  }
}
function exercise5() {
  let year = parseInt(prompt("How many year of deposit"));
  let rate = parseFloat(prompt("What is the rate"));
  let money = parseFloat(prompt("What is the deposit amount"));
  for (let i = 0; i < year; i++) {
    money *= 1 + rate / 100;
  }
  alert(money);
}
function exercise6() {
  let height = prompt("Height of the heart");
  for (let i = 0; i < height; i++) {
    for (let j = height - i; j > 0; j--) {
      document.write("_");
    }
    for (let k = 1; k < i * 2 + 1; k++) {
      document.write("*");
    }
    for (let j = height - i; j > 0; j--) {
      document.write("__");
    }
    for (let k = 1; k < i * 2 + 1; k++) {
      document.write("*");
    }
    document.write("<br>");
  }
  for (let i = 0; i < height * 2; i++) {
    for (let j = 0; j < i; j++) {
      document.write("_");
    }
    for (let k = height * 3.9 - (i * 2 - 1); k > 1; k--) {
      document.write("*");
    }
    document.write("<br>");
  }
}
