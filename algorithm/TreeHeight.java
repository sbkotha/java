package algorithm;

public class TreeHeight {
    public static void main(String[] args) {
        Tree n1 = new Tree(1);

        Tree n2 = new Tree(2);
        n1.setLeftNode(n2);
        Tree n3 = new Tree(3);
        n1.setRightNode(n3);

        Tree n4 = new Tree(5);
        n3.setLeftNode(n4);

        Tree n5 = new Tree(9);
        n4.setLeftNode(n5);

        int height = treeHeight(n1);
        System.out.println("Tree Height = " + height);
    }

    private static int treeHeight(Tree root) {
        if (root == null) {
            return -1;
        } else {
            int leftHeight = treeHeight(root.getLeftNode());
            int rightHeight = treeHeight(root.getRightNode());
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }
}