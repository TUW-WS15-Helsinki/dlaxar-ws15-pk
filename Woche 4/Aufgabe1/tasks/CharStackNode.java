public class CharStackNode {

    private char elem;
    private CharStackNode next;

    // replace the value and next node
    public CharStackNode(char elem, CharStackNode next) {
        this.elem = elem;
        this.next = next;
    }

    // get the value
    public char getElem() {
        return elem;
    }

    // get the next node
    public CharStackNode getNext() {
        return next;
    }
}
