class Solution {
    fun reverseVowels(s: String): String {
        // Will be used to determine if character is a vowel
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val chars = s.toCharArray()

        // Keep two pointers to traverse string.
        // One to start at the beginning string
        // Second to start at the end of the string
        var left: Int = 0
        var right: Int = chars.lastIndex

        // Traverse until both characters are vowels
        while (left < right) {
            while (left < right && chars[left] !in vowels) {
                left++
            }

            while (left < right && chars[right] !in vowels) {
                right--
            }

            // Swap vowels
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp

            // Continue with next characters
            left++
            right--
        }
        // At this point all vowels shouls have been swapped.
        return String(chars)
    }
}