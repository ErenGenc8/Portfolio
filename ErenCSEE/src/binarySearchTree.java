
import java.util.Scanner;

/*Class SBBSTNode */
class SBBSTNode
{
    SBBSTNode left, right;
    int data;
    int height;

    /* Constructor */
    public SBBSTNode()
    {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }
    /* Constructor */
    public SBBSTNode(int n)
    {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}

/* Class SelfBalancingBinarySearchTree */
class SelfBalancingBinarySearchTree
{
    private SBBSTNode root;

    /* Constructor */
    public SelfBalancingBinarySearchTree()
    {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }

    /* Make the tree logically empty */
    public void clear()
    {
        root = null;
    }
    /* Function to insert data */
    public void insert(int data)
    {
        root = insert(data, root);
    }
    /* Function to get height of node */
    private int height(SBBSTNode t )
    {
        return t == null ? -1 : t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    /* Function to insert data recursively */
    private SBBSTNode insert(int x, SBBSTNode t)
    {
        if (t == null)
            t = new SBBSTNode(x);
        else if (x < t.data)
        {
            t.left = insert( x, t.left );
            if (height( t.left ) - height( t.right ) == 2)
                if (x < t.left.data)
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if (x > t.data)
        {
            t.right = insert( x, t.right );
            if (height( t.right ) - height( t.left ) == 2)
                if (x > t.right.data)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
            ;  // Duplicate; do nothing
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    /* Rotate binary tree node with left child */
    private SBBSTNode rotateWithLeftChild(SBBSTNode k2)
    {
        SBBSTNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private SBBSTNode rotateWithRightChild(SBBSTNode k1)
    {
        SBBSTNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private SBBSTNode doubleWithLeftChild(SBBSTNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private SBBSTNode doubleWithRightChild(SBBSTNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(SBBSTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }
    private boolean search(SBBSTNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.data;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(SBBSTNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(SBBSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.left);
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(SBBSTNode r)
    {
        if (r != null)
        {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }
}

 class binarySearchTree {
    /*public static void main(String[] args) {
        /* Creating object of SelfBalancingBinarySearchTree
        AvlTree_ sbbst = new AvlTree_();
        System.out.println("SelfBalancingBinarySearchTree Test\n");
        double avgTimeInsert = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                long startTime = System.nanoTime();
                sbbst.insert(sbbst.root, j);
                long endTime = System.nanoTime();
                double diff = (endTime - startTime) / 1e6;
                avgTimeInsert = avgTimeInsert + diff;
                sbbst = new AvlTree_();
            }
        }
        System.out.println("Insertion average time complexity in milliseconds" + avgTimeInsert / 10);
        double avgTimeSearch = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                sbbst.insert(sbbst.root, j);
            }
            for (int j = 0; j < 20; j++) {
                long startTime = System.nanoTime();
                sbbst.search(j);
                long endTime = System.nanoTime();
                double diff = (endTime - startTime) / 1e6;
                avgTimeSearch = avgTimeSearch + diff;
            }
            sbbst = new AvlTree_();
        }
    }*/
}
//
