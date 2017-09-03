package cn.edu.tju.rico.sort;

import java.util.Arrays;

/**
 * Title: ���������е�ϣ������ Description: �ֱ�Լ��Ϊgap��gap�������н���ֱ�Ӳ������򣬲�����Сgap,ֱ��Ϊ 1
 * 
 * �տ�ʼʱ��gap�ϴ�ÿ��������Ԫ�ؽ��٣������ٶȽϿ죻 ����������ڣ�gap��С��ÿ��������Ԫ�ؽ϶࣬���󲿷�Ԫ�ػ����������������ٶ��ԽϿ졣
 * 
 * ʱ�临�Ӷȣ�O(n) ~ O(n^2) �ռ临�Ӷȣ�O(1) �� �� �ԣ����ȶ� �ڲ�����(���������������Ԫ����ȫ���ڴ�)
 * 
 * @author rico
 * @created 2017��5��20�� ����10:40:00
 */
public class ShellSort {

	/**
	 * @description
	 * @author rico
	 * @created 2017��5��21�� ����7:56:03
	 * @param target
	 * @return
	 */
	public static int[] shellSort(int[] target) {
		if (target != null && target.length != 1) {
			int gap = target.length; // gap����СΪgap��������
			do {
				gap = gap / 3 + 1; // ������Сgapֱ��Ϊ1
				for (int i = 0 + gap; i < target.length; i++) { // ��ÿ�������н���ֱ�Ӳ�������
					if (target[i] < target[i - gap]) {
						int j = i - gap;
						int temp = target[i]; // ������ֵ
						do {
							target[j + gap] = target[j]; // ����Ԫ��
							j = j - gap; // �ٱȽ�ǰһ��Ԫ��
						} while (j >= 0 && target[j] > temp); // ��ǰ�Ƚϵ���ֹ����
						target[j + gap] = temp; // ��������ֵ������ʵ�λ��
					}
				}
			} while (gap > 1);
		}
		return target;
	}

	public static void shellSort1(int[] target) {
		if (target != null && target.length != 1) {
			int gap = target.length;    
			while (gap > 1) {      // gapΪint�ͣ��Զ�ȡ��
				gap = gap / 3 + 1;
				for (int i = gap; i < target.length; i++) {
					int j = i - gap;
					while (j >= 0) {
						if (target[j + gap] < target[j]) {
							swap(target, j, j+gap);
							j -= gap;
						}else{
							break;
						}
					}
				}
			}
		}
	}

	public static void swap(int[] target, int i, int j) {
		int temp = target[i];
		target[i] = target[j];
		target[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] target = {10,9,8,7,6,5,4,3,2,1,0};
		System.out.println("����ǰ�� "  + Arrays.toString(target));
		shellSort1(target);
		System.out.println("����� "  + Arrays.toString(target));
		
	}
}
