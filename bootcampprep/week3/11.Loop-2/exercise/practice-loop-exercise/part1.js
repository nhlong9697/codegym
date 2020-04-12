function exercise1() {
  for (let i = 1; i <= 100; i++) {
    if (i == 99) {
      alert(i);
      alert("Finished");
    } else {
      alert(i);
    }
  }
}

function exercise2() {
  let temperature = prompt("Enter temperature");
  while (temperature > 100 || temperature < 20) {
    if (temperature > 100) {
      temperature = prompt("The temperature is too high, enter again");
    } else if (temperature < 20) {
      temperature = prompt("The temperature is too low, enter again");
    }
  }
  alert("The temperature is " + temperature);
}

function exercise3() {
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
function exercise4() {
  let firstNumber = 1;
  let secondNumber = 1;
  let fib;
  while (secondNumber % 5 != 0) {
    fib = firstNumber + secondNumber;
    firstNumber = secondNumber;
    secondNumber = fib;
  }
  alert(secondNumber);
}

function exercise5() {
  let n = prompt("Enter number of fibonacci");
  let firstNumber = 1;
  let secondNumber = 1;
  let fib;
  let sum = 2;
  let counter = 3;
  if (n == 1) {
    alert(1);
  } else {
    while (counter <= n) {
      fib = firstNumber + secondNumber;
      firstNumber = secondNumber;
      secondNumber = fib;
      counter += 1;
      sum += secondNumber;
    }
    alert(sum);
  }
}

function exercise6() {
  let i = 0;
  let counter = 0;
  let sum = 0;
  while (counter < 30) {
    i += 7;
    console.log(i);
    sum += i;
    console.log(sum);
    counter += 1;
    console.log(counter);
  }
  alert(sum);
}

function exercise7() {
  for (let i = 1; i <= 100; i++) {
    if ((i % 3 == 0) & (i % 5 != 0)) {
      console.log(i + "Fizz");
    } else if ((i % 3 != 0) & (i % 5 == 0)) {
      console.log(i + "Buzz");
    } else if ((i % 3 == 0) & (i % 5 == 0)) {
      console.log(i + "FizzBuzz");
    } else {
      console.log(i);
    }
  }
}

function exercise8() {
  let upperBound = Math.ceil(prompt("Enter upper bound"));
  let lowerBound = Math.floor(prompt("Enter lower bound"));
  let answer =
    Math.floor(Math.random() * (upperBound - lowerBound)) + lowerBound;
  let guess = prompt("Enter guess number");
  while (guess != answer) {
    if (guess > answer) {
      guess = prompt("Guess again. It's lower");
    } else if (guess < answer) {
      guess = prompt("Guess again. It's higher");
    }
  }
  alert("The answer is " + guess + ". You are correct");
}
