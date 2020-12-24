import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class MainSongPLaylist
{
    private static ArrayList<Album> albums = new ArrayList<Album>();

	public static void main(String[] args)
	{
        Album album = new Album("Divide", "Ed Sheeran");
        album.addSong("Eraser", 4.59);
        album.addSong("Castle on the Hill", 3.12);
        album.addSong("Dive", 4.51);
        album.addSong("Shape of you", 3.54);
        album.addSong("Perfect", 3.33);
        album.addSong("Galway Girl", 4.24);
        album.addSong("Happier", 3.15);
        album.addSong("New Man", 4.25);
        album.addSong("Hearts dont't break", 3.14);
        album.addSong("What do I know", 4.05);
        albums.add(album);

        album = new Album("Metallica 1991", "Metallica");
        album.addSong("Enter Sandman", 4.59);
        album.addSong("Sad but true", 3.59);
        album.addSong("Holier than thou", 2.59);
        album.addSong("The unforgiven", 5.59);
        album.addSong("Wherever I may roam", 4.59);
        album.addSong("Through the never", 4.59);
        album.addSong("Nothing else matters", 4.59);
        album.addSong("Of wolf and man", 4.59);
        album.addSong("The God that failed", 4.59);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Shape of you", playList);
        albums.get(0).addToPlaylist("Perfect", playList);
        albums.get(0).addToPlaylist("Speed king", playList);    // Does not exist
        albums.get(0).addToPlaylist(9, playList);
        albums.get(1).addToPlaylist(8, playList);
        albums.get(1).addToPlaylist(3, playList);
        albums.get(1).addToPlaylist(2, playList);
        albums.get(1).addToPlaylist(88, playList);              // Does not exist

        play(playList);
	}


    private static void play(LinkedList<Song> playList)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false; 
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0)
        {
            System.out.println("No songs in playlist");
            return;
        }

        else
        {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();

        }


        while(!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action)
            {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward = true;
                    }

                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing " + listIterator.next().toString());

                    }
                    else
                    {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }

                    break;

                case 2:
                    if(forward)
                    {
                        if (listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward = false;
                    }

                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }

                    else 
                    {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }

                    break;

                case 3:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        }
                        else
                        {
                            System.out.println("We are at the start of the list");
                        }


                    }

                    else
                    {
                       if (listIterator.hasNext())
                       {
                        System.out.println("Now replaying " + listIterator.next().toString());
                        forward = true;
                       }

                       else
                       {
                        System.out.println("We have reached the end of the list");
                       } 
                    }

                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;
            }
        }
    }


    private static void printMenu() 
    {
        System.out.println("Available actions: \npress");
        System.out.println("0 - to quit\n" +
                            "1 - to play next song\n" +
                            "2 - to play previous song\n" + 
                            "3 - to replay the current song\n" +
                            "4 - list songs in the playlist\n" +
                            "5 - print available actions.");
    }



    private static void printList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("========================");
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
        System.out.println("========================");
    }




}