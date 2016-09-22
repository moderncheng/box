package com.main;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements KeyListener{
	JLabel jlabel[][]=new JLabel[12][12];
	int map[][]=new int[12][12];
	JLabel renJLable=null;
	int rx;
	int ry;
	int num=3;
	int count=0;
	public MainFrame(){
		//窗口显示
		this.setVisible(true);
		//尺寸
		this.setSize(600, 600);
		//位置
		this.setLocation(400, 100);
		//标题
		this.setTitle("推箱子1.0");
		//布局为自由布局
		this.setLayout(null);
		//关闭
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.drawMap();
		this.drawPic();	
		this.addKeyListener(this);
		
	}
	public void drawMap(){
		map[2][3]=2;
		map[4][3]=2;
		map[6][3]=2;
		map[2][10]=3;
		map[4][10]=3;
		map[6][10]=3;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				//1表示障碍
				if(i==0||j==0||i==map.length-1||j==map[i].length-1){
					map[i][j]=1;
					Icon image = new ImageIcon("image/tree.jpg");
					jlabel[i][j]=new JLabel(image);
					jlabel[i][j].setBounds(j*50, i*50, 50, 50);
					this.add(jlabel[i][j]);
				}
				//2表示箱子
				if(map[i][j]==2){
					Icon image = new ImageIcon("image/box.png");
					jlabel[i][j]=new JLabel(image);
					jlabel[i][j].setBounds(j*50, i*50, 50, 50);
					this.add(jlabel[i][j]);
				}
				//3表示目的地
				if(map[i][j]==3){
					Icon image = new ImageIcon("image/boxAt.png");
					jlabel[i][j]=new JLabel(image);
					jlabel[i][j].setBounds(j*50, i*50, 50, 50);
					this.add(jlabel[i][j]);
				}
			}
		}
	}
	public void drawPic(){		
		ImageIcon i=null;
		//画人
		rx=2;
		ry=3;
		i = new ImageIcon("image/ren.png");
		renJLable = new JLabel(i);
		renJLable.setBounds(rx*50,ry*50,50,50);
		this.add( renJLable);
		//背景
	    i = new ImageIcon("image/bg.jpg");
	    JLabel lab_bag = new JLabel(i);
	    lab_bag.setBounds(0, 0,600,600);
		this.add(lab_bag);
	}
	public void victory(){
		if(count==num){
			JOptionPane.showMessageDialog(null, "你赢了");
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int x=(int)renJLable.getLocation().getX();
		int y =(int)renJLable.getLocation().getY();
		switch (e.getKeyCode()) {
		case 37:
			Icon left = new ImageIcon("image/ren.png");
			renJLable.setIcon(left);
			
			if(map[ry][rx-1]==1){
				return;
			}
			if(map[ry][rx-1]==2&&map[ry][rx-2]==1){
				return;
			}
			if(map[ry][rx-1]==2&&map[ry][rx-2]==0){
				map[ry][rx-1]=0;
				map[ry][rx-2]=2;
				jlabel[ry][rx-1].setLocation(rx*50-100,ry*50);
				jlabel[ry][rx-2] = jlabel[ry][rx-1];
				jlabel[ry][rx-1] = null;
			}
			if(map[ry][rx-1]==2&&map[ry][rx-2]==2){
				return;
			}
			if(map[ry][rx-1]==2&&map[ry][rx-2]==3){
				map[ry][rx-1]=0;
				map[ry][rx-2]=2;
				jlabel[ry][rx-1].setLocation(rx*50-100,ry*50);
				jlabel[ry][rx-2] = jlabel[ry][rx-1];
				jlabel[ry][rx-1] = null;
				count++;
				
			}
			this.victory();
			rx--;
			renJLable.setLocation(x-50,y);
			break;
	    case 38:
	    	Icon up = new ImageIcon("image/ren_up.png");
	    	renJLable.setIcon(up);
	    	if(map[ry-1][rx]==1){
				return;
			}
			if(map[ry-1][rx]==2&&map[ry-2][rx]==1){
				return;
			}
			if(map[ry-1][rx]==2&&map[ry-2][rx]==2){
				return;
			}
			if(map[ry-1][rx]==2&&map[ry-2][rx]==0){
				map[ry-1][rx]=0;
				map[ry-2][rx]=2;
				jlabel[ry-1][rx].setLocation(rx*50,ry*50-100);
				jlabel[ry-2][rx] = jlabel[ry-1][rx];
				jlabel[ry-1][rx] = null;
			}
			if(map[ry-1][rx]==2&&map[ry-2][rx]==3){
				map[ry-1][rx]=0;
				map[ry-2][rx]=2;
				jlabel[ry-1][rx].setLocation(rx*50,ry*50-100);
				jlabel[ry-2][rx] = jlabel[ry-1][rx];
				jlabel[ry-1][rx] = null;
				count++;
			}
	    	this.victory();
	    	ry--;
	    	renJLable.setLocation(x, y-50);
			break;
        case 39:
        	Icon right = new ImageIcon("image/ren_right.png");
        	renJLable.setIcon(right);
        	if(map[ry][rx+1]==1){
				return;
			}
			if(map[ry][rx+1]==2&&map[ry][rx+2]==1){
				return;
			}
			if(map[ry][rx+1]==2&&map[ry][rx+2]==2){
				return;
			}
			if(map[ry][rx+1]==2&&map[ry][rx+2]==0){
				map[ry][rx+1]=0;
				map[ry][rx+2]=2;
				jlabel[ry][rx+1].setLocation(rx*50+100,ry*50);
				jlabel[ry][rx+2] = jlabel[ry][rx+1];
				jlabel[ry][rx+1] = null;
			}
			if(map[ry][rx+1]==2&&map[ry][rx+2]==3){
				map[ry][rx+1]=0;
				map[ry][rx+2]=2;
				jlabel[ry][rx+1].setLocation(rx*50+100,ry*50);
				jlabel[ry][rx+2] = jlabel[ry][rx+1];
				jlabel[ry][rx+1] = null;
				count++;
			}
			this.victory();
        	rx++;
	    	renJLable.setLocation(x+50,y);
			break;
	    case 40:
	    	Icon down = new ImageIcon("image/ren_down.png");
	    	renJLable.setIcon(down);
	    	if(map[ry+1][rx]==1){
				return;
			}
			if(map[ry+1][rx]==2&&map[ry+2][rx]==1){
				return;
			}
			if(map[ry+1][rx]==2&&map[ry+2][rx]==2){
				return;
			}
			if(map[ry+1][rx]==2&&map[ry+2][rx]==0){
				map[ry+1][rx]=0;
				map[ry+2][rx]=2;
				jlabel[ry+1][rx].setLocation(rx*50,ry*50+100);
				jlabel[ry+2][rx] = jlabel[ry+1][rx];
				jlabel[ry+1][rx] = null;
			}
			if(map[ry+1][rx]==2&&map[ry+2][rx]==3){
				map[ry+1][rx]=0;
				map[ry+2][rx]=2;
				jlabel[ry+1][rx].setLocation(rx*50,ry*50+100);
				jlabel[ry+2][rx] = jlabel[ry+1][rx];
				jlabel[ry+1][rx] = null;
				count++;
			}
			this.victory();
	    	ry++;
	    	renJLable.setLocation(x, y+50);
			break;
		default:
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
