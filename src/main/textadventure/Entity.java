package textadventure;
import java.util.Set;
import java.util.HashSet;

public class Entity {
	
	private String name;
	private String desc;
	private HashSet<String> properties = new HashSet<>();
	
	public Entity(String name){
		this.name = name;
	}

	public Entity(String name, String desc){
		this.name = name;
		this.desc = desc;
	}

	public Entity(String name, String desc, Set<String> properties){
		this.name  = name;
		this.desc  = desc;
		this.properties =  new HashSet<>(properties);		
	}
	
	public String getName(){
		return name;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public boolean hasProperty(String prop){
		return this.properties.contains(prop);
	}

}
