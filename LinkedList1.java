import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList1
{
	public static void main(String[] args)
	{
		LinkedList<String> placesToVisit =  new LinkedList<String>();
		placesToVisit.add("Montreal");
		placesToVisit.add("Toronto");
		placesToVisit.add("Quebec");
		placesToVisit.add("Vancouver");
		placesToVisit.add("Edmonton");
		placesToVisit.add("Winnipeg");
		placesToVisit.add("Regina");

		printList(placesToVisit);


		//will add element on position 1
		placesToVisit.add(1, "Charlottetown");
		printList(placesToVisit);

		//will remove element on number 4
		placesToVisit.remove(4);
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


}