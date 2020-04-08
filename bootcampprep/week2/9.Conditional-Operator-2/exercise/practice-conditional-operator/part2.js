function exercise1(celcius) {
  let fahrenheit = (celcius * 9) / 5 + 32;
  alert(fahrenheit);
}

function exercise2(meter) {
  let feet = meter * 3.2808;
  alert(feet);
}

function exercise3(side) {
  let squareArea = side ^ 2;
  alert(squareArea);
}

function exercise4(height, width) {
  let rectangleArea = height * width;
  alert(rectangleArea);
}

function exercise5(leg1, leg2) {
  let rightTriangleArea = (leg1 * leg2) / 2;
  alert(rightTriangleArea);
}

function exercise6(a, b) {
  let roots = -b / a;
  if (a == 0) {
    if (b == 0) {
      alert("multiple roots");
    } else {
      alert("no roots");
    }
  } else {
    alert("roots of equation is " + roots);
  }
}

function exercise7(a, b, c) {
  let delta = b ^ (2 - 4 * a * c);
  let x1;
  let x2;
  if ((a = 0)) {
    alert("this is not quadratic equation");
  } else {
    if (delta < 0) {
      alert("this equation has no root");
    } else {
      if ((delta = 0)) {
        x1 = (-b / 2) * a;
        alert("root of the equation is " + x1);
      } else {
        x1 = (-b + Math.sqrt(delta)) / (2 * a);
        x2 = (-b - Math.sqrt(delta)) / (2 * a);
        alert("roots of the equation are " + x1 + " and " + x2);
      }
    }
  }
}

function exercise8(age) {
  if ((age < 120) & (age > 0)) {
    alert("this is a real age");
  } else {
    alert("this is not a real age");
  }
}

function exercise9(a, b, c) {
  if ((a > 0) & (b > 0) & (c > 0) & (a + b > c) & (b + c > a) & (c + a > b)) {
    alert("this is a triangle");
  } else {
    alert("this is not a triangle");
  }
}

function exercise10(consumption) {
  let money;
  if (consumption <= 100) {
    money = consumption * 1000;
    alert(money);
  } else {
    if (consumption <= 150) {
      money = 100 * 1000 + (consumption - 100) * 1200;
      alert(money);
    } else {
      if (consumption <= 200) {
        money = 100 * 1000 + 50 * 1200 + (consumption - 150) * 2000;
        alert(money);
      } else {
        money = 100 * 1000 + 50 * 1200 + 50 * 2000 + (consumption - 200) * 2500;
        alert(money);
      }
    }
  }
}

function exercise11(salary) {
  let tax;
  if (salary > 15) {
    tax = salary * 0.3;
    alert(tax);
  } else if (salary >= 7) {
    tax = salary * 0.2;
    alert(tax);
  } else {
    tax = salary * 0.1;
    alert(tax);
  }
}

function exercise12(principal, interestRate, year) {
  let totalMoney;
  totalMoney = (principal * (1 + interestRate)) ^ year;
  alert(totalMoney);
}
