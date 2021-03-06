package com.fengqiliu.test.java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

	public static void main(String[] args) throws IOException {
//		receive();
        testPort2();
	}

    private static void testPort2() throws IOException {
        // 192.168.200.114
        // 119.254.86.250
        // 119.254.64.16

        Socket socket = new Socket("119.254.64.19",9092);
        if (socket.isConnected()){
            System.out.println("可连接");
        }else {
            System.out.println("不可连接");
        }
    }

    private static void testPort(){
        try{
            ServerSocket s = new ServerSocket();
            s.bind(new InetSocketAddress("119.254.64.16",9092));
            s.close();
        }catch(IOException e){
            e.printStackTrace();
            if(e instanceof java.net.BindException) {
                System.out.println(" aready in use.");
            }else {
                System.err.println(" other error..");
            }
        }
    }

	private static void receive() {
		try {
			// 1.建立一个服务器Socket(ServerSocket)绑定指定端口
			ServerSocket serverSocket = new ServerSocket(8800);
			// 2.使用accept()方法阻止等待监听，获得新连接
			Socket socket = serverSocket.accept();
			// 3.获得输入流
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			// 获得输出流
//			OutputStream os = socket.getOutputStream();
//			PrintWriter pw = new PrintWriter(os);
			// 4.读取用户输入信息
			String info = null;
			System.out.println("开始接收用户信息...");
			while (!((info = br.readLine()) == null)) {
				System.out.println(info);
			}
			// 给客户一个响应
//			String reply = "welcome";
//			pw.write(reply);
//			pw.flush();
			// 5.关闭资源
//			pw.close();
//			os.close();
			br.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
