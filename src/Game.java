import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
	
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	private static HashMap<String, String > Roomdescription = new HashMap<String, String>();
	
	public static Scanner scan = new Scanner(System.in);
	

		public static Room getCurrentRoom() {
			return currentRoom;
		}
		
		public static void print(String s) {
			System.out.println(s+"\n");
		}
		
		public static void saveGame() {
			File saveFile = new File("save");
			try {
				saveFile.createNewFile();
				ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
				stream.writeObject(currentRoom);
				stream.writeObject(inventory);
				stream.writeObject(World.rooms); // Hash map of rooms
				stream.close();
				Game.print("Game Saved");
			} catch (IOException ex) {
				print("Error: cannot save file.");
				ex.printStackTrace();
			}
			
		}
		
		public static void loadGame() {
			File loadFile = new File("save");
			try {
				loadFile.createNewFile();
				ObjectInputStream stream = (new ObjectInputStream (new FileInputStream(loadFile)));
				currentRoom = (Room) stream.readObject();
				inventory = (ArrayList<Item>) stream.readObject();
			} catch (IOException e) {
				print("Error: cannot load file.");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void ReadRoomdescriptions() {
			setRoomdescription(new HashMap<String, String>());
		}
		
		private void setRoomdescription(HashMap<String, String> hashMap) {
			// TODO Auto-generated method stub
			
		}

		public static void populateMap(String fileName) {
			//need to loop through to read the descriptions
			try {
				Scanner scan = new Scanner(new File("Roomdescriptions"));
				String line = scan.nextLine();
				for(currentRoom.getRoomdescription()) {
					System.out.print(scan.nextLine());
					 String[] words = line.split(" ");
		                // Assume the first word is the room ID, and the rest is the description
		                if (words.length > 1) {
		                    // Join the words of the description into a single string
		                    String description = String.join(" ", Arrays.copyOfRange(words, 1, words.length));
		                    // Put the room ID and description into the map
		                    roomDescriptions.put(words[0], description);
		                }
				}
				//Roomdescription.put(words[0], words[0]);
			} catch (FileNotFoundException e) {
				System.out.println("File:" + Filename + "not found.");
				e.printStackTrace();
			}
			
		}
		
		public static void printMap() {
			for(String name : getRoomdescription().keySet()) {
			System.out.println(getRoomdescription().get(name));
			}
			
		}

		public static void move(char direction) {
			Room nextRoom = currentRoom.getExit(direction);
			if (nextRoom != null) {
				if (nextRoom.isLocked()) {
					System.out.println("The room is locked");
				}else { 
					currentRoom = nextRoom;
					System.out.println(currentRoom);
				}
			}else {
				System.out.println("You can't go that way");
			}
		}
		
		public static Item getItem(String name) {
			for (Item i : inventory)
				if ( i.getName().equals(name))
					return i;
			return null;
		}
		
	
	    public static void main(String[] args) {
	    	populateMap;
	    	public static HashMap<String, String > getRoomdescription() {
				return Roomdescription;
			}

			public static void setRoomdescription(HashMap<String, String > roomdescription) {
				Roomdescription = roomdescription;
			}
			String playerCommand = "a";
	    	String itemName;
	    	Item i;
	    	NPC npc;
	        currentRoom = World.buildWorld();
	        System.out.println(currentRoom);
	        
	        while(!playerCommand.equals("x")) {
	        	System.out.print("what do you want to do?");
	        	playerCommand = scan.nextLine();
	        	String[] words = playerCommand.split(" ");
	        	switch(words[0]) {
	        	case "n":
	        	case "s":
	        	case "e":
	        	case "w":
	        	case "u":
	        	case "d":
	        		move(playerCommand.charAt(0));
	        		break;
	        	case "save":
	        		saveGame();
	        		break;
	        	case "take":
	        		itemName = words[1];
	        		System.out.print("Take what?");
	        		itemName = scan.nextLine();
	        		if(currentRoom.hasItem(itemName)) {
	        			Item item = currentRoom.getItem(itemName);
	        			item.take();
	        		} else {
	        			System.out.println("There is no" + itemName + "!");
	        		}
	        		break;
	        	case "look": 
	        		i = getItem(words[1]);
	        		if( i == null)
	        			System.out.println("YOu don't have the" + words[1]);
	        		else
	        			i.use();
	        		break;
	        	case "use":
	        		i = getItem(words[1]);
	        		if(i == null)
	        			i = currentRoom.getItem(words[1]);
	        		if(i == null)
	        			System.out.println("You don't have the" + words[1]);
	        		else
	        			i.use();
	        		break;
	        	case "talk":
	        		npc = currentRoom.getNPC(words[1]);
	        		npc.talk();
	        		break;
	        	case "i":
	        		if(inventory.isEmpty()) {
	        			System.out.println("You are carrying nothing!");
	        		}else {
	        			for(Item it : inventory) {
	        				System.out.println(it);
	        			}
	        		}
	        		break;
	        	case "x":
	        		System.out.println("Okay, Bye");
	        		break;
	        	default: 
	        		System.out.println("Invalid command");
	        		}
	        	}
	        	scan.close();
	        }


}
	        



