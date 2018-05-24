import java.util.InputMismatchException;
import java.util.Scanner;
//TODO przerzucic wczytywywanie z klawiatury
public class InitGame {
    private Scanner in = new Scanner(System.in);
    private int computerLevel;
    private boolean isComputerTurn;
    private int xsize;
    private int ysize;
    private int howMannyWin;
    InitGame(){
        setComputerLevel();
        setHowMannyWin();
        colRow();
        whoFirst();
    }
    private void setComputerLevel(){
        boolean isGoodInput=false;
        while (!isGoodInput) {
            try {
                System.out.print("Choice Level(1-2): ");
                this.computerLevel = in.nextInt();
                if (this.computerLevel == 1 || this.computerLevel == 2) {
                    isGoodInput=true;
                }
                else {
                    System.out.println("Wrong number");
                }
            } catch (InputMismatchException e){
                System.err.println("\nIncorrect Input, try again");
                in.nextLine();
                System.out.println("Choice Level Again(1-2): ");
            }
        }

    }
    private void whoFirst(){
        System.out.println("Random coin says:");
        boolean computerFirst = (Math.random() < 0.5);

        if (computerFirst){
            System.out.println("Computer first!");
            this.isComputerTurn=true;
        }
        else{
            System.out.println("Human first!");
            this.isComputerTurn=false;
        }
    }
    private void colRow(){
        boolean isGoodInput=false;
        while (!isGoodInput) {
            try {
                System.out.println("One can't be less then How mark to Win");
                System.out.print("Ile kolumn(2-8): ");
                this.xsize = in.nextInt();
                System.out.print("Ile wierszy(2-8): ");
                this.ysize = in.nextInt();
                if((this.xsize>=howMannyWin || this.ysize>=howMannyWin) && (this.xsize>=2 && this.ysize>=2) && (this.xsize<=8 && this.ysize<=8)){
                    isGoodInput=true;
                }
                else {
                    System.out.println("Wrong number");
                }
            }
            catch(InputMismatchException e){
                System.err.println("\nIncorrect Input, try again");
                in.nextLine();
                System.out.println("Ile kolumn: ");
            }
        }
    }
    public void setHowMannyWin() {
        boolean isGoodInput=false;
        while (!isGoodInput) {
            try {
                System.out.print("How many Mark to win(3-7): ");
                this.howMannyWin = in.nextInt();
                if(this.howMannyWin>=3 && this.howMannyWin<=7){
                    isGoodInput=true;
                }
                else {
                    System.out.println("Wrong number");
                }
            }
            catch(InputMismatchException e){
                System.err.println("\nIncorrect Input, try again");
                in.nextLine();
                System.out.println("Ile kolumn: ");
            }
        }
    }
    public int getHowMannyWin() {
        return howMannyWin;
    }
    public int getComputerLevel() {
        return computerLevel;
    }
    public void setComputerTurn(boolean computerTurn) {
        isComputerTurn = computerTurn;
    }
    public boolean isComputerTurn() {
        return isComputerTurn;
    }
    public int getXsize() {
        return xsize;
    }
    public int getYsize() {
        return ysize;
    }

}
