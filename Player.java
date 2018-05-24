import java.util.Scanner;

public class Player {
    private String name;
    protected char mark;
    public String getName() {
        return name;
    }
    public char getMark() {
        return mark;
    }
    protected Player( char mark, String name){
        this.mark=mark;
        this.name=name;
    }
    public void move(Grid grid){
        Scanner in = new Scanner(System.in);
        boolean good= false;
        boolean done=false;
        int y=0;
        int x=0;
        //ctrl shift T
        //shift+F6 refaktoryzacja

        while(!done) {
            while (!good) {
                System.out.println("Row: ");
                y = in.nextInt();
                if (grid.getYsize() > y) {
                    good = true;
                }
            }
            good = false;
            while (!good) {
                System.out.println("Column: ");
                x = in.nextInt();
                if (grid.getXsize() > x) {
                    good = true;
                }
            }
            good = false;
            if (grid.getTable(y,x) == ' ') {
                done = true;
            }
        }
        grid.setMark(x,y,mark);
    }
}
