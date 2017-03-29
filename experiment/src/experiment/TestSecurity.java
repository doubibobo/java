/*
 * 线程同步的问题
 * volatile 的使用意义：
 * @1：现代版本的jdk进行变量的修改时，先将主存中的变量复制到寄存器中
 * @2：线程之间进行切换和运行时，修改的是寄存器变量的值
 * @3：线程结束之后，将寄存器变量写入主存，主存中包含最终结果
 * @4：由上可知，要保证数据的一致性，即不能使用修改过后在存储器但是还没有在主存当中保存的
 * 		变量的值来进行下一个变量的操作
 * @5：此中规定volatile修饰的函数或者变量要从主存中取值
 * 
 * ### synchronized代码块监视，同一时刻只能有一个线程在执行并且执行完毕
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
