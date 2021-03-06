import java.awt.*;

/**
 * Created by Adrian on 2014-02-19.
 */
public abstract class SimulationEntity {

    private int xpos;
    private int ypos;
    private boolean dead;
	private int energy;

    public int getXpos(){
        return xpos;
    }

    public void setXpos(int x){
        if(x < 0){
            xpos = Constants.WIDTH + x;
        }

        else if(x >= Constants.WIDTH){
            xpos = x - Constants.WIDTH;
        }

        else{
            xpos = x;
        }
    }

    public int getYpos(){
        return ypos;
    }

    public void setYpos(int y){
        if(y < 0){
            ypos = Constants.HEIGHT + y;
        }

        else if(y >= Constants.HEIGHT){
            ypos = y - Constants.HEIGHT;
        }

        else{
            ypos = y;
        }
    }

    public void setDead(boolean d){
        dead = d;
    }

    public boolean isDead(){
        return dead;
    }
    
    public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
		if (this.energy > Constants.maxEnergy)
			this.energy = Constants.maxEnergy;
		else if (this.energy < 0)
			this.energy = 0;
	}
	
	public void addEnergy(int energy) {
		if(getEnergy() + energy <= Constants.maxEnergy){
            setEnergy(getEnergy() + energy);
        }
       else{
            setEnergy(Constants.maxEnergy);
        }
	}
	
	public void dropEnergy(int energy) {
        if(getEnergy() - energy > 0){
		    setEnergy(getEnergy() - energy);
        }
        else{
            setEnergy(0);
            setDead(true);
        }
	}

    public Vector distance(SimulationEntity se){
        int xd1 = se.getXpos() - getXpos(); 
        int xd2 = (se.getXpos() - Constants.WIDTH) - getXpos();
        
        int yd1 = se.getYpos() - getYpos();
        int yd2 = (se.getYpos() - Constants.HEIGHT) - getYpos();
        
        int xd = 0;
        int yd = 0;
        
        if (Math.abs(xd1) < Math.abs(xd2)) {
        	xd = xd1;
        } else {
        	xd = xd2;
        }     
        
        if (Math.abs(yd1) < Math.abs(yd2)) {
        	yd = yd1;
        } else {
        	yd = yd2;
        }
        	
        
        return new Vector(xd, yd);
    }

    //Do not call this directly, call the overloaded methods
    public Color getColor(){
        return new Color(255, 255, 255);
    }
    
    public boolean isPlant() {
    	return false;
    }
    public boolean isBacteria() {
    	return false;
    }
    public Genetics getGenetics() {
    	return null;
    }
    public boolean isDying() {
    	return false;
    }
}
