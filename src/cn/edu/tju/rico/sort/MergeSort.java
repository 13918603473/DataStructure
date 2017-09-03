package cn.edu.tju.rico.sort;

import java.util.Arrays;

/**
 * Title: �鲢���� ����������Ϊ�򵥵������㷨����һ���ݹ��㷨 Description:�鲢��������������̣��� �� ��
 * "��"��ָ��ԭ���зֳɰ������У��ֱ�������н��еݹ����� "��"��ָ���ź���ĸ������кϲ���ԭ����
 * 
 * �鲢�������Ҫ�����ǣ���Ҫһ����ԭ����������һ����ĸ�������ռ�
 * 
 * �鲢����������ԭʼ���У������������Ρ�ƽ�����κ��������ʱ�临�Ӷȶ�һ�� ʱ�临�Ӷȣ��������O(n)��ƽ������O(n^2)���������O(n^2)
 * �ռ临�Ӷȣ�O(n) �� �� �ԣ��ȶ� �ڲ�����(���������������Ԫ����ȫ���ڴ�)
 * 
 * @author rico
 * @created 2017��5��20�� ����10:40:00
 */
public class MergeSort {

	/**
	 * @description �鲢�����㷨(�ݹ��㷨)����ȥ�ֽ⣬�����ϲ�
	 * @author rico
	 * @created 2017��5��20�� ����4:04:52
	 * @param target
	 *            ����������
	 * @param left
	 *            ������������ʼλ��
	 * @param right
	 *            ������������ֹλ��
	 * @return
	 */

	public static void mergeSort(int[] target) {
		int[] copy = Arrays.copyOf(target, target.length);    // �ռ临�Ӷ�O(n)
		mergeSort(target, copy, 0, target.length - 1);
	}

	public static void mergeSort(int[] target, int[] copy, int left, int right) {
		if (right > left) { // �ݹ���ֹ����
			int mid = (left + right) / 2;
			mergeSort(target, copy, left, mid); // �鲢�����һ��������
			mergeSort(target, copy, mid + 1, right); // �鲢����ڶ���������
			merge(target, copy, left, mid, right); // �ϲ������г�ԭ����
		}
	}

	/**
	 * @description ��·�鲢�㷨
	 * @author rico
	 * @created 2017��5��20�� ����3:59:16
	 * @param target
	 *            ���ڴ洢�鲢���
	 * @param left
	 *            ��һ�������ĵ�һ��Ԫ������λ��
	 * @param mid
	 *            ��һ�����������һ��Ԫ������λ��
	 * @param right
	 *            �ڶ������������һ��Ԫ������λ��
	 * @return
	 */
	public static void merge(int[] target, int[] copy, int left, int mid,
			int right) {

		// s1,s2�Ǽ��ָ�룬index �Ǵ��ָ��
		int s1 = left;
		int s2 = mid + 1;
		int index = left;

		// ������δ����꣬�����Ƚ�
		while (s1 <= mid && s2 <= right) {
			if (copy[s1] <= copy[s2]) { // �ȶ���
				target[index++] = copy[s1++];
			} else {
				target[index++] = copy[s2++];
			}
		}

		// ����һ����δ����꣬����
		while (s1 <= mid) {
			target[index++] = copy[s1++];
		}

		// ���ڶ�����δ����꣬����
		while (s2 <= right) {
			target[index++] = copy[s2++];
		}
		
		// ���¸������� copy
		for (int i = left; i <= right; i++) {
			copy[i] = target[i];
		}
	}
	
	public static void main(String[] args) {
		int[] target = { 21, 25, 49, 25, 16, 8, 31, 41 };
		mergeSort(target);
		System.out.println(Arrays.toString(target));
	}
}
