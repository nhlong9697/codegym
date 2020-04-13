function alertMessage() {
  alert("Xin chao");
}

function increaseValue(number) {
  return number + 1;
}

function largerOrSum(firstNumber, secondNumber) {
  if (firstNumber > secondNumber) {
    alert(firstNumber + " is larger than " + secondNumber);
  } else {
    alert(firstNumber + secondNumber);
  }
}

function addNumbers() {
  firstNum = 4;
  secondNum = 8;
  result = firstNum + secondNum;
  return result;
}

result = 0;
result = addNumbers();

function stars(star) {
  let stars = ["Polaris", "Deneb", "Vega", "Altair", "Dubhe", "Regulus"];
  let constellation = "Ursa Minor,Tarurus,Cygnus,Lyra,Aquila,Ursa Major";
  let listOfConstellation = constellation.split(",");
  for (let i = 0; i < stars.length; i++) {
    if (stars[i] == star) {
      return listOfConstellation[i];
    }
  }
  return false;
}

