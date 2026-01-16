package top.tangtian.algorithm.sort.morenum;

/**
 * @author tangtian
 * @date 2026-01-16 18:07
 * 时间复杂度 平均 O(n logn ) 最坏O(n2)
 */
public class QuickSort {
	public static void quickSort(int[] arr,int low,int high){
		if(low < high){
			int pi = partition(arr,low,high);
			quickSort(arr,low,pi - 1);
			quickSort(arr,pi + 1,high);
		}
	}

	private static int partition(int[] arr,int low, int high){
		int pivot = arr[high];
		int i = low - 1;
		for(int j = low;j < high; j++){
			if(arr[j] < pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
