public class DosCard extends Card
{
	public final static int GREEN = CLUBS;
	public final static int BLUE = DIAMONDS;
	public final static int RED = HEARTS;
	public final static int YELLOW = SPADES;
	public final static int WILD_COL = 5;

	public final static int WILD_NUM = JACK;

	protected int color;
	protected String colorName;

	public DosCard(int faceValue, int colorValue)
    {
    	super(faceValue, colorValue);
        face = faceValue;
        setFaceName();

        color = colorValue;
        setColorName();
    }

    protected void setColorName()
    {
        switch (suit)
        {
            case GREEN:
                colorName = "Green";
                break;
            case BLUE:
                colorName = "Blue";
                break;
            case RED:
                colorName = "Red";
                break;
            case YELLOW:
                colorName = "Yellow";
                break;
            case WILD_COL:
            	colorName = "Wild Color";
            	break;
        }
    }

    protected void setFaceName()
    {
        switch (face)
        {
            case ONE:
            	faceName = "One";
            	break;
            case TWO:	//for the wild color card
            	faceName = "Two";
            	break;
            case THREE:
            	faceName = "Three";
            	break;
            case FOUR:
                faceName = "Four";
                break;
            case FIVE:
                faceName = "Five";
                break;
            case SIX:
                faceName = "Six";
                break;
            case SEVEN:
                faceName = "Seven";
                break;
            case EIGHT:
                faceName = "Eight";
                break;
            case NINE:
                faceName = "Nine";
                break;
            case TEN:
                faceName = "Ten";
                break;
            case WILD_NUM:
                faceName = "Wild Number";
                break;
        }
    }

    public int getColor()
    {
        return color;
    }

    public String getColorName()
    {
        return colorName;
    }

    public String toString()
    {
        return colorName + " " + faceName;
    }

}