import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListSorted
{
	public static void main(String[] args)
	{
		LinkedList<String> placesToVisit =  new LinkedList<String>();

		addInOrder(placesToVisit, "Montreal");
		addInOrder(placesToVisit, "Toronto");
		addInOrder(placesToVisit, "Vancouver");
		addInOrder(placesToVisit, "Edmonton");
		addInOrder(placesToVisit, "Calgary");
		addInOrder(placesToVisit, "Quebec");
		addInOrder(placesToVisit, "Regina");
		addInOrder(placesToVisit, "Charlottetown");

		printList(placesToVisit);

		addInOrder(placesToVisit, "Winnipeg");
		addInOrder(placesToVisit, "Quebec");

		printList(placesToVisit);

		
		


	}

	private static void printList(LinkedList<String> linkedList)
	{
		Iterator<String> i = linkedList.iterator();
		while(i.hasNext())
		{
			System.out.println("Now visiting " + i.next());
		}

		System.out.println("====================");
	}

	private static boolean addInOrder(LinkedList<String> linkedList, String newCity)
	{
		ListIterator<String> stringListIterator =  linkedList.listIterator();

		while(stringListIterator.hasNext())
		{
			int comparison = stringListIterator.next().compareTo(newCity);
			if(comparison == 0)		//equal, do not add
			{
				System.out.println(newCity + " is already included as a destination");
				return false;
			}

			else if(comparison > 0)		//new city should appear before this one
			{
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
			}

			else if(comparison < 0)
			{
				//move on next city
			}
		}
		stringListIterator.add(newCity);
		return true;
	}


}