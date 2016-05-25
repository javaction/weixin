/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.ftp.upfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class Test {

    private FTPClient ftp;

    /**
     *
     * @param path 上传到ftp服务器哪个路径下
     * @param addr 地址
     * @param port 端口号
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    private boolean connect(String path, String addr, int port, String username, String password) throws Exception {
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(addr, port);
        ftp.login(username, password);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return result;
        }
        ftp.changeWorkingDirectory(path);
        result = true;
        return result;
    }

    /**
     *
     * @param file 上传的文件或文件夹
     * @throws Exception
     */
    private void upload(File file) throws Exception {

        System.out.println("---file----:" + file.isDirectory());
        if (file.isDirectory()) {
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath() + "\\" + files[i]);
                System.out.println("---file1----:" + file1.isDirectory());
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(file.getPath() + "\\" + files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    System.out.println("--111--：" + ftp.storeFile(file2.getName(), input));
                    input.close();
                }
            }
        } else {
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.enterLocalPassiveMode();
         //   System.out.println("--222--：" + ftp.storeFile(file2.getName(), input));
            ftp.storeFile(file2.getName(), input);
            //System.out.println("--222--："+ftp.storeFile(file2.getName(), input));
            input.close();
        }
    }

    private FTPFile[] getFileList(String filePath) throws IOException {
        FTPFile[] list = ftp.listFiles();
        return list;
    }

    public static void main(String[] args) throws Exception {
        Test t = new Test();
        boolean result = t.connect("", "v0.ftp.upyun.com", 21, "development/outsource", "development");
        System.out.println("连接：" + result);
        if (result) {
            File file = new File("D:\\linshi123\\123.txt"); // D:/linshi123/123.txt   // D:\\555\\22.txt
            t.upload(file);
//
////            FTPFile[] files = t.getFileList("");
////            for (FTPFile f : files) {
////                //System.out.println(11);
////                if (f.isFile()) {
////                    System.out.println(f.getName());
////                }
////            }
//
        }

        /////-----------------------------------

//        File file = new File("D:\\linshi123\\123.txt");
//        if (file.exists()) {
//            System.out.println("====文件存在");
//            System.out.println("路径：" + file.getPath());
//            if (file.isFile()) {
//                System.out.println("====是的，");
//                System.out.println("====文件名称：" + file.getName());
////                 FileInputStream in = new FileInputStream(file);              
////                 System.out.println("====in："+in.toString());
//
//                File f1 = new File(file.getPath());
//                if (f1.isFile()) {
//                    System.out.println("====f1 是个文件 。"+f1.getName());
//                }
//
//            }
//
//        } else {
//            System.out.println("====文件不存在");
//        }


    }
}
