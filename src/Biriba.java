
public class Biriba {

    /*  *  Author:       Christoforos Seas      1028675
     *  *  Written:       27/10/2020
     *  *  Last updated:  29/10/2020
     *  *
     *  *  Compilation command:  javac -classpath .:stdlib.jar Biriba.java
     *  *  Execution command:    java Biriba
     *  *
     *  *  To sygkekrimeno programma to evala na doulevei kai me grafiko tropo (xrisimopoiwntas tin StdDraw)
     *  *  Gia ton grafiko tropo epilekste "GUI" kai meta to panw aristera xarti einai to skarto, dipla einai i anapodogyrismeni trapoula kai dipla einai to xarti pou anapodogyrisate
     *  *  Otan anapodogyrizete ena xarti, dialegete ena xarti apo tin trapoula i to anapodogyrismeno kai kanete click panw tou gia na skartaristei
     *  *  O assos (Ace) vrisketai meta ton King i prin to 2. Den mporei na yparksei Queen, King, Ace kai meta 2 (mporei na yparksei alla den kerdizei)
     *  *  Gia na leitourgisei to programma xreiazetai to Stdlib.jar kai kapoies eikones tis opoies sas tis esteila mesw email. Apothikefste tis ston fakelo me to Biriba.class  */

    public static String skarto = ""; //to skarto xarti
    public static int skarto_index = 0;//poio index twn xartiwn tou tha skartarei
    public static boolean trapoula = false;//an tha fanerwsei to extra xarti (to skarto i tis trapoulas pou tha dialeksei)
    public static String xame = "";//to xarti pou pianei o paixtis (apo tin trapoula i apo ta skarta)

    public static void I_want_the_card_gui(String[] paixtis, boolean want_skarto, String[] deck, int count) {
        trapoula = true; //gia na emfanistei to anapodogyrismeno xarti
        if (want_skarto) //an theloume to skarto tote anapodogyrizoume to skarto
            xame = skarto;
        else //alliws pairnoume xarti apo tin trapoula
            xame = deck[count];

        print_again(paixtis); //ektypwnetai ksana i trapoula mas ananewmeni me to xarti pou pirame
    }

    public static boolean choose(int a, int b, int c, int d)// meta3y a kai b x kai c kai d y
    {
        //an epileksoume anamesa se aftes tis syntetagmenes
        return StdDraw.mouseX() > a && StdDraw.mouseX() < b && StdDraw.mouseY() > c && StdDraw.mouseY() < d;
    }

    public static String picture(String card)// pairnei tin karta kai vriskei tin eikona
    {
        String eikona = "800px-Playing_card_";

        switch (PlayingBiriba.getSuit(card).charAt(0)) {
            case 'C' -> eikona += "club_";
            case 'D' -> eikona += "diamond_";
            case 'H' -> eikona += "heart_";
            case 'S' -> eikona += "spade_";
            case 'J' -> {
                eikona = "1204e1f1b0833cdee4bf1403a01f96b6.png";
                return eikona;
            }
        }

        switch (find_number(PlayingBiriba.getRank(card))) {
            case 1 -> eikona += "A.svg.png";
            case 2 -> eikona += "2.svg.png";
            case 3 -> eikona += "3.svg.png";
            case 4 -> eikona += "4.svg.png";
            case 5 -> eikona += "5.svg.png";
            case 6 -> eikona += "6.svg.png";
            case 7 -> eikona += "7.svg.png";
            case 8 -> eikona += "8.svg.png";
            case 9 -> eikona += "9.svg.png";
            case 10 -> eikona += "10.svg.png";
            case 11 -> eikona += "J.svg.png";
            case 12 -> eikona += "Q.svg.png";
            case 13 -> eikona += "K.svg.png";
        }

        return eikona;
    }

    public static int find_number(String num) { //vriskei ton arithmo tis kartas (gia grafiko tropo mono)
        return switch (num.charAt(0)) {
            case 'A' -> 1;
            case 'J' -> 11;
            case 'Q' -> 12;
            case 'K' -> 13;
            default -> Integer.parseInt(num);
        };
    }

    public static void print_again(String[] arr)
    { //ektypwnetai i trapoula kai ta ypoloipa xartia
        int x = 0, y = -14;
        StdDraw.clear();//katharizei i eikona
        StdDraw.picture(-15, 14, picture(skarto), 8, 11); //ektypwnetai to skarto panw aristera
        StdDraw.picture(-6, 14, "740bdfde43a6acc7dd91ae8818ad4f7d.jpg", 9, 12); //ektypwnetai i anapodogyrismeni trapoula dipla

        if (trapoula) //an pirame xarti tote typwnetai dipla apo tin anapodogyrismeni trapoula
            StdDraw.picture(3, 14, picture(xame), 8, 11);


        for (int i = 0; i < 5; i++)  //to kathe xarti ektypwnetai to ena dipla apo to allo
        {
            StdDraw.picture(-16 + x, y, picture(arr[i + 5]), 8, 11);
            x += 8;
        }
        x = 0;
        y = -2;
        for (int i = 5; i < 10; i++) {
            StdDraw.picture(-16 + x, y, picture(arr[i - 5]), 8, 11);
            x += 8;
        }
        trapoula = false; //den yparxei ston epomeno gyro anapodogyrismeno xarti

    }

    public static String do_you_want_card() //synartisi i opoia elegxei to nai kai to oxi an einai egkyra
    {
        String choice;
        do {
            choice = StdIn.readString();

            if (!(choice.equals("Y") || choice.equals("y") || choice.equals("N") || choice.equals("n")))
                StdOut.println("Invalid choice");

        } while (!(choice.equals("Y") || choice.equals("y") || choice.equals("N") || choice.equals("n")));

        return choice;
    }

    public static void I_want_the_card(String[] paixtis) //synartisi i opoia elegxei an einai egkyro to xarti pou theloume na antikatastisoume
    {
        int replace_index;
        StdOut.println("Which from your cards are you replacing it with?");
        do {
            StdOut.println("Write the number in the queue that you want to replace");
            String testnum = StdIn.readString();

            if (valid_num(testnum)) {
                replace_index = Integer.parseInt(testnum);
                if (!valid_replace(paixtis, replace_index))
                    StdOut.println("Invalid choice");
            } else {
                replace_index = -1;
            }

        } while (!valid_replace(paixtis, replace_index));

    }

    public static char findbigger(int a, int b, int c, int d) //synartisi i opoia vriskei ton megalytero arithmo metaksy tessarwn kai analoga epistrefei ton xaraktira tou Suit
    {
        int max1 = Math.max(a, b), max2 = Math.max(c, d);
        max1 = Math.max(max1, max2);

        if (max1 == a)
            return 'C';
        if (max1 == b)
            return 'S';
        if (max1 == c)
            return 'H';
        return 'D';
    }

    public static boolean calculate_best_choice(String[] com) //synartisi i opoia ypologizei tin kalyteri apofasi pou prepei na parei to computer
    {
        int Clubs = 0, Spades = 0, Hearts = 0, Diamonds = 0;
        char maxsuit;

        if (PlayingBiriba.getSuit(skarto).equals("Joker")) // an einai joker to skarto to pianei
            return true;

        for (String xarti : com) // an exei idi to idio xarti den to xreiazetai
            if (xarti.equals(skarto))
                return false;

        // elegxw to prwto xaraktira tis fylis
        for (String xarti : com) // elegxw ti fyli exw parapanw
            switch (PlayingBiriba.getSuit(xarti).charAt(0)) {
                case 'C' -> Clubs++;
                case 'S' -> Spades++;
                case 'H' -> Hearts++;
                case 'D' -> Diamonds++;
            }

        maxsuit = findbigger(Clubs, Spades, Hearts, Diamonds); // vriskw poia fili exw parapanw egw
        // an to skarto exei tin idia fili tote to thelw, alliws
        // tha parw apo tin trapoula
        return PlayingBiriba.getSuit(skarto).charAt(0) == maxsuit;
    }

    public static boolean calculate_best_choice(int i, String[] com) //synartisi i opoia ypologizei an ena xarti einai kalytero na skartaristei
    {
        if ((PlayingBiriba.getSuit(com[i]).equals("Joker")))
            return false;

        int Clubs = 0, Spades = 0, Hearts = 0, Diamonds = 0;
        char maxsuit;

        // elegxw to prwto xaraktira tis fylis
        for (String xarti : com) // elegxw ti fyli exw parapanw
            switch (PlayingBiriba.getSuit(xarti).charAt(0)) {
                case 'C' -> Clubs++;
                case 'S' -> Spades++;
                case 'H' -> Hearts++;
                case 'D' -> Diamonds++;
            }

        maxsuit = findbigger(Clubs, Spades, Hearts, Diamonds); // vriskw poia fili exw parapanw egw
        // an to xarti den exei tin idia fili me ta parapanw
        // tote tha to diwksw
        return PlayingBiriba.getSuit(com[i]).charAt(0) != maxsuit;
    }

    public static int poio_tha_skartarei(String[] com) //synartisi pou leitourgei vasei tis calculate_best_choice gia na dialeksei poio xarti na skartare
    {
        for (int i = 0; i < com.length; i++)
            if (calculate_best_choice(i, com))
                return i;

        return 9; //an den vriskei kapoio kalytero na skartaristei skartarei to teleftaio, giati den tha einai ekei o joker afou an den vrei thesi gia ton joker ton vazei stin arxi
    }

    public static boolean computer_move(String[] deck, int count, String[] com, boolean terminal) //synartisi gia ti diadikasia tis kinisis tou ypologisti
    {
        boolean piase_skarto = calculate_best_choice(com); // pairnei true an tha parei to skarto kai false an tha parei
        // apo trapoula
        int skarto_index = poio_tha_skartarei(com);// vriskw ti thesi tou xartiou pou thelw na skartaro
        String temp;
        if (terminal) {
            if (piase_skarto) {
                StdOut.print("C >>> I am getting from the deck top the " + skarto);
                temp = com[skarto_index];
                com[skarto_index] = skarto;// an thelw to skarto tote tha tin allaksw me to skarto
                skarto = temp;
                StdOut.println(" and I am throwing onto the pile the " + skarto + "\n");
                return false;
            }

            skarto = com[skarto_index];
            StdOut.println("C >>> I am throwing the " + skarto + " from the deck top ");
            com[skarto_index] = deck[count];// alliws tha parw apo tin trapoula
            return true;
        } else {
            if (piase_skarto) {
                temp = com[skarto_index];
                com[skarto_index] = skarto;// an thelw to skarto tote tha tin allaksw me to skarto
                skarto = temp;
                return false;
            }
            skarto = com[skarto_index];
            com[skarto_index] = deck[count];// alliws tha parw apo tin trapoula
            return true;
        }

    }

    public static int find_number(String[] com, int i) { //synartisi i opoia vriskei ton arithmo kapoias kartas kai ton epistrefei
        int arithmos;

        if (PlayingBiriba.getRank(com[i]).equals("Joker"))
            return -10;

        if (i == 0 && PlayingBiriba.getRank(com[i]).equals("Ace")
                || i == 1 && PlayingBiriba.getRank(com[i]).equals("Ace")
                && PlayingBiriba.getRank(com[0]).equals("Joker")
                || i == 2 && PlayingBiriba.getRank(com[i]).equals("Ace")
                && PlayingBiriba.getRank(com[1]).equals("Joker")) // an einai Ace kai stin prwti thesi
            return 1;

        if (PlayingBiriba.getRank(com[i]).equals("Jack"))
            arithmos = 11;
        else if (PlayingBiriba.getRank(com[i]).equals("Queen"))
            arithmos = 12;
        else if (PlayingBiriba.getRank(com[i]).equals("King"))
            arithmos = 13;
        else if (PlayingBiriba.getRank(com[i]).equals("Ace"))// an aftos o arithmos einai Ace tote einai 14
        {
            if (PlayingBiriba.getRank(com[9]).equals("King"))
                arithmos = 14;
            else
                arithmos = 1;
        } else
            arithmos = Integer.parseInt(PlayingBiriba.getRank(com[i]));

        return arithmos;
    }

    public static void show_cards(String[] arr) { //synartisi i opoia ektypwnei ta xartia sto xeri tou paixti i tou computer
        int i = 1;
        for (String str : arr) {
            if (i < 10)
                StdOut.println(i + ":  " + str);
            else
                StdOut.println(i + ": " + str);
            i++;
        }
    }

    private static boolean valid_replace(String[] arr, int replace) { //synartisi i opoia elegxei an einai egkyri thesi pou antikathistas
        if (replace > 10 || replace < 1)
            return false;

        skarto_index = replace - 1;
        return true;

    }

    public static boolean other_joker(String[] arr, int i) { //synartisi i opoia elegxei an yparxei allos joker meta apo to index pou dinetai
        for (int j = i + 1; j < 10; j++)
            if (arr[j].equals("Joker"))
                return true;

        return false;
    }

    public static boolean valid_joker(String[] com) { //synartisi i opoia elegxei an o joker einai se egkyri thesi gia na kerdisei kapoios
        int arithmos1 = 0, arithmos2 = 0;

        for (int i = 1; i < 10; i++)
            if (PlayingBiriba.getSuit(com[i]).equals("Joker"))// an vrw joker
            {
                if (i == 9)// an o joker einai stin teleftaia thesi
                    return true;
                if (PlayingBiriba.getSuit(com[i + 1]).equals("Joker")) // an einai 2 joker dipla dipla
                {
                    if (i == 8)// an einai stis teleftaies theseis
                        return true;
                    arithmos1 = find_number(com, i - 1);
                    arithmos2 = find_number(com, i + 2);

                    if (arithmos1 != arithmos2 - 3)
                        return false;
                } else {
                    arithmos1 = find_number(com, i - 1);
                    arithmos2 = find_number(com, i + 1);

                    if (i == 1 && arithmos1 == 1 && arithmos2 != 2) //an einai sti defteri thesi kai stin prwti exei ace kai meta den exei 2 tote einai swstos
                        return true;

                    if (arithmos1 != arithmos2 - 2)//an den einai endiamesa 2 arithmwn me diafora 2
                        return false;
                }
            }

        return true;

    }

    public static boolean valid_num(String num) { //elegxei an to input einai arithmos kai den edwse grammata
        for (int i = 0; i < num.length(); i++)
            if (!(Character.isDigit(num.charAt(i)))) {
                StdOut.println("Invalid Input");
                return false;
            }

        return true;
    }

    public static boolean checkwin(String[] com) { //synartisi i opoia elegxei an kapoios kerdise
        String fyli = "";
        int arithmos = 0, proigoumenos_arithmos = 0;

        if (!(PlayingBiriba.getSuit(com[0]).equals("Joker")))
            fyli = PlayingBiriba.getSuit(com[0]);

        else if (!(PlayingBiriba.getSuit(com[1]).equals("Joker")))
            fyli = PlayingBiriba.getSuit(com[1]);

        else
            fyli = PlayingBiriba.getSuit(com[2]);

        if (!valid_joker(com)) {
            return false;
        }

        for (int i = 1; i < 10; i++) {

            proigoumenos_arithmos = find_number(com, i - 1);

            if (proigoumenos_arithmos == 14) // den mporei o proigoumenos arithmos na einai Ace sto telos
                proigoumenos_arithmos = 1;

            arithmos = find_number(com, i);


            if (!(PlayingBiriba.getSuit(com[i]).equals("Joker") || PlayingBiriba.getSuit(com[i]).equals(fyli)))// an
            // estw
            // kai
            // ena
            // exei
            // diaforetiki
            // fyli
            // apo
            // allo
            // simainei
            // den
            // nikises
            {
                return false;
            }
            if (i == 1 && proigoumenos_arithmos == 1 && find_number(com, 9) == 13) { }//an yparxei ace stin prwti thesi kai stin teleftaia king
            else

            if (arithmos != proigoumenos_arithmos + 1 && arithmos != -10 && proigoumenos_arithmos != -10) //an dyo arithmoi extos joker den exoun diafora 1 tote den kerdizeis
                return false;

        }

        return true;

    }

    public static void sort(String[] com) { //synartisi i opoia taksinomei ta xartia kapoiou paixti vasei tou arithmou tous
        int joker_numbers = 1; //posous joker topothetisame an yparxei parapanw apo enas

        for (int i = 1; i < 10; i++) {
            int current = find_number(com, i);
            String temp = com[i];
            int j = i - 1;
            while (j >= 0 && current < find_number(com, j)) {
                com[j + 1] = com[j];
                j--;
            }
            com[j + 1] = temp;
        }

        // an exei joker
        if (find_number(com, 0) == -10 && find_number(com, 1) != -10) //an den exei 2 joker
        {
            for (int i = 2; i < 10; i++) {
                int current = find_number(com, i);
                int j = i - 1;
                if (current == find_number(com, j) + 2) {
                    for (j = 0; j < i - 1; j++)
                        com[j] = com[j + 1];
                    com[j] = "Joker";
                    break;
                }
            }
            if (find_number(com, 0) == -10 && find_number(com, 1) == 1) //an akoma o Joker einai stin prwti thesi kai dipla exei ace tote ta kanei swap
            {
                String temp = com[0];
                com[0] = com[1];
                com[1] = temp;
            }
        }
        else if (find_number(com, 0) == -10) //an exei 2 joker
            for (int i = 2; i < 10; i++) {
                int current = find_number(com, i);
                int j = i - 1;
                if (current == find_number(com, j) + 2 && joker_numbers < 3) {
                    for (j = 0; j < i - 1; j++)
                        com[j] = com[j + 1];
                    com[j] = "Joker";
                    joker_numbers++;
                }
            }
    }

    public static void main(String[] args) {
        StdDraw.setXscale(-20, 20);
        StdDraw.setYscale(-20, 20);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.1);
        boolean valid = false, terminal = false;
        boolean complays = false;
        boolean win = false;

        StdDraw.text(0, 18, "Έκανα το πρόγραμμα και με γραφικό τρόπο,");
        StdDraw.text(0, 16, "αν θέλετε να χρησιμοποιήσετε τον CLI τρόπο όμως επιλέξτε CLI,");
        StdDraw.text(0, 14, "αλλιώς GUI");

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(-5, 5, 4);
        StdDraw.filledSquare(5, 5, 4);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-5, 5, "CLI");
        StdDraw.text(5, 5, "GUI");

        while (!valid) { //gia to gui i to cli
            if (StdDraw.isMousePressed())
                if (StdDraw.mouseX() > 1 && StdDraw.mouseX() < 9 && StdDraw.mouseY() > 1 && StdDraw.mouseY() < 9) {
                    valid = true;
                    StdDraw.clear();
                } else if (StdDraw.mouseX() < -1 && StdDraw.mouseX() > -9 && StdDraw.mouseY() > 1
                        && StdDraw.mouseY() < 9) {
                    StdDraw.text(-5, -1, "Συνεχίστε από το terminal");
                    terminal = true;
                    valid = true;
                }
        }

        String[] deck = PlayingBiriba.generateDoubleDeck();// dimiourgeitai to deck
        String[] paixtis = new String[10];// o paixtis kai to computer pairnoun ta xartia tous
        String[] com = new String[10];
        PlayingBiriba.shuffleDeck(deck);// anakatevetai
        int count = 0;

        for (count = 0; count < 10; count++)
            paixtis[count] = deck[count];

        for (int i = 0; i < 10; i++) {
            com[i] = deck[count];
            count++;
        }

        skarto = deck[count];
        count++;

        if (terminal) { //an epilextei to cli
            if (Math.random() < 0.5)// gia to poios tha paiksei prwtos
            {
                complays = true;
                StdOut.println(">>>> THE GAME BEGINS - THE COMPUTER PLAYS FIRST <<<< ");
            } else {
                StdOut.println(">>>> THE GAME BEGINS - YOU PLAY FIRST <<<< ");
            }

            String choice = " ";
            while (!win) { //oso den exei kerdisei kapoios
                if (complays) {
                    sort(com); //taksinomeitai
                    if (computer_move(deck, count, com, terminal)) // kanei tin kinisi tou to computer kai an tha parei
                        // apo tin
                        // trapoula allazei to index
                        count++;

                    sort(com); //ksanatakseinomeitai gia na elegxtei an kerdise

                    win = checkwin(com);

                    if (win) { //an kerdisei to computer emfanizetai ti krata sto xeri tou
                        show_cards(com);
                        StdOut.println("YOU LOST!");
                        return;
                    }

                    complays = false;

                    StdOut.println(">>>> YOU PLAY NOW <<<< \n>>> Your cards are: ");

                } else { //an paizie o paixtis
                    sort(paixtis); //taksinomountai ta xartia tou
                    show_cards(paixtis); //parousiazontai ta xartia tou

                    StdOut.println("\nJust reminding you that the card on the top of the pile is " + skarto);
                    StdOut.print("\nDo you want this card? (Y/N)");

                    choice = do_you_want_card(); //rwta an thelei to xarti pou einai sta skarta

                    if (choice.equals("Y") || choice.equals("y")) { //an ton thelei kanei ti diadikasia
                        I_want_the_card(paixtis);

                        String temp = skarto;// allazei to skarto me afto pou exei
                        skarto = paixtis[skarto_index];
                        paixtis[skarto_index] = temp;
                    }

                    else {
                        StdOut.println(">>> OK, so do you want the " + deck[count] + " from the deck (Y/N)? "); //rwta an thelei na skartarei afto pou pire i oxi
                        choice = do_you_want_card();

                        if (choice.equals("Y") || choice.equals("y")) {
                            I_want_the_card(paixtis);

                            paixtis[skarto_index] = deck[count];
                        } else
                            skarto = deck[count];

                        count++;
                    }
                    sort(paixtis); //taksinomountai ta xartia gia na eleg3ei an kerdise

                    win = checkwin(paixtis);

                    if (win) {
                        StdOut.println("YOU WIN!");
                        return;
                    }

                    complays = true;
                }
            }
        }

        else { //an dialextei to gui
            boolean[] position = new boolean[10];
            int x1, x2, y2 = 0;
            long startTime = 0; //gia na min patietai kati 2 fores yparxei ena mikro delay

            if (Math.random() < 0.5)// gia to poios tha paiksei prwtos
            {
                complays = true;
                startTime = System.currentTimeMillis();
                StdDraw.text(0, 15, ">>>> THE GAME BEGINS - THE COMPUTER PLAYS FIRST <<<< ");
                while (System.currentTimeMillis() - startTime < 2000) {
                }
                StdDraw.clear();
            } else {
                startTime = System.currentTimeMillis();
                StdDraw.text(0, 15, ">>>> THE GAME BEGINS - YOU PLAY FIRST <<<< ");
                while (System.currentTimeMillis() - startTime < 2000) {
                }
                StdDraw.clear();
            }

            int y1 = 0;
            while (!win) {
                if (complays) {
                    sort(com);
                    if (computer_move(deck, count, com, terminal)) // kanei tin kinisi tou to computer kai an tha parei
                        // apo tin
                        // trapoula allazei to index
                        count++;

                    sort(com);

                    win = checkwin(com);

                    if (win) {
                        print_again(com);
                        StdDraw.text(-14, 6, "YOU LOST!");
                        return;
                    }

                    complays = false;

                    // print_again(paixtis);

                } else { //ginetai i idia diadikasia me to cli
                    sort(paixtis);
                    print_again(paixtis);
                    valid = false;
                    boolean chose_skarto = false;

                    while (!valid) {
                        if (StdDraw.isMousePressed())
                            if (StdDraw.mouseX() > -20 && StdDraw.mouseX() < -12 && StdDraw.mouseY() > 10
                                    && StdDraw.mouseY() < 20) {//an dialeksei apo ta skarta
                                valid = true;
                                chose_skarto = true;
                                I_want_the_card_gui(paixtis, chose_skarto, deck, count);
                            } else if (StdDraw.mouseX() > -11 && StdDraw.mouseX() < -2 && StdDraw.mouseY() > 10
                                    && StdDraw.mouseY() < 20) {//an dialeksei apo tin trapoula
                                I_want_the_card_gui(paixtis, chose_skarto, deck, count);
                                count++;
                                valid = true;
                            }
                    }

                    startTime = System.currentTimeMillis();
                    while (System.currentTimeMillis() - startTime < 100) {
                    } //perimenei ligo

                    chose_skarto = false;
                    valid = false;

                    for (int i = 0; i < 10; i++)
                        position[i] = false;

                    while (!valid) {
                        if (StdDraw.isMousePressed()) { //dialegei poio tha allaksei

                            if (choose(0, 10, 10, 20)) {
                                skarto = xame;
                                valid = true;
                            } else
                                for (int i = 0; i < 5; i++) {
                                    x1 = -20 + i * 8;
                                    x2 = x1 + 8;
                                    y1 = -7;
                                    y2 = 4;
                                    position[i] = choose(x1, x2, y1, y2);
                                    if (position[i]) {
                                        // skarto_index = i;
                                        String temp = paixtis[i];
                                        paixtis[i] = xame;
                                        skarto = temp;
                                        valid = true;
                                    }

                                }

                            for (int i = 5; i < 10; i++) {
                                x1 = -20 + (i - 5) * 8;
                                x2 = x1 + 8;
                                y1 = -19;
                                y2 = -8;

                                position[i] = choose(x1, x2, y1, y2);
                                if (position[i]) {
                                    // skarto_index = i;
                                    String temp = paixtis[i];
                                    paixtis[i] = xame;
                                    skarto = temp;
                                    valid = true;
                                }
                            }
                        }
                    }

                    startTime = System.currentTimeMillis();
                    while (System.currentTimeMillis() - startTime < 100) {
                    }//perimenei ligo

                    sort(paixtis); //taksinomountai ta xartia

                    win = checkwin(paixtis);

                    if (win) {
                        sort(paixtis);
                        print_again(paixtis);
                        StdDraw.text(-14, 6, "YOU WIN!");
                        return;
                    }

                    complays = true;
                }
            }
        }

    }

}
