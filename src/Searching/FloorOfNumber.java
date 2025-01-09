package Searching;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr= new int[]{2,4,6,9,14,16,18};
        int target = 10;
        int ans=floor(arr,target);
        System.out.println(ans);
    }

    //greatest nuumber <= target
    static int floor(int[] arr, int target) {

        if(arr.length==0 || target<arr[0])return -1;
        int start = 0;
        int end = arr.length-1;
        while(start <= end) {
            int mid= start + (end-start)/2;
            if(arr[mid] == target) return arr[mid];
            else if(target<arr[mid]){
                end=mid-1;
            }
            else start=mid+1;
        }
        return arr[end];
    }
}
