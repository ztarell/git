/*
    Zach Tarell
    LAB7 BinarySearchTree
    Data Type Class
    11/21/2017
 */

public class BinarySearchTree_Tarell {

    private TreeNode root;

    public BinarySearchTree_Tarell() {
        root = null;
    }

    public boolean insert(FA2017LAB7_Employee_Tarell newEmployee) {
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode n = new TreeNode();
        if (n == null) //out of memory
        {
            return false;
        } else { //insert the node
            n.node = newEmployee.deepCopy(); //fill in the TreeNode's fields
            n.lc = null;
            n.rc = null;
            if (root == null) //tree is empty
            {
                root = n;
            } else {
                findNode(newEmployee.getKey(), p, c); //find the node's parent
                if (newEmployee.getKey().compareTo(p.get().node.getKey()) < 0) {
                    p.get().lc = n; //insert new node as a left child
                } else {
                    p.get().rc = n; //insert new node as a right child
                }
            }
            return true;
        }
    }//end of insert method

    public FA2017LAB7_Employee_Tarell fetch(String targetKey) {
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        found = findNode(targetKey, p, c); //locates the node
        if (found == true) {
            return c.get().node.deepCopy();
        } else {
            return null;
        }
    }//end of fetch method

    public boolean delete(String targetKey) {
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode largest;
        TreeNode nextLargest;
        found = findNode(targetKey, p, c);
        if (found == false) //node not found
        {
            return false;
        } else { //identify the case number
            if (c.get() == root) {//case 1: deleted node has no children
                if (c.get().lc == null && c.get().rc == null)//CASE 1
                {
                    root = null;
                } else if (c.get().lc == null || c.get().rc == null) {//case 2

                    if (p.get().lc == c.get()) { //deleted node is a left child
                        if (c.get().lc != null) //deleted node has a left child
                        {
                            p.get().lc = c.get().lc;
                        } else {
                            p.get().lc = c.get().rc;
                        }
                        root = null;
                    } else {                       // deleted node is a right child
                        if (c.get().lc != null) //deleted node has a right child
                        {
                            p.get().rc = c.get().lc;
                        } else {
                            p.get().rc = c.get().rc;
                        }
                    }//end case 2
                } else {    //case 3
                    nextLargest = c.get().lc;
                    largest = nextLargest.rc;
                    if (largest != null) { //left child has a right subtree
                        while (largest.rc != null) { //move down right subtree
                            nextLargest = largest;
                            largest = largest.rc;
                        }
                        c.get().node = largest.node; //overwrite deleted node
                        nextLargest.rc = largest.lc; // save the left subtree
                    } else { // left child does not have a right subtree
                        nextLargest.rc = c.get().rc; // save the right subtree
                        if (p.get().lc == c.get()) // deleted node is a left child
                        {
                            p.get().lc = nextLargest; // jump around deleted node
                        } else // deleted node is a right node
                        {
                            p.get().rc = nextLargest; // jump around deleted node
                        }
                        root = null;
                    }
                    
                }// end case 3
            }
            return true;
        }
    }// end of delete method

    public boolean update(String targetKey, FA2017LAB7_Employee_Tarell newEmployee) {
        if (delete(targetKey) == false) {
            return false;
        } else if (insert(newEmployee) == false) {
            return false;
        }
        return true;
    }// end of update method

    public void showAll() {
        if (root == null) //check for an empty tree
        {
            System.out.println("\nThe tree is empty...\n");
        } else {
            LNRoutputTraversal(root);
        }
    }//end of showAll

    public void LNRoutputTraversal(TreeNode root) {
        if (root.lc != null) {
            LNRoutputTraversal(root.lc); // Traverse the entire left subtree
        }
        System.out.println(root.node); // output the root node
        if (root.rc != null) {
            LNRoutputTraversal(root.rc); // traverse the entire right subtree
        }
    }//end of Traverse method

    public class TreeNode {

        private FA2017LAB7_Employee_Tarell node;
        private TreeNode lc;
        private TreeNode rc;

        public TreeNode() {

        }
    }//end of class TreeNode

    private boolean findNode(String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child) {
        parent.set(root);
        child.set(root);
        if (root == null) // tree is empty
        {
            return false;
        }
        while (child.get() != null) {
            if (child.get().node.compareTo(targetKey) == 0) //node found
            {
                return true;
            } else {
                parent.set(child.get());
                if (targetKey.compareTo(child.get().node.getKey()) < 0) {
                    child.set(child.get().lc);
                } else {
                    child.set(child.get().rc);
                }
            }
        }//end while
        return false;
    }//end of findNode method

    public class TreeNodeWrapper {

        TreeNode treeRef = null;

        public TreeNodeWrapper() {

        }

        public TreeNode get() {
            return treeRef;
        }

        public void set(TreeNode t) {
            treeRef = t;
        }
    }//end of TreeNodeWrapper class
}//end of class
