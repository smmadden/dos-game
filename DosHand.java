import java.util.*;

public class DosHand extends DosDeck
{
    private ArrayList<DosCard> hand;

    public DosHand()
    {
    	hand = new ArrayList<DosCard>();
    }

    public void pullCard(DosCard d){
        //draws a card (adds to the hand) from deck
        hand.add(d);
    }

    public void initiateHand(int num, DosDeck d){
    while(num>0){
        this.pullCard(d.deal());
        num--;
    }
    }


    public void removeCard(DosCard c){     // do I want this to return a boolean or void? remove() returns a boolean
        //gets rid of a card
        hand.remove(c);
    }

    public ArrayList getSingleNumberMatches(Card c){
        ArrayList<DosCard> matches = new ArrayList<>();
        //returns matches (number matches)
        return matches;
    }
    public ArrayList getDoubleNumberMatches(Card c){
        ArrayList<DosCard> matches = new ArrayList<>();
        return matches;
        //returns (sum matches)
    }

    public String toString(){
        String result = "";
        for(int i=0; i<hand.size(); i++)
        {
            result+="["+hand.get(i)+"] \t";
        }
        return result;
    }

}