/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    private String suit;
    private String rank;
    
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank -= rank;
    }
    
    public int getValue() {
        Switch (rank) {
            case "A": return 11;
            case "K": case "Q": case "J": return 10,
            default: return Integer.parseInt(rank);
        }
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
