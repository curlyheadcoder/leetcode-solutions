class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for(int i = 0; i < 4; i++){
            if(isEqual(mat, target)){
                return true;
            }else{
                mat = rotateArr(mat);
            }
        }
        return false;
    }
    public int [][] rotateArr(int [][] arr){
        int n = arr.length;
        int [][] rotatedArr = new int [n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rotatedArr[j][n - 1 - i] = arr[i][j];
            }
        }
        return rotatedArr;
    }
    public boolean isEqual(int [][] arr, int [][] target){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}