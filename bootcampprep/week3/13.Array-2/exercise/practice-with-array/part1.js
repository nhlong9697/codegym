function exercise1() {
  let array = new Array(10);
  let count = 0;
  for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 100);
  }
  for (let i = 0; i < array.length; i++) {
    if (array[i] > 10) {
      console.log(array[i]);
      count += 1;
      console.log(count);
    }
  }
}
function exercise2() {
  let array = new Array(10);
  for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 100);
  }
  let max = array[0];
  for (let i = 0; i < array.length; i++) {
    if (max < array[i]) {
      max = array[i];
    }
  }
  console.log(max);
  console.log(i);
}

function exercise3() {
  let array = new Array(10);
  for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 100);
  }
  let max = array[0];
  let sum = 0;
  for (let i = 0; i < array.length; i++) {
    sum += array[i];
    if (max < array[i]) {
      max = array[i];
    }
  }
  console.log(max);
  console.log(i);
  console.log(sum);
}

function exercise4() {
  let array = new Array(10);
  for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 100);
  }
  let max = array[0];
  for (let i = 0; i < array.length; i++) {
    if (max < array[i]) {
      max = array[i];
    }
  }
  console.log(max);
  console.log(i);
}
function exercise5() {
  let array = new Array(10);
  for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 100);
  }
  for (let i = 0; i < array.length / 2; i++) {
    let temp = array[i];
    array[i] = array[array.length - i];
    array[array.length - i] = temp;
  }
}

function exercise6() {
  let array = new Array(10);
  for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 100);
  }
  let input = prompt("enter an integer");
  let result = arr.some((x) => x == input);
  if (result) {
    alert(input + "in the array");
  } else {
    alert(input + "not in the array");
  }
}
function exercise7() {
  let array = new Array(10);
  for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 100);
  }
  let input = prompt("enter an integer");
  let inArray = arr.some((x) => x == input);
  if (inArray) {
    let index = arr.indexOf(Number(input));
    arr.splice(index, 1);
    alert(input + "in the array");
  } else {
    alert(input + "not in the array");
  }
}
