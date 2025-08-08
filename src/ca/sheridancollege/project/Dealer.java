/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author diyac
 */
public class Dealer extends Player {
    public Dealer(String name) {
        super(name);
    }

    @Override
    public void play() {
        // Intentionally empty; use playAutomatically()
    }

    public void playAutomatically(Deck deck) {
        while (getHandValue() < 17) {
            hand.add(deck.drawCard());
        }
    }
}
