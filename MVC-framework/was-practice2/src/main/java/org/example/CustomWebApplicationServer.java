package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {

    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(port)) { // 서버 소캣을 만들고 포트가 해당 포트로 서버 소캣을 만든 다음
            logger.info("[CustomWebApplicationServer] started {} port",port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while((clientSocket = serverSocket.accept()) != null){ // 서버 소캣이 클라이언트를 기다리게 한다
                logger.info("[CustomWebApplicationServer] client connected.");

                /*
                * 사용자의 요청을 메인 thread가 처리
                * */

                /*
                    InputStream을 리더로 why?
                        ├ line by line 으로 읽고 싶어서
                        ├ 그래서 InputSteamReader로 감싸주고
                        └ 이를 line by line으로 읽기 위해서 BufferedReader로 한번 더 감사줌
                 */
                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream oos = new DataOutputStream(out);

                    String line;
                    while ((line = br.readLine()) != "") {
                        System.out.println(line);
                    }
                }

            }
        }
    }
}
