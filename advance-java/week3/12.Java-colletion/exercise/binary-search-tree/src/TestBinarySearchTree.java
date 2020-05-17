public class TestBinarySearchTree {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(2);
    tree.insert(5);
    tree.insert(13);
    tree.insert(22);
    tree.insert(1);
    tree.insert(14);
    tree.insert(12);
    System.out.println(tree.contains(12));
    System.out.println(tree.contains(100));
    System.out.println(tree.delete(100));
    System.out.println(tree.delete(10));
    System.out.println(tree.inOrderTraversal());
    System.out.println(tree.preOrderTraversal());
    System.out.println(tree.postOrderTraversal());
  }
}
