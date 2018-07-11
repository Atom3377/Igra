package igra;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Myachi {
	public Image img;
	public int x,y;
	private pole slogn;
	public Boolean act;
	private Timer timerUpdate;
	
	public Myachi(Image img)
	{
		timerUpdate=new Timer(500,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vniz();
			}
		});
		this.img=img;
		act=false;
	}
	
	public void start()
	{
		timerUpdate.start();
		y=0;
		x=(int)(Math.random()*700);
		act=true;
		
	}
	
	public void vniz()
	{
		if(act==true)
		{
			y=y+20;
		}
		if((y+img.getHeight(null))>=470)
		{
			timerUpdate.stop();
		}
	}
	public void draw(Graphics gr)
	{
		if(act==true)
		{
		gr.drawImage(img, x, y, null);
		}
	}

}
