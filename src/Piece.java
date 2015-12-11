
public class Piece {
    public int x,y,z;
    public int s_x,s_y,s_z;
    public int longestDim; //0-2
    public Piece(int x, int y, int z, int s_x, int s_y, int s_z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.s_x = s_x;
        this.s_y = s_y;
        this.s_z = s_z;
        if(s_x>s_y&&s_x>s_z)
            longestDim=0;
        else if(s_y>s_x&&s_y>s_z)
            longestDim=1;
        else
            longestDim=2;
    }

    public String toString(){
        return x+","+y+","+z;
    }
    public String toExtraString(){
        return x+","+y+","+z + "("+s_x+","+s_y+","+s_z+")"+" longestDim: "+longestDim;
    }
}
