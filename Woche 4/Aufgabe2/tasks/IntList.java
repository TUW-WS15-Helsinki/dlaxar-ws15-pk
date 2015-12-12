public class IntList {

    private class ListNode {
        int elem;
        ListNode next = null;

        int prevSum = 0;

        ListNode(int elem, ListNode next) {
            this.elem = elem;
            this.next = next;
        }

        int getElem() {
            return this.elem;
        }

        ListNode getNext() {
            return this.next;
        }

        void add(int elem) {
            if(next != null) {
                next.add(elem);
            } else {
                next = new ListNode(elem, null);
                next.prevSum = this.prevSum+this.getElem();
            }
        }

        ListNode reverseR() {
            if(next == null) {
                this.prevSum = 0;
                return this;
            }

            ListNode newHead = next.reverseR();

            this.prevSum = next.prevSum + next.getElem();
            next.next = this;
            return newHead;
        }

        public String toString() {
            return this.elem + "(" + prevSum + ")" + ((this.next == null) ? "-|" : "->" + this.next);
        }

    }

    private ListNode head = null;

    public boolean empty() {
        return this.head == null;
    }

    public void add(int elem) {
        if(head == null) {
            head = new ListNode(elem, head);
        } else {
            head.add(elem);
        }
    }

    public boolean search(int value) {
        ListNode pointer = head;
        while(pointer != null) {
            if(pointer.getElem() == value) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    public void reverseI() {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;

            // prepare for the next iteration
            head = prev = current;
            current = next;
        }

        current = head;
        int sum = 0;
        // iterate again to set the correct prevSum values
        while(current != null) {
            current.prevSum = sum;
            sum += current.getElem();
            current = current.next;
        }
    }

    public void reverseR() {
        ListNode newTail = head;
        head = head.reverseR();
        newTail.next = null;
    }

    public String toString() {
        return "[" + this.head + "]";
    }
}