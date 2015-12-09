import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Board {
    Piece red;
    ArrayList<Piece> pieces;
    int dim_x,dim_y,dim_z;

    public Board(int dim_x, int dim_y, int dim_z) {
        this.dim_x = dim_x;
        this.dim_y = dim_y;
        this.dim_z = dim_z;
        pieces = new ArrayList<>();
    }
    static Board load(String s){
        try{
            Scanner in = new Scanner(new File(s));
            Board b = new Board(in.nextInt(),in.nextInt(),in.nextInt());
            in.nextLine();
            while(in.hasNext()){
                Piece p = new Piece(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
                b.pieces.add(p);
            }
            return b;

        }
        catch(Exception e){
            return null;
        }
    }
    boolean checkValidConfiguration(){
        boolean[][][] v = new boolean[dim_x][dim_y][dim_z];
        for(Piece p:pieces)
            for(int x=p.x;x<=p.x+p.s_x;x++)
                for(int y=p.y;y<=p.y+p.s_y;y++)
                    for(int z=p.z;z<=p.z+p.s_z;z++){
                        if(x<0||y<0||z<0||x>=dim_x||y>=dim_y||z>=dim_z||v[x][y][z])
                            return false;
                        else
                            v[x][y][z]=true;
                    }
        return true;
    }

    void printPieces(){
        for(Piece p:pieces){
            System.out.println(p);
        }
    }

}
