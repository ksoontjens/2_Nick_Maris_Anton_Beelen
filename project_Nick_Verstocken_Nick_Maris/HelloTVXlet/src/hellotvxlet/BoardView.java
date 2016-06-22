/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import java.awt.*;
import org.havi.ui.*;
/**
 *
 * @author student
 */
public class BoardView extends HComponent{
     private int w = 7, h = 6, blockSize = 73, xAfstand =15, kolom =0;
     private Color kleur;
     private int[][] array;
     public BoardView(){
         this.setBounds(0,0,600,600);
     }
     
     public void setArray(int[][] array){
         this.array = array;
     }
     public int getKolom(){
         return kolom;
     }
     
     public void setKleur(Color kleur){
         this.kleur = kleur;
         repaint();
     }
     public void moveChip(int kolom){
         this.kolom = kolom;
         repaint();
     }
    public void paint(Graphics g) {

        g.setColor(new Color(26,92,134));
        g.fillRect(0, 75, 545, 500);
        g.setColor(kleur);
        g.fillOval(kolom * blockSize +  xAfstand,5, blockSize - 7, blockSize -7);
        //Grid maken. 
        //Rijen overlopen
        for (int i = 0; i < h; i++) {
            //kolommen overlopen
            for (int j = 0; j < w; j++) {
                //vierkantje maken fillcolor wit en rand zwart
                g.setColor(new Color(9,57,90));
                g.fillOval(j * blockSize + 15, i * blockSize + 100, blockSize - 6 , blockSize - 6);
             g.setColor(Color.BLUE);
             g.drawOval(j * blockSize + 16, i * blockSize + 101, blockSize -7 , blockSize -7 );
                if (array[i][j] > 0) {
                    if (array[i][j] == 1) {
                        g.setColor(new Color(215,32,51));
                    }
                    if (array[i][j] == 2) {
                        g.setColor(new Color(241,193,32));
                    }
                    g.fillOval(j * blockSize + 15, i * blockSize + 100, blockSize - 6, blockSize - 6);
                }
            }
        }

    }
}
