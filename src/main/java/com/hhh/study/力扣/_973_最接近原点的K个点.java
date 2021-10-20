package com.hhh.study.力扣;

import java.util.Comparator;

public class _973_最接近原点的K个点 {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{-2,2}};
        int[][] ints = kClosest(arr, 1);
        for (int[] i:ints){
                System.out.println(i[0]+","+i[1]);
        }

    }

    public static int[][] kClosest(int[][] points, int K) {
        class MaxHeap<V> {
            private Object[] arr = null;
            private Comparator comparator = null;
            private int size = 0;

            public MaxHeap(int length, Comparator comparator){
                this.arr = new Object[length];
                this.comparator = comparator;
            }

            public void add(V value) {

                if (size < arr.length) {
                    arr[size] = value;
                    up(size);
                    size++;
                } else {
                    if (comparator != null) {
                        if (comparator.compare(value, arr[0]) < 0) {
                            arr[0] = value;
                            down(0);
                        }
                    }
                }
            }

            public void up(int index) {
                while (index > 0) {
                    int parent = parentIndex(index);
                    if (comparator != null) {
                        if (comparator.compare(arr[index], arr[parent]) > 0) {
                            swap(index, parent);
                            index = parent;
                            continue;
                        }
                        break;
                    }
                }
            }

            public void down(int index) {
                int sign = size >> 1;

                while (index < sign) {
                    int leftChildIndex = leftChildIndex(index);
                    int rightChildIndex = rightChildIndex(index);
                    int childIndex = leftChildIndex;
                    if (comparator != null) {
                        if (rightChildIndex < size && comparator.compare(arr[leftChildIndex], arr[rightChildIndex]) < 0) {
                            childIndex = rightChildIndex;
                        }

                        if (comparator.compare(arr[index], arr[childIndex]) < 0) {
                            swap(index, childIndex);
                            index = childIndex;
                        } else {
                            break;
                        }
                    }
                }

            }

            public V pop(){
                if (size == 0){
                    throw new NullPointerException("该最大堆无元素");
                }
                V result = (V)arr[0];
                delete(result);

                return result;


            }

            public boolean delete(V value){

                int index = getIndex(value);
                if (index == -1){
                    return false;
                }
                arr[index] = arr[--size];
                arr[size] = null;
                down(index);

                return true;

            }

            public int getIndex(V value){
                for (int i = 0; i < size; i++){
                    if (arr[i].equals(value)){
                        return i;
                    }
                }
                return -1;
            }

            public int getSize(){
                return this.size;
            }

            public int leftChildIndex(int index) {
                return (index << 1) + 1;
            }

            public int rightChildIndex(int index) {
                return (index << 1) + 2;
            }

            public int parentIndex(int index) {
                if (index == 0) {
                    throw new NullPointerException("根节点没有父节点");
                }

                return (index - 1) >> 1;
            }

            public void swap(int index1, int index2) {
                Object temp = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = temp;
            }


        }

        MaxHeap<int[]> maxHeap = new MaxHeap<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0] + o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });

        for (int[] i : points){
            maxHeap.add(i);
        }
        int[][] result = new int[maxHeap.size][];
        int i = 0;
        while (maxHeap.getSize()>0){
            int[] pop = maxHeap.pop();
            result[i++] = pop;

        }

        return result;


    }
}
