package leetcode.treeorGraph;

public class AVLTree {
    NodeTree root;

    // A utility function to get the height of the tree
    int height(NodeTree N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
//    leetcode.array.linkedlist.Node rightRotate(leetcode.array.linkedlist.Node y) {
//        leetcode.array.linkedlist.Node x = y.left;
//        leetcode.array.linkedlist.Node temp = x.right;
//
//        // Perform rotation
//        x.right = y;
//        y.left = temp;
//
//        // Update heights
//        y.height = max(height(y.left), height(y.right)) + 1;
//        x.height = max(height(x.left), height(x.right)) + 1;
//
//        // Return new root
//        return x;
//    }

    NodeTree rightRotate(NodeTree x) {
        NodeTree y = x.left;
        NodeTree temp = y.right;

        // Perform rotation
        y.right = x;
        x.left = temp;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    NodeTree leftRotate(NodeTree x) {
        NodeTree y = x.right;
        NodeTree temp = y.left;

        // Perform rotation
        y.left = x;
        x.right = temp;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(NodeTree N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    NodeTree insert(NodeTree nodeTree, int key) {

        /* 1.  Perform the normal BST insertion */
        if (nodeTree == null)
            return (new NodeTree(key));

        if (key < nodeTree.key)
            nodeTree.left = insert(nodeTree.left, key);
        else if (key > nodeTree.key)
            nodeTree.right = insert(nodeTree.right, key);
        else // Duplicate keys not allowed
            return nodeTree;

        /* 2. Update height of this ancestor node */
        nodeTree.height = 1 + max(height(nodeTree.left),
                height(nodeTree.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(nodeTree);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < nodeTree.left.key)
            return rightRotate(nodeTree);

        // Right Right Case
        if (balance < -1 && key > nodeTree.right.key)
            return leftRotate(nodeTree);

        // Left Right Case
        if (balance > 1 && key > nodeTree.left.key) {
            nodeTree.left = leftRotate(nodeTree.left);
            return rightRotate(nodeTree);
        }

        // Right Left Case
        if (balance < -1 && key < nodeTree.right.key) {
            nodeTree.right = rightRotate(nodeTree.right);
            return leftRotate(nodeTree);
        }

        /* return the (unchanged) node pointer */
        return nodeTree;
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(NodeTree nodeTree) {
        if (nodeTree != null) {
            System.out.print(nodeTree.key + " ");
            preOrder(nodeTree.left);
            preOrder(nodeTree.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }

    /*
    10
        20
            30
     */
}
