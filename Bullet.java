package edu.nyu.cs.ay1290;

import processing.core.PApplet;
import processing.core.PImage;
/**
 * bullet class 
 */
public class Bullet {
	private Game game;
	private final static String BP = "src/edu/nyu/cs/ay1290/bullet.png";//
	private PImage bimg;
	
	private int x;
	private int y;

	
	private int yspeed = -9;
	/**@return the the width of the picture bullet
	 */
	public int getW() {
		return this.bimg.width;
	}
	/**@return the the width of the picture bullet
	 */
	public int getH() {
		return this.bimg.height;
	}
	/**move the bullet in y direction 
	 */
	public void  move() {
		if (this.y+this.yspeed>=0) {
			this.y = this.y+this.yspeed;
		}
		else {
			this.game.getbullet().remove(this);
		}
	}
	/**draw the bullet picture 
	 */
	public void draw() {
		this.game.image(bimg, x, y);
	}
	/**remove the bullet object from ArrayList 
	 */
	public void kill() {
		this.game.getbullet().remove(this);
	}
	/**@return whether bullet and monster collide
	 */
	public static boolean isCol (Bullet bullet, Monster monster) {
		boolean collide = false;
		if (bullet.x>=monster.x && bullet.x+bullet.getW()<=monster.x+monster.getW()) {
			if (bullet.y>=monster.y&&bullet.y+bullet.getH()<=monster.y+monster.getH()) {
				collide= true;
			}
		}
		return collide;
	}
	/**constructor 
	 */
	public Bullet(int x1,int y1, PApplet papp) {
		this.game =(Game) papp;//
		this.x=x1;
		this.y=y1;
		this.bimg=game.loadImage(Bullet.BP);//
		this.game.getbullet().add(this);
	}
	
	
	
	
	

}
