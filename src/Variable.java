
public class Variable {
	String Name;
	int Value;
	
	public Variable()
	{
		Name = "";
		Value = 0;
	}
	
	public Variable(String varName,int varValue)
	{
		Name = varName;
		Value = varValue;
	}
	public String getName() 
	{
		return Name;
	}
	
	public void setName(String name) 
	{
		Name = name;
	}
	
	public int getValue() 
	{
		return Value;
	}
	
	public void setValue(int value) 
	{
		Value = value;
	}
}
