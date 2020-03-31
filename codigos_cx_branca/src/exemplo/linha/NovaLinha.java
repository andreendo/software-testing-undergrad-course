package exemplo.linha;

/**
 *
 * @author andreendo
 */
public class NovaLinha {

	/**
	 * @param argStr string da qual os caracteres de new line serao aglutinados
	 * @return String
	 */
	public String collapseNewlines(String argStr) {
		char last = argStr.charAt(0);
		StringBuffer sBuf = new StringBuffer();

		for (int i = 0; i < argStr.length(); i++) {
			char ch = argStr.charAt(i);
			if (ch != '\n' || last != '\n') {
				sBuf.append(ch);
				last = ch;
			}
		}

		return sBuf.toString();
	}
}
