package cseas002;

/*import cseas002.team3.hw5.Frame;
import cseas002.team3.hw5.Options;

import javax.swing.*;
import java.awt.event.ActionEvent;

 */

public class FrameAndGraphicLessGameMethodsExtraCLI {

    //IN FRAME
    /*
    private JButton playCLI;

    protected void removeButtons()
    {
        remove(play);
        // remove(playCLI);
        remove(fullscreenButton);
    }


    protected void addButtons() {
        fullscreen_button();
        play_button();
        // play_CLI_button();
    }

    private void play_CLI_button() {
        playCLI = new JButton("Play Hangman without graphics!");
        playCLI.setBounds(getWidth() * 1100 / 1920,getHeight() / 3,getWidth() / 6,getHeight() / 10);
        playCLI.addActionListener(this);
        add(playCLI);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit)
            System.exit(0);
        else if (e.getSource() == fullscreenButton) {
            fullscreen = !fullscreen;
            dispose();
            if (fullscreen)
                new Frame() { protected void removeLabels() {}};
            else
                new Frame(800, 600) { protected void removeLabels() {}};
        }
        else if (e.getSource() == play) {
            dispose();
            if (fullscreen)
                new Options();
            else
                new Options(getWidth(), getHeight());
        }
       else if (e.getSource() == playCLI)
        {
            dispose();
            int length = GraphicsLessGame.chooseLength();
            int lives = GraphicsLessGame.chooseLives();
            try {
                new GraphicsLessGame(new Hangman(new File(Hangman.filename), length).toArray(), length, lives);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        } //*/



        //IN GRAPHICLESSGAME:

    /*
    public static int chooseLength()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        while (true) {
            System.out.print("Choose your length (0 - 15, type 0 for random length): ");
            String input = scan.next();
            try {
                int length = Integer.parseInt(input);

                if (length == 0)
                    return 1 + (int) (Math.random() * 15);
                else if (length < 0 || length > 15)
                    System.out.println("Wrong input");
                else
                    return length;
            }catch(NumberFormatException e) {
                System.out.println("Input is not an int value");
            }
        }
    }

    public static int chooseLives()
    {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Choose how many lives you want to have (1 - 25): ");
            String input = scan.next();
            try {
                int lives = Integer.parseInt(input);

                if (lives < 1 || lives > 25)
                    System.out.println("Wrong input");
                else
                    return lives;
            }catch(NumberFormatException e) {
                System.out.println("Input is not an int value");
            }
        }
    }
    }//*/
}
