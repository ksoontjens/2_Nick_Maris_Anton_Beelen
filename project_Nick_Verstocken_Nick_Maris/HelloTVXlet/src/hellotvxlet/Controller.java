/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import java.awt.Color;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;
/**
 *
 * @author student
 */
public class Controller implements HActionListener, UserEventListener{
    private int[] score = new int[2];
    private Model model;
    private BoardView boardView;
    private EventManager manager = EventManager.getInstance();
    private UserEventRepository repository = new UserEventRepository("");
    private boolean hasWinner;
    private Color[] colors = new Color[3];
    public Controller(Model model, BoardView boardView) {
       this.model = model;
       this.boardView = boardView;
       this.hasWinner = false;
       colors[1]=Color.RED;
       colors[2]=Color.YELLOW;
       boardView.setKleur(colors[model.getSpeler()]);
       boardView.setArray(model.getArray());
       addEvents();
    }
     public void resetScore(){
        model=new Model();
        this.hasWinner = false;
        score = new int[2];
        boardView.setKleur(colors[model.getSpeler()]);
        boardView.setArray(model.getArray());
        boardView.moveChip(0);
        boardView.repaint();
        HelloTVXlet.changeScore(score);
    }
    public void resetGame(){
        model.resetArray();
        this.hasWinner = false;
        boardView.setArray(model.getArray()); 
        boardView.repaint();
    }
    public int[] getScore(){
        return this.score;
    }
    public void gameover(){
        //removeEvents();
        
    }

    private void changeSpeler() {
        
     model.setSpeler(model.getSpeler()==1?2:1);
     boardView.setKleur(colors[model.getSpeler()]);
      
     
   }
    private void removeEvents(){
        manager.removeUserEventListener(this);
    }
    private void addEvents(){

         repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
         repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
         repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
         repository.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD1);
         repository.addKey(org.havi.ui.event.HRcEvent.VK_ENTER);
         manager.addUserEventListener( this, repository);  
    }

    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType()== KeyEvent.KEY_PRESSED){
            System.out.println(e.getCode());
            switch(e.getCode()){
                case HRcEvent.VK_NUMPAD1:
                    this.resetScore();
                    break;
                case HRcEvent.VK_ENTER:
                     resetGame();
       
                     break;
                case HRcEvent.VK_RIGHT:
                   if(boardView.getKolom() < 6){
                      boardView.moveChip(boardView.getKolom() + 1); 
                   }
                    break;
                case HRcEvent.VK_LEFT:
                   if(boardView.getKolom() > 0){
                      boardView.moveChip(boardView.getKolom() - 1); 
                   }
                    break;
                 case HRcEvent.VK_DOWN:
                   if(!model.isWinner()){
                       model.setChip(boardView.getKolom());
                   }
                  boardView.setKleur(colors[model.getSpeler()]);
                  if(model.isWinner()&& !this.hasWinner){
                      System.out.println("The winner is " + model.getSpeler());
                     if(model.getSpeler() == 1){
                         score[0] += 1;
                         
                     }
                      if(model.getSpeler() == 2){
                         score[1] += 1;
                         
                     } 
                      this.hasWinner = true;
                      System.out.println("The winner is " + score[0]);
                      HelloTVXlet.changeScore(score);
                      this.changeSpeler();
                      
                   
                      gameover();
                  }
                    break;
            }
          
        }  
    }
}
