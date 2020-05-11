import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

  @Test
  void classifyTriangle222() {
    int a = 2;
    int b = 2;
    int c = 2;
    String expected = "equilateral triangle";
    String result = TriangleClassifier.classifyTriangle(a,b,c);
    assertEquals(expected, result);
  }

  @Test
  void testClassifyTriangle223() {
    int a = 2;
    int b = 2;
    int c = 3;
    String expected = "isosceles triangle";
    String result = TriangleClassifier.classifyTriangle(a,b,c);
    assertEquals(expected, result);
  }

  @Test
  void testClassifyTriangle345() {
    int a = 3;
    int b = 4;
    int c = 5;
    String expected = "normal triangle";
    String result = TriangleClassifier.classifyTriangle(a, b, c);
    assertEquals(expected, result);
  }

  @Test
  void testClassifyTriangle823() {
    int a = 8;
    int b = 2;
    int c = 3;
    String expected = "not a triangle";
    String result = TriangleClassifier.classifyTriangle(a, b, c);
    assertEquals(expected, result);
  }

  @Test
  void testClassifyTriangleMinus121() {
    int a = -1;
    int b = 2;
    int c = 1;
    String expected = "not a triangle";
    String result = TriangleClassifier.classifyTriangle(a,b,c);
    assertEquals(expected, result);
  }

  @Test
  void testClassifyTriangle011() {
    int a = 0;
    int b = 1;
    int c = 1;
    String expected = "not a triangle";
    String result = TriangleClassifier.classifyTriangle(a,b,c);
    assertEquals(expected,result);
  }
}