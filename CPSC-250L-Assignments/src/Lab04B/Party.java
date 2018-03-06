package Lab04B;

import java.util.ArrayList;

public class Party {
	
	private ArrayList<Person> invited;
	
	private ArrayList<Person> RSVP;
	
	
	public Party(){
		invited = new ArrayList<Person>();
		
		RSVP = new ArrayList<Person>();
	}
	
	public void addInvited(Person per){
		Person newPer = new Person("");
		newPer.setName(per.getName());
		
		if(!invited.contains(newPer)){
			invited.add(newPer);
		}
		
		
	}
	
	public void addRSVP(Person per){
		Person newPer = new Person(per.getName());
		
		
		if(invited.contains(newPer)){
			if(!RSVP.contains(newPer)){
				RSVP.add(newPer);
			}
		}
		
	}
	
	public ArrayList<Person> getInvited(){
		ArrayList<Person> newList = new ArrayList<Person>();
		
		for(int i = 0; i < invited.size(); i++){
			Person per = new Person(invited.get(i).getName());
			newList.add(per);
		}
		
		return newList;
	}
	
	public ArrayList<Person> getRSVP(){
		ArrayList<Person> newList = new ArrayList<Person>();
		
		for(int i = 0; i < RSVP.size(); i++){
			Person per = new Person(RSVP.get(i).getName());
			newList.add(per);
		}
		
		return newList;
	}
	

}
