package UDP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;
import java.util.*;
public class QuoteServerThread extends Thread {
	protected DatagramSocket socket = null;
	protected BufferedReader in = null;
	protected boolean moreQuotes = true;
	public QuoteServerThread() throws IOException {
		this("QuoteServerThread");
	}
	public QuoteServerThread(String name) throws IOException {
		super(name);
		socket = new DatagramSocket(4445);
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	public void run() {
		while (moreQuotes) {
			try {
				byte[] btf = new byte[256];
				DatagramPacket packet = new DatagramPacket(btf, btf.length);
				socket.receive(packet);
				System.out.println(new String(packet.getData()));
				
				String dString = in.readLine();
				if (dString.equals("Bye!")) {
					moreQuotes = false;
				} 
				btf = dString.getBytes();
				packet = new DatagramPacket(btf, btf.length, packet.getAddress(), packet.getPort());
				socket.send(packet);
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
				moreQuotes = false;
			}
			socket.close();
		}
	}
}
