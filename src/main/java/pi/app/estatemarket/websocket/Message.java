package pi.app.estatemarket.websocket;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


public class Message {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Message(String name) {
		this.name = name;
	}
	
	

}
