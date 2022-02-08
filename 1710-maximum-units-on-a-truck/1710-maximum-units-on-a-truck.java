class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int units = 0;
        for(int[] boxType : boxTypes){
            int boxCount = Math.min(truckSize, boxType[0]);
            units += boxCount * boxType[1];
            truckSize -= boxCount;
            if(truckSize == 0){
                break;
            }
        }
        return units;
    }
}