package org.example.crapsgame.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.crapsgame.model.Sudoku;
import org.example.crapsgame.view.alert.AlertBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * controlador del sudoku, se crea un objeto sudoku, random y las cell
 */
public class SudokuController {
    @FXML
    private TextField cell00;
    @FXML
    private TextField cell01;
    @FXML
    private TextField cell02;
    @FXML
    private TextField cell03;
    @FXML
    private TextField cell04;
    @FXML
    private TextField cell05;
    @FXML
    private TextField cell06;
    @FXML
    private TextField cell07;
    @FXML
    private TextField cell08;
    @FXML
    private TextField cell09;
    @FXML
    private TextField cell10;
    @FXML
    private TextField cell11;
    @FXML
    private TextField cell12;
    @FXML
    private TextField cell13;
    @FXML
    private TextField cell14;
    @FXML
    private TextField cell15;
    @FXML
    private TextField cell16;
    @FXML
    private TextField cell17;
    @FXML
    private TextField cell18;
    @FXML
    private TextField cell19;
    @FXML
    private TextField cell20;
    @FXML
    private TextField cell21;
    @FXML
    private TextField cell22;
    @FXML
    private TextField cell23;
    @FXML
    private TextField cell24;
    @FXML
    private TextField cell25;
    @FXML
    private TextField cell26;
    @FXML
    private TextField cell27;
    @FXML
    private TextField cell28;
    @FXML
    private TextField cell29;
    @FXML
    private TextField cell30;
    @FXML
    private TextField cell31;
    @FXML
    private TextField cell32;
    @FXML
    private TextField cell33;
    @FXML
    private TextField cell34;
    @FXML
    private TextField cell35;
    @FXML
    private Label helpLabel;

    private int helpCount = 0;

    private Random random = new Random();

    private Sudoku sudoku;

    /**
     * Constructor de la clase SudokuController, crea un objeto sudoku
     */
    public SudokuController() {
        sudoku = new Sudoku();
    }

    /**
     * Metodo que se encarga de validar si el numero ingresado es correcto o no
     * usa un listener que recibe el valor del textfield, la fila y la colummna, si no esta entre
     * 1 y 6 no deja ingresar el numero, lo compara con la solucion y lo marca verde para indicar al usuario
     * si no es igual, se marca en rojo
     * @param textField textfield
     * @param row fila
     * @param col columna
     */
    private void setupTextField(TextField textField, int row, int col) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[1-6]")) {
                textField.setText("");
                textField.setStyle("");
            } else {
                int value = Integer.parseInt(newValue);
                if (sudoku.getSolutionValue(row, col) == value) {
                    textField.setStyle("-fx-text-fill: green;");
                    if (winGame()) {
                        AlertBox alertBox = new AlertBox();
                        alertBox.showMessage("Felicidades", "Ganaste", "Has completado el sudoku correctamente.");
                    }
                } else {
                    textField.setStyle("-fx-text-fill: red;");
                    AlertBox alertBox = new AlertBox();
                    alertBox.showMessage("Error", "Número incorrecto", "El número ingresado es incorrecto, no puede estar en la misma colummna,fila o cuadricula.");

                }
            }
        });
    }

    /**
     * Metodo que se encarga de inicializar los textfields y asignarles celdas
     */
    @FXML
    private void initialize() {
        setupTextField(cell00, 0, 0);
        setupTextField(cell01, 0, 1);
        setupTextField(cell02, 0, 2);
        setupTextField(cell03, 0, 3);
        setupTextField(cell04, 0, 4);
        setupTextField(cell05, 0, 5);

        setupTextField(cell06, 1, 0);
        setupTextField(cell07, 1, 1);
        setupTextField(cell08, 1, 2);
        setupTextField(cell09, 1, 3);
        setupTextField(cell10, 1, 4);
        setupTextField(cell11, 1, 5);

        setupTextField(cell12, 2, 0);
        setupTextField(cell13, 2, 1);
        setupTextField(cell14, 2, 2);
        setupTextField(cell15, 2, 3);
        setupTextField(cell16, 2, 4);
        setupTextField(cell17, 2, 5);

        setupTextField(cell18, 3, 0);
        setupTextField(cell19, 3, 1);
        setupTextField(cell20, 3, 2);
        setupTextField(cell21, 3, 3);
        setupTextField(cell22, 3, 4);
        setupTextField(cell23, 3, 5);

        setupTextField(cell24, 4, 0);
        setupTextField(cell25, 4, 1);
        setupTextField(cell26, 4, 2);
        setupTextField(cell27, 4, 3);
        setupTextField(cell28, 4, 4);
        setupTextField(cell29, 4, 5);

        setupTextField(cell30, 5, 0);
        setupTextField(cell31, 5, 1);
        setupTextField(cell32, 5, 2);
        setupTextField(cell33, 5, 3);
        setupTextField(cell34, 5, 4);
        setupTextField(cell35, 5, 5);

    }

    /**
     * Metodo que se encarga de limpiar el tablero
     */
    public void resetBoard(){
        cell00.clear();
        cell01.clear();
        cell02.clear();
        cell03.clear();
        cell04.clear();
        cell05.clear();

        cell06.clear();
        cell07.clear();
        cell08.clear();
        cell09.clear();
        cell10.clear();
        cell11.clear();

        cell12.clear();
        cell13.clear();
        cell14.clear();
        cell15.clear();
        cell16.clear();
        cell17.clear();

        cell18.clear();
        cell19.clear();
        cell20.clear();
        cell21.clear();
        cell22.clear();
        cell23.clear();

        cell24.clear();
        cell25.clear();
        cell26.clear();
        cell27.clear();
        cell28.clear();
        cell29.clear();

        cell30.clear();
        cell31.clear();
        cell32.clear();
        cell33.clear();
        cell34.clear();
        cell35.clear();
    }

    /**
     * Metodo que se encarga de mostrar una pista al usuario
     *recorre los cells para buscar los vacios y añadirlos al arraylist,
     * adquire una celda de estas vacias, con el grid pane se obtiene el index
     * de su fila y columna, si es null se recorre la matriz de textfields para encontrar la celda
     * si no es null se obtiene el valor correcto de la solucion y se asigna a la celda
     */
    @FXML
    public void showHint() {
        List<TextField> emptyCells = new ArrayList<>();
        TextField[][] cells = {
                {cell00, cell01, cell02, cell03, cell04, cell05},
                {cell06, cell07, cell08, cell09, cell10, cell11},
                {cell12, cell13, cell14, cell15, cell16, cell17},
                {cell18, cell19, cell20, cell21, cell22, cell23},
                {cell24, cell25, cell26, cell27, cell28, cell29},
                {cell30, cell31, cell32, cell33, cell34, cell35}
        };

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (cells[i][j].getText().isEmpty()) {
                    emptyCells.add(cells[i][j]);
                }
            }
        }

        if (!emptyCells.isEmpty()) {
            TextField randomCell = emptyCells.get(random.nextInt(emptyCells.size()));
            Integer row = GridPane.getRowIndex(randomCell);
            Integer col = GridPane.getColumnIndex(randomCell);


            if (row == null || col == null) {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (cells[i][j] == randomCell) {
                            row = i;
                            col = j;
                            break;
                        }
                    }
                }
            }

            if (row != null && col != null) {
                int correctValue = sudoku.getSolutionValue(row, col);
                randomCell.setText(String.valueOf(correctValue));
                randomCell.setStyle("-fx-text-fill: blue;");
            }
        }
    }

    /**
     * metodo para mostrar dos numeros aletaorios en un bloque, variable contadora de maximo 2
     * mientras no se hayan mostrado los dos numeros, se obtiene una fila y columna aleatoria
     * si la celda esta vacia se le asigna el valor de la solucion y se incrementa la variable contadora
     * @param blockRow
     * @param blockCol
     * @param cells
     */
    private void showTwoNumbersInBlock(int blockRow, int blockCol, TextField[][] cells) {
        int count = 0;
        while (count < 2) {
            int row = blockRow + random.nextInt(2);
            int col = blockCol + random.nextInt(3);
            if (cells[row][col].getText().isEmpty()) {
                cells[row][col].setText(String.valueOf(sudoku.getSolutionValue(row, col)));
                count++;
            }
        }
    }

    /**
     * Metodo que se encarga de mostrar dos numeros en cada bloque
     * se crea una matriz de textfields y se recorre la matriz de textfields
     * se llama a la funcion showTwoNumbersInBlock, se suma de a 2 por que cada dos
     * filas cambia la cuadricula en las columnas de a 3 por que cada 3 cambia de cuadricula
     */
    private void showTwoNumbersInEachBlock() {
        TextField[][] cells = {
                {cell00, cell01, cell02, cell03, cell04, cell05},
                {cell06, cell07, cell08, cell09, cell10, cell11},
                {cell12, cell13, cell14, cell15, cell16, cell17},
                {cell18, cell19, cell20, cell21, cell22, cell23},
                {cell24, cell25, cell26, cell27, cell28, cell29},
                {cell30, cell31, cell32, cell33, cell34, cell35}
        };

        for (int blockRow = 0; blockRow < 6; blockRow += 2) {
            for (int blockCol = 0; blockCol < 6; blockCol += 3) {
                showTwoNumbersInBlock(blockRow, blockCol, cells);
            }
        }
    }

    /**
     * Metodo que se encarga de iniciar un nuevo juego
     * confirma al usuario despues del evento de mouse, si el usuario confirma se limpia el tablero
     * y se construye un nuevo objeto sudoku
     * @param event
     */
    @FXML
    public void handleNewGame(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Nuevo Juego");
        alert.setHeaderText("Confirmación de nuevo juego");
        alert.setContentText("¿Estás seguro de que deseas iniciar un nuevo juego?");


        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                sudoku = new Sudoku();
                resetBoard();
                showTwoNumbersInEachBlock();
            }
        });

    }

    /**
     * Metodo que se encarga de mostrar la ayuda al usuario, llama la funcion showhint
     * @param event
     * @throws IllegalAccessException
     */
    @FXML
    public void handleHelp(ActionEvent event) throws IllegalAccessException {
        if (isLeft()) {
            AlertBox alertBox = new AlertBox();
            alertBox.showMessage("Ayuda", "Ayuda", "No hay más pistas disponibles.");

        } else {
            showHint();
            helpCount++;
            helpLabel.setText("Ayudas: " + helpCount);
        }

    }

    /**
     * Metodo que se encarga de mostrar las instrucciones al usuario
     * @param event
     */
    @FXML
    public void instructions(ActionEvent event) {
        AlertBox alertBox = new AlertBox();
        alertBox.showMessage("Instrucciones", "Instrucciones del juego", "El objetivo del juego es rellenar las casillas vacías con un número del 1 al 6, de tal manera que en cada fila, columna y cuadrícula de 2x3 no se repitan los números." +
                "Para empezar un nuevo juego, presiona el botón 'Nuevo Juego'. Si necesitas ayuda, presiona el botón 'Ayuda'. Si se torna verde es número correcto, si se torna rojo es incorrecto y si se torna azul es una pista.Diviertete.");

    }

    /**
     * Metodo que se encarga de cerrar el juego, compara cada celda
     * con la solucion, si hay alguna vacia o diferente a la solucion retorna false
     *
     */
    private boolean winGame() {
        TextField[][] cells = {
                {cell00, cell01, cell02, cell03, cell04, cell05},
                {cell06, cell07, cell08, cell09, cell10, cell11},
                {cell12, cell13, cell14, cell15, cell16, cell17},
                {cell18, cell19, cell20, cell21, cell22, cell23},
                {cell24, cell25, cell26, cell27, cell28, cell29},
                {cell30, cell31, cell32, cell33, cell34, cell35}
        };

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String text = cells[i][j].getText();
                if (text.isEmpty() || Integer.parseInt(text) != sudoku.getSolutionValue(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que se encarga de verificar si hay una celda vacia en el tablero y las demas estan
     * correctas, es para limitar la ultima ayuda
     * se usa el acumulador emptycount, se itera para encontrar los vacios y sumar
     * si hay un vacio y los demas estan correctos retorna true
     * @return
     */
    private boolean isLeft() {
        TextField[][] cells = {
                {cell00, cell01, cell02, cell03, cell04, cell05},
                {cell06, cell07, cell08, cell09, cell10, cell11},
                {cell12, cell13, cell14, cell15, cell16, cell17},
                {cell18, cell19, cell20, cell21, cell22, cell23},
                {cell24, cell25, cell26, cell27, cell28, cell29},
                {cell30, cell31, cell32, cell33, cell34, cell35}
        };

        int emptyCount = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String text = cells[i][j].getText();
                if (text.isEmpty()) {
                    emptyCount++;
                } else if (Integer.parseInt(text) != sudoku.getSolutionValue(i, j)) {
                    return false;
                }
            }
        }
        return emptyCount == 1;
    }

}

