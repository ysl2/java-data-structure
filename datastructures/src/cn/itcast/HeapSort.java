package cn.itcast;

public class HeapSort {
	public static void sort(int[] data) {
		MaxHeap h = new MaxHeap();
		h.init(data);
		for (int i = 0; i < data.length; i++)
			h.remove();
		System.arraycopy(h.queue, 1, data, 0, data.length);
	}

	private static class MaxHeap {

		void init(int[] data) {
			this.queue = new int[data.length + 1];
			for (int i = 0; i < data.length; i++) {
				queue[++size] = data[i];
				fixUp(size);
			}
		}

		private int size = 0;

		private int[] queue;

		public int get() {
			return queue[1];

		}

		public void remove() {
			SortTest.swap(queue, 1, size--);
			fixDown(1);
		}

		// fixdown
		private void fixDown(int k) {
			int j;
			while ((j = k << 1) <= size) {
				if (j < size && queue[j] < queue[j + 1])
					j++;
				if (queue[k] > queue[j]) // ???????

					break;
				SortTest.swap(queue, j, k);
				k = j;
			}
		}

		private void fixUp(int k) {
			while (k > 1) {
				int j = k >> 1;
				if (queue[j] > queue[k])
					break;
				SortTest.swap(queue, j, k);

				k = j;
			}
		}

	}
}
/*
 * �����������˴���ѣ���С���ѣ��Ѷ���¼�Ĺؼ�����󣨻���С����һ������ ʹ���ڵ�ǰ��������ѡȡ��󣨻���С���ؼ��ֵļ�¼��ü򵥡�
 * ��1���ô��������Ļ���˼�� ���� �� �Ƚ���ʼ�ļ�R[1..n]����һ������ѣ��˶�Ϊ��ʼ�������� ���� ��
 * �ٽ��ؼ������ļ�¼R[1]�����Ѷ����������������һ�� ��¼R[n]�������ɴ˵õ��µ�������R[1..n-1]��������R[n]��
 * ������R[1..n-1].keys��R[n].key ���� �����ڽ������µĸ�R[1]����Υ�������ʣ���Ӧ����ǰ������R[1..n-1]����Ϊ�ѡ�
 * Ȼ���ٴν�R[1..n-1]�йؼ������ļ�¼R[1]�͸���������һ����¼R[n-1]������
 * �ɴ˵õ��µ�������R[1..n-2]��������R[n-1..n]��
 * ���������ϵR[1..n-2].keys��R[n-1..n].keys��ͬ��Ҫ��R[1..n-2]����Ϊ�ѡ� �� ֱ��������ֻ��һ��Ԫ��Ϊֹ��
 * ��2������������㷨�Ļ��������� ���� �� ��ʼ����������R[1..n]����Ϊ��ʼ�ѣ� ���� ��
 * ÿһ������Ļ�������������ǰ�������ĶѶ���¼R[1]�͸���������һ����¼������ Ȼ���µ�����������Ϊ�ѣ�����ؽ��ѣ���
 */
