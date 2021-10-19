package frontistiria;

import java.util.Objects;

public class DiatetagmenaZevgi<T>{
    private final T first;
    private final T second;

    public DiatetagmenaZevgi()
    {
        first = null;
        second = null;
    }

    public DiatetagmenaZevgi(T first, T second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;
        DiatetagmenaZevgi<?> other = (DiatetagmenaZevgi<?>) o;
        assert first != null;
        assert second != null;
        return first.equals(other.first) && second.equals(other.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
