package Lab11;

public class MailBox {

   private Mail[] contents;
   private int index;

    public MailBox(int max)
    {
        contents = new Mail[max];
        index = 0;
    }
    public double postage()
    {
        double total =0;

        for(int i=0; i<index;i++)
            total += contents[i].postageRate();

        return total;
    }

    public int invalidMail()
    {
		int count = 0;

		for (int i = 0; i < index; i++)
			if (!contents[i].valid())
				count++;

		return count;
	}

    public void print() {
		for (int i = 0; i < index; i++)
			System.out.println(contents[i]);
	}
    public void addMail(Mail unCourrier)
    {
		if (index < contents.length)
		{
			contents[index] = unCourrier;
			index++;
		}
		else
			System.out.println("Impossible to add new mail. Boite full !");
	}
}
