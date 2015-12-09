import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        String s = "test_1";
        HashSet<String> set = new HashSet<String>();
        LinkedList<Board> queue = new LinkedList<Board>();
        LinkedList<Board> queue2 = new LinkedList<Board>();
        // load 1st board from file (N is first value, then each line is list of pieces x y z s_x s_y s_z)
        Board b = Board.load(s+".txt");
        if(b.checkValidConfiguration())
            System.out.println("valid configuration! calculating...");
        else{
            System.out.println("invalid configuration!");
            System.exit(1);
        }
        queue.add(b);
        try {
            PrintWriter writer = new PrintWriter(s+".out", "UTF-8");
            writer.println(b.dimString());
            //loop through, try moving
            while(!queue.isEmpty()) {
                for (Board board : queue) {
                    if (board.isSolution()) {
                        System.out.println("valid solution!");
                        writer.println(board.toPrintableString());
                        System.exit(0);
                    } else {
                        System.out.println("checking new config...");
                        writer.println(board.toPrintableString());
                        // try moving each piece, store in queue2
                        for(int i=0;i<board.pieces.size();i++){
                            Board b1 = board.clone();
                            Board b2 = board.clone();
                            switch(b1.pieces.get(i).longestDim) {
                                case 0:b1.pieces.get(i).x -= 1;
                                    b2.pieces.get(i).x += 1;break;
                                case 1:b1.pieces.get(i).y -= 1;
                                    b2.pieces.get(i).y += 1;break;
                                case 2:b1.pieces.get(i).z -= 1;
                                    b2.pieces.get(i).z += 1;break;
                            }
                            if(b1.checkValidConfiguration())
                                queue2.add(b1);
                            if(b2.checkValidConfiguration())
                                queue2.add(b2);
                        }
                    }
                }
                queue.clear();
                queue = new LinkedList<>(queue2);
                queue2.clear();
            }
            System.out.println("no possible solutions :(");
            writer.close();
        }
        catch(Exception e){

        }
    }
}
