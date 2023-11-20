import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {
	

    private String description;
    
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private boolean locked; //Is the room locked?
    private String name;
    private String roomID;
    
    private HashMap<String, Item> roomItems;
    private HashMap<String, NPC> roomNPC;

    public Room(String n) {
    	name = n;
    	roomID = n;
        locked = false;
        roomItems = new HashMap<String, Item>();
        roomNPC = new HashMap<String, NPC>();
        World.rooms.put(name, this); // Room object places itself in the Map
        Game.getRoomdescription().put(name, this);
    }
    
    public void addNPC(NPC npc) {
    	roomNPC.put(npc.getName(), npc);
    }
    
    public NPC getNPC(String name) {
    	return roomNPC.get(name);
    }
    
    public String getName() {
    	return name;
    }
    
    public boolean isLocked() {
    	return locked;
    }
    
    public void setLocked(boolean b) {
    	locked = b;
    }
    
    public Item getItem(String name) {
    	return roomItems.get(name);
    }
    
    public Item removeItem(String name) {
    	Item it = roomItems.get(name);
    	roomItems.remove(name);
    	return it;
    }
    
    public void addItem(Item i) {
    	roomItems.put(i.getName(), i);
    }
    
    public boolean hasItem(String name) {
    	return roomItems.containsKey(name);
    }
    
    public void setRoomId(String id) {
    	roomID = id;
    }
    
    public String getDescription() {
    	return Game.getRoomdescription().get(roomID);
    }
    	

    public Room getExit(char direction) {
        switch (direction) {
            case 'e':
                return east;
            case 'w':
                return west;
            case 'n':
                return north;
            case 's':
                return south;
            case 'u':
                return up;
            case 'd':
                return down;
            default:
                return null;
        }
    }

    public void addExit(Room room, char direction) {
        switch (direction) {
            case 'e':
                east = room;
                break;
            case 'w':
                west = room;
                break;
            case 'n':
                north = room;
                break;
            case 's':
                south = room;
                break;
            case 'u':
                up = room;
                break;
            case 'd':
                down = room;
                break;
        }
    }

    @Override
    public String toString() {
        return Game.getRoomdescription().get(roomID);
    }
    

    	
    }
