/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Diego
 */
  

public class NewPanel extends JPanel implements ActionListener, MouseListener{
    
    
    private Timer timer;
    private boolean e;
    private boolean f;
    private boolean k;
    private boolean h;
    private boolean i;
    private boolean j;
    private int y;
    private int x;
    private int z;
    private int v;
   
    
    public NewPanel(){
        
        
        this.timer=new Timer(25,this);
        this.addMouseListener(this);
        this.timer.start();
        this.e=false;
        this.f=false;
        this.k=false;
        this.h=false;
        this.i=false;
        this.j=false;
        this.y=0;
        this.x=0;
        this.z=0;
        
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);  
        Image background=loadImage("Marvel1.jpg");
        Image a=loadImage("1.jpg");
        Image b=loadImage("2.jpg");
        Image c=loadImage("3.jpg");
        Image d=loadImage("4.jpg");
        g.drawImage(background, 0, 0, 600, 600, 150, 0, 750, 600, this);
        g.setColor(Color.white);
        g.drawString("Puntaje " + z, 400, 400);
        if(e==false){
            g.drawImage(d, 0, 0, this);
        }if(f==false){
            g.drawImage(d, 166, 0, this);
        }if(k==false){
            g.drawImage(d, 0, 175, this);
        }if(h==false){    
            g.drawImage(d, 166, 175, this);
        }if(i==false){
            g.drawImage(d, 0, 175*2, this);
        }if(j==false){
            g.drawImage(d, 166, 175*2, this);
        }if(e==true){
            g.drawImage(a, 0, 0, this);
        }if(f==true){
            g.drawImage(b, 166, 0, this);
        }if(k==true){
            g.drawImage(b, 0, 175, this);
        }if(h==true){
            g.drawImage(c, 166, 175, this);
        }if(i==true){
            g.drawImage(c, 0, 175*2, this);
        }if(j==true){
            g.drawImage(a, 166, 175*2, this);
        }
    }
    
    
    public Image loadImage(String imageName){
        ImageIcon ii=new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp=e.getPoint();
        if(M1().contains(mp)){
            this.e=true;
            y++;
        }if(M2().contains(mp)){
            this.f=true;
            y++;
        }if(M3().contains(mp)){
            this.k=true;
            y++;
        }if(M4().contains(mp)){
            this.h=true;
            y++;
        }if(M5().contains(mp)){
            this.i=true;
            y++;
        }if(M6().contains(mp)){
            this.j=true;
            y++;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    public Rectangle M1(){
        return new Rectangle(0,0,166,175);
    }
    public Rectangle M2(){
        return new Rectangle(166,0,166,175);
    }
    public Rectangle M3(){
        return new Rectangle(0,175,166,175);
    }
    public Rectangle M4(){
        return new Rectangle(166,175,166,175);
    }
    public Rectangle M5(){
        return new Rectangle(0,175*2,166,175);
    }
    public Rectangle M6(){
        return new Rectangle(166,175*2,166,175);
    }
    @Override
    public void actionPerformed(ActionEvent e) {      
         if(y==3){
            y=0;
            if((this.e==true && this.j==false) || (this.e==false && this.j==true)){
                z+=1;
                this.e=false;
                this.j=false;
            }if(this.e==true && this.j==true){
                z+=10;
            }
            if((this.f==true && this.k==false) || (this.f==false && this.k==true)){
                z+=1;
                this.f=false;
                this.k=false;
            }if(this.f==true && this.k==true){
                z+=10;
            }
            if((this.h==true && this.i==false) || (this.h==false && this.i==true)){
                z+=1;
                this.h=false;
                this.i=false;
            }if(this.h==true && this.i==true){
                z+=10;
            }
        }
        repaint();
    }
}
