class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()
        val solution: IntArray = intArrayOf(0, 1)
        val numElem: Int = nums.size
        var index = 2

        if (nums[0] + nums[1] == target)
            return solution

        hashMap[nums[0]] = 0
        hashMap[nums[1]] = 1

        while (index < numElem) {
            val result = target - nums[index]

            if (hashMap.containsKey(result)) {
                solution[0] = index
                solution[1] = hashMap.getValue(result)
                break
            }
            hashMap[nums[index]] = index++
        }    

        return solution        
    }
}