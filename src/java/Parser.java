public static Parser {

	public String getTag(BufferedReader br) {
		char in = br.read();
		while (in != '<') {
			in = br.read();
		}
		String tag = "";
		while (in != '>') {
			tag += in;
		}
		return tag;
	}

	public String getContent(BufferedReader br) {
		br.mark(1);
		char in = br.read();
		String content = "";
		while (in != '<') {
			content += in;
			br.mark(1);
		}
		br.reset();
		return content;
	}

}
