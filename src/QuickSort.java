import java.util.ArrayList;
	import java.util.Arrays;
	
public class QuickSort {

		private static void sort(int[]array, int left, int right) {
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
			System.out.println("left:" + left + " right:" + right);
		do {
			
			System.out.println("r " + r + "," + l);
			if(array[l] < p)
				l++;
			
			if(array[r] >= p)
				r--;
			
			if(l < r && array[l]>p && array[r] < p) {
				swap(array, l, r);
				l++;
				r--;	
			}
				print(array);
		}while(l < r);
			swap(array,l,right);
			print(array);
			sort(array,left, l-1);
			sort(array, l+1,right);
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
