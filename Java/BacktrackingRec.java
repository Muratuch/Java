import java.util.ArrayList;

public class BacktrackingRec {
    public static void main(String[] args) {
        System.out.println(maze(3,3));

        path("",3,3);

        System.out.println(Apath("",3,3));
        System.out.println();
        System.out.println();
        pathDiagonal("",3,3);
        System.out.println();
        System.out.println();
        obstaclePath("",3,3);
    }

    static int maze(int r, int c){
        if(r==1||c==1){ return 1;}

        int left=maze(r-1,c);
        int right=maze(r,c-1);

        return left+right;
    }

    static void path(String p, int r, int c){
        if (r==1&&c==1){
            System.out.println(p);
            return;
        }
        if(r>1)
            path(p+"d",r-1,c);

        if (c>1)
            path(p+"r",r,c-1);
    }

    static void pathDiagonal(String p, int r, int c){
        if (r==1&&c==1){
            System.out.println(p);
            return;
        }
        if(r>1)
            pathDiagonal(p+"d",r-1,c);

        if (c>1)
            pathDiagonal(p+"r",r,c-1);

        if (c>1 && r>1)
            pathDiagonal(p+"D",r-1,c-1);
    }

    static ArrayList<String> Apath(String p, int r, int c){
        if (r==1&&c==1){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if(r>1)
            list.addAll(Apath(p+"d",r-1,c));

        if (c>1)
            list.addAll(Apath(p+"r",r,c-1));

        return list;
    }

    static void obstaclePath(String p, int r, int c){
        if(r==2&&c==2) return;

        if (r==1&&c==1){
            System.out.println(p);
            return;
        }
        if(r>1)
            obstaclePath(p+"d",r-1,c);

        if (c>1)
            obstaclePath(p+"r",r,c-1);
    }
}
