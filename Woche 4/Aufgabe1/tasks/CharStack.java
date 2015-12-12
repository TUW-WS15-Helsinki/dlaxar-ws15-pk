public class CharStack {

    private CharStackNode top = null;

    // push an element onto the stack
    public void push(char elem) {
        top = new CharStackNode(elem, top);
    }

    // pop an element from the stack
    public char pop() {
        CharStackNode peek = top;
        top = peek.getNext();
        return peek.getElem();
    }

    // true if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
