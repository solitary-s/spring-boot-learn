package com.aloneness.spring.boot.websocket.controller;


import cn.hutool.core.lang.Dict;
import com.aloneness.spring.boot.websocket.model.Server;
import com.aloneness.spring.boot.websocket.payload.ServerVO;
import com.aloneness.spring.boot.websocket.util.ServerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServerController {

    @RequestMapping("/index")
    public String index() {
        return "server";
    }

    @GetMapping("server")
    @ResponseBody
    public Dict serverInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        ServerVO serverVO = ServerUtil.wrapServerVO(server);
        return ServerUtil.wrapServerDict(serverVO);
    }
}
