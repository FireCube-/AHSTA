package textadventure;
import java.util.Set;
import java.util.HashSet;

public class Entity {
	
	String name;
	String desc;
	
	HashSet<String> properties = new HashSet<>();
	
	String state;
	
	Entity(String name){
		this.name = name;
	}

	Entity(String name, String desc){
		this.name = name;
		this.desc = desc;
	}

	Entity(String name, String desc, String state, Set<String> properties){
		this.name  = name;
		this.desc  = desc;
		this.properties =  new HashSet<>(properties);		
	}

	Entity(String name, String desc, Set<String> properties){
		this.name = name;
		this.desc = desc;
		this.properties =  new HashSet<>(properties);
	}
	
	String getName(){
		return name;
	}
	
	String getDesc(){
		return desc;
	}
	
	boolean hasProperty(String prop){
		return this.properties.contains(prop);
	}

}
