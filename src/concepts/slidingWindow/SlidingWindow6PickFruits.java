package concepts.slidingWindow;

import java.util.HashMap;

public class SlidingWindow6PickFruits {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,2};
		System.out.println(totalFruit(arr));
	}

    public static int totalFruit(int[] fruits) {
        int n=fruits.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        int i=0;
        int j=0;
       
        while(i<n)
        { 
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            if(map.size()>2)
            { 
                while(map.size()>2)
                { 
                   map.put(fruits[j],map.get(fruits[j])-1);
                    if(map.get(fruits[j])==0)
                    map.remove(fruits[j]);
                    j++;
                    
                }
            }
            ans=Math.max(ans,i-j+1);
            i++;

        }
        return ans;

        
    }

}
