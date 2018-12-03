import SortAlgorithm.BubbleSort;
import SortAlgorithm.InsertSort;
import SortAlgorithm.MergeSort;
import SortAlgorithm.QuickSort;
import com.sun.scenario.effect.Merge;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        int nbElem = 100000;

        SortAlgoViewer viewer = new SortAlgoViewer(1600, 900);
        Controller c = new Controller(viewer);


        InsertSort insertSort = new InsertSort(nbElem);
        //c.setAlgorithm(insertSort);

        BubbleSort bubbleSort = new BubbleSort(nbElem);
        //c.setAlgorithm(bubbleSort);

        QuickSort quickSort = new QuickSort(nbElem);

        MergeSort mergeSort = new MergeSort(nbElem);

        HBox hbox = new HBox();

        Button btnInsert = new Button("Tri par insertion");
        Button btnBulle = new Button("Tri à bulles");
        Button btnQuickSort = new Button("Tri rapide");
        Button btnMergeSort = new Button("Tri fusion");

        btnInsert.setOnAction(event -> {
            c.setAlgorithm(insertSort);
        });

        btnBulle.setOnAction(event -> {
            c.setAlgorithm(bubbleSort);
        });

        btnQuickSort.setOnAction(event -> {
            c.setAlgorithm(quickSort);
        });

        btnMergeSort.setOnAction(event -> {
            c.setAlgorithm(mergeSort);
        });

        hbox.getChildren().addAll(btnBulle, btnInsert, btnQuickSort, btnMergeSort);

        Group root = new Group();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hbox, viewer);
        root.getChildren().add(vBox);

        primaryStage.setTitle("SortViewer");
        primaryStage.setScene(new Scene(root, 1600, 1000));
        primaryStage.show();

        c.startTimer();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
