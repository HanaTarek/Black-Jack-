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



import java.util.Scanner ; 

public class BlackJack {
  static Game obj = new Game();
   
  
    public static void main(String[] args) {
      GUI gui= new GUI();
      char ch ; 
     
      boolean pushing ;
      Scanner input = new Scanner( System.in );
       obj.cardDeck();
       obj.setPlayer();
       obj.updateMaxScore();
       gui.runGUI(obj.totalcards, obj.players[0].cards ,obj.players[1].cards , obj.players[2].cards , obj.players[3].cards);
      
        
        for( int i = 0 ; i<4 ; i++){
             
                  
            if( i!=3){
            while( obj.players[i].getScore() <21 ){
                System.out.println("----------");
                System.out.println("player  " + obj.players[i].getName() + "  turn");
                System.out.println("----------");
                System.out.println(" hit or stand ? h or s");
                
                ch = input.next().charAt(0);
                System.out.println("--------------");
                if(ch=='h' || ch=='H'){
                    
                    obj.usercards(obj.DrawRand(),i);
                    
                    
                    gui.updatePlayerHand(obj.players[i].cards[obj.players[i].index],i);
                    
                    obj.updateMaxScore();
                    
                }
                else if( ch=='s'|| ch=='S'){
                    
                    break;
                }
                else{
                    break;
                }
                
            }
            if( obj.players[i].score == 21){
                 System.out.println("---------------------------");
                System.out.println("PLAYER " +  obj.players[i].getName() + " BLACK JACK");
                 System.out.println("---------------------------");
                
            }
             System.out.println("---------------------------");
             System.out.println(" PLAYER " + obj.players[i].getName() + " SCORE IS " + obj.players[i].score);
              System.out.println("---------------------------");
             obj.checklose(i);
            }
           
            else if( i == 3){
                 System.out.println("-------------");
                System.out.println("THE DEALER TURN");
                System.out.println("-------------");
                        
                if( obj.players[i].getScore() > obj.getHigh_score()){
                     System.out.println("---------------------------");
                    
                    System.out.println("DEALER SCORE  " + obj.players[i].getScore());
                    
                    System.out.println("DEALER WINS");
                     System.out.println("---------------------------");
                    break;
                }
               else if( obj.players[i].getScore() == obj.getHigh_score() && obj.players[i].getScore()== 21 ){
                     System.out.println("---------------------------");
                    System.out.println("DEALER SCORE   " + obj.players[i].getScore());
                    
                    System.out.println("THE GAME IS PUSH");
                     System.out.println("---------------------------");
                    break;
                    }
                 else if( obj.players[i].getScore() > obj.getHigh_score() && obj.players[i].getScore()== 21 ){
                     System.out.println("---------------------------");
                    System.out.println("DEALER SCORE   " + obj.players[i].getScore());
                    
                    System.out.println("DEALER IS A BLACKJACK");
                     System.out.println("---------------------------");
                    break;
                    }
                 else if( obj.players[i].getScore() < obj.getHigh_score()){
                    while( obj.players[i].getScore() < 21 ){
                
                    obj.usercards(obj.DrawRand(),i);
                    
                    gui.updateDealerHand(obj.players[i].cards[obj.players[i].index],obj.totalcards);
                    if( obj.players[i].getScore() == obj.getHigh_score() && obj.players[i].getScore()== 21 ){
                     System.out.println("---------------------------");
                    System.out.println("DEALER SCORE   " + obj.players[i].getScore());
                    
                    System.out.println("THE GAME IS PUSH");
                     System.out.println("---------------------------");
                    break;
                    }
                    else if(obj.players[i].getScore()==21 ){
                         System.out.println("DEALER SCORE   " + obj.players[i].getScore());
                        System.out.println("---------------------------");
                       System.out.println(" THE DEALER IS A BLACK JACK ");
                        System.out.println("---------------------------");
                       break;
                   }
                   
                     else if(obj.players[i].getScore() >  obj.getHigh_score() && obj.players[i].getScore()< 21  ){
                        System.out.println("DEALER SCORE" + obj.players[i].getScore());
                         System.out.println("---------------------------");
                        System.out.println(" THE DEALER WINS ");
                         System.out.println("---------------------------");
                        break;
                    }
                  
                     else if(obj.players[i].getScore() > 21){
                       System.out.println("DEALER SCORE  " + obj.players[i].getScore());
                        System.out.println("---------------------------");
                       System.out.println(" DEALER BUSTED");  
                        System.out.println("---------------------------");
                        pushing = obj.pushgame();
                             if(pushing ){
                              System.out.println("THE GAME END PUSHING");
                              
    }
        
                       break;
                }
                  
            }
          
        }
         
          
      
      
   
    
}
             } 
        if( obj.players[0].score > 21 && obj.players[1].score > 21 && obj.players[2].score > 21 && obj.players[3].score > 21)
        {
            System.out.println("A PUSH GAME");
            System.out.println("------------");
        }
        
         
        
     
    }
}

