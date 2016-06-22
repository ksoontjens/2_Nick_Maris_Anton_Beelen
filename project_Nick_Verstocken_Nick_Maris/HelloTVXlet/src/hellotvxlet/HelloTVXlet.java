package hellotvxlet;

import java.awt.Color;
import java.awt.Font;
import javax.tv.xlet.*;
import org.davic.resources.ResourceProxy;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.davic.resources.ResourceClient;





public class HelloTVXlet implements Xlet,ResourceClient,HBackgroundImageListener
{
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug =  true;

            
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg=new HBackgroundImage("Glow.m2v");
     private HTextButton btnNew, btnReset;
     private static HStaticText lbluitleg, lblspeler1, lblspeler2 ;


    public void initXlet(XletContext context) throws XletStateChangeException {
        //achtergrond
        screen = HScreen.getDefaultHScreen();
        bgDevice = screen.getDefaultHBackgroundDevice();
        if (bgDevice.reserveDevice(this)) { System.out.println("achtergrond gereserveerd"); }
        bgTemplate = new HBackgroundConfigTemplate();
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        try{
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch(java.lang.Exception e){
            System.out.println(e.toString());
        }
        
        if(debug) System.out.println("Xlet Initialiseren");
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
                new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, 
                new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
lbluitleg = new HStaticText ( "\u2190,\u2192 = Chip bewegen. \u2193 = Chip zetten. ENTER = Nieuw spel. [1] = Reset score" ) ;
lbluitleg . setLocation(15,550) ;
lbluitleg . setSize (500,16) ;
lbluitleg.setFont(new Font("ARIAL", Font.PLAIN, 16));

lblspeler1 = new HStaticText ( "Speler 1 : " ) ;
lblspeler1 . setLocation(590,200) ;
lblspeler1 . setSize (80,16) ;
lblspeler1.setFont(new Font("ARIAL", Font.PLAIN, 16));
  
lblspeler2 = new HStaticText ( "Speler 2 : " ) ;
lblspeler2 . setLocation(590,230) ;
lblspeler2 . setSize (80,16) ;
lblspeler2.setFont(new Font("ARIAL", Font.PLAIN, 16));
        
btnNew = new HTextButton ( "New Game" ) ;
btnNew.setLocation(590,75) ;
btnNew.setFont(new Font("ARIAL", Font.PLAIN, 16));
btnNew.setSize (100,50) ;
btnNew.setBackground (new Color(26,92,134)) ;
btnNew.setBackgroundMode ( HVisible .BACKGROUND_FILL) ;

btnReset = new HTextButton ( "Reset Score" ) ;
btnReset.setLocation(590,130) ;
btnReset.setFont(new Font("ARIAL", Font.PLAIN, 16));
btnReset.setSize (100,50) ;
btnReset.setBackground (new Color(26,92,134)) ;
btnReset.setBackgroundMode ( HVisible .BACKGROUND_FILL) ;
scene.add(btnNew) ;
scene.add(btnReset) ;
scene.add(lbluitleg);
scene.add(lblspeler1);
scene.add(lblspeler2);
    }

    public void callback()
    {

    }

    public void startXlet() throws XletStateChangeException{
        agrondimg.load(this);
        if(debug) System.out.println("Xlet Starten");
                Model model = new Model();
        BoardView boardview = new BoardView();
        Controller controller = new Controller(model, boardview);  
        
         scene.validate();
         scene.add(boardview);
         scene.setVisible(true); 
    }
    public static void changeScore(int[] score){
        lblspeler1.setTextContent("Speler 1 : " + score[0], HState.NORMAL_STATE);
        lblspeler2.setTextContent("Speler 2 : " + score[1], HState.NORMAL_STATE);
    }
    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException{
    agrondimg.flush();   
    }
    public void imageLoaded(HBackgroundImageEvent e){
        try{
            bgConfiguration.displayImage(agrondimg);
        }
        catch (Exception s){
            System.out.println(s.toString());
        }
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
     
    }

    



