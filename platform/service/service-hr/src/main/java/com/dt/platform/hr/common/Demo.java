package com.dt.platform.hr.common;
import com.jcraft.jsch.*;

import java.util.Properties;

public class Demo {
    public static void main(String[] args) {

        String host = "example.com";
        String user = "username";
        String password = "password";
        int port = 22;
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession("root", "121.43.103.102", 22);
            session.setPassword("123@");
            Properties config = new Properties();
         //   config.put("cipher",",aes256-cbc");
         //   config.put("mac.c2s","hmac-sha2-256");
         //   config.put("KEXs","diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1,diffie-hellman-group-exchange-sha256");
            config.put("StrictHostKeyChecking","no");
            session.setConfig(config);
         //   session.
            System.out.println("123"+session.getConfig("KEXs"));
            session.connect();
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            // 列出远程目录中的文件和文件夹
            sftpChannel.ls(".");
            // 下载远程文件到本地目录
            sftpChannel.get("ac.sh", "/tmp/localfile.txt");
            // 关闭SFTP通道和SSH会话
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }

    }
}
