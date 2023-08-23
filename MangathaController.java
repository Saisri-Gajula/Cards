package Mangatha;

import MangathaCards.Cards;
import MangathaCards.CardComparator;
import MangathaCards.Deck;

public class MangathaController{
	public Deck dk;
	public Cards cd;
	public void init() {
		dk = new Deck();
		cd = new Cards(0,0);
	}
	
	public int getRank() {
		return cd.getRank();
	}
	
	public int getSuit() {
		return cd.getSuit();
	}
	
	public boolean equal() {
		return cd.equals(cd);
	}
	
	public Cards removeFromTop() {
		return dk.removeFromTop();
	}
	
	public void shuffle() {
		dk.shuffle();
	}

}
