import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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

        boolean isLeaf() {
            return left == null && right == null;
        }

        // -- AdHoc starts here

        public int elemSum() {
            int sum = this.elem;
            if(left != null) {
                sum += left.elemSum();
            }
            if(right != null) {
                sum += right.elemSum();
            }
            return sum;
        }

        public int weightedSum(int i) {
            int sum = this.elem * i;
            if(left != null) {
                sum += left.weightedSum(i + 1);
            }
            if(right != null) {
                sum += right.weightedSum(i + 1);
            }
            return sum;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Node) || obj == null) {
                return false;
            }

            return this.elem == ((Node) obj).elem
                    && ((this.left == null && ((Node) obj).left == null) || this.left.equals(((Node) obj).left))
                    && ((this.right == null && ((Node) obj).right == null) || this.right.equals(((Node) obj).right));
        }

        public Set<Integer> getSet() {
            Set<Integer> x = new TreeSet<Integer>();
            x.add(this.elem);
            if(this.left != null) {
                x.addAll(this.left.getSet());
            }
            if(this.right != null) {
                x.addAll(this.right.getSet());
            }
            return x;
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

    // -- AdHoc starts here

    public int elemSum() {
        if(root == null) {
            return 0;
        }

        return root.elemSum();
    }

    public int weightedSum() {
        if(root == null) {
            return 0;
        }

        return root.weightedSum(1);
    }

    @Override
    public int hashCode() {
        return elemSum() + weightedSum() + height();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  IntTree)) {
            return false;
        }

        if(((IntTree) obj).height() != this.height()) {
            return false;
        }

        if(weightedSum() != ((IntTree) obj).weightedSum()) {
            return false;
        }

        return this.root.equals(((IntTree) obj).root);
    }

    public Set<Integer> getSet() {
        if(null == root) {
            return null;
        }

        return root.getSet();
    }

    public IntTree copyBalance() {
        if(root == null) {
            return null;
        }

        Set<Integer> s = getSet();
        Integer[] x = (Integer[]) s.toArray(new Integer[0]);
        Arrays.sort(x);

        System.out.println(x.length);

        System.out.println(s.size());
        IntTree n = new IntTree();

        addFromTo(n, x, 0, x.length);

        System.out.println(n.height());
        System.out.println(n.countNodes());
        return null;
    }

    /**
     * This function gets a sorted array and inserts into the tree merge-sorty-like
     * to achieve perfect balance
     *
     * @param n The tree
     * @param a Array
     * @param from is inclusive
     * @param to is exclusive
     */
    private static void addFromTo(IntTree n, Integer[] a, int from, int to) {
        if(from < 0 || to > a.length || from > to) {
            return;
        }
        int index = (from+to)/2;

        if(index == to) {
            return;
        }
        n.add(a[index]);


        if(from+1 == to || from == to) {
            return;
        }

        // left
        addFromTo(n, a, from, index);
        // right
        addFromTo(n, a, index + 1, to);
    }
}