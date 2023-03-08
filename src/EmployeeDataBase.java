
public class EmployeeDataBase {
	
	Entry[] ent;
	
	private class Entry
	{
		int ID;
		Employee employee;
		public Entry(int i, Employee e)
		{
			ID = i;
			employee = e;
		}
		@Override
		public String toString()
		{
			return "ID: " + this.ID + ", Employee" + this.employee; 
		}
	}
	private class Employee
	{
		String name;
		public Employee(String n)
		{
			name = n;
		}
	}
	
	public int hash(int key)
	{
		int k = (key % 100);
		if (ent[k]==null)
		{
			ent[k] = new Entry(key, new Employee("hi"));
		}
		else
		{
			//linear probing
			putLinear(key, k);
			//quadratic probing
			putQuad(key, k);

		}
		return 0;
	}
	
	public void putLinear(int key, int value)
	{
		if(ent[value+1] == null)
		{
			ent[value+1] = new Entry(key, new Employee("hi"));
		}
		else
		{
			value+=2;
			while(ent[value]!=null)
			{
				value++;
			}
			ent[value] = new Entry(key, new Employee("hi"));
		}
	}
	public void putQuad(int key, int value)
	{
		if(ent[value+1] == null)
		{
			ent[value+1] = new Entry(key, new Employee("hi"));
		}
		else
		{
			int counter = 1;
			int r = 1;
			while(ent[value+r]!=null)
			{
				counter++;
				counter = counter^2;
				r=counter;
			}
			ent[value+r] = new Entry(key, new Employee("hi"));
		}
	}
	
	public Employee get(int key)
	{
		return null;
		
	}
	
}
