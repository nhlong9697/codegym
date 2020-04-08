function result() {
  let month = parseInt(document.getElementById("month").value);
  switch (month) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
      document.getElementById("result").innerHTML =
        "Month " + month + " has 31 days";
      break;
    case 4:
    case 6:
    case 9:
    case 11:
      document.getElementById("result").innerHTML =
        "Month " + month + " has 30 days";
      break;
    case 2:
      document.getElementById("result").innerHTML =
        "Month " + month + " has 28 or 29 days";
      break;
    default:
      document.getElementById("result").value = "This month does not exist";
  }
}
