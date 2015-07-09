
/**ID: 1009239204
 * CSE 214 Homework Number 1
 * @author Shakeeb Saleh
 *r01
 */

public class Player {
	private String name;
	private int hits;
	private int errors;
	
	/**
	 * Constructor
	 */
	public Player(){
		
	}
	/**
	 * Overloaded Constructor
	 * @param bleeh - The name of the Player
	 * @param bloohits - the number of hits
	 * @param wilterrs - the numberof errors
	 */
	public Player(String bleeh, int bloohits, int wilterrs){
		this.name = bleeh;
		this.hits = bloohits;
		this.errors = wilterrs;
	}
	
	/**
	 * setName function
	 * @param bleh - name to set
	 */
	public void setName(String bleh){
		this.name = bleh;
	}
	/**
	 * getName function
	 * @return returns the name
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * setHits function
	 * @param bluh number of hits
	 */
	public void setHits(int bluh){
		if (bluh == 0){
			throw new IllegalArgumentException(); // get better at this
		}
		this.hits = bluh;
	}
	/**
	 * getHits function
	 * @return returns hits
	 */
	public int getHits(){
		return this.hits;
	}
	/**
	 * setErrors function
	 * @param bloh the errors
	 */
	public void setErrors(int bloh){
		if (bloh == 0){
			throw new IllegalArgumentException(); // specify and improve
		}
		this.errors = bloh;
	}
	/**
	 * getErrors function
	 * @return returns errors
	 */
	public int getErrors(){
		return this.errors;
	}
	/**
	 * toString function
	 */
	public String toString(){
		String result;
		result = this.getName() + "\n Hits:  " + this.getHits() +"\n Errors:" + this.getErrors();
		return result;
	}
	/**
	 * clone function
	 */
	public Object clone(){
		Player clone = new Player(this.getName(), this.getHits(), this.getErrors());
		return (Object)clone;
	}

}
