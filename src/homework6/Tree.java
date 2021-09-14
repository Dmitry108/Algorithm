package homework6;

import java.util.Stack;

public class Tree<E extends Comparable<? super E>> implements ITree<E> {
    private Node<E> root;
    private int size;
    private int maxLevel;

    public Tree(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public boolean contains(E value) {
        Edge edge = doFind(value);
        return edge.node != null;
    }

    private Edge doFind(E value) {
        Node<E> node = root;
        Node<E> parent = null;
        int level = 1;
        while (node != null) {
            if (node.value.equals(value)) {
                return new Edge(node, parent, level);
            }
            parent = node;
            node = node.isLeftChild(value) ?
                    node.leftNode : node.rightNode;
            level++;
        }
        return new Edge(null, parent, level);
    }

    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);
        Edge edge = doFind(value);
        if (edge.level > maxLevel) {
            return false;
        }
        if (edge.node != null) {
            edge.node.count++;
            return true;
        }
        Node<E> parent = edge.parent;
        if (parent == null) {
            root = node;
        } else if (parent.isLeftChild(value)) {
            parent.leftNode = node;
        } else {
            parent.rightNode = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E value) {
        Edge edge = doFind(value);
        Node<E> removedNode = edge.node;

        if (removedNode == null) return false;

        if (removedNode.isList()) {
            removeLeafNode(edge);
        } else if (removedNode.hasOnlyOneChild()) {
            removeNodeWithOneChild(edge);
        } else {
            removedNodeWithBothChildren(edge);
        }
        size--;
        return false;
    }

    private boolean removedNodeWithBothChildren(Edge edge) {
        Node<E> removedNode = edge.node;
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        } else if (edge.parent.isLeftChild(removedNode.value)) {
            edge.parent.leftNode = successor;
        } else {
            edge.parent.rightNode = successor;
        }

        System.out.println(successor.value);
        successor.leftNode = removedNode.leftNode;
        return true;
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> successor = node.rightNode;
        Node<E> parent = null;
        while (successor.leftNode != null) {
            parent = successor;
            successor = successor.leftNode;
        }
        if (parent != null) {
            parent.leftNode = successor.rightNode;
            successor.rightNode = node.rightNode;
        }
        return successor;
    }

    private boolean removeNodeWithOneChild(Edge edge) {
        Node<E> child = edge.node.leftNode != null ?
                edge.node.leftNode : edge.node.rightNode;
        if (edge.parent == null) {
            root = child;
        } else if (edge.parent.isLeftChild(edge.node.value)) {
            edge.parent.leftNode = child;
        } else {
            edge.parent.rightNode = child;
        }
        return true;
    }

    private boolean removeLeafNode(Edge edge) {
        if (edge.parent == null) {
            root = null;
        } else if (edge.parent.isLeftChild(edge.node.value)) {
            edge.parent.leftNode = null;
        } else {
            edge.parent.rightNode = null;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isBalanced(Node<E> node) {
        return (node == null) ||
                isBalanced(node.leftNode) && isBalanced(node.rightNode) &&
                        Math.abs(getDeep(node.leftNode) - getDeep(node.rightNode)) <= 1;
    }

    private int getDeep(Node<E> node) {
        return node == null ? 0
                : 1 + Math.max(getDeep(node.leftNode), getDeep(node.rightNode));
    }

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 48;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.leftNode);
                    localStack.push(tempNode.rightNode);
                    if (tempNode.leftNode != null || tempNode.rightNode != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public void traverse(TraversMode mode) {
        switch (mode) {
            case PRE_ORDER:
                preOrder(root);
                break;
            case IN_ORDER:
                inOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                new Exception();
        }
        System.out.println();
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node + " ");
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftNode);
        System.out.print(node + " ");
        inOrder(node.rightNode);
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        System.out.print(node + " ");
    }

    public class Node<E extends Comparable<? super E>> {
        private final E value;
        private Node<E> leftNode;
        private Node<E> rightNode;
        private int count;

        public Node(E value) {
            this.value = value;
            this.count = 1;
        }

        public boolean isLeftChild(E value) {
            return value.compareTo(this.value) < 0;
        }

        public boolean isList() {
            return leftNode == null && rightNode == null;
        }

        public boolean hasOnlyOneChild() {
            return leftNode != null ^ rightNode != null;
        }

        public E getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private class Edge {
        private Node<E> node;
        private Node<E> parent;
        private int level;

        public Edge(Node<E> node, Node<E> parent, int level) {
            this.node = node;
            this.parent = parent;
            this.level = level;
        }
    }
}