public class Main {
    class Node
    {
        int key;
        Node leftChild;
        Node rightChild;

        public Node(int key)
        {
            this.key = key;
            leftChild = null;
            rightChild = null;

        }
        public Node insert(Node tree,int addedValue)
        {
            if(tree == null)
                return new Node(addedValue);
            if(addedValue < tree.key)
                tree.leftChild = insert(tree.leftChild, addedValue);
            else if (addedValue > tree.key)
                tree.rightChild = insert(tree.rightChild, addedValue);
            return tree;

        }
    }
}