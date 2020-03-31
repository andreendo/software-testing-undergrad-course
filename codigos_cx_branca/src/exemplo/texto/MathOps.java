package exemplo.texto;

public class MathOps {
	public static int safe_add(int left, int right) throws Exception {
		if (right > 0) {
			if (left > Integer.MAX_VALUE - right)
				throw new Exception("Overflow");
		} else {
			if (left < Integer.MIN_VALUE - right)
				throw new Exception("Underflow");			
		}
		
		return left + right;
	}
}


