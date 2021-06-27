package com.henrry.overflow.controllers;

import com.henrry.overflow.models.Question;
import com.henrry.overflow.models.Tag;
import com.henrry.overflow.services.AnswerService;
import com.henrry.overflow.services.QuestionService;
import com.henrry.overflow.services.TagService;
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
    private final AnswerService answerService;
    private final TagService tagService;

    public QuestionController(QuestionService questionService, AnswerService answerService, TagService tagService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.tagService = tagService;
    }

    @GetMapping("")
    public String questionDashboard(Model model) {
        List<Question> questions = questionService.allData();
        model.addAttribute("questions", questions);
        return "question/dashboard.jsp";
    }

    @GetMapping("/new")
    public String addQuestion(@ModelAttribute("newQuestion") Question question) {
        return "question/newQuestion.jsp";
    }

    @PostMapping("/new")
    public String newQuestion(@ModelAttribute("newQuestion") Question question,
                              @RequestParam("tagg") String tags) {


            String[] tagsList = tags.split(",");
            System.out.println(Arrays.toString(tagsList));
            List<Tag> allTags = tagService.allData();
            for(String subject: tagsList) {
                if(allTags.contains(new Tag(subject))) {
                    question.setTags(new Tag(subject));
                    questionService.create(question);
                } else {
                    Tag newTag = tagService.create(new Tag(subject));
                    question.setTags(newTag);
                    questionService.create(question);
                }
            }
            return "redirect:/questions";

    }

}
