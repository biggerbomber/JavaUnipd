import java.util.Scanner;
public class ScomposizionePrimi{

    public static void main(String args[]){
		
			Scanner input =new Scanner(System.in);
			
			int N=input.nextInt();
			input.close();
			int saveN=N;
			int [] primi=crivello(N/2);
			int [] scomposizione= new int[N];
			int indexScomposizione=0;
			
			for(int i=0;i<primi.length;i++){
				while(N%primi[i]==0){
					N/=primi[i];
					scomposizione[indexScomposizione]=primi[i];
					indexScomposizione++;
				}
			}
        
			boolean primo=true;
			for(int i=0;i<indexScomposizione;i++){
				if(primo){
					primo=false;
					System.out.print(saveN+" = "+scomposizione[i]);
				}else{
					System.out.print(" * "+scomposizione[i]);
				}
			}		
    }
	
	public static int[] crivello(int N){
		
		//crivello(3);
		int [] numeriPrimi = new int[N];
		int indexPrimi=0;
		{
		
		/*for(int i=0;i<primi.length;i++){
			primi[i]=true;
		}*/
		boolean [] primi= new boolean[N+1];
		
		
		for(int i=2;i<primi.length;i++){
			if(!primi[i]){
				numeriPrimi[indexPrimi]=i;
				indexPrimi++;
				for(int k=1;k*i<primi.length;k++){
					primi[k*i]=true;
				}
			}
		}
		}
		int [] primiReturn=new int[indexPrimi];
		for(int i=0;i<indexPrimi;i++){
			primiReturn[i]=numeriPrimi[i];
		}
		return primiReturn;
	}
}



