import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**ID: 109239204
 * CSE214 Homework number 1
 * @author Shakeeb Saleh
 *r01
 */

/**
 * This whole thing is basically just GUI
 * @author saleh
 *
 */
public class TeamOperations extends JFrame {
	
	JButton add = new JButton("Add a Player");
	JButton stats = new JButton("Get a Player's Stats");
	JButton leader = new JButton("Get a Stat Leader");
	JButton remove = new JButton("Remove Player");
	JButton roster = new JButton("Show Team Roster");
	JButton size = new JButton("Get Size of Team");
	JButton newHits = new JButton("Update a Players Hits");
	JButton newMiss = new JButton("Update a Players Errors");
	JButton quit = new JButton("Quit");
	Team theTeam = new Team();
	
	public TeamOperations (){
		this.setSize(700, 500);
		this.setLayout(new GridLayout(9,1));
		
		this.add(add); this.add(stats); this.add(leader);
		this.add(remove);this.add(roster);this.add(size);this.add(newHits);
		this.add(newMiss); this.add(quit);
		
		add.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(1);}});
		stats.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(2);}});
		leader.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(3);}});
		remove.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(4);}});
		roster.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(5);}});
		size.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(6);}});
		newHits.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(7);}});
		newMiss.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(8);}});
		quit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(9);}});
		
		this.setVisible(true);
	}
		

	
		
		
		public void activate(int option){
			switch(option){
			case 1: // add player
				{String n = JOptionPane.showInputDialog("Player Name: ");
				String h = JOptionPane.showInputDialog("Number of Hits: ");
				String e = JOptionPane.showInputDialog("Number of Errors: ");
				String pos = JOptionPane.showInputDialog("Enter the Position: ");
				Player holder = new Player(n, Integer.parseInt(h), Integer.parseInt(e));
				theTeam.addPlayer(holder, Integer.parseInt(pos));
				JOptionPane.showMessageDialog(null, "Player added - "+n+"\nHits: "+h+"\nErrors: "+e);}
				break;
			case 2: // get stats
				{String pos = JOptionPane.showInputDialog("What position is the Player?");
				JOptionPane.showMessageDialog(null,theTeam.extractStats(Integer.parseInt(pos)));}
				break;
			case 3: // get a stat leader
				{String stat = JOptionPane.showInputDialog("Please input the stat");
				Player p = theTeam.getLeader(stat);
				JOptionPane.showMessageDialog(null, "Leader in "+stat+": \n"+p.getName()+" - "
						+p.getHits()+" "+p.getErrors());}
				break;
			case 4: // remove a player
				{String posi = JOptionPane.showInputDialog("Enter a Position: ");
				int pos = Integer.parseInt(posi);
				theTeam.removePlayer(pos);}
				break;
			case 5: // Show team Roster
				{String position = "Player#";
				String pName = "Name";
				String h = "Hits";
				String e = "Errors";
				String header = String.format("%-10s%-27s%-18s%-10s", position,pName,h,e);
				String line =  "--------------------------------------------------------------------------------";
				JOptionPane.showMessageDialog(null,header + "\n" + line + "\n" + theTeam.toString());}
				break;
			case 6: // get size of team
				if(theTeam.size() == 1){
					JOptionPane.showMessageDialog(null, "there is only 1 player on the team.\nnot a very large team.");
				} else if (theTeam.size() == 0){
					JOptionPane.showMessageDialog(null, "there are no players on the team you fool.");
				} else {
				JOptionPane.showMessageDialog(null, "there are "+theTeam.size()+" Players on the team.");
				}
				break;
			case 7: // Update a Players hits
				{String pName = JOptionPane.showInputDialog("Enter the Player's name: ");
				int newHits = Integer.parseInt(JOptionPane.showInputDialog("Enter the new number of Hits: "));
				theTeam.getPlayerByName(pName).setHits(newHits);}
				break;
			case 8: // Update a Players errors
				{String pName = JOptionPane.showInputDialog("Enter the Player's name: ");
				int newErrors = Integer.parseInt(JOptionPane.showInputDialog("Enter the new number of Errors: "));
				theTeam.getPlayerByName(pName).setErrors(newErrors);}
				break;
			case 9: // Quit
				{System.exit(0);}
				break;
			}
		}
	public static void main(String[] args){
		String nombre = JOptionPane.showInputDialog(" What Do you wish to name your Team?");
		TeamOperations team = new TeamOperations();
		team.setTitle(nombre);
	}
		
	}


