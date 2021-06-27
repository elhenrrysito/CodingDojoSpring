package com.henrry.overflow.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tags")
@Getter @NoArgsConstructor
public class Tag extends BaseModel {
    @Size(min=1)
    private String subject;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name="question_id")
    )
    private List<Question> questions;

    public Tag(String subject) {
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setQuestions(Question question) {
        this.questions.add(question);
    }
}
