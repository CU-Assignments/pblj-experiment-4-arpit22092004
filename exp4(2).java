import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Collection<Card> cards = new ArrayList<>();

        // Adding cards to the collection
        cards.add(new Card("Hearts", "2"));
        cards.add(new Card("Hearts", "3"));
        cards.add(new Card("Spades", "King"));
        cards.add(new Card("Diamonds", "Ace"));
        cards.add(new Card("Clubs", "Queen"));
        cards.add(new Card("Hearts", "Ace"));
        cards.add(new Card("Spades", "2"));

        // User input for symbol search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the symbol to search for (Hearts, Spades, Diamonds, Clubs): ");
        String symbolToSearch = scanner.nextLine();

        // Finding and displaying cards with the given symbol
        System.out.println("Cards with symbol " + symbolToSearch + ":");
        Boolean found = false;
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbolToSearch)) {
                System.out.println(card);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cards found with the symbol " + symbolToSearch);
        }

        scanner.close();
    }
}
