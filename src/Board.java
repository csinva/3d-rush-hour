import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Board {
    ArrayList<Piece> pieces;
    int dim_x,dim_y,dim_z;
    boolean[][][] occupied;
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
    public Board clone(){
        Board s = new Board(dim_x,dim_y,dim_z);
        s.pieces = (ArrayList<Piece>) pieces.clone();
        return s;
    }
    boolean checkValidConfiguration(){
        Piece pc = pieces.get(0);
        if(pc.y!=dim_y/2||pc.z!=dim_z/2)
            return false;
        occupied = new boolean[dim_x][dim_y][dim_z];
        for(Piece p:pieces)
            for(int x=p.x;x<p.x+p.s_x;x++)
                for(int y=p.y;y<p.y+p.s_y;y++)
                    for(int z=p.z;z<p.z+p.s_z;z++){
                        if(x<0||y<0||z<0||x>=dim_x||y>=dim_y||z>=dim_z||occupied[x][y][z])
                            return false;
                        else
                            occupied[x][y][z]=true;
                    }

        return true;
    }
    void printPieces(){
        for(Piece p:pieces){
            System.out.println(p);
        }
    }
    public String toString(){
        String s = "";
        for(Piece p:pieces)
            s+=p.toString();
        return s;
    }

    public boolean isSolution(){
        int x = pieces.get(0).x+pieces.get(0).s_x;
        for(int i=x;i<dim_x;i++){
            if(occupied[i][dim_y/2][dim_z/2])
                return false;
        }
        return true;
    }
    public String dimString(){
        String s = "";
        for(int i=1;i<=pieces.size();i++){
            s+=dim_x+" "+dim_y+" "+dim_z+" ";
            s+=dim_x+" "+dim_y+" "+dim_z+" ";
        }
        return s;
    }
    public String toPrintableString(){
        String s = "";
        for(Piece p:pieces)
            s+=p.x+" "+p.y+" "+p.z+" "+p.s_x+" "+p.s_y+" "+p.s_z+"  ";
        return s;
    }

}
