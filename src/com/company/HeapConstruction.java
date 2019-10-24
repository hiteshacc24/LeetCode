package com.company;
import java.lang.reflect.Array;
import java.util.*;
public class HeapConstruction {
    static class MinHeap {
        ArrayList<Integer> heap = new ArrayList<Integer>();

        public MinHeap(ArrayList<Integer> array) {
            heap = buildHeap(array);
        }

        public ArrayList<Integer> buildHeap(ArrayList<Integer> array) {
            // Write your code here.
            int firstParentIdx = (array.size() - 2)/2;
            for(int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, ArrayList<Integer> heap) {
            // Write your code here.
            int firstChildIdx = currentIdx * 2 + 1;
            while(firstChildIdx <= endIdx) {
                int secondChildIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int indexToSwap;
                if(secondChildIdx !=  -1 && heap.get(secondChildIdx) < heap.get(firstChildIdx)) {
                    indexToSwap = secondChildIdx;
                } else {
                    indexToSwap = firstChildIdx;
                }
                if(heap.get(currentIdx) > heap.get(indexToSwap)) {
                    swap(currentIdx, indexToSwap, heap);
                    currentIdx = indexToSwap;
                    firstChildIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, ArrayList<Integer> heap) {
            // Write your code here.
            while(currentIdx > 0) {
                int parentIdx = (currentIdx - 1)/2;
                if(heap.get(parentIdx) > heap.get(currentIdx)) {
                    swap(currentIdx, parentIdx, heap);
                }
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1)/2;
            }
        }

        public int peek() {
            // Write your code here.
            return heap.get(heap.size() - 1);
        }

        public int remove() {
            // Write your code here.
            swap(heap.size() - 1, 0, heap);
            int valuetoRemove = heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valuetoRemove;
        }

        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            siftUp(heap.size() - 1,heap);
        }
        public void swap(int i, int j, ArrayList<Integer> heap) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}
