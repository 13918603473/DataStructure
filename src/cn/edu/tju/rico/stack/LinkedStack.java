package cn.edu.tju.rico.stack;

/**
 * Title: �Զ�����ʽջ 
 * Description: ��ʽջ��ʵ��
 * 
 * @author rico
 * @created 2017��4��6�� ����7:52:34
 */
public class LinkedStack<E> {

	private Node<E> top; // ջ��Ԫ��
	private int size; // ��ʽջ�Ĵ�С

	// ���캯��
	public LinkedStack(){
		
	}
	
	// ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return size == 0;
	}

	// ѹջ
	public void push(E data) {
		Node<E> node = new Node<E>(data, top); // �¼����Ԫ��ָ��ջ��Ԫ��
		top = node;
		size++;
	}

	//��ջ(������ɾ��ջ��Ԫ��)
	public Node<E> pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("ջΪ��...");
		}

		Node<E> node = top;
		top = top.next;
		node.next = null;
		size--;
		return node;
	}

	// ��ӡջ
	public void print() {
		Node<E> index = top;
		while (index != null) {
			System.out.print(index.data + " ");
			index = index.next;
		}
	}

	
	// ˽���ڲ���
	private class Node<T> {
		private Node<T> next;
		private T data;

		public Node(T data, Node<T> node) {
			this.data = data;
			next = node;
		}
	}

	//����
	public static void main(String[] args) throws Exception {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("Rico");
		stack.push("TJU");
		stack.push("Livia");
		stack.push("NEU");

		stack.print();

		System.out.println();

		stack.pop();
		stack.print();
	}
}
