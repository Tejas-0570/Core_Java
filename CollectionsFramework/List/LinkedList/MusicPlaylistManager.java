/*
#6 Medium LinkedList of objects
-----------------------------------------------------------------------------------------------------------------------------------
Music playlist manager

Create a Song class (title, artist, duration). Build a playlist using LinkedList<Song>. Operations: add song to end, add song at
specific position, remove by title, play next (remove from front and display), shuffle playlist using Collections.shuffle(), show total duration.
-----------------------------------------------------------------------------------------------------------------------------------
Why LinkedList not ArrayList: Playlist constantly adds songs at specific positions and removes currently playing song from front.
Both are O(1) pointer operations in LinkedList. Also LinkedList of objects is identical syntax to ArrayList of objects —
this proves LinkedList is a drop-in replacement when front/middle operations dominate.
-----------------------------------------------------------------------------------------------------------------------------------
add: Shape of You-Ed-4:24, Blinding-Weeknd-4:02
addAt(1): Levitating-Dua-3:23 → [Shape, Levitating, Blinding]
playNext(): "Now playing: Shape of You by Ed | 4:24"
total duration: sum all durations in seconds, display as mm:ss

Skills: LinkedList<Object>, Iterator removal by field, pollFirst(), Collections.shuffle(), duration calculation
Hint at bottom --->
 */


package List.LinkedList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class MusicPlaylistManager {
    public static void main(String[] args) {
        PlaylistManager pm = new PlaylistManager();
//      ------------- Songs Lists --------------
        Song s1 = new Song("Shape of You", "Ed", 264);
        Song s2 = new Song("Blinding", "Weeknd", 242);
        Song s3 = new Song("Levitating", "Dua", 203);
        Song s4 = new Song("Remove-Song-Example", "Remove", 240);

//      ------------- Add Songs -----------------
        pm.addSong(s1);
        pm.addSong(s2);
        pm.addSong(s3);

//      ------------- Add at specific position -----------------
        pm.addSongSpecificPosition(1, s4);

//      ------------- Remove Songs by Title -----------------
        pm.removeSong("Remove-Song-Example");

//      ------------- Next Songs -----------------
        pm.playNext();

//      ------------- Shuffle Playlist -----------------
        pm.shufflePlaylist();

//      ------------- Total Duration of playlist -----------
        pm.showTotalDuration();

//      ------------- Display Playlist -----------------
        pm.displayPlaylist();


    }
}

class Song{
    private final String title;
    private final String artist;
    private final int durationSeconds;

    Song(String title, String artist, int durationSeconds){
        this.title = title;
        this.artist =artist;
        this.durationSeconds = durationSeconds;
    }

//  ------------------- Getters ---------------------
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public int getDurationSeconds(){
        return durationSeconds;
    }

}

class PlaylistManager{
    LinkedList<Song> playlist = new LinkedList<>();

    public void addSong(Song s){
        playlist.addLast(s);
    }

    public void addSongSpecificPosition(int index, Song s){
        playlist.add(index, s);
    }

    public void removeSong(String title){
        Iterator<Song> it = playlist.iterator();
        while (it.hasNext()){
            if(it.next().getTitle().equals(title)){
                it.remove();
                return;
            }
        }
        System.out.println(title + " not found");
    }

    public void playNext(){
        Song next = playlist.pollFirst();
        if(next == null){
            System.out.println("Playlist is Empty!");
            return;
        }
        System.out.println("Next playing: "+next.getTitle());

    }

    public void showTotalDuration(){
        int total = getTotalDuration();
        System.out.println("Total Duration: "+(total/60)+":"+String.format("%02d", (total%60)));
    }

    public int getTotalDuration(){
        int total = 0;
        for(Song s: playlist){
            total += s.getDurationSeconds();
        }
        return total;
    }

    public void shufflePlaylist(){
        Collections.shuffle(playlist);
        System.out.println("Playlist Shuffled Successfully");
    }

    public void displayPlaylist(){
        Iterator<Song> it = playlist.iterator();
        System.out.println("--------------- All Songs in a Playlist -------------------");
        while(it.hasNext()){
            Song current = it.next();
            System.out.println(current.getTitle()+"-"+current.getArtist()+"-"+(current.getDurationSeconds()/60)+":"+String.format("%02d", current.getDurationSeconds()%60));
        }
    }

}

/*
Song class: private title, artist, durationSeconds (store as int seconds internally). Display duration using
durationSeconds/60 + ":" + durationSeconds%60. Constructor takes (String title, String artist, int durationSeconds).

Remove by title: Cannot use playlist.remove("Shape of You") — that looks for a String, not a Song. Must use
Iterator: Iterator<Song> it = playlist.iterator(); while(it.hasNext()) { if(it.next().getTitle().equals(title)) { it.remove(); break; } }

playNext(): Song s = playlist.pollFirst() — removes and returns front song. Check null before using.

Total duration: Loop all songs — total += song.getDuration(). Then display as total/60 + " min " + total%60 + " sec".

Collections.shuffle(): Collections.shuffle(playlist) — works on LinkedList too since it implements List interface.
 */