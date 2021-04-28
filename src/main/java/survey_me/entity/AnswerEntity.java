package survey_me.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class AnswerEntity {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private UUID id;
    private String answer;
    private Integer timesAnswered = 0;

    public AnswerEntity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getTimesAnswered() {
        return timesAnswered;
    }

    public void setTimesAnswered(Integer timesAnswered) {
        this.timesAnswered = timesAnswered;
    }
}
