package pl.edu.zse.projectTemplate.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.zse.projectTemplate.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {}
