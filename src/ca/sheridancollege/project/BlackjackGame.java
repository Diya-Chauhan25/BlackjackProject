/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author diyac
 */
public class BlackjackGame extends Game {
    private Deck deck;
    private Player player;
    private Dealer dealer;

    public BlackjackGame(String name) {
        super(name);
        deck = new Deck();
        player = new Player("Player") {
            @Override
            public void play() {
                // Logic handled in main loop
            }
        };
        dealer = new Dealer("Dealer");
        getPlayers().add(player);
        getPlayers().add(dealer);
    }

    public void dealInitialCards() {
        player.getHand().add(deck.drawCard());
        dealer.getHand().add(deck.drawCard());
        player.getHand().add(deck.drawCard());
        dealer.getHand().add(deck.drawCard());
    }

    public void playerHit() {
        player.getHand().add(deck.drawCard());
    }

    public void dealerTurn() {
        dealer.playAutomatically(deck);
    }

    public void determineWinner() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        System.out.println("Player: " + playerValue);
        System.out.println("Dealer: " + dealerValue);

        if (playerValue > 21) {
            System.out.println("Player busts. Dealer wins.");
        } else if (dealerValue > 21 || playerValue > dealerValue) {
            declareWinner(player);
        } else if (dealerValue > playerValue) {
            declareWinner(dealer);
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void resetGame() {
        player.getHand().clear();
        dealer.getHand().clear();
        deck = new Deck();
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame("Blackjack");
        Scanner sc = new Scanner(System.in);

        while (true) {
            game.resetGame();
            game.dealInitialCards();

            while (game.player.getHandValue() < 21) {
                System.out.println("Your hand: " + game.player.getHand());
                System.out.print("Hit or Stand? ");
                String action = sc.nextLine();
                if (action.equalsIgnoreCase("Hit")) {
                    game.playerHit();
                } else {
                    break;
                }
            }

            game.dealerTurn();
            game.determineWinner();

            System.out.print("Play again? (y/n): ");
            if (!sc.nextLine().equalsIgnoreCase("y")) break;
        }

        sc.close();
    }
}
