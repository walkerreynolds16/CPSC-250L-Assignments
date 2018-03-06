    package Lab04B;

public class Person implements Comparable<Person> {

private String name;
	
	public Person(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
			
		} else if(obj.equals(name)){
			return true;
		}
		
		return false;
	}
	

	public int compareTo(Person per) { 
		return name.compareToIgnoreCase(per.getName());
	}

}
