function exercise1(a, b) {
  if (a % b == 0) {
    alert(a + "is divisible to" + b);
  } else {
    alert(a + "is not divisible to" + b);
  }
}
exercise1(10, 2);
exercise1(5, 2);

function exercise2(age) {
  if (age < 16) {
    alert("Not qualified for 10 grade");
  } else {
    alert("qualified for 10 grade");
  }
}
exercise2(13);
exercise3(17);

function exercise3(number) {
  if (number > 0) {
    alert("number is greater than 10");
  } else {
    alert("number is smaller than 10");
  }
}
exercise3(1);
exercise3(-1);

function exercise4(a, b, c) {
  if (a > b && a > c) {
    alert(a + " is the largest");
  } else if (b > c && b > a) {
    alert(b + " is the largest");
  } else if (c > b && c > a) {
    alert(c + " is the largest");
  }
}
exercise4(1, 2, 3);

function exercise5(testScore, midTermScore, finalScore) {
  let totalScore = (testScore + midTermScore * 2 + finalScore * 3) / 6;
  alert(totalScore);
}
exercise5(6, 7, 8);

function exercise6(sales) {
  let commission;
  if (sales >= 100000000) {
    commission = sales * 0.1;
  } else if (sales >= 50000000) {
    commission = sales * 0.05;
  } else {
    commission = sales * 0.01;
  }
  alert("commsion is " + commission);
}
exercise6(100000000);
exercise6(50000000);
exercise6(10000000);

function exercise7(callTime) {
  let totalBill;
  if (callTime > 6) {
    totalBill = callTime * 80;
  } else {
    totalBill = 6 * 80 + callTime * 13.33;
  }
  alert(totalBill);
}
exercise7(6);
exercise7(10);
