
public class NPC {
	
	private String name;
	private String desc;
	
	public NPC(String name) {
		this.name = name;
	}
	
	public NPC(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
		
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void look() {
		Game.print(desc);
	}
	
	public void talk() {
		Game.print(" ");
	}
	
	public void response(int option) {
		
	}
	public void say(String dialog) {
		Game.print(name + ":" + dialog);
	}
	
	//display options to player
	//prompt player to select an option
	//read players choice
	//call the response method with the player's choice
	//as a parameter
	
	public void getResponse(String[] options) {
		for(int i = 0; i<options.length; i++) {
			Game.print("Option" + (i+1) + options[1]);
			
		}
		Game.print("Enter an option(1-" + options.length + ")");
		int choice = Game.scan.nextInt();
		Game.scan.nextLine();//flush input buffer
		response(choice);
	}

}
