package top.tangtian.algorithm.sort.lessnum;

/**
 * @author tangtian
 * @date 2026-01-16 16:47
 * 选择排序 时间复杂度0n2
 */
public class SelectionSort {
	public static void selectSort(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n - 1;i++){
			int minIdx = i;
			for(int j = i + 1;j < n;j++){
				if(arr[j] < arr[minIdx]){
					minIdx = j;
				}
			}
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
	}
}
