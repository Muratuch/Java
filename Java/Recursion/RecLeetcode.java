import java.util.ArrayList;
import java.util.Collection;

public class RecLeetcode {
    public static void main(String[] args) {
        phoneNum("","12");
        System.out.println();
        System.out.println();
        Amazon("", 4);
        System.out.println();
        System.out.println();
        System.out.println(AmazonList("",4));

    }


    static void phoneNum (String p,String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0)-'0';

        for (int i=(digit-1)*3+1;i<=digit*3;i++){
            if(i==27) break;
            char ch= (char)('a'+i-1);

            phoneNum(p+ch, up.substring(1));
        }
    }


    static Collection<? extends String> Amazon(String p, int target){
        if (target==0){
            System.out.println(p);
            return null;
        }

        for(int i=1;i<=target;i++ ){
            Amazon(p+i,target-i);
        }
        return null;
    }

    static ArrayList<String> AmazonList(String p, int target){
        if (target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list=new ArrayList<>();
        for(int i=1;i<=target;i++ ){
            list.addAll(AmazonList(p+i,target-i));
        }
        return list;
    }
}
