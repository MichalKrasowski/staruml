package co.staruml.test;

import java.awt.Image;
import java.io.IOException;



import javax.imageio.ImageIO;
import javax.swing.*;

import co.staruml.awt.*;
import co.staruml.graphics.*;

public class CanvasAWTTest extends java.awt.Component {
	
	public void paint(java.awt.Graphics g) {
		Canvas canvas = new CanvasAWT();
		((CanvasAWT) canvas).setGraphics((java.awt.Graphics2D) g);
		
		canvas.setColor(Color.RED);
		
		canvas.rectangle(10, 10, 12, 12);
		try {
			Image img = ImageIO.read(getClass().getResource("/icon/class.gif"));
			g.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		canvas.moveTo(0, 0);
		canvas.lineTo(100, 0);
		canvas.lineTo(100, 100);
		canvas.lineTo(200, 100);
		canvas.lineTo(200, 200);
		
		canvas.fillRect(10, 110, 30, 130);
		*/
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		java.awt.Container container = frame.getContentPane();
		CanvasAWTTest canvasTest = new CanvasAWTTest();
		container.add(canvasTest);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

}
