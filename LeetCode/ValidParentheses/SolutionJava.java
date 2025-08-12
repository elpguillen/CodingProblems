class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> checker = new Stack<>();
        
        char[] characters = s.toCharArray();
        
        for (char character : characters) {
            if (checker.empty()) {
                if (isClosedParen(character))
                    return false;
                else
                    checker.push(character);
            } else {
                if (isClosedParen(character)) {
                    char topOfStack = checker.peek();
                    if (!parenMatches(topOfStack, character)) {
                        return false;
                    } else {
                        checker.pop();
                    }
                } else {
                    checker.push(character);
                }
            }
        }
        
        if (checker.empty())
            return true;
        
        return false;
    }
    
    public boolean isOpenParen(char c) {
        
        if ( c == '(' || c == '[' ||
                c == '{' ) {
            return true;
        }
        
        return false;
    }
    
    public boolean isClosedParen(char c) {
        
        if ( c == ')' || c == ']' || c == '}' )
            return true;
        
        return false;
    }
    
    public boolean parenMatches(char open, char closed) {
        if ( open == '(' && closed == ')' )
            return true;
        if ( open == '[' && closed == ']' )
            return true;
        if ( open == '{' && closed == '}' )
            return true;
        return false;
    }
}