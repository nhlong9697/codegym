
function calculateAverage() {
  let physicsScore = parseFloat(document.getElementById("physics").value)
  let chemistryScore = parseFloat(document.getElementById("chemistry").value)
  let biologyScore = parseFloat(document.getElementById("biology").value)
  let averageScore = (physicsScore + chemistryScore + biologyScore) / 3
  document.getElementById("average").innerHTML = '<strong>Average score is: ' + averageScore + '</strong>'
}

function convertFahrenheit() {
  let celcius = parseFloat(document.getElementById("celcius").value)
  let fahrenheit = celcius / 5 * 9 + 32
  document.getElementById("fahrenheit").innerHTML = 'Converted degree is: ' + fahrenheit + ' fahrenheit'
}

function calculateMetrics() {
  let radius = parseFloat(document.getElementById("radius").value)
  let circumfence = radius * 2 * 3.14
  let area = radius * radius * 3.14
  document.getElementById("area").innerHTML = 'Area of circle is: ' + area
  document.getElementById("circumfence").innerHTML = 'Circumfence of circle is: ' + circumfence
}
