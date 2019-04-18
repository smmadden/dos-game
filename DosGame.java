public class DosGame {
    public static void main(String[] args)
    {
        DosDeck deck = new DosDeck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
    }

}
