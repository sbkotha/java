package algorithm;

public class Tree {
    int nodeValue;
    Tree leftNode;
    Tree rightNode;

    public Tree(int value) {
        this.nodeValue = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Tree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Tree leftNode) {
        this.leftNode = leftNode;
    }

    public Tree getRightNode() {
        return rightNode;
    }

    public void setRightNode(Tree rightNode) {
        this.rightNode = rightNode;
    }
}
