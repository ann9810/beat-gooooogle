import java.util.ArrayList;
	import java.util.Arrays;
	
public class QuickSort {

		static void sort(int[]array, int left, int right) {
			if(left == right)
				return;
			if(left+1 == right) {
				if(array[left] > array[right])
					swap(array, left, right);
				return;
			}
				
			int l = left;
			int r = right - 1;
			int p = array[right];
		do {
			if(array[l] < p)
				l++;
			
			if(array[r] >= p)
				r--;
			
			if(l < r && array[l]>p && array[r] < p) {
				swap(array, l, r);
				//print(array);
				l++;
				r--;	
			}
				
		}while(l < r);
		
			if(array[r]>=p) swap(array,r,right);
			else {
				r = r+1;
				swap(array,r,right);
			}
			//print(array);
			if(r>left) 
				sort(array,left, r-1);
			if(r<right)
				sort(array, r+1,right);
		}
		public static void swap(int a[], int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		public static void print(int[] arra) {
			for(int i = 0; i < arra.length; i++)
				System.out.print(arra[i] + " ");
				System.out.println();
		}

}
