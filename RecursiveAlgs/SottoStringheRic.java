
public class SottoStringheRic
{
    public static void main (String [] args)
    {
        if(args.length!=1){
            System.out.println("inserire una stringa da riga di comando");
            System.exit(1);
        }

        String [] sotString = allSubstringRic(args[0]);
        for(int i=0;i<sotString.length;i++){
            System.out.println(sotString[i]);
        }
    }
    public static String [] allSubstringRic(String s)
    {
        if(s.length()==1){
            String [] out=new String[1];
            out[0]=s;
            return out; 
        }
        String [] lastLetterRemoved = allSubstringRic(s.substring(0,s.length()-1));
        String [] firstLetterRemoved = allSubstringRic(s.substring(1));

        String [] out = new String[lastLetterRemoved.length+firstLetterRemoved.length+1];
        append(out,lastLetterRemoved,firstLetterRemoved);
        out[out.length-1]=s;
        return out;
    }
    private static void append(String[] out, String [] left, String [] right){
        if(out.length<left.length+right.length){
            throw new IllegalArgumentException();
        }
        int i=0;
        for(int j=0;j<left.length;j++){
            out[i++]=left[j];
        }
        for(int j=0;j<right.length;j++){
            out[i++]=right[j];
        }
    }
}