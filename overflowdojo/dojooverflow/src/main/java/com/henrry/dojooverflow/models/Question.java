package com.henrry.dojooverflow.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter @Setter @NoArgsConstructor
public class Question extends BaseModel {
    @NotBlank
    private String question;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "questions_tags",
        joinColumns = @JoinColumn(name = "question_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answer> answers;

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }
}
