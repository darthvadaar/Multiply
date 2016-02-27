/**
 * @(#)Particles.java
 *
 *
 * @author 
 * @version 1.00 2016/2/27
 */


public class Particle {
	int x,y,vy,vx;
    public Particle(int x,int y,int vx, int vy) {
    	this.x=x;
    	this.y=y;
    	this.vx=vx;
    	this.vy=vy;
    }
    public void move(){
    	x+=vx;
    	y+=vy;
    } 
    
    
    
}