import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        String s = "test_7";
        HashSet<String> set = new HashSet<String>();
        LinkedList<Board> queue = new LinkedList<Board>();
        LinkedList<Board> queue2 = new LinkedList<Board>();
        // load 1st board from file (N is first value, then each line is list of pieces x y z s_x s_y s_z)
        Board b = Board.load(s+".txt");
        b.printPieces();
        b.prevs=b.toPrintableString();
        if(b.checkValidConfiguration())
            System.out.println("valid configuration! calculating...");
        else{
            System.out.println("invalid configuration!");
            System.exit(1);
        }
        int numMoves=0;
        queue.add(b);
        try {
            PrintWriter writer = new PrintWriter(s+".out", "UTF-8");
            writer.println(b.dimString());
            //loop through, try moving
            while(!queue.isEmpty()) {
                numMoves++;
                System.out.println("numMoves: "+numMoves);
                for (Board board : queue) {
                    set.add(board.toString());
                    if (board.isSolution()) {
                        System.out.println("valid solution! "+numMoves+" moves taken.");
                        System.out.println(board.prevs);
                        writer.println(board.toPrintableString());
                        PrintWriter solWriter = new PrintWriter(s+".sol", "UTF-8");
                        solWriter.println(b.dimString());
                        solWriter.println(board.prevs);
                        solWriter.close();
                        writer.close();
                        System.exit(0);
                    } else {
                        // System.out.println("checking new config...");
                        writer.println(board.toPrintableString());
                        // try moving each piece, store in queue2
                        for(int i=0;i<board.pieces.size();i++){
                            Board b1 = board.clone();
                            Board b2 = board.clone();
                            Piece p = b1.pieces.get(i);
                            switch(p.longestDim) {
                                case 0:
                                    b1.pieces.set(i,new Piece(p.x-1,p.y,p.z,p.s_x,p.s_y,p.s_z));
                                    b2.pieces.set(i,new Piece(p.x+1,p.y,p.z,p.s_x,p.s_y,p.s_z));
                                    break;
                                case 1:
                                    b1.pieces.set(i,new Piece(p.x,p.y-1,p.z,p.s_x,p.s_y,p.s_z));
                                    b2.pieces.set(i,new Piece(p.x,p.y+1,p.z,p.s_x,p.s_y,p.s_z));
                                    break;
                                case 2:
                                    b1.pieces.set(i,new Piece(p.x,p.y,p.z-1,p.s_x,p.s_y,p.s_z));
                                    b2.pieces.set(i,new Piece(p.x,p.y,p.z+1,p.s_x,p.s_y,p.s_z));
                                    break;
                                default:System.out.println("error");
                            }
                            b1.prevs+="\n"+b1.toPrintableString();
                            b2.prevs+="\n"+b2.toPrintableString();
                            if(!set.contains(b1.toString())&&b1.checkValidConfiguration()) {
                                queue2.add(b1);
                            }
                            if(!set.contains(b2.toString())&&b2.checkValidConfiguration()) {
                                queue2.add(b2);
                            }
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
