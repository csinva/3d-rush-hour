import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        HashSet<Boolean> set = new HashSet<Boolean>();
        LinkedList<Board> queue = new LinkedList<Board>();
        // load 1st board from file (N is first value, then each line is list of pieces x y z s_x s_y s_z)
        Board b = Board.load("test_invalid_2.txt");
        if(b.checkValidConfiguration())
            System.out.println("valid configuration! calculating...");
        else{
            System.out.println("invalid configuration!");
            System.exit(1);
        }

    }
}
