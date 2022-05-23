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

public class Player {
       int index=0;
      int count = 0 ; 
   private char name ; 
     int score ; 
    Card [] cards = new Card [11] ;
    
    boolean blackjack ;
    boolean lose ; 

    public Player(char name) {
        this.name = name;
        
    }

    public char getName() {
        return name;
    }
    

 

    public int getScore() {
        return score;
    }
   
    
}
