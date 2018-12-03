import SortAlgorithm.SortAlgorithm;
import javafx.animation.AnimationTimer;

public class Controller {


    private SortAlgorithm algorithm;
    private SortAlgoViewer viewer;
    private AnimationTimer timer;

    public Controller(SortAlgoViewer viewer) {
        this.viewer = viewer;

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                viewer.display();
            }
        };
    }

    public void setAlgorithm(SortAlgorithm algorithm) {
        this.algorithm = algorithm;
        viewer.setAlgorithm(algorithm);
        algorithm.start();
    }

    public void startTimer() {
        timer.start();
    }



}
