class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
    
        if (intervals.isEmpty()) return emptyArray()

        // 1. Sort by start time
        intervals.sortBy { it[0] }

        val result = mutableListOf<IntArray>()

        for (interval in intervals) {
            if (result.isEmpty()) {
                result.add(interval)
            } else {
                val last = result.last()

                // 2. Check for overlap
                if (interval[0] <= last[1]) {
                    // Merge intervals
                    last[1] = maxOf(last[1], interval[1])
                } else {
                    result.add(interval)
                }
            }
        }

        return result.toTypedArray()
    }
}