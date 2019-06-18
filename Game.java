package edu.nyu.cs.ay1290;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import edu.nyu.cs.ay1290.Monster;
import edu.nyu.cs.ay1290.Ship;
import edu.nyu.cs.ay1290.Bullet;
/**
 * @author Aojie YU
 * @version1.0
 * game : the ship follow your mouse and a bullet is shoot when you click your mouse
 * When  you have shooted all the monsters it will tell you all monsters are killed
 */
 

public class Game extends PApplet{
	public final int w = 900;
	public final int h = 500;
	private String message = "KILLED ALL MONSTERS!";
	public final int CC= this.color(99,99,99);
	
	public final static int mspace = 50;
	public final static int mnumber =15;
	
	private Ship ship;
	
	private ArrayList<Monster> monster = new ArrayList<Monster>();
	
	private ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	/**@return the ArrayList that store the bullets
	 */
	public ArrayList<Bullet> getbullet (){
		return this.bullet;
	}
	/**@return the ArrayList that store the monster
	 */
	public ArrayList<Monster> getMonster() {
		return this.monster;
	}
	
	public void settings() {
		this.size(this.w, this.h);
	}
	public void setup() {
		this.background(this.CC);
		this.ship = new Ship(this);
		
		int x = 0;
		int y = 0;
		for (int i =0; i<Game.mnumber;i++) {
			Monster m = new Monster(x,y,this);
			this.monster.add(m);
			x=x+m.getW()+Game.mspace;
			if (x+m.getW()>this.w) {
				x=0;
				y=y+m.getH()+mspace;
			}
		}
	}
	public void draw() {
		this.background(this.CC);
		this.ship.move();
		this.ship.draw();
		for (int i = 0; i< this.bullet.size();i++) {
			Bullet b = this.bullet.get(i);
			b.move();
			b.draw();
		}
		for (int i = 0;i<this.monster.size();i++) {
			Monster m = this.monster.get(i);
			m.move();
			m.draw();
		}
		ArrayList<Monster> rm = new ArrayList<Monster>();
		ArrayList<Bullet>  rb = new ArrayList<Bullet>();
		
		for (Bullet b: this.bullet) {
			for (Monster m: this.monster) {
				if( Bullet.isCol(b,m)) {
					rm.add(m);
					rb.add(b);
					////this.bullet.remove(b);//
					//this.monster.remove(m);
				}
			}	
		}
		for (Monster m : rm) {
			m.kill();
		}
		for(Bullet b: rb) {
			b.kill();
		}
		
		if (monster.size()==0) {
			this.textSize(30);
			this.fill(0,0,0);
			this.text(this.message, 100, 100);
		}
	}
	public void mouseClicked() {
		this.ship.shoot();
	}
	public static void main(String[] args) {
		PApplet.main("edu.nyu.cs.ay1290.Game");
	}

}
