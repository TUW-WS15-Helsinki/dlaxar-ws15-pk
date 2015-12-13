class StringTree {

    private class Node {

        String elem;
        Node left = null;
        Node right = null;

        Node(String elem) {
            this.elem = elem;
        }

        void add(String elem) {
            if(elem.compareTo(this.elem) > 0) {
                if(this.right == null) {
                    this.right = new Node(elem);
                } else {
                    this.right.add(elem);
                }
            } else {
                if(this.left == null) {
                    this.left = new Node(elem);
                } else {
                    this.left.add(elem);
                }
            }
        }

        int height() {
            if(left == null && right == null) {
                return 1;
            }

            return Math.max(
                    (left == null ? 0 : left.height()),
                    (right == null ? 0 : right.height())
            ) + 1;
        }

        @SuppressWarnings("Duplicates")
        void printLeaves() {
            if(isLeaf()) {
                System.out.println(this.elem);
            } else {
                if(left != null) {
                    left.printLeaves();
                }
                if(right != null) {
                    right.printLeaves();
                }
            }
        }

        void printInOrderUp() {
            if(left != null) {
                left.printInOrderUp();
            }
            System.out.println(this.elem);
            if(right != null) {
                right.printInOrderUp();
            }
        }

        void printInOrderUpSub(String elem) {
            if(elem.equals(this.elem)) {
                this.printInOrderUp();
            } else {
                if(elem.compareTo(this.elem) < 0) {
                    left.printInOrderUpSub(elem);
                } else {
                    right.printInOrderUpSub(elem);
                }
            }
        }

        void printPostOrder() {
            if(left != null) {
                left.printPostOrder();
            }
            if(right != null) {
                right.printPostOrder();
            }
            System.out.println(this.elem);
        }

        void printPreOrder() {
            System.out.println(this.elem);
            if(left != null) {
                left.printPreOrder();
            }
            if(right != null) {
                right.printPreOrder();
            }
        }

        void printLevelOrder(int level) {
            if(level == 0) {
                System.out.print(this.elem + " ");
            } else {
                if(left != null) {
                    left.printLevelOrder(level-1);
                }
                if(right != null) {
                    right.printLevelOrder(level-1);
                }
            }
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    private Node root = null;

    public void add(String elem) {
        if(root == null) {
            root = new Node(elem);
        } else {
            root.add(elem);
        }
    }

    public boolean empty() {
        return this.root == null;
    }

    public int height() {
        if(root == null) {
            return 0;
        }
        return root.height();
    }

    public void printLeaves() {
        if(root == null) {
            return;
        }
        root.printLeaves();
    }

    public void printInOrderUpSub(String elem) {
        if(root == null) {
            return;
        }
        root.printInOrderUpSub(elem);
    }

    public void printPostOrder(){
        if(root == null) {
            return;
        }
        root.printPostOrder();
    }

    public void printPreOrder(){
        if(root == null) {
            return;
        }
        root.printPreOrder();
    }

    public void printLevelOrder(){
        if(root == null) {
            return;
        }
        for(int i = 0; i < height(); i++) {
            root.printLevelOrder(i);
            System.out.println();
        }
    }
}
