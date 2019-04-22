import java.util.*;

public class DosGame {
    public static void main(String[] args) {
        boolean again = true;
        boolean game = true;

        DosDeck deck = new DosDeck();
        DosHand centerRow = new DosHand();
        DosHand discard = new DosHand();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first player's name: ");
        DosPlayer player1 = new DosPlayer(scan.next());

        System.out.print("Enter the second player's name: ");
        DosPlayer player2 = new DosPlayer(scan.next());

        System.out.print("Enter the second player's name: ");
        DosPlayer player3 = new DosPlayer(scan.next());

        centerRow.initiateHand(2, deck);
        for(int i=0; i<7; i++){
            player1.pullCard(deck.deal());
            player2.pullCard(deck.deal());
            player3.pullCard(deck.deal());
        }

        System.out.println();
        while(again){
            System.out.println(player1.getName() + "'s hand: " + player1.myHand());
            System.out.println(player2.getName() + "'s hand: " + player2.myHand());
            System.out.println(player3.getName() + "'s hand: " + player3.myHand());
            System.out.println();

            while(game){
                turn(player1, centerRow, discard, deck, player2, player3);
                if(checkWin(player1, deck)){

                    break;
                }
                System.out.println(""+ player1 + player2 + player3);

                turn(player2, centerRow, discard, deck, player3, player1);
                if(checkWin(player2, deck)){

                    break;
                }
                System.out.println(""+ player1 + player2 + player3);

                turn(player3, centerRow, discard, deck, player1, player2);
                if(checkWin(player3, deck)){

                    break;
                }
                System.out.println(""+ player1 + player2 + player3);
            }
            System.out.println(player1.getName() + "'s record: " + player1.getWins()+" wins and " + player1.getLosses() + " losses.");
            System.out.println(player2.getName() + "'s record: " + player2.getWins()+" wins and " + player2.getLosses() + " losses.");
            System.out.println(player3.getName() + "'s record: " + player3.getWins()+" wins and " + player3.getLosses() + " losses.");
            System.out.print("Would you like to play again? (y/n): ");
            String yn = scan.next();
            while(!yn.equals("y") && !yn.equals("n") && !yn.equals("Y") && !yn.equals("N")){
                System.out.print("Invalid input. Please re-enter y or n: ");
            }
            if(yn.equals("n") || yn.equals("N")){
                again = false;
            } else {
               System.out.println("You chose to play again!\n\nNew game:\n");
                // resets
                deck = new DosDeck();
                deck.shuffle();
                discard = new DosHand();
                centerRow = new DosHand();
                centerRow.initiateHand(2, deck);
                for(int i=0; i<7; i++){
                    player1.pullCard(deck.deal());
                    player2.pullCard(deck.deal());
                    player3.pullCard(deck.deal());
                }
            }
        }

    }

    private static void displayMatches(ArrayList m){
        if(!m.isEmpty()) {
            System.out.println("Here are the possible matches: ");
            for (int i = 0; i < m.size(); i++) {
                System.out.println((i + 1) + ": " + m.get(i));
            }
        } else {
            System.out.println("No possible matches");
        }
        System.out.println();
    }

    private static boolean checkSingleBonus(DosCard c, DosCard d){ // add wild card ones
        if(c.getColor() == d.getColor()){
            return true;
        } else if(c.getColor() == DosCard.WILD_COL || d.getColor() == DosCard.WILD_COL){
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkDoubleBonus(DosCard c, DosCard d, DosCard s){
        if(c.getColor() == d.getColor() && d.getColor() == s.getColor()){
            return true;
        } else if(c.getColor() == DosCard.WILD_COL && d.getColor() == s.getColor()){
            return true;
        } else if(d.getColor() == DosCard.WILD_COL && s.getColor() == c.getColor()){
            return true;
        } else if(s.getColor() == DosCard.WILD_COL && c.getColor() == d.getColor()){
            return true;
        } else if(c.getColor() == DosCard.WILD_COL && d.getColor() == DosCard.WILD_COL){
            return true;
        } else if(d.getColor() == DosCard.WILD_COL && s.getColor() == DosCard.WILD_COL){
            return true;
        } else if(s.getColor() == DosCard.WILD_COL && c.getColor() == DosCard.WILD_COL){
            return true;
        } else {
            return false;
        }
    }

    private static void turn(DosPlayer p, DosHand centerRow, DosHand discard, DosDeck deck, DosPlayer p1, DosPlayer p2){
        boolean turn = true;
        int z = 0;
        int n = 0;
        Scanner scan = new Scanner(System.in);
        Random gen = new Random();
        System.out.println(p.getName() + ", it's your turn!");
        System.out.println("Here is your hand: \n" + p.myHand());
        System.out.println("Here is the center row: \n" + centerRow);
        System.out.println();

        while(turn){
            System.out.println("Single matches: ");
            for (int i = 0; i < centerRow.getSize(); i++) {
                System.out.println("Center Row card #" + (i + 1) + ": ");
                displayMatches(p.myHand().getSingleNumberMatches(centerRow.getCard(i)));
            }

            System.out.println("Double matches: ");
            for (int i = 0; i < centerRow.getSize(); i++) {
                System.out.println("Center Row card #" + (i + 1) + ": ");
                displayMatches(p.myHand().getDoubleNumberMatches(centerRow.getCard(i)));
            }

            boolean isEmpty = true;
            for (int i = 0; i < centerRow.getSize(); i++) {
                if (!p.myHand().getSingleNumberMatches(centerRow.getCard(i)).isEmpty()) { // if the list is not empty then there is at least one option to match
                    isEmpty = false;
                    break;
                }
                if (!p.myHand().getDoubleNumberMatches(centerRow.getCard(i)).isEmpty()) { // if the list is not empty then there is at least one option to match
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) { // no matches (match lists are all empty)
                turn = false;
                System.out.print(p.getName() + ", you have no possible matches.");
                if(z==0){
                    System.out.print( " Press 'p' to pull from the deck. ");
                    while(!scan.next().equals("p")) {
                        System.out.println();
                        System.out.print("Incorrect input. Please press 'p' ");
                        System.out.println();
                    }
                    //add to centerRow then remove
                    int rand = gen.nextInt(p.myHand().getSize());
                    centerRow.pullCard(p.myHand().getCard(rand));
                    p.myHand().removeCard(p.myHand().getCard(rand));
                    p.myHand().pullCard(deck.deal());
                    System.out.println("Here is the center row now: \n" + centerRow);
                    System.out.println(p.getName() + ", here is your hand: \n" + p.myHand());
                    System.out.println();

                    System.out.println("Single matches: ");
                    for (int i = 0; i < centerRow.getSize(); i++) {
                        System.out.println("Center Row card #" + (i + 1) + ": ");
                        displayMatches(p.myHand().getSingleNumberMatches(centerRow.getCard(i)));
                    }

                    System.out.println("Double matches: ");
                    for (int i = 0; i < centerRow.getSize(); i++) {
                        System.out.println("Center Row card #" + (i + 1) + ": ");
                        displayMatches(p.myHand().getDoubleNumberMatches(centerRow.getCard(i)));
                    }

                    isEmpty = true;
                    for (int i = 0; i < centerRow.getSize(); i++) {
                        if (!p.myHand().getSingleNumberMatches(centerRow.getCard(i)).isEmpty()) { // if the list is not empty then there is at least one option to match
                            isEmpty = false;
                            break;
                        }
                        if (!p.myHand().getDoubleNumberMatches(centerRow.getCard(i)).isEmpty()) { // if the list is not empty then there is at least one option to match
                            isEmpty = false;
                            break;
                        }
                    }
                } else {
                    while(centerRow.getSize() < 2){
                        centerRow.pullCard(deck.deal());
                    }
                    if(n>0 && n<=p.myHand().getSize()){
                        for(int i=0; i<n; i++){
                            int rand = gen.nextInt(p.myHand().getSize());
                            centerRow.pullCard(p.myHand().getCard(rand));
                            p.myHand().removeCard(p.myHand().getCard(rand));
                        }
                    } else if(n>0){
                        for(int i=0; i<p.myHand().getSize(); i++){
                            int rand = gen.nextInt(p.myHand().getSize());
                            centerRow.pullCard(p.myHand().getCard(rand));
                            p.myHand().removeCard(p.myHand().getCard(rand));
                        }
                    }






                    System.out.println(" It is now the next person's turn!\n");
                }

            }
            if(!isEmpty){
                System.out.print("Would you like to play a single or double match? (S or D): ");
                String sd = scan.next();
                System.out.println();
                while (!sd.equals("s") && !sd.equals("d") && !sd.equals("S") && !sd.equals("D")) {
                    System.out.print("Invalid input. Please enter S or D: ");
                    sd = scan.next();
                    System.out.println();
                }
                if (sd.equals("S") || sd.equals("s")) { // single match
                    System.out.print("You chose to play a single number match. Which center row card would you like to match to? Card #: ");
                    int cc = scan.nextInt();
                    System.out.println();
                    while (cc > centerRow.getSize() || cc <= 0) {
                        System.out.print("This is an invalid center row card number. Please re-enter: ");
                        cc = scan.nextInt();
                        System.out.println();
                    }
                    cc--;
                    //single matches center row card cc
                    ArrayList<DosCard> singleMatches = p.myHand().getSingleNumberMatches(centerRow.getCard(cc));
                    System.out.print("Which match would you like to play for " + centerRow.getCard(cc) + "? Match #: ");
                    int match = scan.nextInt();
                    System.out.println();
                    while (match > singleMatches.size()) {
                        System.out.print("This is an invalid match option. Please re-enter: ");
                        match = scan.nextInt();
                        System.out.println();
                    }
                    match--;
                    System.out.println("You chose to match center row card " + centerRow.getCard(cc) + " with your " + singleMatches.get(match) + " card.");

                    if (checkSingleBonus(centerRow.getCard(cc), singleMatches.get(match))) {
                        p.bonus();
                        n++;
                        System.out.println("The colors match, you got a bonus point!");
                    }
                    discard.pullCard(singleMatches.get(match));
                    discard.pullCard(centerRow.getCard(cc));
                    p.myHand().removeCard(singleMatches.get(match));
                    centerRow.removeCard(centerRow.getCard(cc));

                    if(centerRow.getSize() <= 0){
                        turn = false;
                        System.out.println("\nThere are no more center cards for you to match. It is now the next person's turn!");
                        while(centerRow.getSize() < 2){
                            centerRow.pullCard(deck.deal());
                        }
                        if(n>0 && n<=p.myHand().getSize()){
                            for(int i=0; i<n; i++){
                                int rand = gen.nextInt(p.myHand().getSize());
                                centerRow.pullCard(p.myHand().getCard(rand));
                                p.myHand().removeCard(p.myHand().getCard(rand));
                            }
                        } else if(n>0){
                            for(int i=0; i<p.myHand().getSize(); i++){
                                int rand = gen.nextInt(p.myHand().getSize());
                                centerRow.pullCard(p.myHand().getCard(rand));
                                p.myHand().removeCard(p.myHand().getCard(rand));
                            }
                        }
                    } else if(checkWin(p, deck)){
                        System.out.println(p.getName() + ", you win!");
                        p.won();
                        p1.lost();
                        p2.lost();
                    } else {
                        System.out.println("Here is the center row now: \n" + centerRow);
                    }
                    System.out.println();


                } else { // double match
                    System.out.print("You chose to play a double number match. Which center row card would you like to match to? Card #: ");
                    int cc = scan.nextInt();
                    System.out.println();
                    while (cc > centerRow.getSize() || cc <= 0) {
                        System.out.print("This is an invalid center row card number. Please re-enter: ");
                        cc = scan.nextInt();
                        System.out.println();
                    }
                    cc--;
                    //double matches center row card cc
                    ArrayList<ArrayList> doubleMatches = p.myHand().getDoubleNumberMatches(centerRow.getCard(cc));
                    System.out.print("Which match would you like to play for " + centerRow.getCard(cc) + "? Match #: ");
                    int match = scan.nextInt();
                    System.out.println();
                    while (match > doubleMatches.size()) {
                        System.out.print("This is an invalid match option. Please re-enter: ");
                        match = scan.nextInt();
                        System.out.println();
                    }
                    match--;
                    System.out.println("You chose to match center row card " + centerRow.getCard(cc) + " with " + doubleMatches.get(match).get(0) + " and " + doubleMatches.get(match).get(1) + ".");

                    if (checkDoubleBonus(centerRow.getCard(cc), (DosCard)doubleMatches.get(match).get(0), (DosCard)doubleMatches.get(match).get(1))) {
                        p.bonus();
                        n++;
                        p1.pullCard(deck.deal());
                        p2.pullCard(deck.deal());
                        System.out.println("The colors match, you got a bonus point and the other players must draw!");
                    }
                    discard.pullCard((DosCard)doubleMatches.get(match).get(0));
                    discard.pullCard((DosCard)doubleMatches.get(match).get(1));
                    discard.pullCard(centerRow.getCard(cc));
                    p.myHand().removeCard((DosCard)doubleMatches.get(match).get(0));
                    p.myHand().removeCard((DosCard)doubleMatches.get(match).get(1));
                    centerRow.removeCard(centerRow.getCard(cc));

                    if(centerRow.getSize() <= 0){
                        turn = false;
                        System.out.println("\nThere are no more center cards for you to match. It is now the next person's turn!");
                        while(centerRow.getSize() < 2){
                            centerRow.pullCard(deck.deal());
                        }
                        if(n>0 && n<=p.myHand().getSize()){
                            for(int i=0; i<n; i++){
                                int rand = gen.nextInt(p.myHand().getSize());
                                centerRow.pullCard(p.myHand().getCard(rand));
                                p.myHand().removeCard(p.myHand().getCard(rand));
                            }
                        } else if(n>0){
                            for(int i=0; i<p.myHand().getSize(); i++){
                                int rand = gen.nextInt(p.myHand().getSize());
                                centerRow.pullCard(p.myHand().getCard(rand));
                                p.myHand().removeCard(p.myHand().getCard(rand));
                            }
                        }
                    } else if(checkWin(p, deck)){
                        System.out.println(p.getName() + ", you win!");
                        p.won();
                        p1.lost();
                        p2.lost();
                    } else {
                        System.out.println("Here is the center row now: \n" + centerRow);
                    }
                    System.out.println();

                }
                z++; // keeps track of number of matches per person per turn
            }
        }
    }

    private static boolean checkWin(DosPlayer p, DosDeck deck){
        if(deck.getSize() <= 0 || p.myHand().getSize() <= 0 || p.getBonusPoints()>=5){
            return true;
        } else {
            return false;
        }
    }

}