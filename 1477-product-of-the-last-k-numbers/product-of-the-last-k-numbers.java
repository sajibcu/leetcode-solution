class ProductOfNumbers {
    List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
    }
    
    public void add(int num) {
        products.add(num);
    }
    
    public int getProduct(int k) {
        int p = 1;
        int i = products.size() - 1;
        while( k-- > 0 ) {
            p *=products.get(i--);
            if( p == 0 ) return p;
        }

        return p;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */