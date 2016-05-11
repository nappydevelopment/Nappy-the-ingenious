package nappydevelopment.nappyTheIngenious.util.eastereggs;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Marc on 11.05.2016.
 */
public class NelsonFrame extends JFrame{

    private int counter;

    public static void createNewNelson(){
        new NelsonFrame(1);
    }

    NelsonFrame(int timesOpened){
        super();
        this.counter = timesOpened;
        this.setTitle("HAHA");
        this.setSize(300, 300);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                exitForm();
            }
        });
        this.setVisible(true);
    }

    private void exitForm() {
        if(counter < 3) {
            new NelsonFrame(counter + 1);
            new NelsonFrame(counter + 1);
        }
        this.dispose();
    }
}