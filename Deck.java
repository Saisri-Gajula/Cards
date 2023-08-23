package MangathaCards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Cards> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for (int rank = Cards.MIN_RANK; rank <= Cards.MAX_RANK; rank++)
			for (int suit = Cards.MIN_SUIT; suit <= Cards.MAX_SUIT; suit++)
				cards.add(new Cards(rank, suit));
	}
	
	public Cards removeFromTop() {
		if (cards.isEmpty()) {
			System.out.println("No more cards left!");
			return null;
		}
		return cards.remove(0);
	}
	
	public void addToTop(Cards c) {
		cards.add(0, c);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}

}