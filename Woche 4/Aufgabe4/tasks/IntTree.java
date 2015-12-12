class IntTree {

    private class Node {

        int elem;
        Node left = null;
        Node right = null;

        Node(int elem) {
            this.elem = elem;
        }

        void add(int elem) {
            if(elem > this.elem) {
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

        int countNodes() {
            return (left == null ? 0 : left.countNodes())
                    +  (right == null ? 0 : right.countNodes()) + 1;
        }

        int countLeaves() {
            if(right == null && left == null) {
                return 1;
            } else {
                return (left == null ? 0 : left.countLeaves())
                        +  (right == null ? 0 : right.countLeaves());
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
            if(isLeave()) {
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

        void printInOrderUpSub(int elem) {
            if(elem == this.elem) {
                this.printInOrderUp();
            } else {
                if(elem < this.elem) {
                    left.printInOrderUpSub(elem);
                } else {
                    right.printInOrderUpSub(elem);
                }
            }
        }

        void printInOrderDown() {
            if(right != null) {
                right.printInOrderDown();
            }
            System.out.println(this.elem);
            if(left != null) {
                left.printInOrderDown();
            }
        }

        boolean isLeave() {
            return left == null && right == null;
        }
    }

    private Node root = null;

    public void add(int elem) {
        if(root == null) {
            root = new Node(elem);
        } else {
            root.add(elem);
        }
    }

    public boolean empty() {
        return this.root == null;
    }

    public int countNodes() {
        if(root == null) {
            return 0;
        }
        return root.countNodes();
    }

    public int countLeaves() {
        if(root == null) {
            return 0;
        }
        return root.countLeaves();
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

    public void printInOrderUp() {
        if(root == null) {
            return;
        }
        root.printInOrderUp();
    }

    public void printInOrderUpSub(int elem) {
        if(root == null) {
            return;
        }
        root.printInOrderUpSub(elem);
    }

    public void printInOrderDown() {
        if(root == null) {
            return;
        }
        root.printInOrderDown();
    }
}