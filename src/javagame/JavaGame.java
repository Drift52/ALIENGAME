package javagame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class JavaGame extends JFrame implements Runnable {
    int x, y, xDirection, yDirection;
    private Image dbImage;
    private Graphics dbg;
    Image alien;
    
    public void run(){
        try{
            while(true){
                
                move();
                
                Thread.sleep(5);
                
            }
            
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    
    public void move() {
    x += xDirection;
    y += yDirection;
    if (x<=0)
        x = 0;
    if (x >= 400)
        x=400;
    if (y<=0)
        y = 0;
    if (y>350)
        y=350;
    }
    
    public void setXDirection(int xdir){
        xDirection = xdir;
       
    }
  
    public void setYDirection(int ydir)
    {
        yDirection = ydir;
    }    
    Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
    
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_LEFT) {
             setXDirection(-1);
        } 
            if(keyCode == e.VK_RIGHT) {
              setXDirection(+1);
        }  
            if(keyCode == e.VK_UP) {
              setYDirection(-1);
        }  
            if(keyCode == e.VK_DOWN) {
            setYDirection(+1);
        }
       
        } 
        
        public void keyReleased(KeyEvent e){
            int keyCode = e.getKeyCode();
             if(keyCode == e.VK_LEFT) {
             setXDirection(0);
        } 
            if(keyCode == e.VK_RIGHT) {
              setXDirection(0);
        }  
            if(keyCode == e.VK_UP) {
              setYDirection(0);
        }  
            if(keyCode == e.VK_DOWN) {
            setYDirection(0);
        }
       
        }
    }
    public JavaGame(){
        //Load Images
        ImageIcon i = new ImageIcon("C:/Users/Link/Documents/NetBeansProjects/JavaGame/src/javagame/alien.gif");
        alien = i.getImage();
                

        //Game Properties
        
        
        addKeyListener (new AL());
        setTitle("Game");
        setSize(500,500);
        setResizable(false);
        setVisible(true);
        setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        x = 150;
        y = 150;
    }         
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
        
    }
    
    public void paintComponent(Graphics g){
        
        
        g.setColor(Color.MAGENTA);
        g.drawImage(alien, x, y, this);
        
        repaint();
            
    }
    
    public static void main (String[] args) {
        JavaGame jg = new JavaGame();
        
        //Threads
        Thread t1= new Thread(jg);
        t1.start();
    }

   //rkewr32rjk4rhnkdwjfnkwfwfwefwefwe
        
    
}