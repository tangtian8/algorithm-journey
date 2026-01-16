package top.tangtian.algorithm.sort.lessnum;

/**
 * @author tangtian
 * @date 2026-01-16 16:40
 * 冒泡排序
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n - 1; i++){
			boolean swapped = false;
			for(int j = 0; j < n - 1 -i;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			//如果没有交换，已排序
			if(!swapped)break;
		}
	}
}
