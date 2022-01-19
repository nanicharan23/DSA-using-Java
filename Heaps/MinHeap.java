import java.util.*;
class MinHeap
{
    int capacity=10;
    int size=0;
    int items[]=new int[capacity];
    //Methods to get Index of parent,left and right
    int getLeftChildIndex(int parentIndex){return 2*parentIndex+1;}
    int getRightChildIndex(int parentIndex){return 2*parentIndex+2;}
    int getParentIndex(int childIndex){return (childIndex-1)/2;}// floor value


    //Methods to know if there is left,right or parent
    boolean hasLeftChild(int index){return getLeftChildIndex(index)<size;}
    boolean hasRightChild(int index){return getRightChildIndex(index)<size;}
    boolean hasParent(int index){return getParentIndex(index)>=0;}


    //Methods to get the value of left, right and parent
    int lefChild(int index){return items[getLeftChildIndex(index)];}
    int parent(int index){return items[getParentIndex(index)];}
    int rightChild(int index){return items[getRightChildIndex(index)];}


    // Method to swap values in two indices.
    void swap(int index1 , int index2)
    {
        int temp=items[index1];
        items[index1]=items[index2];
        items[index2]=temp;
    }

    /*If the array is full, 
    it creates new array which 
    is doubled of prev array.*/
    void ensureCapacity()
    {
        if(size==capacity)
        {
            items=Arrays.copyOf(items, capacity*2);
            capacity*=2;
        }
    }
    int peek()
    {
        if(size==0) 
        return -1;
        return items[0];
    }
    int poll()
    {
        if(size==0) return -1;
        int item=items[0];
        items[0]=items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    void add(int item)
    {
        ensureCapacity();
        items[size]=item;
        size++;
        heapifyUp();
    }
    void heapifyUp()
    {
        int index=size-1;
        while(hasParent(index) && parent(index)>items[index])
        {
            swap(getParentIndex(index),index);
            index=getParentIndex(index);
        }
    }
    void heapifyDown()
    {
        int index=0;
        while(hasLeftChild(index))
        {
            int smallerChildIndex=getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index)<lefChild(index))
            {
                smallerChildIndex=getRightChildIndex(index);
            }
            if(items[index]<items[smallerChildIndex])
                break;
            else
            {
                swap(smallerChildIndex,index);
            }
            index=smallerChildIndex;
        }
    }
  /*  void displayitems()
    {
        for(int i=0;i<size;i++)
        {
            System.out.print(items[i]+" ");
        }
    }*/
    static void solve()
    {
        Scanner sc=new Scanner(System.in);
        MinHeap m=new MinHeap();
        int n=sc.nextInt();
        while(n-->0)
        {
            int val=sc.nextInt();
            m.add(val);
        }
        while(m.size!=0)
        {
            System.out.println(m.poll());
        }
    }
    public static void main(String[] args) {
        
        solve();
    }
}