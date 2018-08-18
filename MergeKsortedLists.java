/**
 * Zhia's Interview Prep Course <Week 2>
 *
 * @author Chloe Kim (chloekim@cmu.edu)
 */
import java.util.*;
/**
 * [Question 2]
 * Write a function to sort two sorted lists.
 * Follow-up: Write a function to sort k number of sorted lists.
 *
 * [Explanation]
 * I would use the index and iterator in order to sort two sorted lists.
 * By comparing the current element at each indices, I would be able to sort/merge two sorted lists.
 * 
 * For the follow-up question, I would use a inner class 'Node' which has an iterator in it
 * and a min heap to keep track of the current smallest element in each lists.
 */
class MergeKsortedLists {
    public static void main(String[] args) {
        MergeKsortedLists m = new MergeKsortedLists();
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        List<Integer> innerlist1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> innerlist2 = Arrays.asList(2, 5, 7, 8);
        List<Integer> innerlist3 = Arrays.asList(13);
        List<Integer> innerlist4 = Arrays.asList(4, 9, 10, 20);
        input.add(innerlist1);
        input.add(innerlist2);
        input.add(innerlist3);
        input.add(innerlist4);

        for (int i : m.sort(input)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public List<Integer> sort(List<List<Integer>> input) {
        PriorityQueue<Node> pq = new PriorityQueue<>(input.size(), (a,b) -> a.val - b.val);
        for (List<Integer> list : input) {
            Iterator<Integer> itr = list.iterator();

            if (!itr.hasNext()) {
                continue;
            }
            Node node = new Node(itr.next(), itr);
            pq.offer(node);
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            res.add(node.val);
            if (node.itr.hasNext()) {
                node.val = node.itr.next();
                pq.offer(node);
            }
        }
        return res;
    }

    private class Node {
        int val;
        Iterator<Integer> itr;

        Node (int val, Iterator<Integer> itr) {
            this.val = val;
            this.itr = itr;
        }
    }
}