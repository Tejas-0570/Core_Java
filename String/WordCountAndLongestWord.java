/*
Word count and longest word

Given a sentence, find: (1) the number of words, (2) the longest word, and (3) its length.
Words are separated by single spaces.

Input: "I love Java programming"
Output: Words: 4, Longest: "programming" (11)


 */

public class WordCountAndLongestWord {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String str = "I love Java programming";
        String[] array = str.split(" ");
        int longest = 0;
        String longestWord = "";
        for(int i = 0; i < array.length; i++){
            if(longest < array[i].length()){
                longest = array[i].length();
                longestWord = array[i];
            }
        }
        System.out.println("Words : "+array.length);
        System.out.println("Longest : "+longestWord+" ("+longestWord.length()+")");
    }
}
