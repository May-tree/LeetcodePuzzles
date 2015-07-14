/**
 * Created by NicolasTsui on 7/9/15.
 * two pointers
 *
 */
public class ContainWithMostWater {
    public static int maxArea(int[] height){
        int start=0;
        int end=height.length-1;
        int h=Math.min(height[start],height[end]);
        int max=h*(end-start);
        while(start<end){
            h=Math.min(height[start],height[end]);
            System.out.println("h: "+h);
            max=Math.max(max,h*(end-start));
            while(height[start]<=h && start<end){
                start++;
            }
            System.out.println("start: "+start);
            while(height[end]<=h && start<end){
                end--;
            }
            System.out.println("end: "+end);

        }
        return max;
    }
    public static void main(String[] args){
        int[] height={10,9,8,7,6,5,4,3,2,1};
        System.out.println(maxArea(height));
    }
}
