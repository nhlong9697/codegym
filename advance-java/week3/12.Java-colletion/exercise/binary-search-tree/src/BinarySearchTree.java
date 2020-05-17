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
      preOrderTraversalHelper(node.left, inputArray);
    }
    if (node.right != null) {
      preOrderTraversalHelper(node.right, inputArray);
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

  public boolean delete(int value) {
    return deleteHelper(value, this.root);
  }
  private boolean deleteHelper(int value, Node inputNode) {
    Node parentNode = null;
    Node currentNode = inputNode;
    while(currentNode != null && currentNode.value != value) {
      parentNode = currentNode;
      if (value < currentNode.value) {
        currentNode = currentNode.left;
      }
      else {
        currentNode = currentNode.right;
      }
    }
    //not found
    if (currentNode == null) {
      return false;
    }
    //found
    //case 1: node has no children(leaf node)
    if (currentNode.left == null && currentNode.right == null) {
      //if not a root node
      if (currentNode != inputNode) {
        if (parentNode.left == currentNode) {
          parentNode.left = null;
        }
        else {
          parentNode.right =null;
        }
      }
      //if is a root node
      else {
        inputNode = null;
      }
      return true;
    }
    //case 2:node to be deleted has 2 children
    else if (currentNode.left != null && currentNode.right != null) {
      int minValue = getMinValue(currentNode.right);
      deleteHelper(minValue, inputNode);
      currentNode.value = minValue;
      return true;
    }
    //case 3:node to be deleted has 1 children
    else {
      Node child = (currentNode.left != null) ? currentNode.left : currentNode.right;

      if (currentNode != inputNode) {
        parentNode.left = child;
      }
      else {
        parentNode.right = child;
      }
      return true;
    }
  }
  private int getMinValue(Node currentNode) {
    int value = currentNode.value;
    while(currentNode.left != null) {
      currentNode = currentNode.left;
      value = currentNode.value;
    }
    return value;
  }
}
