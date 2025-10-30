package me.zdcoder.hastebin.core.controllers;

import me.zdcoder.hastebin.core.models.RecordModel;
import me.zdcoder.hastebin.core.repositories.RecordRepository;
import me.zdcoder.hastebin.core.utility.HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class HasteBinController {


    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    @PostMapping("/saved")
    public String save(@RequestParam("content") String content, Model model) {
        RecordModel recordModel = new RecordModel(HashGenerator.generateHash(recordRepository.count()), content);
        recordModel.setExpiryDate(LocalDateTime.now().plusMinutes(1));
        recordRepository.save(recordModel);
        model.addAttribute("message", "Success!");
        model.addAttribute("savedContent", content);
        model.addAttribute("hash", recordModel.getHash());
        return "result";
    }
    @GetMapping("/view/{hash}")
    public String view(@PathVariable String hash, Model model) {
        Optional<RecordModel> recordModelOptional = recordRepository.findByHash(hash);
        if (!recordRepository.existsByHash(hash)) {
            model.addAttribute("error", "Record not found.");
            return "error";
        }

        RecordModel recordModel = recordModelOptional.get();
        model.addAttribute("id", recordModel.getId());
        model.addAttribute("content", recordModel.getText());
        return "view";
    }
}
