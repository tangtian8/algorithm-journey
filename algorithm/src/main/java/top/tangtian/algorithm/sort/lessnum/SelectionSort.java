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

	public static void selectSortPractice1(int[] arr){
		 int n = arr.length;
		 //外层循环：需要进行n - 1轮（最后一个元素自动就位）
		 for(int i = 0; i < n - 1;i++){
			 //假设当前的位置i就是未排序部分的最小值
			 int minIdx = i;
			 //内层循环 在未排序部分[i+1, n-1]中找正在的最小值
			 for(int j = i + 1; j < n;j++){
				 //如果找到最小的元素 更新 minIdx
				 if(arr[j] < arr[minIdx]){
					 minIdx = j;
				 }
			 }
			 //内层循环结束后，minIdx 指向未排序部分的最小值
			 //将它与位置i的元素交换
			 int temp = arr[minIdx];
			 arr[minIdx] = arr[i];
			 arr[i] = temp;
		 }
	}

	public static void selectSortPractice2(int[] arr){
		int len = arr.length;
		for(int i = 0; i < len - 1; i++){
			int minInx = i;
			for(int j = i+1 ; j < len;j++){
				if(arr[j] < arr[minInx]){
					minInx = j;
				}
			}
			int temp = arr[minInx];
			arr[minInx] = arr[i];
			arr[i] = temp;
		}
	}















































}
