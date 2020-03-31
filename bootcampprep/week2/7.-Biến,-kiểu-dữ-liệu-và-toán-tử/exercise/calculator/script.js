function calculate() {
  let firstNumber = parseFloat(document.getElementById('firstNumber').value)
  let secondNumber = parseFloat(document.getElementById('secondNumber').value) 
  let operation = event.srcElement.id
  let result;
  if (operation == 'addition') {
    result = firstNumber + secondNumber
  } 
  else if (operation == 'subtraction') {
    result = firstNumber - secondNumber
  }
  else if (operation == 'multiplication') {
    result = firstNumber * secondNumber
  }
  else {
    result = firstNumber / secondNumber
  }
  displayResult(result)
}
function displayResult(result) {
  document.getElementById('result').innerHTML = 'The result is ' + result
}