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
		/*1*/char last = argStr.charAt(0);
		/*1*/StringBuffer sBuf = new StringBuffer();

		for (/*2*/int i = 0; /*3*/i < argStr.length(); /*4*/i++) {
			/*5*/char ch = argStr.charAt(i);
			if (/*6*/ch != '\n' || /*7*/last != '\n') {
				/*8*/sBuf.append(ch);
				/*8*/last = ch;
			}
		}

		/*9*/return sBuf.toString();
	}
}
