public class TriangleClassifier {
  public static String classifyTriangle(int a, int b, int c) {
    if (!isATriangle(a,b,c)) {
      return "not a triangle";
    }
    else {
      if (isIsoscelesTriangle(a,b,c)) {
        if (isEquilateralTriangle(a,b,c))
          return "equilateral triangle";
        return "isosceles triangle";
      }
      else {
        return "normal triangle";
      }
    }
  }
  public static Boolean isATriangle(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || b + c <= a || c + a <= b)
      return false;
    return true;
  }
  public static Boolean isEquilateralTriangle(int a, int b, int c) {
    if (a == b & b == c)
      return true;
    else
      return false;
  }
  public static Boolean isIsoscelesTriangle(int a, int b, int c) {
    if (a == b || b == c || c == a)
      return true;
    return false;
  }
}
