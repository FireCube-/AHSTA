package textadventure;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Parser {
	
	public static String getTag(BufferedReader br) {
		try {
			char in = (char) br.read();
			while (in != '<') {
				in = (char) br.read();
			}
			String tag = "";
			in = (char) br.read();
			while (in != '>') {
				tag += in;
				in = (char) br.read();
			}
			return tag;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		throw new XMLParseException();
	}

	public static String getContent(BufferedReader br) {
		try {
			br.mark(1);
			char in = (char) br.read();
			String content = "";
			while (in != '<') {
				content += in;
				br.mark(1);
				in = (char) br.read();
			}
			br.reset();
			return content;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		throw new XMLParseException("Invalid Content");
	}
	
	public static Save parseSave(String fileName) throws FileNotFoundException {
		FileReader fr = new FileReader(fileName  + ".xml");
		BufferedReader br = new BufferedReader(fr);
		String check = Parser.getTag(br);
		if (!check.equals("save"))
			throw new XMLParseException("Invalid save tag");
		String tag = Parser.getTag(br);
		String locName = "";
		String locDesc = "";
		ArrayList<Connection> locConnections = new ArrayList<>();
		ArrayList<Entity> locEntities = new ArrayList<>();
		ArrayList<Entity> entities = new ArrayList<>();
		while (!tag.equals("/save")) {
			switch(tag) {
				case "location":
					tag = Parser.getTag(br);
					while (!tag.equals("/location")) {
						switch(tag) {
							case "name":
								locName = Parser.getContent(br);
								if (!Parser.getTag(br).equals("/name"))
									throw new XMLParseException("Invalid name tag");
								break;
							case "desc":
								locDesc = Parser.getContent(br);
								if (!Parser.getTag(br).equals("/desc"))
									throw new XMLParseException("Invalid desc tag");
								break;
							case "entity":
								locEntities.add(parseEntity(br));
								break;
							case "connection":
								locConnections.add(parseConnection(br));
								break;
							default:
								throw new XMLParseException("Invalid XML");
						}
						tag = Parser.getTag(br);
					}
					break;
				case "entity":
					entities.add(parseEntity(br));
					break;
				default:
					throw new XMLParseException("Invalid XML");
			}
			tag = Parser.getTag(br);
		}
		return new Save(new Location(locName, locConnections, locDesc, locEntities), entities);
	}
	
	public static Location parseLocation(String fileName) throws FileNotFoundException {
		//Loads the location from xml and stores it in the location member variable.
		FileReader fr = new FileReader(fileName + ".xml");
		BufferedReader br = new BufferedReader(fr);
		String check = Parser.getTag(br);
		if (!check.equals("location"))
			throw new XMLParseException("Invalid location tag");
		String tag = Parser.getTag(br);
		String locName = "";
		String locDesc = "";
		ArrayList<Entity> locEntities = new ArrayList<>();
		ArrayList<Connection> locConnections = new ArrayList<>();
		while (!tag.equals("/location")) {
			switch(tag) {
				case "name":
					locName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/name"))
						throw new XMLParseException("Invalid name tag");
					break;
				case "desc":
					locDesc = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/desc"))
						throw new XMLParseException("Invalid desc tag");
					break;
				case "entity":
					locEntities.add(parseEntity(br));
					break;
				case "connection":
					locConnections.add(parseConnection(br));
					break;
				default:
					throw new XMLParseException("Invalid XML");
			}
			tag = Parser.getTag(br);
		}
		return new Location(locName, locConnections, locDesc, locEntities);
	}

	private static Entity parseEntity(BufferedReader br) {
		String tag = Parser.getTag(br);
		String eName = "";
		String eDesc = "";
		HashSet<String> eProps = new HashSet<>();
		while (!tag.equals("/entity")) {
			switch(tag) {
				case "name":
					eName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/name"))
						throw new XMLParseException("Invalid name tag");
					break;
				case "desc":
					eDesc = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/desc"))
						throw new XMLParseException("Invalid desc tag");
					break;
				case "property":
					eProps.add(Parser.getContent(br));
					if (!Parser.getTag(br).equals("/property"))
						throw new XMLParseException("Invalid property tag");
					break;
				default:
					throw new XMLParseException("Invalid XML");
			}
			tag = Parser.getTag(br);
		}
		return new Entity(eName, eDesc);
	}
	
	private static Connection parseConnection(BufferedReader br) {
		String tag = Parser.getTag(br);
		String cName = "";
		String cDesc = "";
		String cDestination = "";
		while (!tag.equals("/connection")) {
			switch(tag) {
				case "name":
					cName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/name"))
						throw new XMLParseException("Invalid name tag");
					break;
				case "desc":
					cName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/desc"))
						throw new XMLParseException("Invalid desc tag");
					break;
				case "destination":
					cDestination = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/destination"))
						throw new XMLParseException("Invalid destination tag");
					break;
				default:
					throw new XMLParseException("Invalid XML");
			}
			tag = Parser.getTag(br);
		}
		return new Connection(cName, cDestination, cDesc);
	}

}
