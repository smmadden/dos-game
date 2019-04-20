import java.util.*;

public class DosDeck extends CardStack
{
    private ArrayList<DosCard> stack;

    public DosDeck()
    {
        stack = new ArrayList<DosCard>();

        // creates the 12 wild dos cards
        for(int i =0; i<12; i++){
        	DosCard c = new DosCard(2, 5);
        	stack.add(c);
        }
        
        // creates the 2 cards 1, 3, 4, and 5
        int z = 0;
        for(int i=0; i<12;i++){
        	if(z<3){
        		DosCard c = new DosCard(1, 2);
        		stack.add(c);
        		z++;
        	} else if(z<6) {
        		DosCard c = new DosCard(3, 2);
        		stack.add(c);
        		z++;
        	} else if(z<9) {
        		DosCard c = new DosCard(4, 2);
        		stack.add(c);
        		z++;
        	} else if(z<12) {
        		DosCard c = new DosCard(5, 2);
        		stack.add(c);
        		z++;
        	}
        }

        // creates the 2 cards 6-10
        z = 0;
        for(int i=0; i<10;i++){
        	if(z<2){
        		DosCard c = new DosCard(6, 2);
        		stack.add(c);
        		z++;
        	} else if(z<4) {
        		DosCard c = new DosCard(7, 2);
        		stack.add(c);
        		z++;
        	} else if(z<6) {
        		DosCard c = new DosCard(8, 2);
        		stack.add(c);
        		z++;
        	} else if(z<8) {
        		DosCard c = new DosCard(9, 2);
        		stack.add(c);
        		z++;
        	} else if(z<10) {
        		DosCard c = new DosCard(10, 2);
        		stack.add(c);
        		z++;
        	}
        }

        // creates wild number cards for 2
        for(int i=0; i<2; i++){
        	DosCard c = new DosCard(11, 2);
        	stack.add(c);
        }

        // creates the 1 cards 1, 3, 4, and 5
        z = 0;
        for(int i=0; i<12;i++){
        	if(z<3){
        		DosCard c = new DosCard(1, 1);
        		stack.add(c);
        		z++;
        	} else if(z<6) {
        		DosCard c = new DosCard(3, 1);
        		stack.add(c);
        		z++;
        	} else if(z<9) {
        		DosCard c = new DosCard(4, 1);
        		stack.add(c);
        		z++;
        	} else if(z<12) {
        		DosCard c = new DosCard(5, 1);
        		stack.add(c);
        		z++;
        	}
        }

        // creates the 1 cards 6-10
        z = 0;
        for(int i=0; i<10;i++){
        	if(z<2){
        		DosCard c = new DosCard(6, 1);
        		stack.add(c);
        		z++;
        	} else if(z<4) {
        		DosCard c = new DosCard(7, 1);
        		stack.add(c);
        		z++;
        	} else if(z<6) {
        		DosCard c = new DosCard(8, 1);
        		stack.add(c);
        		z++;
        	} else if(z<8) {
        		DosCard c = new DosCard(9, 1);
        		stack.add(c);
        		z++;
        	} else if(z<10) {
        		DosCard c = new DosCard(10, 1);
        		stack.add(c);
        		z++;
        	}
        }

        // creates wild number cards for 1
        for(int i=0; i<2; i++){
        	DosCard c = new DosCard(11, 1);
        	stack.add(c);
        }

        // creates the 3 cards 1, 3, 4, and 5
        z = 0;
        for(int i=0; i<12;i++){
        	if(z<3){
        		DosCard c = new DosCard(1, 3);
        		stack.add(c);
        		z++;
        	} else if(z<6) {
        		DosCard c = new DosCard(3, 3);
        		stack.add(c);
        		z++;
        	} else if(z<9) {
        		DosCard c = new DosCard(4, 3);
        		stack.add(c);
        		z++;
        	} else if(z<12) {
        		DosCard c = new DosCard(5, 3);
        		stack.add(c);
        		z++;
        	}
        }

        // creates the 3 cards 6-10
        z = 0;
        for(int i=0; i<10;i++){
        	if(z<2){
        		DosCard c = new DosCard(6, 3);
        		stack.add(c);
        		z++;
        	} else if(z<4) {
        		DosCard c = new DosCard(7, 3);
        		stack.add(c);
        		z++;
        	} else if(z<6) {
        		DosCard c = new DosCard(8, 3);
        		stack.add(c);
        		z++;
        	} else if(z<8) {
        		DosCard c = new DosCard(9, 3);
        		stack.add(c);
        		z++;
        	} else if(z<10) {
        		DosCard c = new DosCard(10, 3);
        		stack.add(c);
        		z++;
        	}
        }

        // creates wild number cards for 3
        for(int i=0; i<2; i++){
        	DosCard c = new DosCard(11, 3);
        	stack.add(c);
        }

        // creates the 4 cards 1, 3, 4, and 5
        z = 0;
        for(int i=0; i<12;i++){
        	if(z<3){
        		DosCard c = new DosCard(1, 4);
        		stack.add(c);
        		z++;
        	} else if(z<6) {
        		DosCard c = new DosCard(3, 4);
        		stack.add(c);
        		z++;
        	} else if(z<9) {
        		DosCard c = new DosCard(4, 4);
        		stack.add(c);
        		z++;
        	} else if(z<12) {
        		DosCard c = new DosCard(5, 4);
        		stack.add(c);
        		z++;
        	}
        }

        // creates the 4 cards 6-10
        z = 0;
        for(int i=0; i<10;i++){
        	if(z<2){
        		DosCard c = new DosCard(6, 4);
        		stack.add(c);
        		z++;
        	} else if(z<4) {
        		DosCard c = new DosCard(7, 4);
        		stack.add(c);
        		z++;
        	} else if(z<6) {
        		DosCard c = new DosCard(8, 4);
        		stack.add(c);
        		z++;
        	} else if(z<8) {
        		DosCard c = new DosCard(9, 4);
        		stack.add(c);
        		z++;
        	} else if(z<10) {
        		DosCard c = new DosCard(10, 4);
        		stack.add(c);
        		z++;
        	}
        }

        // creates wild number cards for 4
        for(int i=0; i<2; i++){
        	DosCard c = new DosCard(11, 4);
        	stack.add(c);
        }
    }

    public void shuffle()
    {
    	Random generator = new Random();
    	    for(int i =0; i<stack.size(); i++)
    	    {
    	      int index = generator.nextInt(stack.size());
    	      DosCard temp = stack.get(i);
    	      stack.set(i, stack.get(index));
    	      stack.set(index, temp);  
    	    }     
    }

	public DosCard deal()
	{
		if (stack.size() > 0) {
			return stack.remove(0);
		} else {
			return null;
		}
	}

    public DosCard getCard(int i)
    {
        if(stack.size()>i) {
            return stack.get(i);
        }
        return null;
    }

	public void addCard(DosCard c)
	{
		stack.add(c);
	}

    public int getSize()
    {
        return stack.size();
    }

    public String toString()
    {
        String result = "";
        for(int i=0; i<stack.size(); i++)
        {
            result+="["+stack.get(i).toString()+"] \n";
        }
        return result;
    }
}//add card
