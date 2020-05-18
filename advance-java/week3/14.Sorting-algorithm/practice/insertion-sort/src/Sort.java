public class Sort {
  static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
  static double[] list1 = {1, 2};
  static double[] list2 = {1};
  static double[] list3 = {};


  public static void selectionSort(double[] list) {
    for (int i = 0; i < list.length; i++) {
      double minNumber = list[i];
      int minNumberIndex = i;
      for (int j = i + 1; j < list.length; j++) {
        if (minNumber > list[j]) {
          minNumber = list[j];
          minNumberIndex = j;
        }
      }
      swap(list, minNumberIndex, i);
    }
  }

  public static void insertionSort(double[] list) {
    for (int i = 1; i < list.length; i++) {
      double key = list[i];
      int j = i - 1;
      while (j >= 0 && list[j] > key) {
        list[j + 1] = list[j];
        j--;
      }
      list[j+1] = key;
    }
  }

  public static void bubbleSort(double[] list) {
    for (int i = 0; i < list.length - 1; i++) {
      for (int j = 0; j < list.length - 1 - i; j++) {
        if (list[j] > list[j + 1]) {
          double temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;
        }
      }
    }
  }

  public static void swap(double[] list, int firstIndex, int secondIndex) {
    double temp = list[firstIndex];
    list[firstIndex] = list[secondIndex];
    list[secondIndex] = temp;
  }

  public static void main(String[] args) {
    insertionSort(list);
    insertionSort(list1);
    insertionSort(list2);
    insertionSort(list3);
    for (double v : list) {
      System.out.println(v + " ");
    }
    for (double v : list1) {
      System.out.println(v + " ");
    }
    for (double v : list2) {
      System.out.println(v + " ");
    }
    for (double v : list3) {
      System.out.println(v + " ");
    }
  }
}
