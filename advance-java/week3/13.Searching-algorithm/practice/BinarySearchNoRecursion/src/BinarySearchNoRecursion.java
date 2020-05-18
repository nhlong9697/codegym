public class BinarySearchNoRecursion {
  public static void main(String[] args) {

  }

  public int BinarySearch(double[] inputArray, double value) {
    int left = 0;
    int right = inputArray.length - 1;
    while(left <= right) {
      int middle = (left + right) / 2;
      if (inputArray[middle] == value) {
        return middle;
      }
      else if (value < inputArray[middle]) {
        right = middle - 1;
      }
      else {
        left = middle + 1;
      }
    }
    return -1;
  }
}
