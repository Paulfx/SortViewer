import SortAlgorithm.SortAlgorithm;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class SortAlgoViewer extends Canvas {

    final Color columnColor = Color.GRAY;
    final Color selectedColumnColor = Color.BLACK;

    private double width, height;
    private SortAlgorithm algorithm;
    private double columnWidth;

    private GraphicsContext gc;

    public SortAlgoViewer(double width, double height) {
        super(width, height);
        this.width = width;
        this.height = height;

        gc = this.getGraphicsContext2D();
    }

    public void display() {
        if (algorithm != null) {
            gc.setFill(Color.WHITE);
            gc.clearRect(0, 0, width, height);
            int[] sortingList = algorithm.getList();
            List<Integer> currentIndex = algorithm.getCurrentIndex();
            int value;
            Color color;
            for (int elemIndex = 0; elemIndex < sortingList.length; elemIndex++) {
                value = sortingList[elemIndex];
                color = currentIndex.contains(elemIndex) ? selectedColumnColor : columnColor;
                drawRectangle(gc, elemIndex * columnWidth, height - getHeightColumn(value), columnWidth, getHeightColumn(value), color);

            }
        }
    }

    private double getHeightColumn(int value) {
        return ((double) value / 100) * height;
    }

    private void drawRectangle(GraphicsContext gc, double x, double y, double width, double height, Color color){
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }

    public void setAlgorithm(SortAlgorithm algorithm) {
        this.algorithm = algorithm;
        columnWidth = width / algorithm.getNumberElements();
    }
}
