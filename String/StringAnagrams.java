/*
Definition :
Two strings are anagrams if they contain the exact same characters with the exact same frequencies,
just arranged in a different order.

e.g.
1) listen & silent => frequency - l=1, i=1,s=1,t=1,e=1,n=1 ---> true
2) aabb & aabb => frequency - a=2, b=2 ---> true
3) hello & world ---> false
 */

import java.util.Scanner;
public class StringAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a first String : ");  // listen
        String s1 = sc.next().toLowerCase();
        System.out.print("Enter a second String : "); // silent
        String s2 = sc.next().toLowerCase();
        if(s1.isEmpty() || s2.isEmpty()){
            System.out.println(s1+" & "+s2+" are not anagrams of each other");
            return;
        }
        if(s1.length() != s2.length()){
            System.out.println(s1+" & "+s2+" are not anagrams of each other");
            return;
        }
        if (isAnagrams(s1, s2)) {
            System.out.println(s1+" & "+s2+" are anagrams of each other");
        } else {
            System.out.println(s1+" & "+s2+" are not anagrams of each other");
        }
    }

    public static boolean isAnagrams(String s1, String s2){
        int[] freq = new int[26]; // Create array of 26 slots and assign default value 0 to each slot

        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }

}


/*
i did not understand How Frequency Array Works, can you explain in depth?

index:  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
letter: a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z

'a' - 'a' = 97 - 97 = 0   → index 0
'b' - 'a' = 98 - 97 = 1   → index 1
'l' - 'a' = 108 - 97 = 11  → index 11
's' - 'a' = 115 - 97 = 18  → index 18

Step by Step Example

s1 = "listen"
s2 = "silent"

freq = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] by default assigned by 0
        a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z

Loop runs for each index i simultaneously on both strings:

i=0 → s1[0]='l', s2[0]='s'
      freq['l'-'a']++ → freq[11]++ = 1
      freq['s'-'a']-- → freq[18]-- = -1

i=1 → s1[1]='i', s2[1]='i'
      freq['i'-'a']++ → freq[8]++ = 1
      freq['i'-'a']-- → freq[8]-- = 0

i=2 → s1[2]='s', s2[2]='l'
      freq['s'-'a']++ → freq[18]++ = 0  (was -1, now back to 0)
      freq['l'-'a']-- → freq[11]-- = 0  (was 1, now back to 0)

i=3 → s1[3]='t', s2[3]='e'
      freq['t'-'a']++ → freq[19]++ = 1
      freq['e'-'a']-- → freq[4]-- = -1

i=4 → s1[4]='e', s2[4]='n'
      freq['e'-'a']++ → freq[4]++ = 0   (was -1, now back to 0)
      freq['n'-'a']-- → freq[13]-- = -1

i=5 → s1[5]='n', s2[5]='t'
      freq['n'-'a']++ → freq[13]++ = 0  (was -1, now back to 0)
      freq['t'-'a']-- → freq[19]-- = 0  (was 1, now back to 0)


One more question why you have minus 'a' why you have not used any other alphabet like freq[s1.charAt(i) - 'e']++ ?
'a' - 'a' = 97 - 97 = 0   ✅ valid index
'b' - 'a' = 98 - 97 = 1   ✅ valid index
'c' - 'a' = 99 - 97 = 2   ✅ valid index
...
'z' - 'a' = 122 - 97 = 25 ✅ valid index

What Happens If You Use - 'e'
'a' - 'e' = 97 - 101 = -4   ❌ NEGATIVE index — crashes!
'b' - 'e' = 98 - 101 = -3   ❌ NEGATIVE index — crashes!
'c' - 'e' = 99 - 101 = -2   ❌ NEGATIVE index — crashes!
'd' - 'e' = 100 - 101 = -1  ❌ NEGATIVE index — crashes!
'e' - 'e' = 101 - 101 = 0   ✅ only this works
'f' - 'e' = 102 - 101 = 1   ✅
...
'z' - 'e' = 122 - 101 = 21  ✅


 */
