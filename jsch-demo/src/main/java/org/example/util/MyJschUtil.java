package org.example.util;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-01 15:50
 */
@Slf4j
public class MyJschUtil {

    private MyJschUtil(){}


    public static Session connect(String ip, String username, String password, int port) {
        JSch jSch = new JSch();
        try {
            Session session = jSch.getSession(username, ip, port);
            //设置首次登录跳过主机检查
            session.setConfig("StrictHostKeyChecking", "no");
            //设置登录超时时间
            session.connect(3000);
            session.setPassword(password);
            return session;

        } catch (JSchException e) {
            throw new RuntimeException(e);
        }
    }

    public static int execute(Session session, String cmd) throws IOException {
        InputStream inputStream = null;
        ChannelExec channelExec = null;
        try {
            channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(cmd);
            channelExec.connect();
            inputStream = channelExec.getInputStream();
            String result = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            while ((result = in.readLine()) != null) {
                System.out.println(result);
            }

        } catch (JSchException e) {
            throw new RuntimeException(e);
        } finally {
            if (channelExec != null) {
                channelExec.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
//        Session session = MyJschUtil.connect("10.182.212.169", "root", "HillstoneHSM4Ever", 22);
//        MyJschUtil.execute("ls", session);
        Session session = JschUtil.getSession("10.182.212.169", 22, "root", "HillstoneHSM4Ever");
        Scanner cmd = new Scanner(System.in);
        while (cmd.hasNextLine()) {
            MyJschUtil.execute(session, cmd.nextLine());
        }
    }
}