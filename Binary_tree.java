package data_s;


//Node class for Binary Tree
class Node {
 int data;
 Node left, right;

 public Node(int item) {
     data = item;
     left = right = null;
 }
}

//Binary Tree class with insertion, deletion, and traversal methods
class Binary_tree {
 Node root;

 public Binary_tree() {
     root = null;
 }

 // Insert a node in the binary tree
 public void insert(int data) {
     root = insertRec(root, data);
 }

 // A recursive function to insert a new key in BST
 private Node insertRec(Node root, int data) {
     if (root == null) {
         root = new Node(data);
         return root;
     }
     if (data < root.data)
         root.left = insertRec(root.left, data);
     else if (data > root.data)
         root.right = insertRec(root.right, data);
     return root;
 }

 // Deletion of a node
 public void delete(int data) {
     root = deleteRec(root, data);
 }

 private Node deleteRec(Node root, int data) {
     if (root == null) return root;

     // Recur down the tree
     if (data < root.data)
         root.left = deleteRec(root.left, data);
     else if (data > root.data)
         root.right = deleteRec(root.right, data);

     // If the key is the same as root's key, then this is the node to be deleted
     else {
         // Node with only one child or no child
         if (root.left == null)
             return root.right;
         else if (root.right == null)
             return root.left;

         // Node with two children: Get the inorder successor (smallest in the right subtree)
         root.data = minValue(root.right);

         // Delete the inorder successor
         root.right = deleteRec(root.right, root.data);
     }

     return root;
 }

 private int minValue(Node root) {
     int minv = root.data;
     while (root.left != null) {
         minv = root.left.data;
         root = root.left;
     }
     return minv;
 }

 // In-order traversal
 public void inorder() {
     inorderRec(root);
     System.out.println();
 }

 private void inorderRec(Node root) {
     if (root != null) {
         inorderRec(root.left);
         System.out.print(root.data + " ");
         inorderRec(root.right);
     }
 }

 // Pre-order traversal
 public void preorder() {
     preorderRec(root);
     System.out.println();
 }

 private void preorderRec(Node root) {
     if (root != null) {
         System.out.print(root.data + " ");
         preorderRec(root.left);
         preorderRec(root.right);
     }
 }

 // Post-order traversal
 public void postorder() {
     postorderRec(root);
     System.out.println();
 }

 private void postorderRec(Node root) {
     if (root != null) {
         postorderRec(root.left);
         postorderRec(root.right);
         System.out.print(root.data + " ");
     }
 }

 // Main method to test the tree operations
 public static void main(String[] args) {
     Binary_tree tree = new Binary_tree();

     // Inserting nodes
     tree.insert(50);
     tree.insert(30);
     tree.insert(20);
     tree.insert(40);
     tree.insert(70);
     tree.insert(60);
     tree.insert(80);

     // Print traversals
     System.out.println("Inorder traversal:");
     tree.inorder();

     System.out.println("Preorder traversal:");
     tree.preorder();

     System.out.println("Postorder traversal:");
     tree.postorder();

     // Deleting a node
     System.out.println("\nAfter deleting 20:");
     tree.delete(20);
     System.out.println("Inorder traversal:");
     tree.inorder();

     System.out.println("\nAfter deleting 30:");
     tree.delete(30);
     System.out.println("Inorder traversal:");
     tree.inorder();

     System.out.println("\nAfter deleting 50:");
     tree.delete(50);
     System.out.println("Inorder traversal:");
     tree.inorder();
 }
}
