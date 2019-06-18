package edu.nyu.cs.ay1290;

import processing.core.PApplet;
import processing.core.PImage;

public class Ship extends Shiparent {
	private static Game game;
	private final static String PATHS = "src/edu/nyu/cs/ay1290/spaceship.png";//
	private static PImage img ;
	private int x;
	private int y;
	//private int xspeed=5;
	//private int yspeed=5;
	/**constructor
	 */
	public Ship(Game game) {
		Ship.game = game;
		this.x = 0;
		this.y = (int)(Ship.game.h);
		Ship.img=Ship.game.loadImage(Ship.PATHS);//
	}
	
	/**return width of the picture
	 */
	public int getW() {
		return Ship.img.width;
	}
	
	public int getH() {
		return Ship.img.height;
	}
	//shipmove follow the mouse in x,y direction
	public void move() {
		if (Ship.game.mouseX>=0 && Ship.game.mouseX<=Ship.game.w) {
		this.x=Ship.game.mouseX;
		}
		else {
			if (Ship.game.mouseX<0) {
				this.x=0;
			}
			else {
				this.x= Ship.game.w;
			}
		}
		if (Ship.game.mouseY>=(Ship.game.h)/2 && Ship.game.mouseY+this.getH()<=Ship.game.h) {
			this.y=Ship.game.mouseY;
		}
		else {
			if(Ship.game.mouseY<(Ship.game.h)/2) {
				this.y=(Ship.game.h)/2;
			}
			else {
				this.y = Ship.game.h-Ship.img.height;
			}
		}
	}
	/**draw the ship 
	 */
	public void draw() {
		Ship.game.image(Ship.img, this.x, this.y);
	}
	/**shoot a bullet 
	 */
	public void shoot() {
		int x =(int) (this.x+(this.getW())/2);
		int y =(int)(this.y-this.getH());
		Bullet bullet = new Bullet(x,y,Ship.game);
	}
	
}
