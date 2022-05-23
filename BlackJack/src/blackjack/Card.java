/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author pc
 */
public class Card {
     
      private final int rank ;
       private final int suit ;
       private final int value ; 

    public Card(int rank, int suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }
     public Card ( Card card ){
         rank = card.rank ;
         suit = card.suit  ;
         value = card.value ; 
         
     }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
     
}

   
     

