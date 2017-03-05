package textadventure;
import java.util.Set;
import java.util.HashSet;

public class Entity {
	
	private String name;
	private String desc;
	private HashSet<String> properties = new HashSet<>();
	
	Entity(String name){
		this.name = name;
	}

	Entity(String name, String desc){
		this.name = name;
		this.desc = desc;
	}

	Entity(String name, String desc, Set<String> properties){
		this.name  = name;
		this.desc  = desc;
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
