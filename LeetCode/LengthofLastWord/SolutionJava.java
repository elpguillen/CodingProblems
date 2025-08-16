class Solution {
    public int lengthOfLastWord(String s) {

        int length = 0;
        int sPos = s.length() - 1;

        while ( sPos >= 0 && s.charAt(sPos) == ' ')
            sPos -= 1; 
        
        while ( sPos >= 0 && s.charAt(sPos) != ' ') {
            length += 1;
            sPos -= 1;
        }

        return length;
    }
}