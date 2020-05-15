public class TestBinarySearchTree {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(10);
    tree.insert(5);
    tree.insert(40);
    tree.insert(1);
    tree.insert(7);
    tree.insert(50);
    System.out.println(tree.contains(10));
    System.out.println(tree.contains(100));
    System.out.println(tree.inOrderTraversal());
    System.out.println(tree.postOrderTraversal());
    System.out.println(tree.preOrderTraversal());
  }
}
