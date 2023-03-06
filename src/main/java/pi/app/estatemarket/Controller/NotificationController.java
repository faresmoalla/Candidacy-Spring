package pi.app.estatemarket.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pi.app.estatemarket.Services.MailService;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
@NoArgsConstructor
public class NotificationController {


    private MailService mailService;

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        try {
            mailService.sendEmail(to, subject, body);
            return ResponseEntity.ok("E-mail sent successfully.");
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send e-mail: " + e.getMessage());
        }
    }
}
