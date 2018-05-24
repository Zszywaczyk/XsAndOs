public class Computer extends Player{
    private int level;

    Computer(char mark, String name, int level){
        super(mark,name);
        this.level=level;
    }

    @Override
    public void move(Grid grid) {
        if(level==1){
            lvl1(grid);
        }
        else if(level==2){
            lvl2(grid);
        }
        else if(level==3){
            lvl3(grid);
        }
        else{}
    }
    private void lvl1(Grid grid){
        //po kolei
        boolean chosed =false;
        for (int y=0;y<grid.getYsize();y++){
            for (int x=0;x<grid.getXsize();x++){
                if (grid.getTable(y,x)==' '){
                    grid.setMark(x,y,super.mark);
                    chosed=true;
                    break;
                }
            }
            if(chosed){break;}
        }
    }
    private void lvl2(Grid grid){
        //random
        boolean chosed =false;
        int x;
        int y;
        while (!chosed) {
            x = (int)Math.round(Math.random()*(grid.getXsize()-1));
            y = (int)Math.round(Math.random()*(grid.getYsize()-1));
            System.out.println(x);
            if (grid.getTable(y, x) == ' ') {
                grid.setMark(x, y, super.mark);
                chosed = true;
            }
        }
    }
    private void lvl3(Grid grid){

    }
}
