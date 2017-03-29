/*
 * ������ͬ����Դ����ֻ��һ���߳���������
 * �����˼����� ��synchronized ���ε�run���������������Ǳ�����
 */
package experiment;
import java.io.*;
class Resource1 implements Runnable {
	volatile public int i;
	public Resource1 (int _i) {
		i = _i;
	}
	public synchronized void run() {
		while (true) {
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
public class TestSecurity1 {
	public static void main(String args[]) {
		Resource1 m = new Resource1(100);
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		t1.start();
		t2.start();
	}
}
