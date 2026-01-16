package top.tangtian.algorithm.sort.lessnum;

/**
 * @author tangtian
 * @date 2026-01-16 17:02
 * 插入排序 O(n2)
 */
public class InsertionSort {
	public static void insertSort(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n; i++){
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}
