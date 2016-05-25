/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.ftp.upfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Administrator
 */
public class UploadFile {

    public static boolean uploadFile1(String url, String user, String pass, String path, String fileName, InputStream input, int port) {
//        String url = "";
//        String user = "";
//        String pass = "";
//        String path = "";
//        String fileName = "";
//        InputStream input = null;
//        int port = 21;
        boolean result = false;

        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);//连接FTP服务器 
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器 
            ftp.login(user, pass);//登录 
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(fileName, input);

            input.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
            return result;
        }
    }
    //-----------------
    private static FTPClient ftpClient = new FTPClient();
    private static String encoding = System.getProperty("file.encoding");

    /**
     * /**
     * Description: 向FTP服务器上传文件
     *
     * @Version1.0
     * @param url FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param path FTP服务器保存目录,如果是根目录则为“/”
     * @param filename 上传到FTP服务器上的文件名
     * @param input 本地文件输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile2(String url, int port, String username,
            String password, String path, String filename, InputStream input) {
        boolean result = false;

        try {
            int reply;
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
//            ftpClient.connect(url);
            ftpClient.connect(url, port);// 连接FTP服务器
            // 登录
            ftpClient.login(username, password);
            ftpClient.setControlEncoding(encoding);
            // 检验是否连接成功
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.out.println("连接失败");
                ftpClient.disconnect();
                return result;
            }

            // 转移工作目录至指定目录下
            boolean change = ftpClient.changeWorkingDirectory(path);
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            System.out.println("====change===:"+result);
            System.out.println("====result===:"+result);
            if (change) {
//                result = ftpClient.storeFile(new String(filename.getBytes(encoding), "iso-8859-1"), input);
                result = ftpClient.storeFile(filename, input);
                System.out.println("====//===:"+result);
                if (result) {
                    System.out.println("上传成功!");
                }
            }
            input.close();
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    public static void main(String args[]) throws FileNotFoundException {

////        FileInputStream in = new FileInputStream("D:/linshi123/123.txt");
//        // new FileInputStream(new File("D:/test.txt")); 
//
//        FileInputStream in = new FileInputStream(new File("D:/linshi123/123.txt"));
//        // String url,String user,String pass,String path,String fileName,InputStream input,int port
//        // boolean flag = uploadFile("127.0.0.1", 21, "test", "test", "D:/ftp", "test.txt", in);
//        boolean re = uploadFile1("v0.ftp.upyun.com", "development/outsource", "development", "/", "ttt", in, 21);
//        System.out.println("-----" + re);

        //---------


        try {
            FileInputStream in = new FileInputStream(new File("D:\\linshi123\\123.txt"));
            boolean flag = uploadFile2("v0.ftp.upyun.com", 21, "development/outsource", "development", "", "aa", in);
            System.out.println(flag);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
