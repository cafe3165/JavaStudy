package leetcode_list200;

public class T74searchMatrix_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int len=m*n;
        return biSearch(matrix,target,0,len-1);
    }

    private boolean biSearch(int[][] matrix, int target, int l, int h) {
            int mid=l+(h-l)/2;
            int m=mid/matrix[0].length,n=mid%matrix[0].length;
            if(matrix[m][n]==target){
                return true;
            }
            if(l>=h){
                return false;
            }

            boolean res=false;
            if(matrix[m][n]>=target){
                res|=biSearch(matrix,target,l,mid);
                if(res==true){
                    return res;
                }
            }
            if(matrix[m][n]<target){
                res|=biSearch(matrix,target,mid+1,h);
            }
            return res;

    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        T74searchMatrix_1 t = new T74searchMatrix_1();
        System.out.println(t.searchMatrix(matrix, target));
    }
}
