package tutorials;

abstract public class VoteTutorial {

    public VoteTutorial()
    {
        System.out.println(this);
        System.out.println(getName());
    }

    protected abstract String getName();

    abstract public String toString();
}
