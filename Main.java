import java.util.Random;
import java.util.Scanner;
class Main{
    public static void main(String[] args){
        int[] nums = new int[20];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<nums.length;i++){
            nums[i]=rand.nextInt(1,100);
        }

        System.out.println("1.Sort\n2.Search");
        int choice = sc.nextInt();


        if(choice==1){
                System.out.println("1.Bubble Sort\n2.Selection Sort\n3.Insertion Sort");
                int sorttype = sc.nextInt();
                if(sorttype == 1){
                    for(int i=0;i<nums.length;i++){
                        System.out.print(nums[i]+",");
                    } 
                    int[] sortedNums = bubbleSort(nums);
                    for(int i=0;i<sortedNums.length;i++){
                        System.out.print(sortedNums[i]+",");
                    }
                }
                else if(sorttype==2){
                    for(int i=0; i<nums.length;i++){
                        System.out.print(nums[i]+",");
                    }
                    int[] sortedNums = selectionSort(nums);
                    System.out.println();
                    for(int i=0;i<sortedNums.length;i++){
                        System.out.print(sortedNums[i]+",");
                    }                
                }
                else{
                    System.out.println("This sorting algorithm is not implemented yet");
                }
            }
            else if(choice==2){
                System.out.println("1.Linear Search\n2.Binary Search");
                int searchtype = sc.nextInt();
                if(searchtype == 1){
                    System.out.println("Enter number to search for :-");
                    int target = sc.nextInt();

                    int indexx = linearSearch(nums, target);
                    if(indexx != -1){
                        System.out.println("Here is the index : "+indexx);
                    }
                    else{
                        System.out.println("Your element is not there");
                    }
                    for(int i=0;i<nums.length;i++){
                        System.out.print(nums[i]+",");
                    }
                }
                if(searchtype==2){
                    System.out.println("Enter number to search for :-");
                    int target = sc.nextInt();
                    int[] sortedNums = bubbleSort(nums);
                    int it = binarySearch(sortedNums, target);
                    if(it != -1){
                        System.out.println("Here is the index : "+it);
                    }
                    else{
                        System.out.println("Your element is not there");
                    }
                    for(int i=0;i<sortedNums.length;i++){
                        System.out.print(sortedNums[i]+",");
                    }
                }
                else{
                    System.out.println("This searching algorithm is not implemented yet");
                }
            }
        
    }


    public static int linearSearch(int[] arr, int target){
        for (int i=0; i<arr.length;i++){
            if (arr[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target){
        int size = arr.length;
        int left=0;
        int right=size-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==target){
                return mid;    
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else if(arr[mid]>target){
                right=mid-1;
            }

        }
        return -1;
    }


    public static int[] bubbleSort(int[] arr){
        int size = arr.length;
        for(int i=0;i<size-1;i++){
                for(int j=0;j<size-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        int size= arr.length;
        for(int i=0;i<size-1;i++){
            int minimumIndex=i;
            for(int j=i+1;j<size;j++){
                if(arr[j]<arr[minimumIndex]){
                    minimumIndex=j;
                }
            }
            int temp;
            temp=arr[minimumIndex];
            arr[minimumIndex]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }


}