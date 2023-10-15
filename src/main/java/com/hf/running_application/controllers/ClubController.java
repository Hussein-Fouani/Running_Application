package com.hf.running_application.controllers;

import com.hf.running_application.entities.Club;
import com.hf.running_application.model.ClubDTO;
import com.hf.running_application.services.ClubService;
import jakarta.validation.Valid;
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
        List<ClubDTO> clubs= clubService.findAllClubs();
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
    public String createClub(@Valid @ModelAttribute("club") ClubDTO club, Model model, BindingResult result){
        if (result.hasErrors()){
                model.addAttribute("clubDTO",club);
                return "clubs-create";
        }
        clubService.save(club);
        return "redirect:/clubs";
    }
    @GetMapping("/{clubId}")
    public String clubDetail(@PathVariable("clubId") Long clubId,Model model){
        ClubDTO clubs = clubService.findClubById(clubId);
        model.addAttribute("club",clubId);
        return "clubs-detail";

    }

    @GetMapping("/search")
    public String  searchByTitle(@RequestParam(value = "param") String Query,Model model){
        List<ClubDTO> clubDTOS = clubService.searchClubs(Query);
        model.addAttribute("clubs",clubDTOS);
        return "clubs-list";
    }

    @GetMapping("/{clubId}/delete")
    public String deleteClub(@PathVariable Long clubId){
        clubService.deletebyId(clubId);
        return "redirect:/clubs";
    }
    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId,Model model){
        ClubDTO club = clubService.findClubById(clubId);
        model.addAttribute("club",club);
        return "clubs-edit";
    }

    @PostMapping("/{clubId}/edit")
    public String updateClub(@PathVariable Long clubId, @Valid @ModelAttribute("club") ClubDTO clubdto,Model model, BindingResult result){
       if(result.hasErrors()){
           model.addAttribute("event",clubdto);
           return "clubs-edit";
       }
        clubdto.setId(clubId);
        clubService.updateClub(clubdto);
        return "redirect:/clubs";
    }
}
