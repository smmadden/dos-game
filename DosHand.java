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

    public DosCard getCard(int i)
    {
        if(hand.size()>i) {
            return hand.get(i);
        }
        return null;
    }

    public void initiateHand(int num, DosDeck d){
    while(num>0){
        //DosCard card = new DosCard(d.deal().getFace(), d.deal().getColor());
        hand.add(d.deal());
        num--;
    }
    }

    public void removeCard(DosCard c){     // do I want this to return a boolean or void? remove() returns a boolean
        //gets rid of a card
        hand.remove(c);
    }

    public int getSize()
    {
        return hand.size();
    }

    public ArrayList getSingleNumberMatches(DosCard c){
        ArrayList<DosCard> matches = new ArrayList<>();
        for(int i=0; i<this.getSize(); i++){
            if(this.getCard(i).getFace()==c.getFace()){
                matches.add(this.getCard(i));
            } else if(this.getCard(i).getFace() == DosCard.WILD_NUM){
                matches.add(this.getCard(i));
            } else if(c.getFace() == DosCard.WILD_NUM){
                matches.add(this.getCard(i));
            }
        }
        return matches;
    }


    public ArrayList getDoubleNumberMatches(DosCard c){
        ArrayList<ArrayList> matches = new ArrayList<>();
        int i = 0;
        int z;
        while(i<this.getSize()){
            z=i;
            while(z<this.getSize()){
                if(this.getCard(i).getFace() + this.getCard(z).getFace() == c.getFace() && c.getFace()!=11){
                    ArrayList<DosCard> match = new ArrayList<>();
                    match.add(this.getCard(i));
                    match.add(this.getCard(z));
                    matches.add(match);
                } else if(c.getFace()==11 && this.getCard(i).getFace() + this.getCard(z).getFace() <= 10){
                    ArrayList<DosCard> match = new ArrayList<>();
                    match.add(this.getCard(i));
                    match.add(this.getCard(z));
                    matches.add(match);
                } else if(this.getCard(i).getFace() == 11 && this.getCard(z).getFace() < c.getFace()){
                    ArrayList<DosCard> match = new ArrayList<>();
                    match.add(this.getCard(i));
                    match.add(this.getCard(z));
                    matches.add(match);
                } else if(this.getCard(z).getFace() == 11 && this.getCard(i).getFace() < c.getFace()){
                    ArrayList<DosCard> match = new ArrayList<>();
                    match.add(this.getCard(i));
                    match.add(this.getCard(z));
                    matches.add(match);
                }
                z++;
            }
            i++;
        }
        return matches;
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