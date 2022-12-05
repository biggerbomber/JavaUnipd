
public class Chronometer
{
	private final int OFF     = 0;
	private final int RUNNING = 1;
	private final int READY   = 2;
	
	private int state;
	private long startTime;
	private long endTime;
	
	
	public Chronometer()
	{
		state=OFF;
	}
	
	public void start()
	{
		startTime=System.nanoTime();
		state=RUNNING;
	}
	
	public void stop()
	{
		if(state==RUNNING){
			endTime=System.nanoTime();
			state=READY;
		}	
	}
	
	public void reset()
	{
		state=OFF;
	}
	public boolean isRunning()
	{
		if(state==RUNNING)
		{
			return true;
		}else
		{
			return false;
		}	
	}
	public boolean isTimeReady()
	{
		if(state==READY)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public String getElapsedTime()
	{
		if(state!=READY)
		{
			return "0";
		}
			
		double time=endTime-startTime;
		time/=1000000000;
		
		return String.format("%.4f",time);
		
	
	}
	public String toString()
	{
		return "Chronometer "+stateToString()+" "+getElapsedTime();	
	}
	private String stateToString()
	{
		if(state==OFF){return "off";}
		if(state==RUNNING){return "running";}
		return "ready";
	}

}
















