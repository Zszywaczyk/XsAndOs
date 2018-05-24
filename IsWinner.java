import java.io.IOException;

public class IsWinner {
    private Grid grid;
    private int howMannyWin=3;
    private char mark;

    IsWinner(int howMannyWin){
        this.howMannyWin=howMannyWin;
    }

    public void check4winner(Grid grid, char mark, String name) throws IOException {
        this.grid = grid;
        this.mark = mark;
        if(checkDiag() || checkHor() || checkVer() || checkBackDiag()){
            System.out.println("We have a Winner: "+name);
            System.in.read();
            System.exit(0);
        }
        else if(isDraw()){
            System.out.println("No winner! Draw");
            System.in.read();
            System.exit(0);
        }
    }
    private boolean checkHor(){
        int c=0;
        for (int y=0;y<grid.getYsize();y++){
            for (int x=0;x<grid.getXsize();x++){
                if(grid.getTable(y,x)==mark){
                    c++;
                }
                if(grid.getTable(y,x)!=mark){
                    c=0;
                }
                if(c==howMannyWin){
                    return true;
                }

            }
            c=0;
        }
        return false;
    }
    private boolean checkVer(){
        int c=0;
        for (int x=0;x<grid.getXsize();x++){
            for (int y=0;y<grid.getYsize();y++){
                if(grid.getTable(y,x)==mark){
                    c++;
                }
                if(grid.getTable(y,x)!=mark){
                    c=0;
                }
                if(c==howMannyWin){
                    return true;
                }
            }
            c=0;
        }
        return false;
    }
    private boolean checkDiag(){
        int c=0;
        int d=0;
        //for(int i=0;i<grid.getYsize();i++){
        for(int y=0;y<grid.getYsize();y++) {
            int xx=0;
            int yy=y;
            for (int i = 0; i <= d; i++) {
                //System.out.println("[" + yy + "]" + "[" + xx + "]");
                if(grid.getTable(yy,xx)==mark){
                    c++;
                }
                if(grid.getTable(yy,xx)!=mark){
                    c=0;
                }
                if(c==howMannyWin){
                    return true;
                }
                if(yy-1!=-1) {
                    yy--;
                }
                if (xx+1<grid.getXsize()){
                    xx++;
                }
            }
            //System.out.println();
            c=0;
            if(d!=(grid.getXsize()>grid.getYsize()?grid.getYsize()-1:grid.getXsize()-1)){
                d++;
            }
        }
        //===================
        boolean check=true;
        d=(grid.getXsize()>grid.getYsize()?grid.getYsize()-1:grid.getXsize()-1);//2
        for(int x=1;check;) {//true
            int xx=x;//1
            int yy=grid.getYsize()-1;//2
            for (int i = 0; i <=d; i++) {//2
                if(xx==grid.getXsize()){
                    break;
                }
                if(grid.getTable(yy,xx)==mark){
                    c++;
                }
                if(grid.getTable(yy,xx)!=mark){
                    c=0;
                }
                if(c==howMannyWin){
                    return true;
                }
                //System.out.println(d+"[" + yy + "]" + "[" + xx + "]");
                yy--;
                xx++;
            }
            //System.out.println();
            if(xx==grid.getXsize()){
                d--;
                if(x!=grid.getXsize()-1){
                    x++;
                }
            }
            else{
                x++;
            }
            if(d==-1){
                check=false;
            }
        }
        return false;
    }
    private boolean checkBackDiag(){
        int c=0;
        int d=0;
        //for(int i=0;i<grid.getYsize();i++){
        for(int y=0;y<grid.getYsize();y++) {
            int xx=grid.getXsize()-1;
            int yy=y;
            for (int i = 0; i <= d; i++) {
                //System.out.println("[" + yy + "]" + "[" + xx + "]");
                if(grid.getTable(yy,xx)==mark){
                    c++;
                }
                if(grid.getTable(yy,xx)!=mark){
                    c=0;
                }
                if(c==howMannyWin){
                    return true;
                }
                if(yy-1!=-1) {
                    yy--;
                }
                if (xx!=0){
                    xx--;
                }
            }
            //System.out.println();
            c=0;
            if(d!=(grid.getXsize()>grid.getYsize()?grid.getYsize()-1:grid.getXsize()-1)){
                d++;
            }
        }
        //===================
        boolean check=true;
        d=(grid.getXsize()>grid.getYsize()?grid.getYsize()-1:grid.getXsize()-1);//2
        for(int x=grid.getXsize()-2;check;) {//true
            int xx=x;//1
            int yy=grid.getYsize()-1;//2
            for (int i = 0; i <=d; i++) {//2
                if(xx==-1){
                    break;
                }
                if(grid.getTable(yy,xx)==mark){
                    c++;
                }
                if(grid.getTable(yy,xx)!=mark){
                    c=0;
                }
                if(c==howMannyWin){
                    return true;
                }
                //System.out.println(d+"[" + yy + "]" + "[" + xx + "]");
                yy--;
                xx--;
            }
            //System.out.println();
            if(xx==-1){
                d--;
                if(x!=0){
                    x--;
                }
            }
            else{
                x--;
            }
            if(d==-1){
                check=false;
            }
        }
        return false;
    }
    private boolean isDraw(){
        for (int y=0;y<grid.getYsize();y++) {
            for (int x = 0; x < grid.getXsize(); x++) {
                if(grid.getTable(y,x)==' '){
                    return false;
                }
            }
        }
        return true;
    }

}
