package MangathaCards;


import java.util.Comparator;

public class CardComparator implements Comparator<Cards>{

	@Override
	public int compare(Cards arg0, Cards arg1) {
		if (arg0.getRank() == arg1.getRank())
			return Integer.compare(arg0.getSuit(), arg1.getSuit());
		else
			return Integer.compare(arg0.getRank(), arg1.getRank());
	}

}

