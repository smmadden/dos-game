import java.util.*;

public class DosGame {
    public static void main(String[] args) {
        DosDeck deck = new DosDeck();
        DosHand centerRow = new DosHand();
        DosHand discard = new DosHand();
        boolean turn, game;
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
        player1.startingHand(deck);
        player2.startingHand(deck);
        player3.startingHand(deck);

        System.out.println();

        System.out.println(player1.getName() + ", you go first. Here is your hand: \n" + player1);
        System.out.println("Here is the center row: \n" + centerRow);
        System.out.println();
        turn = true;

        while(turn){
            System.out.println("Single matches: ");
            for (int i = 0; i < centerRow.getSize(); i++) {
                System.out.println("Center Row card #" + (i + 1) + ": ");
                displayMatches(player1.myHand().getSingleNumberMatches(centerRow.getCard(i)));
            }

            System.out.println("Double matches: ");
            for (int i = 0; i < centerRow.getSize(); i++) {
                System.out.println("Center Row card #" + (i + 1) + ": ");
                displayMatches(player1.myHand().getDoubleNumberMatches(centerRow.getCard(i)));
            }

            boolean isEmpty = true;
            for (int i = 0; i < centerRow.getSize(); i++) {
                if (!player1.myHand().getSingleNumberMatches(centerRow.getCard(i)).isEmpty()) { // if the list is not empty then there is at least one option to match
                    isEmpty = false;
                    break;
                }
                if (!player1.myHand().getDoubleNumberMatches(centerRow.getCard(i)).isEmpty()) { // if the list is not empty then there is at least one option to match
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                turn = false;
                System.out.println("You have no possible matches.");


                // go through procedure if no possible matches


            } else {
                System.out.print("Would you like to play a single or double match? (S or D): ");
                String sd = scan.next();
                System.out.println();
                while (!sd.equals("s") && !sd.equals("d") && !sd.equals("S") && !sd.equals("D")) {
                    System.out.print("Invalid input. Please enter S or D: ");
                    sd = scan.next();
                    System.out.println();
                }
                if (sd.equals("S") || sd.equals("s")) { // single match
                    // ask for which match
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
                    ArrayList<DosCard> singleMatches = player1.myHand().getSingleNumberMatches(centerRow.getCard(cc));
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
                    //remove from hand, check for bonus, add to discard, check for end of game, display center row again

                    if (checkSingleBonus(centerRow.getCard(cc), singleMatches.get(match))) {
                        player1.bonus();
                        System.out.println("The colors match, you got a bonus point!");
                    }
                    discard.addCard(singleMatches.get(match));
                    discard.addCard(centerRow.getCard(cc));
                    player1.myHand().removeCard(singleMatches.get(match));
                    centerRow.removeCard(centerRow.getCard(cc));

                    if(centerRow.getSize() <= 0){
                        turn = false;
                        System.out.println("There are no more center cards for you to match. It is now the next person's turn!");
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
                    ArrayList<ArrayList> doubleMatches = player1.myHand().getDoubleNumberMatches(centerRow.getCard(cc));
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
                    //remove from hand, check for bonus, add to discard, display center row again


                    if (checkDoubleBonus(centerRow.getCard(cc), (DosCard)doubleMatches.get(match).get(0), (DosCard)doubleMatches.get(match).get(1))) {
                        player1.bonus();
                        System.out.println("The colors match, you got a bonus point!");
                    }
                    discard.addCard((DosCard)doubleMatches.get(match).get(0));
                    discard.addCard((DosCard)doubleMatches.get(match).get(1));
                    discard.addCard(centerRow.getCard(cc));
                    player1.myHand().removeCard((DosCard)doubleMatches.get(match).get(0));
                    player1.myHand().removeCard((DosCard)doubleMatches.get(match).get(1));
                    centerRow.removeCard(centerRow.getCard(cc));

                    if(centerRow.getSize() <= 0){
                        turn = false;
                        System.out.println("There are no more center cards for you to match. It is now the next person's turn!");
                    } else {
                        System.out.println("Here is the center row now: \n" + centerRow);
                    }
                    System.out.println();

                }
            }
            // check if center row is empty, then end of turn

        }

        // ask for index of choice, then return that index of that object in the hand with indexOf(),
        // then remove that card from the hand and add both center row card and hand card to discard pile
        // after user enters choice, check for bonus points if applicable
        //System.out.println(player1.myHand().getSingleNumberMatches(centerRow.getCard(0)).contains(player1.myHand().getCard(0))); // contains() works

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
        return c.getColor() == d.getColor();
    }

    private static boolean checkDoubleBonus(DosCard c, DosCard d, DosCard s){
        return c.getColor() == d.getColor() && d.getColor() == s.getColor();
    }

    // method to check if its the end of the game

}



//ask for name of first player, then ask if there is another player then ask for that name, so on

// here are your single number matches:   1: match
//                                        2: match
//                                        etc
//  then ask for which match the user would like to play
