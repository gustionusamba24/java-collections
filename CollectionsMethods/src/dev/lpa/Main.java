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
        Card.printDeck(deck, "Sorted by rank and suit reverse", 13);

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

        deck.sort(sortingAlgorithm);
        Card queenOfSpades = Card.getFaceCard(Card.Suit.SPADE, 'Q');
        int foundIndex = Collections.binarySearch(deck, queenOfSpades, sortingAlgorithm);
        System.out.println("foundIndex: " + foundIndex);
//        indexOf is used for unsorted collections
        System.out.println("foundIndex: " + deck.indexOf(queenOfSpades));
        System.out.println(deck.get(foundIndex));

        Card queenOfHearts = Card.getFaceCard(Card.Suit.HEART, 'Q');
        Collections.replaceAll(deck, queenOfHearts, queenOfSpades);
        Card.printDeck(deck.subList(40, 44), "Queens of Spades", 1);

        Collections.replaceAll(deck, queenOfSpades, queenOfHearts);
        Card.printDeck(deck.subList(40, 44), "Queens of Hearts", 1);

        if (Collections.replaceAll(deck, queenOfHearts, queenOfSpades)) {
            System.out.println("Replaced all queens of spades with hearts");
        } else {
            System.out.println("Failed to replace all queens of spades with hearts");
        }

        Card.printDeck(deck.subList(40, 44), "Queens of Spades", 1);

        System.out.println("Queen of Spades Card: " + Collections.frequency(deck, queenOfSpades));

        System.out.println("Best Card: " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card: " + Collections.min(deck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 4);
        System.out.println("Unrotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + 4 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, -4);
        System.out.println("Unrotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + -4 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        for (int i = 0; i < copied.size() / 2; i++) {
            Collections.swap(copied, i, copied.size() - 1 - i);
        }
        System.out.println("Manual reverse: " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copied);
        System.out.println("Using reverse: " + copied);
    }
}
