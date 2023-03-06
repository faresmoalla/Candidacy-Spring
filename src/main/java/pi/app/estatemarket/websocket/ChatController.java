package pi.app.estatemarket.websocket;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import pi.app.estatemarket.Services.IContractService;




@Controller
//@RequestMapping("/api/chatwork")
//@AllArgsConstructor
public class ChatController {
	
	
	
	
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessagePojo) {
		return chatMessagePojo;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {

		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
		return chatMessagePojo;
	}
	
}
