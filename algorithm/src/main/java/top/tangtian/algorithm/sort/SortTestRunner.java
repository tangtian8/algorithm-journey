package top.tangtian.algorithm.sort;

import top.tangtian.algorithm.sort.lessnum.BubbleSort;
import top.tangtian.algorithm.sort.lessnum.InsertionSort;
import top.tangtian.algorithm.sort.morenum.MergeSort;
import top.tangtian.algorithm.sort.morenum.QuickSort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tangtian
 * @date 2026-02-03
 * 排序算法通用测试启动类
 */
public class SortTestRunner {

    /**
     * 排序算法包装类
     */
    public static class SortAlgorithm {
        private final String name;
        private Consumer<int[]> sortMethod;

        public SortAlgorithm(String name, Consumer<int[]> sortMethod) {
            this.name = name;
            this.sortMethod = sortMethod;
        }

        public String getName() {
            return name;
        }

        public Consumer<int[]> getSortMethod() {
            return sortMethod;
        }
    }

    /**
     * 生成随机数组
     */
    public static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(maxValue);
        }
        return arr;
    }

    /**
     * 生成几乎有序的数组（用于测试最好情况）
     */
    public static int[] generateNearlySortedArray(int size, int swapCount) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < swapCount; i++) {
            int idx1 = random.nextInt(size);
            int idx2 = random.nextInt(size);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }

    /**
     * 生成逆序数组
     */
    public static int[] generateReversedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    /**
     * 打印数组
     */
    public static void printArray(int[] arr) {
        if (arr.length <= 20) {
            System.out.println(Arrays.toString(arr));
        } else {
            System.out.println("数组过大，仅显示前10个元素: " +
                    Arrays.toString(Arrays.copyOfRange(arr, 0, 10)) + " ...");
        }
    }

    /**
     * 验证数组是否已排序
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试单个排序算法
     */
    public static void testSort(SortAlgorithm algorithm, int[] arr, boolean showArray) {
        System.out.println("\n========== " + algorithm.getName() + " ==========");

        // 复制数组以避免影响原数组
        int[] testArr = Arrays.copyOf(arr, arr.length);

        if (showArray) {
            System.out.println("排序前: ");
            printArray(testArr);
        }

        // 记录开始时间
        long startTime = System.nanoTime();

        // 执行排序
        try {
            algorithm.getSortMethod().accept(testArr);
        } catch (Exception e) {
            System.out.println("排序过程出现异常: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // 记录结束时间
        long endTime = System.nanoTime();

        if (showArray) {
            System.out.println("排序后: ");
            printArray(testArr);
        }

        // 验证结果
        boolean sorted = isSorted(testArr);
        System.out.println("排序结果: " + (sorted ? "✓ 正确" : "✗ 错误"));
        System.out.println("耗时: " + (endTime - startTime) / 1000000.0 + " ms");
    }

    /**
     * 批量测试多个算法
     */
    public static void testAllAlgorithms(List<SortAlgorithm> algorithms, int[] arr, boolean showArray) {
        for (SortAlgorithm algorithm : algorithms) {
            testSort(algorithm, arr, showArray);
        }
    }

    /**
     * 性能对比测试
     */
    public static void performanceTest(List<SortAlgorithm> algorithms, int arraySize, int maxValue) {
        System.out.println("\n########## 性能对比测试 ##########");
        System.out.println("数组大小: " + arraySize + ", 最大值: " + maxValue);

        int[] originalArr = generateRandomArray(arraySize, maxValue);

        for (SortAlgorithm algorithm : algorithms) {
            int[] arr = Arrays.copyOf(originalArr, originalArr.length);
            long startTime = System.nanoTime();
            try {
                algorithm.getSortMethod().accept(arr);
                long endTime = System.nanoTime();
                boolean correct = isSorted(arr);
                System.out.printf("%-20s 耗时: %8.2f ms  结果: %s\n",
                        algorithm.getName(),
                        (endTime - startTime) / 1000000.0,
                        correct ? "✓" : "✗");
            } catch (Exception e) {
                System.out.printf("%-20s 执行失败: %s\n", algorithm.getName(), e.getMessage());
            }
        }
    }

    /**
     * 多场景综合测试
     */
    public static void comprehensiveTest(List<SortAlgorithm> algorithms) {
        System.out.println("\n============ 综合场景测试 ============");

        // 场景1: 小数组
        System.out.println("\n--- 场景1: 小数组 (10个元素) ---");
        int[] smallArr = generateRandomArray(10, 100);
        testAllAlgorithms(algorithms, smallArr, true);

        // 场景2: 空数组
        System.out.println("\n--- 场景2: 边界情况 - 空数组 ---");
        testAllAlgorithms(algorithms, new int[]{}, true);

        // 场景3: 单元素
        System.out.println("\n--- 场景3: 边界情况 - 单元素 ---");
        testAllAlgorithms(algorithms, new int[]{42}, true);

        // 场景4: 已排序
        System.out.println("\n--- 场景4: 已排序数组 (最好情况) ---");
        int[] sortedArr = generateNearlySortedArray(20, 0);
        testAllAlgorithms(algorithms, sortedArr, true);

        // 场景5: 逆序
        System.out.println("\n--- 场景5: 逆序数组 (最坏情况) ---");
        int[] reversedArr = generateReversedArray(20);
        testAllAlgorithms(algorithms, reversedArr, true);

        // 场景6: 大量重复元素
        System.out.println("\n--- 场景6: 大量重复元素 ---");
        int[] duplicateArr = generateRandomArray(20, 5);
        testAllAlgorithms(algorithms, duplicateArr, true);
    }

    public static void main(String[] args) {
        // 注册要测试的排序算法
        List<SortAlgorithm> algorithms = new ArrayList<>();

        // 方式1: 无参数的排序算法 - 直接使用方法引用
         algorithms.add(new SortAlgorithm("冒泡排序", BubbleSort::bubbleSortPractise4));
        // algorithms.add(new SortAlgorithm("选择排序", SelectionSort::selectSort));
//         algorithms.add(new SortAlgorithm("插入排序", InsertionSort::insertSortPractice3));

        // 方式2: 有额外参数的排序算法 - 使用Lambda表达式包装
         //algorithms.add(new SortAlgorithm("快速排序", arr -> QuickSort.quickSort(arr, 0, arr.length - 1)));
        // algorithms.add(new SortAlgorithm("归并排序", arr -> MergeSort.mergeSort(arr, 0, arr.length - 1)));
        // algorithms.add(new SortAlgorithm("堆排序", arr -> HeapSort.heapSort(arr, arr.length)));

        if (algorithms.isEmpty()) {
            System.out.println("请先在main方法中注册要测试的排序算法！");
            System.out.println("\n示例1 - 无参数算法（只接收数组）：");
            System.out.println("algorithms.add(new SortAlgorithm(\"冒泡排序\", BubbleSort::bubbleSort));");
            System.out.println("\n示例2 - 有额外参数的算法（需要索引等参数）：");
            System.out.println("algorithms.add(new SortAlgorithm(\"快速排序\", arr -> QuickSort.quickSort(arr, 0, arr.length - 1)));");
            return;
        }

        // 1. 综合场景测试
        comprehensiveTest(algorithms);

        // 2. 性能对比测试 - 不同规模
        performanceTest(algorithms, 1000, 10000);
        performanceTest(algorithms, 5000, 10000);
        performanceTest(algorithms, 10000, 10000);
    }
}