package PERTEMUAN7;

import java.util.Stack;

public class MainTree {
    public static void main(String[] args) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(new TreeNode('C'));
        System.out.println(stack.pop().getData());

        Tree tree = new Tree();
        String Expression = "(A+B)";
        tree.addExpressionInfix(Expression);

        System.out.println("Infix:");
        tree.infix();

        System.out.println("Prefix");
        tree.prefix();

        System.out.println("Postfix:");
        tree.postfix();
    }
}

