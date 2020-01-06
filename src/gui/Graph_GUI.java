package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dataStructure.*;

public class Graph_GUI extends JFrame implements ActionListener {
	
	private int Width = 1000;
	private int Height = 600;
	
	private graph g;
	private int prevMC;
	
	public Graph_GUI(graph graph) {
		this.g = graph;
		prevMC = graph.getMC();
		initGUI();
	}
	
	private void initGUI() {
		this.setSize(Width, Height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		menuBar.add(menu);
		
		Menu algo = new Menu("Algorithms");
		menuBar.add(algo);
		this.setMenuBar(menuBar);
		
		MenuItem item1 = new MenuItem("Update");
		item1.addActionListener(this);
		
		MenuItem item2 = new MenuItem("Save");
		item2.addActionListener(this);
		
		menu.add(item1);
		menu.add(item2);
		
		/*MenuItem item = new MenuItem("Item");
		item.addActionListener(this);
		
		algo.add(item);*/
		
	}

	public void paint(Graphics p) {
		
		super.paint(p);
		
		for(node_data v: g.getV()) {
			
			p.setColor(Color.blue);
			p.fillOval(v.getLocation().ix(), v.getLocation().iy(), 12, 12);
			p.drawString(""+v.getKey(), v.getLocation().ix(), v.getLocation().iy()+1);
			
			for(edge_data e: g.getE(v.getKey())) {
				node_data src = g.getNode(e.getSrc());
				int x0 = (int) src.getLocation().x();
				int y0 = (int) src.getLocation().y();
				
				node_data dest = g.getNode(e.getDest());
				int x1 = (int) dest.getLocation().x();
				int y1 = (int) dest.getLocation().y();
				
				p.setColor(Color.red);
				p.drawLine(x0, y0, x1, y1);
				p.drawString(""+e.getWeight(), Math.abs(x0-x1), Math.abs(y0-y1));
				
				p.setColor(Color.yellow);
				int m = (y0-y1)/(x0-x1);
				p.fillOval(x1-1, m*(-1)+y1, 12, 12);
				
			}
		}
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("Update")) {
			if(g.getMC()!=prevMC) {
				prevMC = g.getMC();
				repaint();
			}
		}
		
		if(str.equals("Save"));
		
	}


}
