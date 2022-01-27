package Currency.Crypto.repos;

import Currency.Crypto.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
   List<Message> findByName(String name);
}
