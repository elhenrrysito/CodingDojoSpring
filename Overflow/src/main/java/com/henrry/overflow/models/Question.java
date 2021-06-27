package com.henrry.overflow.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="questions")
@Getter @Setter
public class Question extends BaseModel {
    @Size(min=5)
    private String question;

    @OneToMany(mappedBy = "answer", fetch = FetchType.LAZY)
    private List<Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Tag> tags;

    public Question(String question) {
        this.question = question;
        tags = new ArrayList<>();
        answers = new ArrayList<>();
    }


    public void setTags(Tag tag) {
        this.tags.add(tag);
    }
}
