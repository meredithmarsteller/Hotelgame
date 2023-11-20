import java.util.HashMap;

public class World {
	
	public static HashMap<String, Room> rooms =
			new HashMap<String, Room>();
	
	 public static Room buildWorld() {
		 
	        Room LOBBY = new Room("LOBBY");
	        
	        Room LOUNGE = new Room("LOUNGE");
	        
	        Room BAR = new Room("BAR");
	        
	        Room HALL = new Room("HALL");
	        
	        Room HALL2 = new Room("HALL2");
	        
	        Room RESTROOM = new Room("RESTROOM");
	        
	        Room BEDROOM = new Room("BEDROOM");
	        
	        Room MASTER_BEDROOM = new Room("MASTER_BEDROOM");
	        
	        
	        
	        LOBBY.addExit(LOUNGE, 'e'); 
	        LOBBY.addExit(BAR, 'w'); 
	        LOBBY.addExit(HALL, 'n'); 
	        LOBBY.addExit(HALL2, 'u');
	        
	        
	        LOUNGE.addExit(LOBBY, 'w');
	        LOUNGE.setLocked(true);
	        Item key = new Key();
	        key.setDesc("It's an old key");
	        LOUNGE.addItem(key);
	        
	        
	        BAR.addExit(LOBBY,  'e');
	        BAR.addExit(RESTROOM, 'n');
	        
	        HALL.addExit(LOBBY,  's');
	        Item Wand = new Item ("Wand");
	        HALL.addItem(Wand);
	       
	        
	        HALL2.addExit(LOBBY, 'd');
	        HALL2.addExit(BEDROOM, 'w');
	        HALL2.addExit(MASTER_BEDROOM, 'e');
	        
	        RESTROOM.addExit(BAR, 's');
	        
	        BEDROOM.addExit(HALL2, 'e');
	        BEDROOM.addItem(new Item("Chest"));
	        Item Chest = new Item("The Chest contains an Item");
	        
	        MASTER_BEDROOM.addExit(HALL2, 'w');
	        MASTER_BEDROOM.addItem(new Item("Remote"));
	        MASTER_BEDROOM.addItem(new Item("TV"));
	        
	        
	        
	        return LOBBY;
	        
	       
	    }
	}
