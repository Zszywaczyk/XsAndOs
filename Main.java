import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        InitGame initGame = new InitGame();
        Grid grid = new Grid(initGame.getXsize(),initGame.getYsize());
        IsWinner isWinner = new IsWinner(initGame.getHowMannyWin());


        char []mark=(Math.random()<0.5? new char[]{'x', 'o'} : new char[]{'o', 'x'});
        System.out.println("And play as: "+mark[0]);
        Computer computer;
        Player player;

        if (initGame.isComputerTurn()){
            computer = new Computer(mark[0],"Computer", initGame.getComputerLevel());
            player = new Player(mark[1], "Human");
        }
        else {
            computer = new Computer(mark[1], "Computer", initGame.getComputerLevel());
            player = new Player(mark[0], "Human");
        }

        System.out.print("Press any key...");
        System.in.read();



        while (true){
            if (initGame.isComputerTurn()){
                //cos dla komputera
                computer.move(grid);
                initGame.setComputerTurn(false);
            }
            grid.initPrint();
            isWinner.check4winner(grid, computer.getMark(), computer.getName());
            if(!initGame.isComputerTurn()){
                //cos dla gracza
                player.move(grid);
                initGame.setComputerTurn(true);
            }
            grid.initPrint();
            isWinner.check4winner(grid, player.getMark(), player.getName());
        }



    }



}
