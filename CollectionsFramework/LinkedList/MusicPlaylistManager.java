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


package LinkedList;

public class MusicPlaylistManager {
    public static void main(String[] args) {

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