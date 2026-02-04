package top.tangtian.algorithm.sort.lessnum;

/**
 * @author tangtian
 * @date 2026-01-16 17:02
 * 插入排序 O(n2)
 */
public class InsertionSort {
	public static void insertSort(int[] arr){
		int n = arr.length;
		for(int i = 1; i < n; i++){
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	private static void insertSortPractice1(int[] arr){
		int len = arr.length;
		for(int i = 1; i < len; i++){
			int key = arr[i];
			int j = i - 1;
			while(j >=0 && arr[j] > key){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	private static void insertSortPractice2(int[] arr){
		int n = arr.length;
		for(int i = 1; i < n ; i++){
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key){
				arr[j + 1] = arr[j];
				j--;
 			}
			arr[j + 1] = key;
		}
	}

	public static void insertSortPractice3(int[] arr){
		int len = arr.length;
		for(int i = 1; i < len; i++){
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && key < arr[j]){
				arr[j + 1] = arr[j];// 把 arr[j] 向右移一位
				j--;//继续向左检查
			}
			arr[j + 1] = key;
		}
	}
}
