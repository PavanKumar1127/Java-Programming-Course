package amazon;
import java.util.PriorityQueue;

public class CostliestElementBox {
    private PriorityQueue<Integer> maxHeap;

    public CostliestElementBox() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max Heap comparator
    }

    public void addElement(int element) {
        maxHeap.offer(element); // Add element to the Max Heap
    }

    public int getCostliestElement() {
        return maxHeap.peek(); // Get the costliest element
    }

    public int pickElement() {
        return maxHeap.poll(); // Remove and return the costliest element
    }

    public static void main(String[] args) {
        CostliestElementBox box = new CostliestElementBox();
        box.addElement(10);
        box.addElement(20);
        box.addElement(15);

        System.out.println("Costliest element: " + box.getCostliestElement()); // Output: 20

        int pickedElement = box.pickElement();
        System.out.println("Picked element: " + pickedElement); // Output: 20

        System.out.println("Costliest element after picking: " + box.getCostliestElement()); // Output: 15
    }
}
