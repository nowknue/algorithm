package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1744_bf {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException, IOException {
        int result =0;
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        for(;left<right;left+=2){
            if(nums[left]<1 && nums[left+1]<1){
                result += (nums[left]*nums[left+1]);
            }
            else
                break;
        }
        for(;right>0;right-=2){
            if(nums[right]>1 && nums[right-1]>1){
                result += (nums[right]*nums[right-1]);
            }
            else
                break;
        }
        for(;right>=left;right--){
            result += nums[right];
        }

        System.out.println(result);
    }
}
