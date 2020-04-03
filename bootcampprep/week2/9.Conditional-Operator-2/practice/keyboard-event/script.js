function upArrowPress() {
  let element = document.getElementById("nobita")
  element.style.top = parseInt(element.style.top) - 5 + 'px'; 
}
function downArrowPress() {
  let element = document.getElementById("nobita")
  element.style.top = parseInt(element.style.top) + 5 + 'px';
}
function leftArrowPress() {
  let element = document.getElementById("nobita")
  element.style.left = parseInt(element.style.left) - 5 + 'px';
}
function rightArrowPress() {
  let element = document.getElementById("nobita")
  element.style.left = parseInt(element.style.left) + 5 + 'px';
}
function moveSelection(evt) {
  switch (evt.keyCode) {
    case 37:
      leftArrowPress();
      break;
    case 39:
      rightArrowPress();
      break;
    case 38:
      upArrowPress();
      break;
    case 40:
      downArrowPress();
      break;
 
  }
}
function getReady() {
  window.addEventListener('keydown', moveSelection);
}

