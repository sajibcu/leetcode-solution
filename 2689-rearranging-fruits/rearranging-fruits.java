class Solution {
    public long minCost(int[] basket1, int[] basket2) {

        // \U0001f534 Check if making baskets equal is even possible
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : basket1) freq.put(n, freq.getOrDefault(n, 0) + 1);
        for (int n : basket2) freq.put(n, freq.getOrDefault(n, 0) + 1);
        for (int count : freq.values()) {
            if (count % 2 != 0) return -1;
        }

        Thread t1 = new Thread( ()->{
            Arrays.sort(basket1);
        } );
        Thread t2 = new Thread(() -> {
            Arrays.sort(basket2);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println("error");
        }

        List<Integer> remaing1 = new ArrayList<>();
        List<Integer> remaing2 = new ArrayList<>();

        int len1 = basket1.length, len2 = basket2.length;
        int i = 0,j=0;
        while(i< len1 || j < len2) {
            if( i >= len1) {
                remaing2.add(basket2[j++]);
                continue;
            }
            if( j>= len2) {
                remaing1.add(basket1[i++]);
                continue;
            }
            if( basket1[i] ==  basket2[j]) {
                i++;
                j++;
            }else if( basket1[i]  < basket2[j] ) {
                remaing1.add(basket1[i]);
                i++;
            }else {
                remaing2.add(basket2[j]);
                j++;
            }
        }

        // System.out.println(remaing1);
        // System.out.println(remaing2);

        if(remaing1.size() != remaing2.size() || remaing1.size() %2==1 ) return -1;

        i=0;
        j=remaing2.size()-1;

        long ans = 0;
        int allMin = Math.min(basket1[0],basket2[0]);

        while( i < remaing1.size() -1 ) {
            //if(remaing1.get(i) != remaing1.get(i+1) || remaing2.get(j) != remaing2.get(j-1)) return -1;
            ans +=Math.min(Math.min(remaing1.get(i), remaing2.get(j)), 2*allMin);
            i+=2;
            j-=2;
        }
        return ans;
        
    }
}