import java.util.Scanner;
public class TestReindirizzamento
{
    public static void main(String [] a)
    {
        Scanner input = new Scanner(System.in);
        
        String [] poesia= new String[10];

        int i=0;
        while(i<poesia.length && input.hasNext()){
            poesia[i++]=input.next();
        }
        
        for(int j=i-1;j>0;j--)
        {
            System.out.println(poesia[j]);
        }

        input.close();
    }
}
