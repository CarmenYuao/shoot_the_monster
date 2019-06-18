package edu.nyu.cs.ay1290;

import processing.core.PApplet;
import processing.core.PImage;

public class Monster {

	private Game game; //reference to Game object handles processing specific stuff
	private static String PATH ="src/edu/nyu/cs/ay1290/alien.png";//
	private PImage im;
	private final static int  MXSPEED= 2;
	public int x;
	public int y ;
	private int xspeed;
	private int yspeed;
	//method return image height
	public int getH() {
		return this.im.height;
	}
	//method return image width
	public int getW() {
		return this.im.width;
	}
	//return a random speed
	public int getRS() {
		int speed = (int)((Math.random()*Monster.MXSPEED*2)-Monster.MXSPEED);
		return speed;
	}
	//setter
	public void setPosition(int x,int y) {
     	this.x= x;
		this.y = y;
	}
	public void setSpeed(int speedX,int speedY) {
		this.xspeed = speedX;
		this.yspeed= speedY;
	}
	/**draw monster to the screen
	 */
	public void draw() {
		this.game.image(this.im, this.x, this.y);
	}
	/**remove the monster from the ArrayList 
	 */
	public void kill() {
		this.game.getMonster().remove(this);//
	}
	/**move the monster
	 */
	public void move() {
		int xrs = this.getRS();
		int yrs = this.getRS();
		if (this.x+xrs+this.im.width<=this.game.w && this.x+xrs>=0) {
			this.x= this.x+xrs;
		}
		else {
			if(this.x+xrs+this.im.width>this.game.w) {
				this.x=this.game.width;
			}
			else {
				this.x= 0;
			}
		}
		if(this.y<0) {
			this.y= 0;
		}
		else {
			if(this.y+yrs>this.im.height/2) {
				this.y= this.im.height/2;
			}
			else {
				this.y = this.y+yrs;
			}
		}
	}
	//constructor
	public Monster(int x,int y, Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
		
		this.im= this.game.loadImage(Monster.PATH);
		this.xspeed= this.getRS();
		this.yspeed=this.getRS();
	}
	//overload constructor
	public Monster(Game game) {
		this.x= (int)(Math.random()*this.game.w);
		this.y = (int)(Math.random()*(this.game.h/2));
		this.game= game ;
		
		this.im= this.game.loadImage(Monster.PATH);//
		this.xspeed= this.getRS();
		this.yspeed=this.getRS();
	
	}
}
