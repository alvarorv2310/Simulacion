package simulation;

import models.shapes.Figure;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

public class SimulationManager {
    private List<Animation> animations = new ArrayList<>();

    public void addFigure(Figure figure, JPanel panel) {
        animations.add(new Animation(figure, panel));
    }

    public void startAll() {
        for (Animation a : animations) a.start();
    }

    public void stopAll() {
        for (Animation a : animations) a.stop();
    }
}

