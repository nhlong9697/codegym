function isPrime(number) {
  if (number == 2) {
    return true;
  } else {
    for (let i = 2; i < number - 1; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
