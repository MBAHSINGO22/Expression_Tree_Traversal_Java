package PERTEMUAN7;

public class TreeNode {
    char data;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(char data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public boolean isLeaf() {
    return leftNode == null && rightNode == null;
    }
    
    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

}