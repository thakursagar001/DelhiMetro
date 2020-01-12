package delhi.metro.card.dao;

import delhi.metro.card.models.StationEnum;
import delhi.metro.card.models.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {

    List<TransactionModel> findBySource(StationEnum source);

    List<TransactionModel> findByDestination(StationEnum destination);

}
