package com.example.send.Controllers;
import com.example.send.services.SendServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/send")
public class SendController {
    @Autowired
    private SendServices sendServices;

    @PostMapping("")
    public ResponseEntity<String> send ( @RequestBody String json) {
        sendServices.sendOrder(json);

        return ResponseEntity.ok("{state:'sended'}");
    }

}
