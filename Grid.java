import java.util.Scanner;

public class Grid {
    public int getXsize() {
        return xsize;
    }

    public int getYsize() {
        return ysize;
    }

    private int xsize;
    private int ysize;
    private char [][] sgrid; //przechowuje caly rysunek planszy
    private char [][] table; //przecowuje same liczby 3x3 lub inne

    public char getTable(int y, int x) {
        return this.table[y][x];
    }


    //TODO: nie moze byc 1x1 2x2 ale moze byc 2x3 lub 3x2 co konczy sie najczesciej remisem
    Grid(int xsize, int ysize){
        this.xsize = xsize;
        this.ysize = ysize;

        this.sgrid = new char[ysize+(ysize+1)][xsize*3+(xsize+1)];
        this.table = new char[ysize][xsize];

        for (int i = 0; i< ysize; i++){
            for (int j = 0; j<xsize; j++){
                table[i][j]=' ';
            }
        }

        for(int i=0;i<ysize+(ysize+1);i++) {
            for (int j = 0; j < xsize * 3 + (xsize + 1); j++) {
                if(i==0 && j==0){//poczatek
                    sgrid[i][j]= '╔';
                }
                else if(i==0 && j==(xsize*3+xsize)){
                    sgrid[i][j]= '╗';
                }
                else if(i==0 && j%4==0){
                    sgrid[i][j]= '╦';
                }
                else if(i==0){
                    sgrid[i][j]= ' ';
                }

                else if(i==(ysize+ysize) && j==0){//koniec
                    sgrid[i][j]= '╚';
                }
                else if(i==(ysize+ysize) && j==(xsize*3+xsize)){
                    sgrid[i][j]= '╝';
                }
                else if(i==(ysize+ysize) && j%4==0){
                    sgrid[i][j]= '╩';
                }
                else if(i==(ysize+ysize)){
                    sgrid[i][j]= ' ';
                }
                //else if(i%2==1 && (j<2 || j>(xsize*3+xsize)-2)){//srodek
                //    sgrid[i][j]= ' ';
                //}
                else if(i%2==1 && ((j+2)%4==0)){
                    sgrid[i][j]= ' ';
                }
                else if(i%2==1){
                    sgrid[i][j]= ' ';
                }

                else if(i%2==0 && j==0){
                    sgrid[i][j]= '╠';
                }
                else if(i%2==0 && j==(xsize*3+xsize)){
                    sgrid[i][j]= '╣';
                }
                else if(i%2==0 && j%4==0){
                    sgrid[i][j]= '╬';
                }
                else if(i%2==0){
                    sgrid[i][j]= ' ';
                }
            }
        }


    }

    public void initPrint(){
        for(int i=0;i<ysize+(ysize+1);i++) {
            for (int j = 0; j < xsize * 3 + (xsize + 1); j++) {
                System.out.print(sgrid[i][j]);
            }
            System.out.println();
        }
    }
    public void setMark(int x, int y, char mark){
       this.table[y][x]=mark;
       buildSgrid();
    }
    public void buildSgrid(){
        int k=0;
        int w=0;
        for(int i=0;i<ysize+(ysize+1);i++) {
            for (int j = 0; j < xsize * 3 + (xsize + 1); j++) {
                if(i%2==1 && ((j+2)%4==0)){
                    sgrid[i][j]= table[w][k];
                    k++;
                    if(k==xsize){
                        k=0;
                        w++;
                    }
                }
            }
        }
    }
}
