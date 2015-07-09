import javax.swing.JOptionPane;
/**ID: 109239204
 * CSE 214 Homework Number 1
 * @author Shakeeb Saleh
 *R01
 */

public class Team {
	public final int MAX = 40;
	private int amount = 0;
	private Player[] team;
	private String teamName;
	
	/**
	 * Constructor
	 */
	public Team(){
		team = new Player[MAX];
	}
	/**
	 * setName
	 * @param name - name of the team
	 */
	public void setName(String name){
		this.teamName = name;
	}
	/**
	 * Clone function
	 */
	public Object clone(){
		 Player[] result = new Player[MAX];
		 for(int i = 0; i<= amount; i++){
			 result[i] = (Player)team[i].clone();
		 } return result;
	}
	/**
	 * TeamAsPlayerArray
	 * @return returns team as array of its players
	 */
	public Player[] TeamAsPlayerArray(){
		return team;
	}
	/**
	 * equals method
	 */
	public boolean equals(Object obj){
		boolean result = false;
		if (!(obj instanceof Team)){
			return false;
		} Team nasty = (Team)obj;
		Player[] team1 = this.sort(nasty);
		Player[] team2 = this.sort(this);
		for(int i = 0; i<40;i++){
			if((team1[i].getName().equals(team2[i].getName()))
					&&(team1[i].getHits() == team2[i].getHits())
					&&(team1[i].getErrors() == team2[i].getErrors()))
				result = true;
		} return result;
	}
	/**
	 * sort method
	 * @param nasty - the team you wish to sort
	 * @return returns team as a player array
	 */
	public Player[] sort(Team nasty){
		Player[] sort = nasty.TeamAsPlayerArray();
		Player temp;
		int first = 0;
		for(int i = nasty.size()-1;i>0;i--){
			for(int j = 1; j<=i; j++){
			 if(sort[j].getHits() > sort[first].getHits() ){
				 first = j;
			 }
			 temp = sort[first];
			 sort[first] = sort[i];
			 sort[i] = temp;
			}
		} return sort;		
	}
	/**
	 * add function
	 * @param p - player 
	 * @param pos - position of the player on the team
	 */
	public void addPlayer (Player p, int pos) {
		try{
			if (!(pos > 0)){throw new IndexOutOfBoundsException(); }
		pos--;
		if (pos > amount){
		team[++amount] = p;
		} else {
			for(int i = amount; i >= pos; i--){
				if (amount == 40){
					throw new FullTeamException(); //revise so its the right type of exception
				} else {
				team[i+1]=team[i]; 
				}	
			}
			team[pos] = p; amount++;
		}
		} catch (FullTeamException f) { JOptionPane.showMessageDialog(null, "The team is Full! FullTeamException Caught!"); }
		catch(IndexOutOfBoundsException i) {JOptionPane.showMessageDialog(null, "The position is invalid. Please select a position between 1-40"); }
	}
	/**
	 * removePlayer
	 * @param pos - position of the player getting ejected
	 */
	public void removePlayer (int pos) {
		try{
		if (!(pos > 0))	{throw new IndexOutOfBoundsException(); } 
		pos--;
		if (amount == 0){
			throw new IllegalArgumentException(); // i wasnt sure what type of exception to use, so i just used illegalArgumentException
		} else if (pos < amount){
			for(int i = pos;i < amount; i++){
			team[i]=team[i+1];
		} amount--;	
		} else {
			throw new IllegalArgumentException(); 
		
		}
		} catch (IllegalArgumentException e){ JOptionPane.showMessageDialog(null, "You can't Remove a Player from an EMPTY TEAM!\n are you dense?\n Exception Handled."); }
		catch (IndexOutOfBoundsException i){ JOptionPane.showMessageDialog(null, "Please choose a number from 1-40");}
	}
	/**
	 * Size 
	 * @return returns how large the team is
	 */
	public int size(){
		return this.amount;
	}
	/**
	 * extractStats
	 * @param pos - position of the player
	 * @return player with all stats
	 */
	public String extractStats(int pos){
		pos--;
		String result;
		result = team[pos].getName() +" - \nHits: "+team[pos].getHits()+"\nErrors: "+team[pos].getErrors();
		return result;
	}
	/**
	 * getPlayerByName
	 * @param pName - name of player
	 * @return player object
	 */
	public Player getPlayerByName(String pName){
		Player result = new Player();
		for(int i=0;i<amount;i++){
			if (pName.equals(team[i].getName())){
				result = team[i];
			}
		} return result;
	}
	/**
	 * getLeader
	 * @param stat - either hits or errors
	 * @return return the leader in that stat
	 */
	public Player getLeader(String stat){
		try{
		if (stat.equals("hits") || stat.equals("Hits")){
			int highest = 0;
			Player currentLeader = new Player();
			for(int i = 0; i < amount; i++){
				if(team[i].getHits()>highest){
					highest=team[i].getHits();
					currentLeader = team[i];
				}
			} return currentLeader;
		} else if(stat.equals("Errors") || stat.equals("errors")){
			int lowest = 1000000;
			Player currentLeader = new Player();
			for(int i = 0; i < amount; i++){
				if(team[i].getErrors()<lowest){
					lowest=team[i].getErrors();
					currentLeader = team[i];
		}
	} return currentLeader;
		}
		else { throw new IllegalArgumentException();}
		} catch (IllegalArgumentException e){JOptionPane.showMessageDialog(null, "No such Stat. Stop Messin Around!");}
		return null;
	}
	/**
	 * PrintallPlayers Method
	 */
	public void printAllPlayers(){
		String result = "";
		for(int i = 0; i<amount; i++){
			int posi = i; posi++;
			String pName = team[i].getName();
			int h = team[i].getHits();
			int e = team[i].getErrors();
			String pl = String.format("%-10s%-27s%-18d%-10d\n", posi, pName, h, e);
			result += pl; 
		} JOptionPane.showMessageDialog(null, result);
	}
	/**
	 * toString method
	 */
	public String toString(){
		String result = "";
		for(int i = 0; i<amount; i++){
			int posi = i; posi++;
			String pName = team[i].getName();
			int h = team[i].getHits();
			int e = team[i].getErrors();
			String pl = String.format("%-10s%-27s%-18d%-10d\n", posi, pName, h, e);
			result += pl; 
		} return result;
	}
	

}
