package com.hf.running_application.controllers;

import com.hf.running_application.model.clubDTO;
import com.hf.running_application.services.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClubController {

    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }


    @GetMapping("/clubs")
    public String getAllClubs(Model model){
        List<clubDTO> clubs= clubService.findAllClubs();
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }

}
