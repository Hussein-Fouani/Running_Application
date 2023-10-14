package com.hf.running_application.controllers;

import com.hf.running_application.entities.Club;
import com.hf.running_application.model.clubDTO;
import com.hf.running_application.services.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/clubs")
public class ClubController {

    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }


    @GetMapping
    public String getAllClubs(Model model){
        List<clubDTO> clubs= clubService.findAllClubs();
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }

    @GetMapping("/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club",club);
        return "clubs-create";
    }
    @PostMapping("/new")
    public String createClub(@ModelAttribute("club") Club club){
        clubService.save(club);
        return "redirect:/clubs";

    }
    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId,Model model){
        clubDTO club = clubService.findClubById(clubId);
        model.addAttribute("club",club);
        return "clubs-edit";
    }

    @PostMapping("/{clubId}/edit")
    public String updateClub(@PathVariable Long clubId, @ModelAttribute("club") clubDTO clubdto, BindingResult result){
        clubdto.setId(clubId);
        clubService.updateClub(clubdto);
        return "redirect:/clubs";
    }
}
