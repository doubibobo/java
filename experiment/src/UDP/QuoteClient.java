/*
 * �ͻ�������
 * ����Ҫ����socket����
 * ��ν������ݰ�DatagramPacket���������ݵĽ���
 * ��Ϊ���ͺͽ�����������ȥִ��
 * ͨ�������е���ʽ���в���
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
