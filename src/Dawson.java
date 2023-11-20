
public class Dawson extends NPC {
	
	public Dawson() {
		super("employee", " a tall man");
	}
	
	public void talk() {
		say();
		String[] options = {
				"",
				""
		};
		getResponse(options);
	}
	
	public void response(int choice) {
		switch(choice) {
		case 1:
			say("");
			break;
		case 2 :
			say("");
			break;
		case 3:
			say("");
			Game.print("");
			break;
		}
	}

}
