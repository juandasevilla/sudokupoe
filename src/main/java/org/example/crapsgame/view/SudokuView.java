package org.example.crapsgame.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.crapsgame.controller.SudokuController;

import java.io.IOException;

public class SudokuView extends Stage {
    private SudokuController sudokuController;

    public SudokuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/crapsgame/prueba2.fxml"));
        Parent root = loader.load();
        sudokuController = loader.getController();
        Scene scene = new Scene(root);
        setTitle("Sudoku");
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/org/example/crapsgame/images/sudoku.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }

    public SudokuController getSudokuController() {return sudokuController;}

    public static SudokuView getInstance()throws IOException {
        return SudokuViewHolder.INSTANCE = new SudokuView();
    }

    public static void deleteInstance() {
        SudokuView.SudokuViewHolder.INSTANCE.close();
        SudokuView.SudokuViewHolder.INSTANCE = null;
    }

    private static class SudokuViewHolder {
        private static SudokuView INSTANCE;
    }


}
