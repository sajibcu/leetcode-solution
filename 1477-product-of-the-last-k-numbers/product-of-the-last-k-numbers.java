class ProductOfNumbers {
    List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }
    
    public void add(int num) {
        if( num == 0) {
            products.clear();
            products.add(1);
            return;
        }

        int l = products.size();
        products.add(num * products.get(l - 1 ));
       
    }
    
    public int getProduct(int k) {

        
        
        int l = products.size();
        // for(int i = 0; i< l; i++ ){
        //     System.out.print(products.get(i)+"##");
        // }
        // System.out.println("------------------");
        if( k >=l ) return 0;
        return products.get(l-1) / products.get(l-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */