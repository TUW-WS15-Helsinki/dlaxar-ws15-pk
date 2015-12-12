class CharList {

    private class ListNode {
        char elem;
        ListNode next = null;
        ListNode prev = null;

        ListNode(char elem, ListNode next, ListNode prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

        int getElem() {
            return this.elem;
        }
        ListNode getNext() {
            return this.next;
        }
        ListNode getPrev() {
            return this.prev;
        }

        void add(char elem) {
            if(next != null && next.getElem() <= elem) {
                next.add(elem);
            } else {
                ListNode nn = new ListNode(elem, this.getNext(), this);
                if(this.getNext() != null) {
                    this.getNext().prev = nn;
                }
                this.next = nn;
            }
        }

        public String toString() {
            return this.elem + ((this.next == null) ? "-|" : "->" + this.next);
        }

    }

    private ListNode head = null;

    public boolean empty() {
        return this.head == null;
    }

    public void add(char elem) {
        if(head == null) {
            head = new ListNode(elem, null, null);
        } else {
            head.add(elem);
        }
    }

    public boolean search(char value) {
        ListNode pointer = head;
        while(pointer != null) {
            if(pointer.getElem() == value) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    public boolean insert(char value) {
        if(head == null) {
            add(value);
        }

        ListNode current = head;
        while(current.next != null && current.next.getElem() <= value) {
            current = current.next;
        }

        ListNode nn = new ListNode(value, current.next, current);
        if(current.getNext() != null) {
            current.getNext().prev = nn;
        }

        // is head
        if(current.getPrev() == null) {
            head = nn;
            nn.prev = null;
            nn.next = current;
        } else {
            current.next = nn;
        }

        return false;
    }

    public boolean remove(char value) {
        ListNode current = head;
        while(current != null) {
            if(current.getElem() == value) {
                if(current.getNext() != null) {
                    current.getNext().prev = current.prev;
                }

                if(current.getPrev() != null){
                    current.getPrev().next = current.getNext();
                }

                if(current == head) {
                    head = current.getNext();
                }

                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public String toString() {
        return "[" + this.head + "]";
    }
}
