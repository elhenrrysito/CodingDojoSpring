package com.henrry.dojooverflow.services;

import com.henrry.dojooverflow.models.Answer;
import com.henrry.dojooverflow.models.Question;
import com.henrry.dojooverflow.models.Tag;
import com.henrry.dojooverflow.repositories.QuestionRepository;
import com.henrry.dojooverflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final AnswerService answerService;
    private final TagService tagService;

    public QuestionService(QuestionRepository questionRepository, TagRepository tagRepository, AnswerService answerService, TagService tagService) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
        this.answerService = answerService;
        this.tagService = tagService;
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }

    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public void addQuestionTag(Question question, Tag tag) {
            question.getTags().add(tag);
            System.out.println("error panita" + tag);
        questionRepository.save(question);
        if(!tagService.allTags().contains(tag.getSubject())) {
            tagRepository.save(tag);
        }
    }

    public void addAnswerToQuestion(Question question, Answer answer) {
        answerService.createAnswer(answer);
        answer.setQuestion(question);
        answerService.updateAnswer(answer);
    }
}
