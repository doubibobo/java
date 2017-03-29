/*
 * 客户方程序
 * 首先要建立socket链接
 * 其次建立数据包DatagramPacket来进行数据的交互
 * 分为发送和接收两个步骤去执行
 * 通过命令行的形式进行操作
 */
package UDP;
import java.io.*;
import java.net.*;
import java.util.*;
public class QuoteClient {
	public static void main(String args[]) throws IOException {
//		if (args.length != 1) {
//			System.out.println("Usage:java QuoteClient<hostname>");
//			return;
//		}
		DatagramSocket socket = new DatagramSocket();
		byte[] buf = new byte[256];
//		InetAddress address = InetAddress.getByName(args[0]);
		InetAddress address = InetAddress.getLocalHost();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		socket.send(packet);
		
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		
		String received = new String(packet.getData());
		
		System.out.println("Quote of the Moment: " + received);
		socket.close();
	}
}
