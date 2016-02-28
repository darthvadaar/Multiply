/**
 * @(#)ScoreText.java
 *
 *
 * @author 
 * @version 1.00 2016/2/14
 */


public class ScoreText {
	public String name;
	public int frameduration;		
	public int x,y;
    public ScoreText(String name,int frameduration,int x,int y) {
    	this.frameduration=frameduration;
    	this.name=name;
    	this.x=x;
    	this.y=y;
    }
    public void update(){
    	frameduration-=1;
    }
}