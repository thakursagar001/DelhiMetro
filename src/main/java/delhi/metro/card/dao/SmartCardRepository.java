package delhi.metro.card.dao;

import delhi.metro.card.models.SmartCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartCardRepository extends JpaRepository<SmartCardModel, Long> {
}
