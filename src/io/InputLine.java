package io;

public class InputLine {

	private String original;
	private String variable;
	private String value;

	public InputLine (String input) {
		this.original = input;
		String lowString = input;
		lowString = lowString.trim().toLowerCase();
		String tempVar = "";
		String tempVal = "";
		int i = 0;
		boolean equalsFound = false;
		while (i < lowString.length()) {
			int curAsc = lowString.charAt(i);
			if (curAsc == 61) {
				equalsFound = true;
				i++;
				continue;
			}
			if (!equalsFound) {
				if (((curAsc > 96) && (curAsc < 123)) || (curAsc == 95))  {
					tempVar = tempVar + (char) curAsc;
				}
			} else {
				tempVal = tempVal + (char) curAsc;
			}
			i++;
		}
		this.variable = tempVar;
		this.value = tempVal.trim();
	}

	public String getOriginal() {
		return original;
	}

	public String getVariable() {
		return variable;
	}

	public String getValue() {
		return value;
	}

}