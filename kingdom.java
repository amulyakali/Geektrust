package southeros;
import java.util.*;
public class kingdom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// kingdoms is a map of kingdom name and emblem.
		Map<String,String> kingdoms = new HashMap<String,String>();
		kingdoms.put("Land", "panda");
		kingdoms.put("Water", "octopus");
		kingdoms.put("Ice","mammoth");
		kingdoms.put("Air", "owl");
		kingdoms.put("Fire", "dragon");
		boolean loopCheck = true;
		Scanner kb = new Scanner(System.in);
		String question1 = "Who is the ruler of Southeros?";
		String question2 = "Allies of King Shan?";
		String question3 ="Allies of Ruler?";
		String exit = "End";
		Set<String> allies = new HashSet<String>();
		do{
			String input = kb.nextLine();
			if(question1.equalsIgnoreCase(input)){
				if(allies.size() <= 2)
					System.out.println("None");
				else{
					System.out.println("King Shah");
				}
			}
			else if(question2.equalsIgnoreCase(input)||question3.equalsIgnoreCase(input)){
				if(allies.size() == 0)
					System.out.println("None");
				else{
					int count=0;
					
					for(String s : allies){
						if(count < allies.size()-1)
							System.out.print(s+", ");
						else
							System.out.print(s);
						count++;
					}
					System.out.println();
					
				}
				
			}
			else if(exit.equalsIgnoreCase(input)){
				loopCheck = false;
				kb.close();
			}
			else{
				String [] str = input.split(",");
                
				str[0] = str[0].replaceAll(" ", "");
				if(isMessageCorrect(str[1],kingdoms.get(str[0]))){
					allies.add(str[0]);
				}
			}
			
		}while(loopCheck);
		
		
	}
	
		
	
	/**
	 * Tests whether the secret message contain the letters of the animal in their emblem
	 * @param message
	 * @param emblem
	 * @return
	 */
	public static boolean isMessageCorrect(String message, String emblem){
		boolean check = true;
		message = message.toLowerCase();
		emblem = emblem.toLowerCase();
		for(int s=0; s<emblem.length();s++){
			if(!message.contains(String.valueOf(emblem.charAt(s)))) {
				check = false;
				break;
			}
		}
		return check;
	}
}
