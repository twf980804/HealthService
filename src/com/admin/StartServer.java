package com.admin;





import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.ArrayList;  
import java.util.Vector;  
  
import javax.swing.JOptionPane;  
  
//启动服务端接收客户端的线程  
public class StartServer implements Runnable{  
    private int port;  
    public static ArrayList<Socket> userList = null;  
    public static Vector<String> userName = null;  
    public static ServerSocket ss = null;  
    public static boolean flag = true;  
      
    //传入端口号  
    public StartServer(int port) throws IOException{  
        this.port = port;         
    }  
  
    public void run() {  
        Socket s = null;  
        userList = new ArrayList<Socket>();//客户端端口容器  
        userName = new Vector<String>();//用户名称容器  
        //System.out.println("启动服务端");  
        try {  
            ss = new ServerSocket(port);//启动服务端  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
        while (flag) {//开启循环，等待接收客户端  
            try {     
                s = ss.accept();//接收客户端  
                userList.add(s);//将客户端的socket添加到容器中  
                  
                //打印客户端信息  
                String id = s.getInetAddress().getHostName();  
                System.out.println(id + "-----------connected");  
                System.out.println("当前客户端个数为：" + userList.size());  
                  
                //启动与客户端相对应的信息接收线程  
                new Thread(new ReceiveServer(s,userList,userName)).start();  
          
            } catch (IOException e) {  
                JOptionPane.showMessageDialog(WindowServer.window, "服务端退出！");  
            }     
        }  
    }  
}  
  
//服务端信息接收线程  
class ReceiveServer implements Runnable{  
    private Socket socket;  
    private ArrayList<Socket> userList;  
    private Vector<String> userName;  
      
    public ReceiveServer(Socket s,ArrayList<Socket> userList,Vector<String> userName) {  
        this.socket = s;  
        this.userList = userList;  
        this.userName = userName;  
    }  
      
    public void run() {   
        try {  
            //读取信息流  
            BufferedReader brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
            while(true){          
                char info = (char)brIn.read();//先读取信息流的首字符，并判断信息类型  
                String line = brIn.readLine();//读取信息流的信息内容  
                  
                if(info == '1'){//1代表收到的是信息  
                    WindowServer.textMessage.append(line + "\r\n");//将信息添加到服务端聊天记录中  
                    //设置消息显示最新一行，也就是滚动条出现在末尾，显示最新一条输入的信息  
                    WindowServer.textMessage.setCaretPosition(WindowServer.textMessage.getText().length());  
                    new SendServer(userList, line, "1");//将信息转发给客户端  
                }  
                  
                if(info == '2'){//2代表有新客户端建立连接  
                    userName.add(line);//将新客户端用户名添加到容器中  
                    WindowServer.user.setListData(userName);//更新服务端用户列表  
                    new SendServer(userList, userName, "2");//将用户列表以字符串的形式发给客户端  
                }  
                  
                if(info == '3'){//3代表有用户端退出连接  
                    userName.remove(line);//移除容器中已退出的客户端用户名  
                    userList.remove(socket);//移除容器中已退出的客户端的socket  
                    WindowServer.user.setListData(userName);//更新服务端用户列表  
                    new SendServer(userList, userName, "3");//将用户列表以字符串的形式发给客户端  
                    socket.close();//关闭该客户端的socket  
                    break;//结束该客户端对于的信息接收线程  
                }  
            }     
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }     
}  
  
//服务端发送信息  
class SendServer {  
    SendServer(ArrayList<Socket> userList,Object message,String info) throws IOException{  
        String messages = info + message;//添加信息头标记  
        PrintWriter pwOut = null;  
        for(Socket s : userList){//将信息发送给每个客户端  
            pwOut = new PrintWriter(s.getOutputStream(),true);  
            pwOut.println(messages);  
        }  
    }  
}     


