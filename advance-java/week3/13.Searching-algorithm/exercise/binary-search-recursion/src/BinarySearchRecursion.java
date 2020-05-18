public class BinarySearchRecursion {
  public static void main(String[] args) {
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 5));
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 4));
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 2));
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 1));
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 6));
  }

  public static int binarySearch(int[] array, int value) {
    return binarySearchHelper(array, value, 0, array.length - 1);
  }

  private static int binarySearchHelper(int[] array, int value, int left, int right) {
    if (left > right) {
      return -1;
    }

    int mid = (left + right) / 2;

    if (array[mid] == value) {
      return mid;
    } else if (value < array[mid]) {
      return binarySearchHelper(array, value, left, mid - 1);
    } else {
      return binarySearchHelper(array, value, mid + 1, right);
    }
  }
}
