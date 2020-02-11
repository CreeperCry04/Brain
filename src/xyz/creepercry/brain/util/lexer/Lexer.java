package xyz.creepercry.brain.util.lexer;

import java.util.Arrays;
import java.util.List;

public class Lexer {
	
	public void initiate() {
		
	}

	public List<String> getWords(String s) {
		return Arrays.asList(s.split("\\s+"));
	}
	
	public IntentType determineIntent(String s) {
		s = s.toLowerCase();
		switch (Character.toString(s.charAt(s.length() - 1))) {
			case ".":
				// should cover it for now
				if (s.contains("please") || s.contains("go") && !s.contains("good") || s.contains("now") || s.startsWith("get")) return IntentType.COMMAND;
				// return s.contains("please") || !s.contains("now") ? IntentType.STATEMENT : IntentType.COMMAND;
				return IntentType.STATEMENT;
			case "?":
				if (s.contains("please") || s.contains("go") && !s.contains("good") || s.contains("now") || s.startsWith("get") || s.contains("retrieve")) return IntentType.COMMAND;
				return IntentType.QUESTION;
			case "!":
				return IntentType.EXCLAMATORY;
			default:
				if (s.startsWith("who") || s.startsWith("what") || s.startsWith("when") || s.startsWith("where") || s.startsWith("why") || s.startsWith("how") || s.startsWith("are") || s.startsWith("is") || s.startsWith("do") && !(s.startsWith("don't") || s.startsWith("dont") || s.startsWith("do not"))) return IntentType.QUESTION;
				if (s.contains("please") || s.contains("go") && !s.contains("good") || s.contains("now") || s.startsWith("get") || s.contains("retrieve")) return IntentType.COMMAND;
				return IntentType.STATEMENT;
		}
	}

	public enum IntentType {
		STATEMENT,
		COMMAND,
		QUESTION,
		EXCLAMATORY;
		// UNKNOWN
	}
}