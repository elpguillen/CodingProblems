class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        // Create List where solution will be stored
        // and add [1] to the first row
        List<List<Integer>> result = new ArrayList<>();        
        result.add(new ArrayList<Integer>(Arrays.asList(1)));
        
        // will add a new row with pascal values until
        // we have reached numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> nextRow = new ArrayList<>();
            // every row starts with '1'
            nextRow.add(1);
            
            // compute values and add them to the nextRow
            // the values we are interested in computing
            // will be those up to but not including
            // (currentRow / 2)
            for(int next = 0; next < (i/2); next++) {
                nextRow.add(
                    result.get(i - 1).get(next) +
                    result.get(i - 1).get(next + 1));
            }
            
            // retrieve the other half of the pascal
            // triangle from the values inserted in nextRow
            int index = (int)Math.ceil(i/2.0) - 1;
            
            for (; index >= 0; index--) {
                nextRow.add(nextRow.get(index));
            }
            
            double a = Math.ceil(1/2.0);
            result.add(nextRow);
        }
        
        return result;
        
    }
}