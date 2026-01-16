package top.tangtian.algorithm.sort.morenum;

/**
 * @author tangtian
 * @date 2026-01-16 18:21
 */
public class MergeSort {
	public static void mergeSort(int[] arr,int left, int right){
		if(left < right){
			int mid = left + (right - left) / 2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+ 1,right);
			merge(arr,left,mid,right);
		}
	}

	private static void merge(int[] arr, int left,int mid ,int right){
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];


	}
}
