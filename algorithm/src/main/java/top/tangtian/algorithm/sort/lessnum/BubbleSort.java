package top.tangtian.algorithm.sort.lessnum;

/**
 * @author tangtian
 * @date 2026-01-16 16:40
 * 冒泡排序
 * 最坏情况（逆序）：O(n²)
 * 最好情况（已排序）：O(n) ✨ 因为有 swapped 优化
 * 平均情况：O(n²)
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

	private  void bubbleSortPractise1(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n- 1;i++){
			boolean swapped = false;
			for(int j = 0; i < n - 1 - i; j++){
				if(arr[i] > arr[j]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped){
				break;
			}
		}
	}

	private void bubbleSortPractise2(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n-1;i++){
			//每一轮有是否有交换， 没有交换就是已经排序好了的
			boolean swapped = false;
			for(int j = 0; j < n - 1 - i;j++){
				if(arr[j] > arr [j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
		}
	}


	public static void bubbleSortPractise3(int[] arr){
		int len = arr.length;
		for(int i = 0; i < len - 1; i++){
			boolean swapped = false;
			for(int j = 0; j < len - 1 - i; j++){
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr [j + 1];
					temp = arr[j];
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
		}
	}


	public static void bubbleSortPractise4(int[] arr){
		int len = arr.length;
		for(int i = 0; i < len - 1; i++){
			boolean swapped = false;
			for(int j = 0; j < len - i - 1; j++){
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
		}
	}




































}
