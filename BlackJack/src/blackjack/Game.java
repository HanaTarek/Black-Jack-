/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package blackjack;


import java.util.Random;

/**
 *
 * @author pc
 */
 import java.util.Scanner ; 
public class Game {
    Player [] players = new Player [4];
    
    Card [] totalcards = new Card [52];
    Card kart=null;
    Card tonull = null;
    private int high_score = 0 ; 
    int x = 0 ;
    
    public int getHigh_score() {
        return high_score;
    }
    
    public void setHigh_score(int high_score) {
        if( high_score <= 21 )
        {
        this.high_score = high_score;
        }
    }
    
    public void cardDeck(){
        
          for( int i=0 ; i < 4 ; i++){
              for( int j = 0 ; j < 13 ; j++  ){
                  if( j < 10){
                      
                      totalcards[x]= new Card(j , i , j+1);
                      
                      
                  x++;
                  }
                  else if( j >=10){
                      
                      totalcards[x]= new Card(j , i ,10);
                     
                  x++;
                  }
              }
          }
    }
    
  
    
    public Card  DrawRand ( ){
        
            Random rand = new Random(); 
           
            do {
             int y = rand.nextInt(52);
               
             if( totalcards[y]!=null){
                 kart = new Card( totalcards[y].getRank() ,totalcards[y].getSuit(),totalcards[y].getValue() );
                 
                 totalcards[y] = tonull ;
                
                 
                         
             }
                 
    
            }while(kart == null);
             
           
            return kart;
    }
    
    
public void setPlayer (){
    Scanner input = new Scanner( System.in );
    for( int i=0 ; i<4 ; i++){
       if( i != 3){
           System.out.println("----------");
        System.out.println("enter the user name ");
           System.out.println("==========================");
        char name = input.next().charAt(0);
           System.out.println("==========================");
       players[i]=new Player(name);
       }
       if(i==3){
           players[i]=new Player('D');
            System.out.println("==========================");
           System.out.println("D");
            System.out.println("==========================");
       }
        
       for(int j = 0 ; j <2 ; j++){
      usercards(DrawRand(),i);
           
       }  
     
    }
  
 
}
      public void updateMaxScore(){
                

          for(int i=0 ; i<4 ; i++){
           if( players[i].getScore()<=21 &&players[i].getScore()> getHigh_score()  )
               setHigh_score(players[i].getScore());
              
           }
      
   
      }
      
      public void usercards(Card card , int i ){
          
      players[i].cards[players[i].count]=card;
      players[i].index=players[i].count;
      players[i].count++;
         
          
          
          System.out.println(players[i].cards[players[i].index].getValue());
          
           
      if( card.getValue() < 21){
       players[i].score+= card.getValue();
         
      }
      }
      
      public void checklose(int i ){
          if( players[i].score > 21){
              System.out.println("---------------------------");
              System.out.println(" THE PLAYER   " + players[i].getName() + "   BUSTED" );
                  System.out.println("---------------------------");
          }
      }
      
      
      
      
      
      boolean bool = false ;
      int winner= -1;
      int high = 0 ; 
      int num=0;
      int p =0 ;
      public boolean pushgame(){
         for( int i =0 ; i<4 ; i++){
             
             if( players[i].score == getHigh_score()){
                 num++;
             }
             
         }
         if( num == 1 ){
             for( int i =0 ; i<4 ; i++){
             if( players[i].score == getHigh_score() && players[i].score<21 ){
                     System.out.println("---------------------------");
                 System.out.println("THE WINNER IS  " + players[i].getName());
                     System.out.println("---------------------------");
                
                 
             }
             if( players[i].score == getHigh_score() && players[i].score==21 ){
                     System.out.println("---------------------------");
                 System.out.println("THE PLAYER " + players[i].getName() + "  IS A BLACKJACK");
                     System.out.println("---------------------------");
                
                 
             }
         }
         }
         if( num > 1 ){
             bool = true;
             
        }
         return bool;
      
      
      

}
      
      
}