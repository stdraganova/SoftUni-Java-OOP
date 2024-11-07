package workingwithabstraction.lab.exercise.cards;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//       // Exercise 1 CardSuits
//
//        //Gets all enum values from the Enumeration class
//        workingwithabstraction.lab.exercise.cards.CardSuit[] cardSuits = workingwithabstraction.lab.exercise.cards.CardSuit.values();
//
//        System.out.println("workingwithabstraction.lab.exercise.cards.Card Suits:");
//
//        //Iterate over the cardSuits array
//        for (workingwithabstraction.lab.exercise.cards.CardSuit cardSuit : cardSuits){
//            //Get the ordinal (order) value of the current card
//            int ordinalValue = cardSuit.ordinal();
//
//            System.out.printf("Ordinal value: %d; Name value: %s%n", ordinalValue, cardSuit);
//        }


        //Exercise 2 workingwithabstraction.lab.exercise.cards.CardRank
//        workingwithabstraction.lab.exercise.cards.CardRank[] cardRanks = workingwithabstraction.lab.exercise.cards.CardRank.values();
//
//        System.out.println("workingwithabstraction.lab.exercise.cards.Card Ranks:");
//
//        for (workingwithabstraction.lab.exercise.cards.CardRank rank : cardRanks){
//
//            int ordinalValue = rank.ordinal();
//
//            System.out.printf("Ordinal value: %d; Name value: %s%n", ordinalValue, rank);
//        }

//        //Exercise 3 Cards with Power
        Scanner scanner = new Scanner(System.in);

        //Reads from the console and returns the correct enum value
        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardSuit cardSuit = CardSuit.valueOf(scanner.nextLine());

        Card card = new Card(cardSuit, cardRank);

        System.out.printf("workingwithabstraction.lab.exercise.cards.Card name: %s of %s; workingwithabstraction.lab.exercise.cards.Card power: %d", cardRank, cardSuit, card.getPower());
    }
}
