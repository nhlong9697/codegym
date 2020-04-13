function exercise1(number) {
  return number ^ 2;
}

function exercise2a(radius) {
  return radius ^ (2 * 3.14);
}

function exercise2b(radius) {
  return radius * 2 * 3.14;
}

function exercise3(character) {
  return Number.isInteger(character);
}

function exercise4(a, b, c) {
  return Math.min(a, b, c);
}

function exercise6(number) {
  if (number > 0) {
    return true;
  } else {
    return false;
  }
}

function exercise7(array) {
  let temp = array[0];
  array[0] = array[1];
  array[1] = temp;
  return array;
}

function exercise8(array) {
  let first = 0;
  let last = array.length - 1;
  let temp;
  while (first < last) {
    temp = array[first];
    array[first] = array[last];
    array[last] = temp;
    first++;
    last--;
  }
  return array;
}

function exercise9(array, character) {
  for (let i = 0; i < array.length; i++) {
    if (array[i] == character) {
      return i;
    }
  }
  return -1;
}
