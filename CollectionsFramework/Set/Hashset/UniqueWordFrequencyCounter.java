/*
#3 Easy Iteration and conversion
-----------------------------------------------------------------------------------------------------------------------------------
Unique word frequency counter

Take a paragraph as input. Find all unique words using HashSet. Then count how many times each unique word appears in the original text.
Convert HashSet to array and to ArrayList. Show all three iteration styles on HashSet — for-each, Iterator, and converting to
sorted list for ordered printing.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 Why HashSet for unique words: Finding unique words = classic deduplication. HashSet add() is O(1) and auto-deduplicates.
For frequency counting — use unique words from HashSet to drive the count loop over original text. This separation of concerns
(unique extraction vs counting) is cleaner than tracking frequencies manually during input.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 Better for frequency counting — HashMap: HashMap<String, Integer> stores word→count directly in one pass. HashSet + manual
counting is two passes. You will implement this in HashMap problems — but HashSet first teaches the uniqueness foundation that
HashMap builds on.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — HashSet has no index, so how do we iterate? HashSet implements Iterable so for-each works. It also provides iterator()
method. But NO get(index) exists — you cannot ask "give me the 3rd element" because HashSet has no concept of position.
The internal bucket array has positions but they are based on hashCode, not insertion order. Converting to ArrayList gives you
index access — but loses the O(1) lookup benefit. Choose based on what you need after conversion.
-----------------------------------------------------------------------------------------------------------------------------------
Input: "java is great java is powerful java"
Unique words: [java, is, great, powerful] — 4 unique
java: 3 | is: 2 | great: 1 | powerful: 1
Sorted print: [great, is, java, powerful] — via ArrayList sort

Skills: split(), frequency counting, toArray(), HashSet↔ArrayList conversion, Collections.sort() on converted list
Hint at bottom ------>
 */

package Set.Hashset;

import java.util.*;

public class UniqueWordFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = sc.nextLine();

        String[] words = input.split(" ");

        HashSet<String> unique = new HashSet<>();
        for(String w : words){
            unique.add(w);
        }

        System.out.println("\nUnique: "+unique);

        for(String u : unique){
            int count = 0;
            for(String w : words){
                if(u.equals(w)){
                    count++;
                }
            }
            System.out.println(u + ": " + count);
        }

        ArrayList<String> sorted = new ArrayList<>(unique);
        Collections.sort(sorted);
        System.out.println("\nSorted Using ArrayList: "+sorted);

        String[] arr = unique.toArray(new String[0]);
        System.out.println("Array: "+ Arrays.toString(arr));
    }
}

/*
Extract unique words:
String[] words = input.toLowerCase().split(" ")
HashSet<String> unique = new HashSet<>()
for(String w : words) unique.add(w)

Count frequency for each unique word:
for(String u : unique) {
int count = 0;
for(String w : words) { if(w.equals(u)) count++; }
System.out.println(u + ": " + count);
}

Three iteration styles:
1. for-each: for(String s : unique)
2. Iterator: Iterator<String> it = unique.iterator(); while(it.hasNext()) it.next()
3. Convert + sort: ArrayList<String> sorted = new ArrayList<>(unique); Collections.sort(sorted);

Convert to array:
String[] arr = unique.toArray(new String[0])

Convert ArrayList to HashSet:
HashSet<String> fromList = new HashSet<>(existingArrayList) — constructor accepts any Collection.
 */