class Solution:
    def reverseWords(self, s: str) -> str:
        """
        Reverses the words of a string.
        Steps:
          1. Create an array of words from 's'.
          2. Reverse the array of words.
          3. Join each word in the array of words
              with a space between each word.

        Keyword arguments:
        s -- the string to reverse
        """
        splitWords = s.split()
        reverseWords = splitWords[::-1]
        return ' '.join(reverseWords)