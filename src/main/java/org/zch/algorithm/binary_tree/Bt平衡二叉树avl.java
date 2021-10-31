package org.zch.algorithm.binary_tree;


import org.junit.Test;

public class Bt平衡二叉树avl {
    class Node {
        public int data;
        public int height;
        public Node left;
        public Node right;

        public Node(int data, Node left, Node right) {
            super();
            this.height = 0;
            this.data = data;
            this.left = left;
            this.right = right;
        }


        public Node(int data, int height, Node left, Node right) {
            super();
            this.data = data;
            this.height = height;
            this.left = left;
            this.right = right;
        }

        public Node(Node node) {
            if (node != null) {
                this.data = node.data;
                this.left = node.left;
                this.right = node.right;
                this.height = node.height;
            }
        }
    }

    /**
     * 平衡二叉树
     *
     * @author zch
     */
    class AVLTree {
        private int size;
        public Node root;

        public AVLTree() {
            super();
            size = 0;
            root = null;
        }

        /**
         * 二叉搜索树的插入（对比avl树）
         *
         * @param node
         * @param data
         * @return
         */
        public Node insert(Node node, int data) {
            if (node == null) {
                Node newNode = new Node(data, null, null);
                node = newNode;
            } else if (node.data > data) {
                node.left = insert(node.left, data);
            } else if (node.data < data) {
                node.right = insert(node.right, data);
            }
            return node;
        }

        public Node insertAVL(Node node, int data) {
            if (node == null) {
                Node newNode = new Node(data, 0, null, null);
                return newNode;
            }

            if (data < node.data) {
                node.left = insertAVL(node.left, data);
                if (PostOrderGetHeight(node.left) - PostOrderGetHeight(node.right) == 2) {
                    if (data < node.left.data) {//LL
                        node = singleLeftRotation(node);
                    } else if (data > node.left.data) {//LR
                        node = doubleLeftRightRotation(node);
                    }
                }

            } else if (data > node.data) {
                node.right = insertAVL(node.right, data);
                if (PostOrderGetHeight(node.left) - PostOrderGetHeight(node.right) == -2) {
                    if (data > node.right.data) {
                        node = singleRightRotation(node);
                    } else if (data < node.right.data) {
                        node = doubleRightLeftRotation(node);
                    }
                }
            }

            return node;

        }

        /**
         * LL
         *
         * @param node
         * @return
         */
        private Node singleLeftRotation(Node node) {
            Node leftNode = node.left;
            node.left = leftNode.right;
            leftNode.right = node;

            node.height = PostOrderGetHeight(node);
            leftNode.height = PostOrderGetHeight(leftNode);

            return leftNode;
        }

        private Node singleRightRotation(Node node) {
            Node rightNode = node.right;
            node.right = rightNode.left;
            rightNode.left = node;

            node.height = PostOrderGetHeight(node);
            rightNode.height = PostOrderGetHeight(rightNode);

            return rightNode;
        }

        private Node doubleLeftRightRotation(Node node) {
            node.left = singleRightRotation(node.left);
            return singleLeftRotation(node);
        }

        private Node doubleRightLeftRotation(Node node) {
            node.right = singleLeftRotation(node.right);
            return singleRightRotation(node);
        }

        /**
         * 求树的高度
         *
         * @param bt
         * @return
         */
        int PostOrderGetHeight(Node bt) {
            if (bt != null) {
                int leftHeight = PostOrderGetHeight(bt.left);
                int rightHeight = PostOrderGetHeight(bt.right);
                int maxH = leftHeight > rightHeight ? (leftHeight + 1) : (rightHeight + 1);
                return maxH;
            } else {
                return 0;
            }
        }


        public Node serarch(Node node, int data) {
            if (node == null) {
                return null;
            } else if (data < node.data) {
                return serarch(node.left, data);
            } else if (data > node.data) {
                return serarch(node.right, data);
            } else {
                System.out.println("find it!");
                return node;
            }
        }


        public Node findMax(Node node) {
            if (node == null) {
                return null;
            }
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

        public Node findMin(Node node) {
            if (node == null) {
                return null;
            }
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public void preOrderTraversal(Node node) {
            if (node != null) {
                System.out.println(node.data);
                preOrderTraversal(node.left);
                preOrderTraversal(node.right);
            }
        }

        public int getSize() {
            return size;
        }
    }

    @Test
    public void test2() {
        AVLTree avlTree = new AVLTree();
        int[] numArr = {
                11, 3, 5, 23, 9, 88, 12, 21, 44
        };

        Node root = null;
        for (int i = 0; i < numArr.length; i++) {
            root = avlTree.insertAVL(root, numArr[i]);
        }
    }
}
