import java.util.HashSet;

public class Entity {
	
	String name;
	String desc;
	
	HashSet<String> properties = new HashSet<String>(0);
	
	String state;
	
	Entity(String name){
		this.name = name;
	}

	Entity(String name, String desc){
		this.name = name;
		this.desc = desc;
	}

	Entity(String name, String desc, String state){
		this.name  = name;
		this.desc  = desc;
		this.state = state;
	}

	Entity(String name, String desc, String state, String[] properties){
		this.name  = name;
		this.desc  = desc;
		this.state = state;
		
		for (String prop : properties){
			this.properties.add(prop);
		}
		
	}

	Entity(String name, String desc, String[] properties){
		this.name = name;
		this.desc = desc;
		
		for (String prop : properties){
			this.properties.add(prop);
		}
		
	}
	
	String getName(){
		return name;
	}
	
	String view(){
		return desc;
	}
	
	boolean hasProperty(String prop){
		if (properties.contains(prop))
			return true;
		return false;
	}
	
	boolean inState(String state){
		if (state.equals(this.state))
			return true;
		return false;
	}
	
	void changeState(String state){
		this.state = state;
	}
}
