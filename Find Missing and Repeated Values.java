class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<Integer> l = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                l.add(grid[i][j]);
            }
        }
        Collections.sort(l);
        int len = l.size();
        int[] arr = {-1, -1};
        
        for(int i=0; i<len-1; i++){
            if(l.get(i).equals(l.get(i+1))){
                arr[0] = l.get(i);
            }
        }
        
        for(int i=0; i<len; i++){
            if(!l.contains(i+1)){
                arr[1] = i+1;
                break;
            }
        }
        return arr;
    }
}
