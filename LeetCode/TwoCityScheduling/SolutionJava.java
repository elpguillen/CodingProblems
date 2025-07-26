class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        // find difference for each pair
        // select the pair with max difference and choose
        // the lesser value as long as the city it belongs to
        // has not reached n otherwise choose the other city
        
        int costsRows = costs.length;
        int costsCol = costs[0].length;
        int peopleInA = 0;
        int peopleInB = 0;
        int n = costsRows / 2;
        
        List<Pair<Integer, Integer>> differences = new ArrayList<Pair<Integer,Integer>>();
        
        for (int i = 0; i < costsRows; i++) {
            int difference = Math.abs(costs[i][0] - costs[i][1]);
            Pair<Integer,Integer> pairDiff = new Pair<>(i, difference);
            differences.add(pairDiff);
        }
        
        int sum = 0;
        
        for (int i = 0; i < differences.size(); i++) {
            sum += differences.get(i).getValue();
        }
            
        differences.sort(
            Comparator.<Pair<Integer, Integer>>comparingInt(Pair::getValue).reversed()
        );
        
        int index = 0;
        int nextMinIndex;
        int costCityA;
        int costCityB;
        int totalCost = 0;
        
        while (peopleInA < n && peopleInB < n) {
            nextMinIndex = differences.get(index++).getKey();
            costCityA = costs[nextMinIndex][0];
            costCityB = costs[nextMinIndex][1];
            
            if (costCityA < costCityB) {
                totalCost += costCityA;
                peopleInA++;
            } else {
                totalCost += costCityB;
                peopleInB++;
            }
        }
        
        while (peopleInA < n && index < costsRows) {
            nextMinIndex = differences.get(index++).getKey();
            totalCost += costs[nextMinIndex][0];
            peopleInA++;
        }
        
        while (peopleInB < n && index < costsRows) {
            nextMinIndex = differences.get(index++).getKey();
            totalCost += costs[nextMinIndex][1];
            peopleInB++;
        }
        
        return totalCost;
        
    }
}