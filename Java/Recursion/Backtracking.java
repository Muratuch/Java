import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {
        boolean[][] sample={{true,true,true},{true,true,true},{true,true,true}};
        int[][] track=new int[sample.length][sample[0].length];
        pathRestriction("",sample,0,0);
        System.out.println();
        pathAll("",sample,0,0);
        System.out.println();
        printPathAll("",sample,0,0,track,1);



    }




    static void pathRestriction(String p, boolean[][] obs, int r, int c){
        if(!obs[r][c]){
            return;
        }

        if(r==obs.length-1&&c==obs[0].length-1){
            System.out.println(p);
            return;
        }

        if (r<obs.length-1)
            pathRestriction(p+"d",obs,r+1,c);

        if (c< obs[0].length-1)
            pathRestriction(p+"r",obs,r,c+1);
    }


    static void pathAll(String p, boolean[][] obs, int r, int c){
        if (r == obs.length - 1 && c == obs[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!obs[r][c]) {
            return;
        }

        // I am considering this block
        obs[r][c] = false;



        // Explore in all possible directions
        if (r < obs.length - 1)
            pathAll(p + "d", obs, r + 1, c); // Down

        if (c < obs[0].length - 1)
            pathAll(p + "r", obs, r, c + 1); // Right

        if (r > 0)
            pathAll(p + "u", obs, r - 1, c); // Up

        if (c > 0)
            pathAll(p + "l", obs, r, c - 1); // Left

        // Restore the state once all directions have been explored
        obs[r][c] = true;

    }

    static void printPathAll(String p, boolean[][] obs, int r, int c, int[][] path, int step){
        if (r == obs.length - 1 && c == obs[0].length - 1) {
            path[r][c]=step;
            System.out.println(p);
            for(int[] arr:path)
                System.out.println(Arrays.toString(arr));
            return;
        }

        if (!obs[r][c]) {
            return;
        }

        // I am considering this block
        obs[r][c] = false;


        path[r][c]=step;
        // Explore in all possible directions
        if (r < obs.length - 1)
            printPathAll(p + "d", obs, r + 1, c, path, step+1); // Down

        if (c < obs[0].length - 1)
            printPathAll(p + "r", obs, r, c + 1, path, step+1); // Right

        if (r > 0)
            printPathAll(p + "u", obs, r - 1, c, path, step+1); // Up

        if (c > 0)
            printPathAll(p + "l", obs, r, c - 1, path, step+1); // Left

        // Restore the state once all directions have been explored
        obs[r][c] = true;
        path[r][c]=0;
    }
}
