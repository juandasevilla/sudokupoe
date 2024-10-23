package org.example.crapsgame.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.crapsgame.model.Cell;

/**
 * Clase sudoku que se usa para manejar la lógica del juego
 * sudoku class is used to handle the logic of the game
 */

public class Sudoku {
    private List<Cell> board;
    private int[][] solution;

    /**
     * Constructor de la clase Sudoku, crea una solucion para el sudoku,la usaremos para validar
     * constructor of the class sudoku,create a solution for the game, we will use it to validate
     */
    public Sudoku() {
        solution = new int[6][6];
        generateSolution();
        printSolution();
    }

    /**
     * Metodo que usamos para validar en consola la solucion, usado para debuggear o validaciones
     * Method used to validate the solution in the console, used for debugging or validations
     */
    public void printSolution() {
        System.out.println("Generated Sudoku Solution:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *recorre filas y columnas si encuentra un 0, lo rellena con un numero aleatorio entre 1 y 6 alojado en un arraylist
     * si no encuentra un numero valido, lo reemplaza por 0 y vuelve a intentar
     * @return true si ha generado una solución valida, false si no ha podido.
     */
    private boolean generateSolution() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (solution[row][col] == 0) {
                    List<Integer> numbers = new ArrayList<>();
                    for (int i = 1; i <= 6; i++) {
                        numbers.add(i);
                    }
                    Collections.shuffle(numbers);
                    for (int number : numbers) {
                        if (isValid(row, col, number)) {
                            solution[row][col] = number;
                            if (generateSolution()) {
                                return true;
                            }
                            solution[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * obtiene el valor de la casilla en la solucion, usado para comparar
     * @param row fila
     * @param col columna
     * @return valor de la solucion
     */
    public int getSolutionValue(int row, int col) {
        return solution[row][col];
    }

    public boolean isCorrectValue(int row, int col, int value) {
        return solution[row][col] == value;
    }

    public Cell getCell(int row, int col) {
        return board.stream().filter(cell -> cell.getRow() == row && cell.getCol() == col).findFirst().orElse(null);
    }

    private boolean isValidRow(int row, int value) {
        return board.stream().filter(cell -> cell.getRow() == row).noneMatch(cell -> cell.getValue() == value);
    }

    private boolean isValidCol(int col, int value) {
        return board.stream().filter(cell -> cell.getCol() == col).noneMatch(cell -> cell.getValue() == value);
    }

    private boolean isValidBlock(int row, int col, int value) {
        int blockRow = (row / 2) * 2;
        int blockCol = (col / 3) * 3;
        return board.stream().filter(cell -> (cell.getRow() >= blockRow && cell.getRow() < blockRow + 2) &&
                (cell.getCol() >= blockCol && cell.getCol() < blockCol + 3)).noneMatch(cell -> cell.getValue() == value);
    }

    /**
     * Metodo que valida si un numero es valido en una fila, columna y bloque
     *primero itera la fila que recibe con todas las columnas o la la columna con todas las filas, si es igual false
     * luego itera el bloque de 2x3 que contiene la casilla, se divide la fila que se recibe por 2 y se multiplica por 2
     * para hallar el entero a la baja, clasificando en 3 cuadriculas las filas, si es 0 la cuadricula comienza en fila 0, 2 fila 2
     * 4 fila 4, se hace lo mismo con la columna pero se divide por 3 y se multiplica por 3, clasificando en 2 cuadriculas las columnas, donde 0, 1 y 2
     * pertenecen a la cuadricula 1 y 3 4 y 5 a la cuadricula 2
     * @param row fila
     * @param col columnna
     * @param number numero a validar
     * @return true si es valido el numero, false si no lo es
     */
    private boolean isValid(int row, int col, int number) {
        for (int i = 0; i < 6; i++) {
            if (solution[row][i] == number || solution[i][col] == number) {
                return false;
            }
        }

        int blockRow = (row / 2) * 2;
        int blockCol = (col / 3) * 3;
        for (int i = blockRow; i < blockRow + 2; i++) {
            for (int j = blockCol; j < blockCol + 3; j++) {
                if (solution[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    public void SetCellValue(int row, int col, int value) {
        getCell(row, col).setValue(value);
    }
}
