package Lab1;

public class Rectangle {
	private int length;
	private int width;
	public Rectangle () {
		this.length=1;
		this.width=1;
	}
	public Rectangle(int length,int width) {
		this.length=length;
		this.width=width;
	}
	public int getlength() {
		return this.length;
	}
	public int getwidth() {
		return this.width;
	}
    public void setwidth(int width) {
    	this.width= width;
    }
    public void setlength(int length) {
    	this.length = length;
    }
    public int area() {
    	int area = this.getwidth()* this.getlength();
    	for(int i = 0;i<10;i++) {
    		System.out.println(area);
    	}
    	return area;
    }
    public boolean issquare() {
    	boolean square=false;
    	if(this.getlength()==this.getwidth()) {
    		square=true;
    	}
    	return square;
    }
}
