import java.util.*;

public class DosGame {
    public static void main(String[] args)
    {
        DosDeck deck = new DosDeck();
        DosHand centerRow = new DosHand();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your player name: ");
        DosPlayer player1 = new DosPlayer(scan.next());
//        boolean yn = true;
//        while(yn){
//            System.out.print("\nWould you like to add another player? (y/n): ");
//            String ans = scan.next();
//            if(ans.equals("n") || ans.equals("N")){
//                yn = false;
//            }
//            System.out.println();
//            System.out.print("Enter your player name: ");
//            DosPlayer player1 = new DosPlayer(scan.next());
//        }

        centerRow.initiateHand(2, deck);
        player1.startingHand(deck);



        System.out.println(player1.getName() + ", you go first. Here is your hand: \n"+player1);
        System.out.println("Here is the center row: \n" + centerRow);

    }

}

//ask for name of first player, then ask if there is another player then ask for that name, so on
