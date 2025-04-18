class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());

        if(left.size() < right.size() ) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if( left.size() == right.size() ) return (double) ( left.peek() + right.peek() ) / 2.0;
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */