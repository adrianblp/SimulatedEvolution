import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Start {

    public static void main(String[] args) {

        Simulation sim;
        MainCanvas canvas;

        //Make static or something
        final int WIDTH = 250;
        final int HEIGHT = 150;
        final int scale = 4; //We need to bump up internal resolution so everything is not just one pixel

        final JFrame myFrame = new JFrame("Evolution"); //title

        myFrame.setSize(new Dimension(WIDTH * scale, HEIGHT * scale + 22)); //+22?
        myFrame.setVisible(true);
        myFrame.setResizable(false);
        //myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
        //myFrame.setUndecorated(true); //noborder
        initWindowClose(myFrame);

        sim = new Simulation(WIDTH, HEIGHT);
        canvas = new MainCanvas(WIDTH * scale, HEIGHT * scale);
        canvas.setSimulation(sim);
        myFrame.add("Center", canvas);

        //Simulation loop
        while(true){
            sim.run();
            canvas.update(canvas.getGraphics());
        }

    }

    //Enables the user to exit the program by pressing escape
    public static void initWindowClose(JFrame myFrame){

        Action escapeAction = new AbstractAction() {
            // close the frame when the user presses escape
            @Override
            public void actionPerformed(ActionEvent e) {
                //myFrame.dispose();
                System.exit(0);
            }
        };

        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        myFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        myFrame.getRootPane().getActionMap().put("ESCAPE", escapeAction);

    }
}
