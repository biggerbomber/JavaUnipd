

public class ParentesiBilanciate {
    public static void main(String [] args)
    {
        String s="(())()()()(())()";

        System.out.print(isBalanced(s));
    }


    public static boolean isBalanced(String s)
    {
        return isBalancedDepth(s, 0);
    }

    public static boolean isBalancedDepth(String s,int NumParentesiAperte)
    {
        if(s==null){throw new IllegalArgumentException();}

        if(s.length()<1){
            return NumParentesiAperte==0;
        }

        char c = s.charAt(0);
        if(c=='('){
            return isBalancedDepth(s.substring(1), NumParentesiAperte+1);
        }else  if(c==')')
        {
            if(NumParentesiAperte>0){
                return isBalancedDepth(s.substring(1), NumParentesiAperte-1);
            }else
            {
                return false;
            }
        }else
        {
            throw new IllegalArgumentException();
        }
    }
}
