class Solution {
    public int[] findRightInterval(int[][] intv) {
        int n=intv.length;
        int [][] arr=new int[n][3];

        for(int i=0;i<n;i++){
           
            arr[i][0]=intv[i][0];
             arr[i][1]=intv[i][1];
              arr[i][2]=i;
        }


        Arrays.sort(arr,(a,b)->a[0]-b[0]);

int ans[]=new int[n];
         for(int i=0;i<n;i++){

            ans[arr[i][2]]=binaryseach(arr,i,n-1,arr[i][1]);
         }
        

        return ans;
    }

    public int binaryseach(int [][] arr,int low,int high,int target){

        
         int result = -1; 

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid][0] >= target) {
                result = arr[mid][2];  
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;


    }
}