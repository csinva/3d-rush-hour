
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
        if(x>y&&x>z)
            longestDim=0;
        else if(y>x&&y>z)
            longestDim=1;
        else if(z>z&&z>y)
            longestDim=2;
    }

    public String toString(){
        return x+","+y+","+z;
    }
}
