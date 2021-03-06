package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Represents a unique game player
 */
public class Player {
    /*
    Gets the name of the player
     */
    public String get_name() {
        return _name;
    }
    /*
    Gets the unique id of the player.
     */
    public int get_Id() {
        return _Id;
    }

    /*
    Represents the name of the player
     */
    private String _name;
    /*
    Represents the unique id of the player
     */
    private int _Id;

    /*
    Gets the current cards that the player holds in hand
     */
    public Stack<Card> get_hand() {
        return _hand;
    }

    /*
        For LIFO putpose
         */
    /*
    Represents the cars that player holds in hand
     */
    private Stack<Card> _hand = new Stack<Card>();
    /*
    Represents the cars the player collected after winning
     */
    private List<Card> _pile = new ArrayList<>();

    /*
    Gets total point of a player in any time of the gane
     */
    public double get_point() {

        return _pile.size();
    }

    /*
    Gets a card passed by dealer
     */
    public void acceptCard(Card card) {

        this._hand.add(card);

    }

    public Card throwCard() {

       return _hand.pop();
    }

    public Card throwCardByRule(Card previousCard) throws Exception {

        throw new Exception("not implemented");

    }

    public Player(Integer _Id) {

        this._name = Player.class.getName().concat(_Id.toString());
        this._Id = _Id;
    }
    /*
    Adds a collected of cards to the pile after a winning tour
     */
    public void addPile(List<Card> crds){

        _pile.addAll(crds);
    }

    @Override
    public String toString() {

        return this.get_name();

    }
    /*
    Represents the tour number that the player wins
     */
    private int totalLuckyTours;

    /*
    Happens when a player can throw the same card as the previous player for the first time
     */
    private Integer bonusPoint=0;
    /*
    Increment bonus number of player after a special win
     */
    public void incrementBonusPoint(){bonusPoint ++;}
    /*
    Gets total bonus point of the player
     */
    public int getbonusPoint(){

        return bonusPoint;
    }
    /*
    Increments the number of tours that the player won
     */
    public void incrementLuckyTourNumber(){
        totalLuckyTours ++;
    }
    /*
    Gets the total winning tour number of player
     */
    public int getTotalLuckyTours(){
        return totalLuckyTours;
    }
    /*
    Gets the total card number collected after winning.
     */
    public int getTotalCardsCollected(){

        return _pile.size();
    }
}

