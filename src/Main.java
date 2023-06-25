import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Board testBoard = new Board();
        testBoard.printBoard();
        Scanner scanner = new Scanner(System.in);
        int plateNum , blockNum ;
        boolean endGame = false;
        char presentPlayerColor ;
        int turnCounter = 0;
        while(!endGame){
            if(turnCounter % 2 == 0){
                System.out.println("Red's turn");
                    presentPlayerColor = 'r';
            }
            else{
                System.out.println("Blue's turn");
                    presentPlayerColor = 'b';
            }
            System.out.println("Enter plate number");
            plateNum = scanner.nextInt();
            System.out.println("Enter block number");
            blockNum = scanner.nextInt();
            while(!testBoard.putDisk(plateNum,blockNum,presentPlayerColor)){
                System.out.println("invalid block");
            }
            testBoard.putDisk(plateNum, blockNum, presentPlayerColor);
            int rotateNum = -1;
            while(rotateNum == -1) {
                System.out.println("Enter plate number to rotate(Enter 0 to pass if it's valid)");
                rotateNum = scanner.nextInt();
                System.out.println(testBoard.centralSymmetryCheck());
                if (rotateNum == 0)
                    if (!testBoard.centralSymmetryCheck()) {
                        System.out.println("invalid pass");
                        rotateNum = -1;
                    }
            }
            testBoard.plateRotater(rotateNum);
            testBoard.printBoard();
            endGame = testBoard.checkWin();
            turnCounter++;
        }
    }
}
