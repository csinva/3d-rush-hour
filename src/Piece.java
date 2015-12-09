
public class Piece {
    public int x,y,z;
    public int s_x,s_y,s_z;

    public Piece(int x, int y, int z, int s_x, int s_y, int s_z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.s_x = s_x;
        this.s_y = s_y;
        this.s_z = s_z;
    }

    public String toString(){
        return x+","+y+","+z+"-"+s_x+","+s_y+","+s_z;
    }
}
