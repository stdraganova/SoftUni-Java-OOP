package workingwithabstraction.lab.exercise.cards;

public class Card {
    private int power;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.power = cardRank.getPower() + cardSuit.getPower();
    }

    public int getPower() {
        return power;
    }
}
