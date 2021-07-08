package com.henrry.dojooverflow.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tags")
@Getter @Setter @NoArgsConstructor
public class Tag extends BaseModel {
    
    private String subject;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "questions_tags",
        joinColumns = @JoinColumn(name = "tag_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;


    public void addQuestion(Question question) {
        this.questions.add(question);
    }
}
