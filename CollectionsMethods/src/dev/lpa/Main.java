package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Card> deck = Card.getStandardDeck();
//        Card.printDeck(deck);

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

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck of Cards:", 4);

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        deck.sort(sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank and suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank and suit reeversed", 13);

        List<Card> aces = new ArrayList<>(deck.subList(0, 4));
        Card.printDeck(aces, "Aces in deck", 1);

        List<Card> eights = new ArrayList<>(deck.subList(24, 28));
        Card.printDeck(eights, "Eights in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, aces);
        System.out.println("sublist index for aces: " + subListIndex);
        System.out.println("contains: " + deck.containsAll(aces));

        boolean disjoint = Collections.disjoint(deck, eights);
        System.out.println("disjoint: " + disjoint);

        boolean disjoint2 = Collections.disjoint(eights, aces);
        System.out.println("disjoint: " + disjoint2);
    }
}
