import java.util.ArrayList;

public class BinarySearchTree {
  Node root;

  private class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public BinarySearchTree() {
    this.root = null;
  }

  public Node insert(int value) {
    if (this.root == null) {
      this.root = new Node(value);
      return this.root;
    }
    Node currentNode = this.root;
    while (true) {
      if (value < currentNode.value) {
        if (currentNode.left == null) {
          currentNode.left = new Node(value);
          break;
        }
        else {
          currentNode = currentNode.left;
        }
      }
      else {
        if (currentNode.right == null) {
          currentNode.right = new Node(value);
          break;
        }
        else {
          currentNode = currentNode.right;
        }
      }
    }
    return this.root;
  }
  public ArrayList<Integer> inOrderTraversal() {
    ArrayList<Integer> result = new ArrayList<>();
    return this.inOrderTraversalHelper(this.root, result);
  }
  private ArrayList<Integer> inOrderTraversalHelper(Node node, ArrayList<Integer> inputArray) {
    if (node.left != null) {
      inOrderTraversalHelper(node.left, inputArray);
    }
    if (node != null) {
      inputArray.add(node.value);
    }
    if (node.right != null) {
      inOrderTraversalHelper(node.right, inputArray);
    }
    return inputArray;
  }

  public ArrayList<Integer> preOrderTraversal() {
    ArrayList<Integer> result = new ArrayList<>();
    return this.preOrderTraversalHelper(this.root, result);
  }

  private ArrayList<Integer> preOrderTraversalHelper(Node node, ArrayList<Integer> inputArray) {
    if (node != null) {
      inputArray.add(node.value);
    }
    if (node.left != null) {
      inOrderTraversalHelper(node.left, inputArray);
    }
    if (node.right != null) {
      inOrderTraversalHelper(node.right, inputArray);
    }
    return inputArray;
  }

  public ArrayList<Integer> postOrderTraversal() {
    ArrayList<Integer> result = new ArrayList<>();
    return this.postOrderTraversalHelper(this.root, result);
  }

  private ArrayList<Integer> postOrderTraversalHelper(Node node, ArrayList<Integer> inputArray) {
    if (node.left != null) {
      postOrderTraversalHelper(node.left, inputArray);
    }
    if (node.right != null) {
      postOrderTraversalHelper(node.right, inputArray);
    }
    if (node != null) {
      inputArray.add(node.value);
    }
    return inputArray;
  }

  public boolean contains(int value) {
    Node currentNode = this.root;
    while (currentNode != null) {
      if (value < currentNode.value) {
        currentNode = currentNode.left;
      }
      else if (value > currentNode.value) {
        currentNode = currentNode.right;
      }
      else {
        return true;
      }
    }
    return false;
  }
}
