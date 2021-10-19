public class CStack {
    private int top = -1;
    private char[] elems;
    private int capacity;

    public CStack(int N) {
        capacity = N;
        elems = new char[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int length() {
        return top + 1;
    }

    public char getTop() {
        if (!isEmpty())
            return elems[top];
        else
            return '!';
    }

    public void push(char c) {
        if (!isFull())
            elems[++top] = c;
    }

    public char pop() {
        if (!isEmpty())
            return elems[top--];
        else
            return '!';
    }
}