package Lab20;

import java.util.ArrayList;
import java.util.Collection;

public class GenericStackArrayList<T> extends ArrayList {

    public GenericStackArrayList() {}

    public GenericStackArrayList(int initialCapacity)
    {
        super(initialCapacity);
    }

    public GenericStackArrayList(Collection<? extends T> c)
    {
        super(c);
    }

    public boolean push(T item)
    {
        return this.add(item);
    }

    public T pop()
    {
       return (T) remove(this.size() - 1);
    }

    public static void main(String[] args) {
        GenericStackArrayList<Integer> myStack = new GenericStackArrayList<>();
        for (int i = 0; i < 13; i++)
            myStack.push((int) (Math.random() * 100));

        for (int i = 0; i < myStack.size(); i++)
            System.out.println(myStack.get(i));
    }
}
