package Currency.Crypto;

import Currency.Crypto.domain.Message;
import Currency.Crypto.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;

@Controller
class CryptoController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/crypto")
    public String crypto(@RequestParam(name="name", required=false,
            defaultValue="SMB") String name, Map<String, Object> model) {
        model.put("name", name);
        return "crypto_main";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main_block";
    }
    @PostMapping
    public String add(@RequestParam String name, @RequestParam double price, Map<String, Object> model){
        Message message = new Message(name, price);
        messageRepository.save(message);
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main_block";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty())
        messages = messageRepository.findByName(filter);
        else messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main_block";
    }
}
