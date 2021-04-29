package survey_me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import survey_me.entity.AnswerEntity;
import survey_me.entity.QuestionEntity;
import survey_me.entity.SurveyEntity;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, UUID> {
    Optional<Set<AnswerEntity>> findAllByQuestion(QuestionEntity question);
}
