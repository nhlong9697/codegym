function findMax(array) {
  let max = array[0];
  for (let i = 0; i < array.length; i++) {
    if (max < array[i]) {
      max = array[i];
    }
  }
  return max;
}

function tryRemoveFromArray(array, deleteNumber) {
  let deleteNumbers = 0;
  for (let i = 0; i < array.length; i++) {
    if (array[i] === deleteNumber) {
      deleteNumbers += 1;
      array.splice(i, 1);
      i--;
    }
  }
  if (deleteNumbers > 0) {
    return true;
  }
  return false;
}

function isFibonacci(number) {
  if (number == 0 || number == 1) {
    return true;
  } else {
    let fibonacci = 0;
    let firstNumber = 0;
    let secondNumber = 1;
    while (fibonacci <= number) {
      fibonacci = firstNumber + secondNumber;
      firstNumber = secondNumber;
      secondNumber = fibonacci;
      if (fibonacci == number) {
        return true;
      }
    }
    return false;
  }
}

function Circle(x, y, radius, color) {
  this.x = x;
  this.y = y;
  this.radius = radius;
  this.color = color;
  this.render = () => {
    let cvs = document.getElementById("canvas");
    let ctx = cvs.getContext("2d");
    ctx.beginPath();
    ctx.arc(
      this.x + this.radius,
      this.y + this.radius,
      this.radius,
      0,
      2 * Math.PI
    );
    ctx.fillStyle = this.color;
    ctx.fill();
  };
}
//test case
console.log(findMax([1, 5, 6, 8, 2, 4]));
console.log(isFibonacci(55));
console.log(isFibonacci(11));
console.log(tryRemoveFromArray([4, 5, 5, 7], 8));
console.log(tryRemoveFromArray([4, 5, 5, 7], 5));
let circle = new Circle(10, 10, 100, "#000000");
circle.render();
