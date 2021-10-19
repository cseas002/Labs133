package Lab20;

public class GenericStack<T> {
    private T[] arr;
    private int length;
    private int index = -1;

    public GenericStack(int length)
    {
        this.length = length;
        arr = (T[]) new Object[length];
    }

    public GenericStack()
    {
        this(1);
    }


    public void push(T item)
    {
        if (index >= arr.length - 1) {
            T[] arr2 = (T[]) new Object[length *= 2];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = arr2;
        }

        arr[++index] = item;
    }

    public T pop()
    {
        if (index >= 0)
            return arr[index--];
        return null;
    }

    public T peek()
    {
        return arr[index];
    }

    public T get(int i)
    {
        if (i <= index)
        return arr[i];

        return null;
    }

    public int size()
    {
        return index + 1;
    }

    public void clear()
    {
        index = -1;
        arr = (T[]) new Object[1];
        length = 1;
    }

    public boolean contains(T item)
    {
        for (T obj : arr)
            if (obj.equals(item))
                return true;

        return false;
    }

    public static void main(String[] args) {
        GenericStack<Integer> myStack = new GenericStack<>();
        for (int i = 0; i < 13; i++)
            myStack.push((int) (Math.random() * 100));

        for (int i = 0; i < myStack.size(); i++)
            System.out.println(myStack.get(i));
    }
}
