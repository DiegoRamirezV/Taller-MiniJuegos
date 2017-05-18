/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Diego
 */
public class NewPanel extends JPanel implements ActionListener,MouseListener {

    private Timer timer;
    private int x;
    private int y;
    private int z;
    private int c;
   
    private boolean ch;
    private String letra;
    private String[] palabras={"thinking","anymore","dangerously","shades","attention"};
    private String[] palabra1;
    private String[] palabra2;
    private String palabra;
    
    
    
    
    

    public NewPanel() {
        this.timer=new Timer(25,this);
        this.addMouseListener(this);
        this.timer.start();
        this.x=0;
        this.y=0;
        this.z=0;
        this.ch=false;
        this.c=0;
        this.letra=new String();
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Image ahorcado = loadImage("ahorcado.png");
        Image abecedario = loadImage("abecedario.png");
        setBackground(Color.WHITE);
        g.drawImage(abecedario, 360, 200, this);
        g.drawString("Fallos: " + z +" ", 400, 100);
        
        
        if(z==7){
            g.setColor(Color.black);
            finish(g);
        }
        g.setColor(Color.BLUE);
        for(int i=0; i<x;i++){
            g.drawLine(50+(i*50), 400, 80+(i*50), 400);
        }
        
        for(int i=0; i<x;i++){
            if(this.palabra2[i]!=null){ 
                g.setColor(Color.black);
                g.drawString(palabra2[i], 50+(i*50), 400);              
            }
            if(i==x-1){
                this.ch=false;
            }
        }
        if(this.c==this.x){
            g.setColor(Color.black);
            finish(g);
        }
        
        switch(z){
            case 1:
                g.drawImage(ahorcado, 50, 50, 50+136, 50+200,0*136,0,(0*136)+136,200,null);
                break;
            case 2:
                g.drawImage(ahorcado, 50, 50, 50+136, 50+200,1*136,0,(1*136)+136,200,null);
                break;
            case 3:
                g.drawImage(ahorcado, 50, 50, 50+136, 50+200,2*136,0,(2*136)+136,200,null);
                break;
            case 4:
                g.drawImage(ahorcado, 50, 50, 50+136, 50+200,3*136,0,(3*136)+136,200,null);
                break;
            case 5:
                g.drawImage(ahorcado, 50, 50, 50+136, 50+200,4*136,0,(4*136)+136,200,null);
                break;
            case 6:
                g.drawImage(ahorcado, 50, 50, 50+136, 50+200,5*136,0,(5*136)+136,200,null);
                break;
            case 7:
                g.drawImage(ahorcado, 50, 50, 50+136, 50+200,6*136,0,(6*136)+136,200,null);
                break;
        }
        
    }
    
    public Image loadImage(String imageName){
        ImageIcon aa = new ImageIcon(imageName);
        Image image = aa.getImage();
        return image;
    }
    
    public void finish(Graphics g){
        g.drawString("Perdiste", 480, 100);
        this.timer.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(y<1){palabras();}      
        repaint();
    }

    public int palabras(){
        Random random=new Random();
        int ran=random.nextInt(this.palabras.length);
        String palabra=this.palabras[ran];
        this.palabra1=new String[palabra.length()];
        this.palabra2=new String[palabra.length()];
        for(int i=0;i<palabra.length();i++){
            this.palabra1[i]=new String();
            this.palabra1[i]=palabra.substring(i, i+1);
        }
        this.x=palabra.length();
        this.y++;
        return this.x;
    }
    
    public Rectangle[][] Rect(){
        Rectangle[][] rect=new Rectangle[3][9];
        for(int i=0; i<3;i++){
            for(int j=0; j<9;j++){
                rect[i][j]=new Rectangle(360+(j*48), 200+(i*49), 49, 49);
            }
        }
        return rect;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        int num=0;
        Point mp=me.getPoint();
        Rectangle[][] rect=Rect();
        for(int i=0; i<3;i++){
            for(int j=0; j<9;j++){
                if(rect[i][j].contains(mp)){
                    num=(i*10)+j;
                }
            }
        }
        if(num<9){
            switch(num){
                case 0:
                    this.letra="a";
                    break;
                case 1:
                    this.letra="b";
                    break;
                case 2:
                    this.letra="c";
                    break;
                case 3:
                    this.letra="d";
                    break;
                case 4:
                    this.letra="e";
                    break;
                case 5:
                    this.letra="f";
                    break;
                case 6:
                    this.letra="g";
                    break;
                case 7:
                    this.letra="h";
                    break;
                case 8:
                    this.letra="i";
                    break;
            }
        }if(num>9 && num<19){
            switch(num){
                case 10:
                    this.letra="j";
                    break;
                case 11:
                    this.letra="k";
                    break;
                case 12:
                    this.letra="l";
                    break;
                case 13:
                    this.letra="m";
                    break;
                case 14:
                    this.letra="n";
                    break;
                case 15:
                    this.letra="ñ";
                    break;
                case 16:
                    this.letra="o";
                    break;
                case 17:
                    this.letra="p";
                    break;
                case 18:
                    this.letra="q";
                    break;
            }
        }if(num>19 && num<29){
            switch(num){
                case 20:
                    this.letra="r";
                    break;
                case 21:
                    this.letra="s";
                    break;
                case 22:
                    this.letra="t";
                    break;
                case 23:
                    this.letra="u";
                    break;
                case 24:
                    this.letra="v";
                    break;
                case 25:
                    this.letra="w";
                    break;
                case 26:
                    this.letra="x";
                    break;
                case 27:
                    this.letra="y";
                    break;
                case 28:
                    this.letra="z";
                    break;
            }
        }
        for(int i=0;i<this.x;i++){
            if(this.palabra1[i].contains(letra)){
                c++;
                this.palabra2[i]=letra;
                ch=true;
            }
        }
        if(ch==false){
            z++;
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
    
    
}
