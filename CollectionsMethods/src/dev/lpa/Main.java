package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceofHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceofHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceofHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceofHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card queenOfDiamonds = Card.getFaceCard(Card.Suit.DIAMOND, 'Q');
        List<Card> queensOfDiamonds = Collections.nCopies(13, queenOfDiamonds);
        Card.printDeck(queensOfDiamonds, "Queens of Diamonds", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card collection with Aces addes", 2);

        Collections.copy(cards, queensOfDiamonds);
        Card.printDeck(cards, "Card collection with queens copied", 2);

        cards = List.copyOf(queensOfDiamonds);
        Card.printDeck(cards, "List copy of queens", 1);
    }
}
