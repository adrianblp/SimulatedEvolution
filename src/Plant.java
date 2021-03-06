import java.awt.Color;
import java.util.Random;

public class Plant extends SimulationEntity {

    private Random rand;
    private Color color;
    
    public Plant() {
    	rand = new Random();
    	color = new Color(0, 255, 0);

    	this.setEnergy(Constants.plantEnergy);
        setDead(false);
    	spawn();
    }
	
    private void spawn() {
        int value = rand.nextInt(Constants.WIDTH);
        setXpos(value);

        value = rand.nextInt(Constants.HEIGHT);
        setYpos(value);
    }

	public Color getColor() {
		return color;
	}
	
	public boolean isPlant() {
		return true;
	}
	
	
    public void remove(){
    	rand = null;
    	color = null;
    }
}
