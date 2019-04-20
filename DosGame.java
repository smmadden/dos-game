import java.util.*;

public class DosGame {
    public static void main(String[] args)
    {
        DosDeck deck = new DosDeck();
        DosHand centerRow = new DosHand();
        //System.out.println(deck);
        deck.shuffle();
        //System.out.println(deck);

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your player name: ");
        DosPlayer player1 = new DosPlayer(scan.next());

        centerRow.initiateHand(2, deck);
        player1.startingHand(deck);
        System.out.println();


        System.out.println(player1.getName() + ", you go first. Here is your hand: \n"+player1);
        System.out.println("Here is the center row: \n" + centerRow);
        System.out.println();

        System.out.println("Single matches: ");
        for(int i=0; i<centerRow.getSize(); i++){
            displayMatches(player1.myHand().getSingleNumberMatches(centerRow.getCard(i)));
        }

        System.out.println("Double matches: ");
        for(int i=0; i<centerRow.getSize(); i++){
            displayMatches(player1.myHand().getDoubleNumberMatches(centerRow.getCard(i)));
        }

    }

    public static void displayMatches(ArrayList m){
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

}



//ask for name of first player, then ask if there is another player then ask for that name, so on

// here are your single number matches:   1: match
//                                        2: match
//                                        etc
//  then ask for which match the user would like to play


// display matches method in this class
