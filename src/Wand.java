
public class Wand extends Item{
	
	public Wand() {
		super("Wand");
	}
	
	@Override
	public void take() {
		super.take(); // Calls item's take() method
		Game.getCurrentRoom().setRoomId("HALL_A");
	}
	
	@Override
	public void use() {
		if(Game.getCurrentRoom().getName().equals("lobby")) {
			System.out.println("You wave the wand and the lounge maggically unlocks"); //print ' you unlock the lounge"
			Room lounge = Game.getCurrentRoom().getExit('e'); //unlock the lounge
			lounge.setLocked(false);
		}else {
			System.out.println("You wave the wand around.");
		}
	}

}
