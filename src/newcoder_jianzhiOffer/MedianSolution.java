package newcoder_jianzhiOffer;

import java.util.PriorityQueue;

public class MedianSolution {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    int count=0;

    public void Insert(Integer num) {

        if(count%2==0){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;


    }

    public Double GetMedian() {
        if(count%2==0){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            return new Double(minHeap.peek());
        }

    }


    public static void main(String[] args) {
        MedianSolution m = new MedianSolution();

    }


}
