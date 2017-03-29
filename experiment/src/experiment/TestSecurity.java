/*
 * �߳�ͬ��������
 * volatile ��ʹ�����壺
 * @1���ִ��汾��jdk���б������޸�ʱ���Ƚ������еı������Ƶ��Ĵ�����
 * @2���߳�֮������л�������ʱ���޸ĵ��ǼĴ���������ֵ
 * @3���߳̽���֮�󣬽��Ĵ�������д�����棬�����а������ս��
 * @4�����Ͽ�֪��Ҫ��֤���ݵ�һ���ԣ�������ʹ���޸Ĺ����ڴ洢�����ǻ�û�������浱�б����
 * 		������ֵ��������һ�������Ĳ���
 * @5�����й涨volatile���εĺ������߱���Ҫ��������ȡֵ
 * 
 * ### synchronized�������ӣ�ͬһʱ��ֻ����һ���߳���ִ�в���ִ�����
 */
package experiment;
import java.io.*;
class Resource implements Runnable {
	volatile public int i;
	volatile public Integer it;
	public Resource(int _i) {
		i = _i;
		it = new Integer(i);
	}
	public void run() {
		while (true) {
			synchronized(it) {
				if (i > 0) {
					try {
						Thread.sleep(200);
					} catch (Exception e) {
						
					}
					i--;
					System.out.println(Thread.currentThread().getName() + " " + i);
				} else {
					System.out.println(Thread.currentThread().getName());
					break;
				}
			}
		}
	}
}
public class TestSecurity {
	public static void main(String args[]) {
		Resource m = new Resource(9);
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		t1.start();
		t2.start();
	}
}
