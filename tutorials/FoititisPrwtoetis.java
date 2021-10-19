package tutorials;

public class FoititisPrwtoetis extends FoititesClass implements Foitites{
    private String name;
    private int ID;
    private double[] grades;

    public FoititisPrwtoetis(){}

    public FoititisPrwtoetis(int ID)
    {
        this();
        this.ID = ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return ID;
    }


    @Override
    public double[] getGrades() {
        return grades;
    }
}
