package cn.edu.tju.rico.queue;

import cn.edu.tju.rico.stack.LinkedStack;
import cn.edu.tju.rico.stack.Node;

/**
 * Title: ʹ������ջģ��һ������ 
 * Description: ����һ��ջר���������(ʼ�ղ�ִ�г��Ӳ���)����һ��ջר����������(ʼ�ղ�ִ����Ӳ���)
 * 				���ֽⷨ�����StackQueue����Ҫ�߲��٣������˷���������ջ��������Ҫʱ�š�����һ�Σ�����
 * @author rico
 * @created 2017��5��19�� ����10:45:11
 */
public class OptimizationStackQueue<E> {

	private LinkedStack<E> stack1; // ���ջ
	private LinkedStack<E> stack2; // ����ջ

	public OptimizationStackQueue() {
		stack1 = new LinkedStack<E>();
		stack2 = new LinkedStack<E>();
	}

	/**
	 * @description ���Ԫ�ص���β,ֱ�Ӷ�stack1ִ��ѹջ������
	 * @author rico
	 * @created 2017��5��19�� ����10:47:59
	 * @param e
	 */
	public void put(E e) {
		stack1.push(e);
	}

	/**
	 * @description ɾ����ͷ�����ض�ͷԪ�ص�ֵ���ȼ��stack2�Ƿ�Ϊ�գ�
	 *              ��Ϊ�գ��Ƚ�stack1�е�Ԫ�ص���stack2(stack1Ԫ�ز�������)���ٶ�stack2ִ�е�ջ����
	 *              ������ֱ�Ӷ�stack2ִ�е�ջ����
	 * @author rico
	 * @created 2017��5��19�� ����10:48:32
	 * @return
	 */
	public E pop() {
		if (stack2.isEmpty()) {
			Node<E> temp = stack1.peek();  // Stack1ʼ�ղ�ִ�е�ջ������peek����ȡԪ�ص���ɾ��
			while (temp != null) {
				stack2.push(temp.getData());
				temp = temp.getNext();
			}
		}
		return stack2.pop().getData();
	}

	@Override
	public String toString() {
		String str = new StringBuilder(stack1.toString()).reverse().toString();
		if(stack2.isEmpty()){
			return str;
		}
		return str.substring(str.indexOf(stack2.peek().getData().toString()));
	}
}
