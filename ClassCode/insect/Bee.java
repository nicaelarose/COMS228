package insect;

public class Bee extends Insect implements Locomotion, Pollination, Cloneable
{
	private String swarm; 
	
	public Bee(int size, String color, String swarm)
	{
		super(size, color);
		this.swarm = swarm; 
	}
	
	public String getSwarm()
	{
		return swarm; 
	}
	
	@Override
	public void move()
	{
		System.out.println("fly"); 
	}
	
	@Override 
	public void attack()
	{
		System.out.println("sting"); 
	}
	
	@Override
	public boolean pollinate()
	{
		return true; 
	}
	
	public void makeHoney()
	{
		System.out.println("Orange Blossom"); 
	}


	@Override
	public boolean equals(Object o)   
	{
		if (o == null || o.getClass() != getClass())
		{
			return false;
		}
	
		// typecast o to Bee so that we can compare data members
		Bee b = (Bee) o;
	
		// Compare the data members and return accordingly
		return b.size == size  
			     && (b.color == color || b.color != null && b.color.equals(color))
			     && (b.swarm == swarm || b.swarm != null && b.swarm.equals(swarm));
	}
	

	@Override
	public Object clone()   
	{
		try
		{
			// default clone() does field-by-field copying, thus of the values  
			// of size, color, and swarm 
			Bee b = (Bee) super.clone(); 
			return b; 
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		} 
		
		// an alternative below, without calling super.clone(), is 
		// considered against the API practice of creating a copy of 
		// an object at runtime without knowing its type.
//		Bee b = new Bee(size, color, swarm); 
//		return b;
	}
	
}
