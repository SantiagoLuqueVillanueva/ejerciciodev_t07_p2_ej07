public class App {
    public static void main(String[] args) throws Exception {
        String[][] board = new String[5][4];

        int deathRow = (int)(Math.random()) * 6;
        int deathColumn = (int)(Math.random()) * 5;

        board[deathRow][deathColumn] = "*";

        boolean correctPos = false;
        int row = 0;
        int column = 0;

        do {
            row = Integer.parseInt(System.console().readLine("Cordenada x: "));
            column = Integer.parseInt(System.console().readLine("Cordenada y: "));

            if (board[row][column].equals("*")) {
                System.out.println("Has perdido");
                correctPos = true;
            } else {
                board[row][column] = "X";
            } 
        } while (correctPos);
    }
}
