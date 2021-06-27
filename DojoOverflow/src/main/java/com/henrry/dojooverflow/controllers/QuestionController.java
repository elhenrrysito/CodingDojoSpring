package com.henrry.dojooverflow.controllers;

import com.henrry.dojooverflow.models.Answer;
import com.henrry.dojooverflow.models.Question;
import com.henrry.dojooverflow.models.Tag;
import com.henrry.dojooverflow.services.AnswerService;
import com.henrry.dojooverflow.services.QuestionService;
import com.henrry.dojooverflow.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;
    private final TagService tagService;
    private final AnswerService answerService;

    public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }

    @GetMapping("")
    public String questionDashboard(Model model) {
        List<Question> questions = questionService.allQuestions();
        model.addAttribute("questions", questions);
        return "question/dashboard.jsp";
    }

    @GetMapping("/new")
    public String newQuestion(@ModelAttribute("newQuestion") Question question) {
        return "question/newQuestion.jsp";
    }

    @PostMapping("/new")
    public String addQuestion(@Valid @ModelAttribute("newQuestion") Question question, @RequestParam("tags") String tags,
                              BindingResult result) {
        if(result.hasErrors()) {
            return "question/new.jsp";
        } else {
            List<String> tagsSubmited = Arrays.asList(tags.split(","));
//            String[] tagsSubmited = tags.split("\\s*,\\s*");
            System.out.println(tagsSubmited);
            for(String subject: tagsSubmited) {
                if(tagService.allTags().contains(subject)) {
                    questionService.addQuestionTag(question, tagService.findTagByName(subject));
                } else {
                    Tag newTag = tagService.createTag(new Tag(subject));
                    questionService.addQuestionTag(question, newTag);
                }
            }
            return "redirect:/questions";
        }

    }

    @GetMapping("{id}")
    public String newAnswer(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
        Question question = questionService.findQuestion(id);
        List<Answer> questionAnswers = question.getAnswers();
        List<Tag> tagsQuestion = question.getTags();
        model.addAttribute("answers", questionAnswers);
        model.addAttribute("tags", tagsQuestion);
        return "question/addAnswer.jsp";
    }

    @PostMapping("{id}")
    public String addAnswer(@PathVariable("id") Long id, @Valid @ModelAttribute("answer") Answer answer,
                            BindingResult result) {
        if(result.hasErrors()) {
            return "question/addAnswer.jsp";
        } else {
            Question question = questionService.findQuestion(id);
            questionService.addAnswerToQuestion(question, answer);
            return "redirect:/questions";
        }
    }




}
