package PERTEMUAN7;

import java.util.Stack;

public class Tree {
    private TreeNode root;

    public Tree() {
        root = null;
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void addExpressionInfix(String x) {
        Stack<TreeNode> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        char c;
        TreeNode operatorNode, leftNode, rightNode;

        for (int i = 0; i < x.length(); i++) {
            c = x.charAt(i);

            if (c == '(') {
                operator.push(c);
            } else if (Character.isLetterOrDigit(c)) {
                operand.push(new TreeNode(c));
            } else if (c == ')') {
                while (operator.peek() != '(') {
                    rightNode = operand.pop();
                    leftNode = operand.pop();
                    operatorNode = new TreeNode(operator.pop());
                    operatorNode.leftNode = leftNode;
                    operatorNode.rightNode = rightNode;
                    operand.push(operatorNode);
                }
                operator.pop();
            } else {
                operator.push(c);
            }
        }
        root = operand.pop();
    }

    public boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
    }

    public boolean isOperator(char x) {
        return (x == '*' || x == '+' || x == '-' || x == '^' || x =='/');}

    public TreeNode getNode(int key) {
        TreeNode bantu = root;
        while (bantu != null) {
            if (key == bantu.data) {
                return bantu;
            }
            if (key < bantu.data) {
                bantu = bantu.leftNode;
                continue;
            }
            bantu = bantu.rightNode;
        }
        return null;
    }

    public TreeNode getParent(int key) {
        TreeNode bantu = root;
        TreeNode parent = null;

        while (bantu != null) {
            if (bantu.data == key) {
                return parent;
            }
            parent = bantu;
            if (bantu.data > key) {
                bantu = bantu.leftNode;
            } else {
                bantu = bantu.rightNode;
            }
        }
        return null;
    }

    public boolean remove(int key) {
        TreeNode bantu = getNode(key);
        if (bantu == null)
            return false;

        if (bantu.data == root.data) {
            if (bantu.isLeaf()) {
                root = null;
            } else if (bantu.rightNode == null) {
                root = bantu.leftNode;
            } else if (bantu.leftNode == null) {
                root = bantu.rightNode;
            } else {
                TreeNode predecessor = getPredecessor(bantu);
                TreeNode parentPredecessor = getParent(predecessor.data);
                bantu.data = predecessor.data;

                if (parentPredecessor != bantu) {
                    if (predecessor.leftNode != null) {
                        parentPredecessor.rightNode = predecessor.leftNode;
                    } else {
                        parentPredecessor.rightNode = null;
                    }
                } else {
                    bantu.leftNode = predecessor.leftNode;
                }
            }
            return true;
        }

        TreeNode parent = getParent(key);
        if (parent == null)
            return false;

        if (key < parent.data) {
            if (bantu.isLeaf()) {
                parent.leftNode = null;
            } else if (bantu.rightNode == null) {
                parent.leftNode = bantu.leftNode;
            } else if (bantu.leftNode == null) {
                parent.leftNode = bantu.rightNode;
            } else {
                TreeNode predecessor = getPredecessor(bantu);
                TreeNode parentPredecessor = getParent(predecessor.data);
                bantu.data = predecessor.data;

                if (parentPredecessor != bantu) {
                    if (predecessor.leftNode != null) {
                        parentPredecessor.rightNode = predecessor.leftNode;
                    } else {
                        parentPredecessor.rightNode = null;
                    }
                } else {
                    bantu.leftNode = predecessor.leftNode;
                }
            }
        } else {
            if (bantu.isLeaf()) {
                parent.rightNode = null;
            } else if (bantu.rightNode == null) {
                parent.rightNode = bantu.leftNode;
            } else if (bantu.leftNode == null) {
                parent.rightNode = bantu.rightNode;
            } else {
                TreeNode predecessor = getPredecessor(bantu);
                TreeNode parentPredecessor = getParent(predecessor.data);
                bantu.data = predecessor.data;

                if (parentPredecessor != bantu) {
                    if (predecessor.leftNode != null) {
                        parentPredecessor.rightNode = predecessor.leftNode;
                    } else {
                        parentPredecessor.rightNode = null;
                    }
                } else {
                    bantu.leftNode = predecessor.leftNode;
                }
            }
        }
        return true;
    }

    public TreeNode getPredecessor(TreeNode node) {
        TreeNode bantu = node.leftNode;
        while (bantu.rightNode != null) {
            bantu = bantu.rightNode;
        }
        return bantu;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preorderTraversal() {
        preorderHelper(root);
    }

    public void inorderTraversal() {
        inorderHelper(root);
    }

    public void postorderTraversal() {
        postorderHelper(root);
    }

    public void preorderHelper(TreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderHelper(node.getLeftNode());
            preorderHelper(node.getRightNode());
        }
    }

    public void inorderHelper(TreeNode node) {
        if (node != null) {
            inorderHelper(node.getLeftNode());
            System.out.print(node.getData() + " ");
            inorderHelper(node.getRightNode());
        }
    }

    public void postorderHelper(TreeNode node) {
        if (node != null) {
            postorderHelper(node.getLeftNode());
            postorderHelper(node.getRightNode());
            System.out.print(node.getData() + " ");
        }
    }

    public void prefix() {
        prefixHelper(root);
        System.out.println();
    }

    public void infix() {
        infixHelper(root);
        System.out.println();
    }

    public void postfix() {
        postfixHelper(root);
        System.out.println();
    }

    private void prefixHelper(TreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            prefixHelper(node.getLeftNode());
            prefixHelper(node.getRightNode());
        }
    }

    private void infixHelper(TreeNode node) {
        if (node != null) {
            if (!node.isLeaf()) {
                System.out.print("(");
            }
            infixHelper(node.getLeftNode());
            System.out.print(node.getData() + " ");
            infixHelper(node.getRightNode());
            if (!node.isLeaf()) {
                System.out.print(")");
            }
        }
    }

    private void postfixHelper(TreeNode node) {
        if (node != null) {
            postfixHelper(node.getLeftNode());
            postfixHelper(node.getRightNode());
            System.out.print(node.getData() + " ");
        }
    }

}
