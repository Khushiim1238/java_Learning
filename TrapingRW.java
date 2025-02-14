
public class TrapingRW {
    // Logic -
    // Trapping RainWater  *** MPI
     ////if array mai 1 ya 2 element honge toh work nhhi kerga(which means 1 ya 2 buildings hogi toh koi pani trap nhi hoga) [minbar>2] [no ascending or descending order]
     /// pani trap tab hoga jab right and left bar mai se jo minimum aayega uske jitna ji store hogaa and then vo waterlevel ho jayega phir uske baad waterlevel - barheight kr dengai and multiply it by the width of the bar
     /// WaterLevel = min(maxLeftBoundary , maxRightBoundary)  
     /// these two variable are calculated with help of auxiliary arrays, which means that we will calc two arrays(leftMaxBounary and rightMaxBoundary) for each element in the given array of building's height . in this they will contain the max left height for every bar and viceverse for rightMaxBoundary
    public static int tRW(int[] height){
        int n = height.length ;
        // Calc left max Boundary -arrray
        int[] leftMaxBound = new int[n];
        leftMaxBound[0] = height[0];
        for(int i =1;i<n;i++){
            leftMaxBound[i] = Math.max(height[i], leftMaxBound[i-1]);             //leftmost pata hai with help of height and leftmost, next value nikal rhe hai
        }
        // Right Max Boundary -array
        int[] rightMaxBound = new int[n];
        rightMaxBound[n - 1] = height[n - 1];
        for(int i =n-2;i>=0;i--){
            rightMaxBound[i] = Math.max(height[i], rightMaxBound[i+1]);             //rightmost pata hai with help of height and rightmost reverse mai value nikal rhe hai
        }

        int trappedWater = 0;
        // loop where calc waterLevel = min(leftMaxBound,rightMaxBound)
        for(int i =0;i<n;i++){
           int waterLevel = Math.min(leftMaxBound[i], rightMaxBound[i]);
           trappedWater += waterLevel-height[i];           //here we are subtracting the height of the building from the water level to get the exact water levl 
        }
        return trappedWater;
    }
    

    // maxProfitTrade
    //// sabse minimun value price pr buy kr le and use jayda price pr sell krna hai
    /// buyPrice < sellingPrice
    /// profit = sell - buy   [Formula]
    /// price ki array mai se 1st day sirf buy kr sakte hai sell nhi
    /// next ek ekk element ke liye nikalna hai (Sp , (jis din ka dekh rhe hai usse phle tk ka min)Bp , maxProfit
     
    public static int buySellStock(int[] price){
        int maxProfit = 0;                                //global profit
        int buyPrice = Integer.MAX_VALUE;

        for(int i = 0;i<price.length;i++){
            if(buyPrice < price[i]){      //profit
                int profit = price[i] - buyPrice;         //todys profit
                maxProfit = Math.max(maxProfit, profit);
            }
            else{
                buyPrice = price[i];
            }

        }


        return maxProfit;
    }




    public static void main(String[] args) {
        int[] height = {4,2,0,6,3,2,5};
        System.out.println(tRW(height));

        int[] price = {7,1,5,3,6,4};
        System.out.println(buySellStock(price));             //TC = O(n)
    }
}
