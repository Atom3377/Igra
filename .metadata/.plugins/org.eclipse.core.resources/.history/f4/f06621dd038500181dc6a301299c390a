package igra;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.*;

class pole extends JPanel {

	private Image shapka;
	private Image end_game;
	private Image fon;
	public int x=400;
	private int slogn;
	private Myachi[] gamePodar;
	public Timer timerUpdate, timerDraw;
	public int schet=0;
	
	public pole(int slogn)
	{
		this.slogn=slogn;
		try
		{
			shapka=ImageIO.read(new File("C:/Users/2009l/Desktop/1Ñ/igra/src/football.png"));
		}
		catch(IOException ex){}
		
		try
		{
			fon=ImageIO.read(new File("pole.png"));
		}
		catch(IOException ex){}
		
		try
		{
			end_game=ImageIO.read(new File("C:/Users/2009l/Desktop/1Ñ/igra/src/end.png"));
		}
		catch(IOException ex){}
		
		gamePodar= new Myachi[7];
		for(int i=0;i<7;i++)
		{
		try
		{
			gamePodar[i]=new Myachi(ImageIO.read(new File("C:/Users/2009l/Desktop/1Ñ/igra/src/b"+i+".png")));
		}
		catch(IOException ex){}
		}
		
		timerUpdate=new Timer(3000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				updateStart();
			}
		});
		timerUpdate.start();
		
		timerDraw = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repaint();
			}
		});
		timerDraw.start();
	}
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr);
		gr.drawImage(fon, 0, 0, null);
		gr.drawImage(shapka, x, 465, null);
		
		String str = Integer.toString(schet);
		   Font f2 = new Font ("Serif", Font.BOLD, 80);
	    	gr.setFont(f2);
	    	Color newColor = new Color(200, 200, 0);
	    	gr.setColor(newColor);
	    	gr.drawString(str, 650, 80);
		
		for(int i=0;i<7;i++)
		{
			gamePodar[i].draw(gr);
			if(gamePodar[i].act==true)
			{
				if((gamePodar[i].y+gamePodar[i].img.getHeight(null))>=470)
				{
					if(Math.abs(gamePodar[i].x-x)>75)
					{
						gr.drawImage(end_game,300,300,null);
						timerDraw.stop();
						timerUpdate.stop();
						break;
					}else {gamePodar[i].act=false; schet+=1;}
				}
			}
		}
	}
	
	private void updateStart()
	{
		int kol=0;
		for(int i=0;i<7;i++)
		{
			if(gamePodar[i].act==false)
			{
				if(kol<slogn)
				{
					gamePodar[i].start();
					break;
				}
			}
			else kol++;
		}
	}
}
