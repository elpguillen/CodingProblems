class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        if (ransomNote.length() > magazine.length())
            return false;
        // hashMap<Character, Integer>
        // key = character in magazine
        // value = # times character appears in magazine
        
        // add characters in magazine to map
        HashMap<Character, Integer> letters = new HashMap<>();
        char[] magazineCharacters = magazine.toCharArray();
        
        for (char c : magazineCharacters) {
            if (letters.containsKey(c)) {
                int numTimesAppear = letters.get(c);
                letters.replace(c, numTimesAppear + 1);
            } else {
                letters.put(c, 1);
            }
        }
        
        // check if all letters from magazine can
        // be found in ransomNote
        char[] noteCharacters = ransomNote.toCharArray();
        
        for (char c : noteCharacters) {
            if (letters.containsKey(c)) {
                int timesAppear = letters.get(c);
                if (timesAppear < 1) {
                    return false;
                }
                letters.replace(c, timesAppear - 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
}