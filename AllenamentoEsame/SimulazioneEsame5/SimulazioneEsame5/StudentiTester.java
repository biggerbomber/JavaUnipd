// nome e cognome del candidato, matricola, data,       numero postazione



public class StudentiTester
{   public static void main(String[] args)
    {
      // ....... da completare ............
    }
}


class Studenti implements Dictionary
{

    //costruttori e metodi pubblici ......da completare ......
    	public static final int INITIAL_SIZE=2;
	private Object [] container;
	private int vSize;
	public Studenti()
	{
		makeEmpty();
	}
	public void makeEmpty()
	{
		
		vSize=0;
		container= new Object[INITIAL_SIZE];
	}
   
   	/*
        verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    public boolean isEmpty(){
    
    		return vSize==0;
    }

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia', il valore ad essa associato viene sovrascritto 
     col nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    public void insert(Comparable key, Object value){
    		if(key==null || value == null || !(key instanceof Long) || !(value instanceof String))
    		{
    			throw new IllegalArgumentException();
    		}
    		int index= findIndex(key);
    		if(index<0){
    			
    			if(vSize>=container.length){
    				container = resize(container,vSize*2);
    			}
    			
    			int i=vSize;
    			while(i>0 && ((Pair)container[i]).getMatr()>(long)value)
    			{
    				container[i]=container[i-1];
    				i--;
    			}
    			container[i+1]= new  Pair((long)key,(String)value);
    		
    		}else
    		{
    			container[index]= new Pair((long)key,(String)value);
    		}
    
    
    }
    
    private Object [] resize(Object [] vet, int newSize)
    {
    		Object [] nArr= new Object[newSize];
    		System.arraycopy(vet,0,nArr,0,vet.length);
    		return nArr;
    
    }

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException 
    */
    public void remove(Comparable key){
    		int index = findIndex(key);
    		if(index<0){throw new DictionaryItemNotFoundException();}
    		
    		while(index<vSize-1){
    			container[index]=container[index+1];
    		}
    		vSize--;
    }

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
     public Object find(Comparable key){
    		int index = findIndex(key);
    		if(index<0){throw new DictionaryItemNotFoundException();}
    		return container[index];
    		
    	}
    	private int findIndex(Comparable key)
    	{
    		return binSearch(0,vSize-1,key);
	   
    	}
    	private int binSearch(int start, int end, Comparable key)
    	{
    	
    		if(start<=end){
    			int mid= (start+end)/2;
    			if(((Pair)container[mid]).getMatr() == (long)key){
    				return mid;
    			}else if(((Pair)container[mid]).getMatr()< (long)key){
    				return binSearch(mid+1,end,key);
    			}else{
    				return binSearch(start,mid-1,key);
    			}
    		
    		}
    		return -1;
    	
    	}
    	
    	
    	
    	
    public String toString()
    { return null; }   // ..... da completare .........
    
    //campi di esemplare  ..... da completare ......


    //classe privata Pair: non modificare!!
    private class Pair
    {   public Pair(long matr, String name)
        {   this.matr=matr; 
            this.name=name;
        }
        public long getMatr() 
        {   return matr; }
        public String getName() 
        {   return name; }
        /*
            Restituisce una stringa contenente
            - il numero di matricola, (numero long contenuto in "matr")
            - un carattere di separazione ( : )
            - il nome (stringa di una o piu` parole contenuta in "name")
        */
        public String toString() 
        {   return matr + " : " + name; }
        //campi di esemplare
        private long matr;
        private String name;
    }
}


interface Dictionary
{
    /*
        verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    boolean isEmpty();
    
    /*
        svuota il dizionario
    */
    void makeEmpty();

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia', il valore ad essa associato viene sovrascritto 
     col nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    void insert(Comparable key, Object value);

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException 
    */
    void remove(Comparable key);

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
    Object find(Comparable key);
}

class DictionaryItemNotFoundException extends RuntimeException {}



