function displayYes() {
  alert("<3");
}
function hideNo() {
  let oldXPosition = document.getElementById("no").style.left
  console.log(oldXPosition)
  let oldYPostion = document.getElementById("no").style.top
  console.log(oldYPostion)
  let newXPosition = Math.random() * window.innerWidth 
  let newYPosition = Math.random() * window.innerHeight 
  //make sure new position does not randomly equal old position
  while(oldXPosition === newXPosition) {
    newXPosition = Math.random() * window.innerWidth + 'px'
  }
  //make sure new position doesn't randomly equal old position
  while(oldYPostion === newYPosition) {
    newYPosition = Math.random() * window.innerHeight + 'px'
  }
  document.getElementById("no").style.left = newXPosition + 'px';
  document.getElementById("no").style.top = newYPosition + 'px';

}
