public class DosPlayer extends Player
{
    private DosHand hand;
    private int bonusPoints;

    public DosPlayer(String name) {
        super(name);
        hand = new DosHand();
        bonusPoints = 0;
    }

    public void startingHand(DosDeck d){
        hand.initiateHand(7, d);
    }

    public void pullCard(DosCard d){
        hand.pullCard(d);
    }

    public void removeCard(DosCard c){
        hand.removeCard(c);
    }

    public DosHand myHand(){
        return hand;
    }

    public String getHand(){
        return hand.toString();
    }

    public String toString(){
        return super.getName() + " " + "Hand: " + hand.toString(); // add wins / losses / bonus points?
    }

}
