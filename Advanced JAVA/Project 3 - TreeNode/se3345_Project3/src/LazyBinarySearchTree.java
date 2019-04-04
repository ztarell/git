/*
Lazy Deletion Binary Search Tree by Zachary Tarell - 3/3/2019
This class keeps a binary search tree and uses lazy deletion as a method.
It outputs the deleted items with an asterick next to the node.
It also outputs the tree nodes with PreOrder (NLR) Traversal.
 */
public class LazyBinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    //Constructor
    public LazyBinarySearchTree() {
        root = null;
    }

    //Insert Method
    public boolean insert(AnyType key) {
        root = insert(key, root);
        return true;
    }

    //Delete method
    public boolean delete(AnyType key) {
        TreeNode<AnyType> t = delete(key, root);
        if (t == null) {
            return false;
        } else {
            return true;
        }
    }

    //FindMin Method
    public AnyType findMin() {
        if (isEmpty()) {
            return null;
        } else {
            return findMin(root).key;
        }
    }

    //FindMax Method
    public AnyType findMax() {
        if (isEmpty()) {
            return null;
        } else {
            return findMax(root).key;
        }
    }

    //Contains Method
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    //toString Method
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Tree is Empty";
        } else {
            return toString(root);
        }
    }

    //Height Method
    public int height() {
        return height(root);
    }

    //Size Method
    public int size() {
        return size(root);
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    //Private Insert Method
    private TreeNode<AnyType> insert(AnyType x, TreeNode<AnyType> t) {
        if (t == null) {
            return new TreeNode(x, null, null);
        }
        //compareResult is set to integer of compared items
        int compareResult = x.compareTo(t.key);

        if (compareResult < 0) {
            t.leftChild = insert(x, t.leftChild);//left subtree
        } else if (compareResult > 0) {
            t.rightChild = insert(x, t.rightChild);//right subtree
        } else
            ;  // Duplicate; do nothing
        return t;
    }

    //Private Delete method
    private TreeNode<AnyType> delete(AnyType x, TreeNode<AnyType> t) {
        if (t == null) {
            return t;   // Item not found, do nothing
        }
        //compareResult is set to integer of compared items
        int compareResult = x.compareTo(t.key);
        if (compareResult == 0) {//finds node and changes boolean to deleted = true
            t.deleted = true;
            return t;
        }
        if (compareResult < 0) {
            return delete(x, t.leftChild);
        } else if (compareResult > 0) {
            return delete(x, t.rightChild);
        }
        return t;
    }

    //Private FindMin Method
    private TreeNode<AnyType> findMin(TreeNode<AnyType> t) {
        if (t != null) {
            while (t.leftChild != null && !t.deleted) {
                t = t.leftChild;
            }
        }
        return t;
    }

    //Private FindMax Method
    private TreeNode<AnyType> findMax(TreeNode<AnyType> t) {
        if (t != null) {
            while (t.rightChild != null && !t.deleted) {
                t = t.rightChild;
            }
        }
        return t;
    }

    //Private Contains Method
    private boolean contains(AnyType x, TreeNode<AnyType> t) {
        if (t == null) {
            return false;
        }
        //compareResult is set to integer of compared items
        int compareResult = x.compareTo(t.key);

        if (compareResult < 0) {
            return contains(x, t.leftChild);
        } else if (compareResult > 0) {
            return contains(x, t.rightChild);
        } else {
            return !t.deleted;
        }
    }

    //Private Height Method
    private int height(TreeNode<AnyType> t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.leftChild), height(t.rightChild));
        }
    }

    //Private Size Method
    private int size(TreeNode<AnyType> t) {
        if (t == null) {
            return -1;
        } else {
            return 2 + Math.max(height(t.leftChild), height(t.rightChild));
        }
    }

    //Private toString Method
    private String toString(TreeNode<AnyType> root) {
        String r;
        String left = "";
        String right = "";
        if (root == null) {
            return "";
        } else {
            if (root.deleted) {
                r = "*" + root.key.toString() + " ";//Adds an asterick before deleted node
            } else {
                r = root.key.toString() + " "; // output the root node
                left = toString(root.leftChild); // Traverse the entire left subtree
                right = toString(root.rightChild); // traverse the entire right subtree
            }
            return r + left + right;
        }
    }//End toString Method

    //Private TreeNode class
    private static class TreeNode<AnyType> {
        // Constructors

        TreeNode(AnyType theElement) {
            this(theElement, null, null);
        }

        TreeNode(AnyType theElement, TreeNode<AnyType> lt, TreeNode<AnyType> rt) {
            key = theElement;
            leftChild = lt;
            rightChild = rt;
        }

        AnyType key;          // The data in the node
        TreeNode leftChild;   // Left child
        TreeNode rightChild;  // Right child
        boolean deleted = false; //Deleted boolean to check for lazy deletion
    }//End Private TreeNode class

    /**
     * The tree root.
     */
    private TreeNode<AnyType> root;
}//End of LazyBinarySearchTree class
