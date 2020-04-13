function isPalindrome(string) {
  let first = 0;
  let last = string.length - 1;
  while (first < last) {
    if (string[first] !== string[last]) return false;
    first++;
    last--;
  }
  return true;
}
