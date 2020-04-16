function bubbleSort(array) {
  let isSorted = false;
  let counter = 0;
  while (!isSorted) {
    isSorted = true;
    for (let i = 0; i < array.length - counter - 1; i++) {
      if (array[i] > array[i + 1]) {
        swap(i, i + 1, array);
        isSorted = false;
      }
    }
    counter++;
  }
  return array;
}
function swap(i, j, array) {
  let temp = array[i];
  array[i] = array[j];
  array[j] = temp;
}

function binarySearch(array, number) {
  let begin = 0;
  let end = array.length - 1;
  while (begin <= end) {
    let middle = Math.floor((begin + end) / 2);
    if (array[middle] == number) {
      return middle;
    } else if (array[middle] < number) {
      begin = middle;
    } else {
      end = middle;
    }
  }
  return false;
}
