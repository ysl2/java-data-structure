package cn.itcast;

/*
 * 插入排序基本思想
 * 将n个元素的数列分为已有序和无序两个部分，如插入排序过程示例下所示：
 * {{a1}，{a2，a3，a4，…，an}}
 * {{a1⑴，a2⑴}，{a3⑴，a4⑴ …，an⑴}}
 * {{a1(n-1），a2(n-1) ，…},{an(n-1)}}
 * 每次处理就是将无序数列的第一个元素与有序数列的元素从后往前逐个进行比较，
 * 找出插入位置，将该元素插入到有序数列的合适位置中。
 */
public class InsertSort {
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; (j > 0) && (arr[j] < arr[j - 1]); j--) {
				SortTest.swap(arr, j, j - 1);
			}
		}
	}
}
