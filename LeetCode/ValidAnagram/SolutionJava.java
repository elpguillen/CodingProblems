class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharacters = s.toCharArray();
        char[] tCharacters = t.toCharArray();
        
        Arrays.sort(sCharacters);
        Arrays.sort(tCharacters);
        
        return Arrays.equals(sCharacters, tCharacters);
    }
}