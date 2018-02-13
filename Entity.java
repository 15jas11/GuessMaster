package PersonAndDate;

public class Entity {
	private String name; 
	private Date born; 
	//Copy constructor
	
	public Entity() {
		name = ""; 
		born = new Date(); 
	}
	public Entity(String nameIn, Date dateIn) {
		name = nameIn; 
		born = dateIn; 
	}

	public void printName(Entity object) {
		System.out.println(object.name);
	}
	
	public String getName() {
		return name; 
	}
	
	public Date getBorn() {
		return new Date(born);
	}
	
	//ToString Constructor 
	//Returns content of an entiry as string e.g "Celine Dion, born on March 40, 1968" or Eiffel Tower, born on March 31, 1889"
	public void printString() { 
		System.out.println(name + ", born on " + born.toString()); 
	}
		
	//Equals compares the two entinties 
	public boolean equals(Entity entity) { 
		if(entity != null) { 
			return entity.born.equals(born); 
		}else { 
			System.out.println("Entitiy has not been defined");
			return false; 
		}
		
		
	}
	
	public boolean precedes(Entity entity) { 
		return entity.born.precedes(born); 
	}
}
