package algorithm;

public class NodeHeight {
    public static void main(String[] args) {
        Tree n1 = new Tree(1);

        Tree n2 = new Tree(2);
        n1.setLeftNode(n2);
        Tree n3 = new Tree(3);
        n1.setRightNode(n3);

        Tree n4 = new Tree(5);
        n3.setLeftNode(n4);

        int height = nodeHeight(n1, 5);
        System.out.println("Found at Depth = " + height);
    }

    private static int nodeHeight(Tree root, int nodeValue) {
        if (root == null) {
            return -1;
        } else if (root.getNodeValue() == nodeValue) {
            return 0;
        } else {
            int childIndex = nodeHeight(root.getLeftNode(), nodeValue);
            if (childIndex != -1) {
                return 1 + childIndex;
            }

            childIndex = nodeHeight(root.getRightNode(), nodeValue);
            if (childIndex != -1) {
                return 1 + childIndex;
            }
            return -1;
        }
    }
}

