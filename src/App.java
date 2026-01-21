public class App {
    public static void main(String[] args) throws Exception {
        String[][] board = new String[5][4];

        int treasureRow = (int)(Math.random() * 5);
        int treasureColumn = (int)(Math.random() * 4);

        int mineRow = (int)(Math.random() * 5);
        int mineColumn = (int)(Math.random() * 4);

        boolean win = false;

        do {
            int playerRow = Integer.parseInt(System.console().readLine("Coordenada x: "));
            int playerColumn = Integer.parseInt(System.console().readLine("Coordenada y: "));

            if ((playerRow == treasureRow) && (playerColumn == treasureColumn)) {
                board[treasureRow][treasureColumn] = "*";
                System.out.println("¡GANASTE!");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        String cell = board[i][j];
                        if (cell == null) {
                            cell = " "; 
                        }
                        System.out.printf("%5s", cell);
                    }
                    System.out.println();
                }
                win = true;
            } else if ((playerRow == mineRow) && (playerColumn == mineColumn)){
                board[playerRow][playerColumn] = "&";
                System.out.println("Has perdido");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        String cell = board[i][j];
                        if (cell == null) {
                            cell = " "; 
                        }
                        System.out.printf("%5s", cell);
                    }
                    System.out.println();
                }
                win = true;
            }
            else{
                board[playerRow][playerColumn] = "X";
                System.out.println("Sigue intentándolo");

                int distFila = Math.abs(playerRow - mineRow);
                int distColumna = Math.abs(playerColumn - mineColumn);

                if (distFila <= 1 && distColumna <= 1) {
                    System.out.println("¡CUIDADO! ¡Hay una mina muy cerca!");
                }
                
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        String cell = board[i][j];
                        if (cell == null) {
                            cell = " "; 
                        }
                        System.out.printf("%5s", cell);
                    }
                    System.out.println();
                }
            }
        } while (!win);
    }
}
