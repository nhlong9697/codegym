import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestStudent {
  public static void main(String[] args) {
    Student student = new Student("Kien", 28, "HN");
    Student student1 = new Student("Nam", 26, "HT");
    Student student2 = new Student("Anh", 38, "HT");
    Student student3 = new Student("Tung", 38, "HT");

    List<Student> lists = new ArrayList<Student>();
    lists.add(student);
    lists.add(student1);
    lists.add(student2);
    lists.add(student3);

    Collections.sort(lists);
    //sort by name because student class extends comparable which has the method compareTo for sort
    for (Student st : lists) {
      System.out.println(st.toString());
    }

    AgeComparator ageComparator = new AgeComparator();
    Collections.sort(lists, ageComparator);
    System.out.println("Sort by age");

    for (Student st : lists) {
      System.out.println(st.toString());
    }
  }
}
