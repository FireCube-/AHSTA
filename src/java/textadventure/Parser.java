package textadventure;
import java.io.BufferedReader;
import java.io.IOException;

public class Parser {

	public static String getTag(BufferedReader br) {
		try {
			char in = (char) br.read();
			while (in != '<') {
				in = (char) br.read();
			}
			String tag = "";
			while (in != '>') {
				tag += in;
			}
			return tag;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return "";
	}

	public static String getContent(BufferedReader br) {
		try {
			br.mark(1);
			char in = (char) br.read();
			String content = "";
			while (in != '<') {
				content += in;
				br.mark(1);
			}
			br.reset();
			return content;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return "";
	}

}
