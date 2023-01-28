import java.util.Scanner;

public class Parentesi
{

	public static void main(String [] args)
	{
	
		Scanner in = new Scanner(System.in);
		
		boolean result = checkParentesi(in.nextLine());
		System.out.println(result);
	
	}
	public static boolean checkParentesi(String s){
	
		Pila p= new Pila();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(!(c=='('||c==')'||c=='['||c==']'||c=='{'||c=='}')){continue;}
			
			if(p.isEmpty()){
				if(!(c=='('||c=='['||c=='{')){return false;}
				p.push(s.charAt(i));
			}else{
				Character lastParO = (Character)p.top();
				char lastPar=lastParO.charValue();
				
				if(lastPar=='(')
				{
					if(c=='(')
					{
						p.push(c);
						continue;
					}else if(c==')')
					{
						p.pop();
						continue;
					}
					return false;
				}else if(lastPar=='[')
				{
					if(c=='[')
					{
						p.push(c);
						continue;
					}else if(c==']')
					{
						p.pop();
						continue;
					}else if(c=='(')
					{
						p.push(c);
						continue;
					}
					return false;
				
				}else if(lastPar=='{')
				{
					if(c=='{')
					{
						p.push(c);
						continue;
					}else if(c=='}')
					{
						p.pop();
						continue;
					}else if(c=='[')
					{
						p.push(c);
						continue;
					}
					else if(c=='(')
					{
						p.push(c);
						continue;
					}
					return false;
				}
	
			}
			
			
		}
		
		return p.isEmpty();

	}
}
