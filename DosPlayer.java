public class DosPlayer extends Player
{
    private DosHand hand;
    private int bonusPoints;

    public DosPlayer(String name) {
        super(name);
        hand = new DosHand();
        bonusPoints = 0;
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

    public void bonus()
    {
        bonusPoints++;
    }

    public int getBonusPoints(){
        return bonusPoints;
    }

    public String toString(){
        return super.getName() + " has "+ this.getBonusPoints() + " bonus points and " + hand.getSize() + " cards left in hand.\n"; // add wins / losses / bonus points?
    }

}
