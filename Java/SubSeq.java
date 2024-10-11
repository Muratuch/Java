import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subseq("","abc");
        System.out.println();
        System.out.println();
        permutation("","abc");
        System.out.println();
        System.out.println();
        //System.out.println(Apermutation("","abc"));
    }

        static void subseq(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=up.charAt(0);

        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }
    static void permutation(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=up.charAt(0);

        for (int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            permutation(f+ch+s,up.substring(1));
        }
    }

    static ArrayList<String> Apermutation(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch=up.charAt(0);

        ArrayList<String> left= new ArrayList<>(Apermutation(p+ch,up.substring(1)));
        ArrayList<String> right= new ArrayList<>(Apermutation(ch+p,up.substring(1)));
        left.addAll(right);
        return left;
    }
}
