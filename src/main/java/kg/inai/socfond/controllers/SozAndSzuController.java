package kg.inai.socfond.controllers;

import kg.inai.socfond.entities.*;
import kg.inai.socfond.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SozAndSzuController {

    @Autowired
    private SozRepo sozRepo;

    @Autowired
    private SzuRepo szuRepo;

    @Autowired
    private CurrencyRepo currencyRepo;

    @Autowired
    private ZnachimoeObstoyatelstvoRepo znachimoeObstoyatelstvoRepo;

    @Autowired
    private TrudovayaDeyatelnostRepo trudovayaDeyatelnostRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private TypeUchastnikRepo typeUchastnikRepo;

    @Autowired
    private TypeDocumentRepo typeDocumentRepo;

    @Autowired
    private TypeRodstvaRepo typeRodstvaRepo;

    @Autowired
    private CompetentOrganOtpravitelRepo competentOrganOtpravitelRepo;

    @Autowired
    private CompetentOrganPoluchatelRepo competentOrganPoluchatelRepo;

    @Autowired
    private OblastRepo oblastRepo;

    @Autowired
    private RayonRepo rayonRepo;

    @Autowired
    private PlaceNameRepo placeNameRepo;

    @Autowired
    private TypePensiyaRepo typePensiyaRepo;

    //MAPPINGS FOR SOZ
    @GetMapping("/soz/list")
    public String getListOfsoz(Model model){
        model.addAttribute("sozs",sozRepo.findAll());
        return "soz/list";
    }

    @GetMapping("/soz/add")
    public String getFormsoz(Model model){
        model.addAttribute("competentOrganPoluchatels", competentOrganPoluchatelRepo.findAll());
        model.addAttribute("competentOrganOtpravitels", competentOrganOtpravitelRepo.findAll());
        model.addAttribute("typeUchastniks", typeUchastnikRepo.findAll());
        model.addAttribute("typeRodstvas", typeRodstvaRepo.findAll());
        model.addAttribute("countries", countryRepo.findAll());
        model.addAttribute("sexs", Sex.values());
        model.addAttribute("typeDocuments", typeDocumentRepo.findAll());
        model.addAttribute("currencies", currencyRepo.findAll());
        model.addAttribute("znachimObstoyats", znachimoeObstoyatelstvoRepo.findAll());
        model.addAttribute("trudDeyatelnosts", trudovayaDeyatelnostRepo.findAll());
        model.addAttribute("oblasts", oblastRepo.findAll());
        model.addAttribute("rayons", rayonRepo.findAll());
        model.addAttribute("placeNames", placeNameRepo.findAll());
        model.addAttribute("typePensiya", typePensiyaRepo.findAll());
        return "soz/form";
    }

    @PostMapping("/soz/add")
    public String addFormsoz(@ModelAttribute Soz soz){
        sozRepo.save(soz);
        return "redirect:/soz/list";
    }

    @GetMapping("/soz/{id}")
    public String getsozFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("soz", sozRepo.getById(id));

        model.addAttribute("competentOrganPoluchatels", competentOrganPoluchatelRepo.findAll());
        model.addAttribute("competentOrganOtpravitels", competentOrganOtpravitelRepo.findAll());
        model.addAttribute("typeUchastniks", typeUchastnikRepo.findAll());
        model.addAttribute("typeRodstvas", typeRodstvaRepo.findAll());
        model.addAttribute("countries", countryRepo.findAll());
        model.addAttribute("sexs", Sex.values());
        model.addAttribute("typeDocuments", typeDocumentRepo.findAll());
        model.addAttribute("currencies", currencyRepo.findAll());
        model.addAttribute("znachimObstoyats", znachimoeObstoyatelstvoRepo.findAll());
        model.addAttribute("trudDeyatelnosts", trudovayaDeyatelnostRepo.findAll());
        model.addAttribute("oblasts", oblastRepo.findAll());
        model.addAttribute("rayons", rayonRepo.findAll());
        model.addAttribute("placeNames", placeNameRepo.findAll());
        model.addAttribute("typePensiya", typePensiyaRepo.findAll());
        return "soz/form";
    }

    @PostMapping("/soz/edit")
    public String getsozEdit(@ModelAttribute("soz") Soz soz) {
        sozRepo.save(soz);
        return "redirect:/soz/list";
    }

    //MAPPINGS FOR SZU
    @GetMapping("/szu/list")
    public String getListOfszu(Model model){
        model.addAttribute("szus", szuRepo.findAll());
        return "szu/list";
    }

    @GetMapping("/szu/add")
    public String getFormszu(Model model){
        model.addAttribute("competentOrganPoluchatels", competentOrganPoluchatelRepo.findAll());
        model.addAttribute("competentOrganOtpravitels", competentOrganOtpravitelRepo.findAll());
        model.addAttribute("typeUchastniks", typeUchastnikRepo.findAll());
        model.addAttribute("typeRodstvas", typeRodstvaRepo.findAll());
        model.addAttribute("countries", countryRepo.findAll());
        model.addAttribute("sexs", Sex.values());
        model.addAttribute("typeDocuments", typeDocumentRepo.findAll());
        model.addAttribute("currencies", currencyRepo.findAll());
        model.addAttribute("znachimObstoyats", znachimoeObstoyatelstvoRepo.findAll());
        model.addAttribute("trudDeyatelnosts", trudovayaDeyatelnostRepo.findAll());
        model.addAttribute("oblasts", oblastRepo.findAll());
        model.addAttribute("rayons", rayonRepo.findAll());
        model.addAttribute("placeNames", placeNameRepo.findAll());
        model.addAttribute("typePensiya", typePensiyaRepo.findAll());
        return "szu/form";
    }

    @PostMapping("/szu/add")
    public String addFormszu(@ModelAttribute Szu szu){
        szuRepo.save(szu);
        return "redirect:/szu/list";
    }

    @GetMapping("/szu/{id}")
    public String getszuFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("szu", szuRepo.getById(id));

        model.addAttribute("competentOrganPoluchatels", competentOrganPoluchatelRepo.findAll());
        model.addAttribute("competentOrganOtpravitels", competentOrganOtpravitelRepo.findAll());
        model.addAttribute("typeUchastniks", typeUchastnikRepo.findAll());
        model.addAttribute("typeRodstvas", typeRodstvaRepo.findAll());
        model.addAttribute("countries", countryRepo.findAll());
        model.addAttribute("sexs", Sex.values());
        model.addAttribute("typeDocuments", typeDocumentRepo.findAll());
        model.addAttribute("currencies", currencyRepo.findAll());
        model.addAttribute("znachimObstoyats", znachimoeObstoyatelstvoRepo.findAll());
        model.addAttribute("trudDeyatelnosts", trudovayaDeyatelnostRepo.findAll());
        model.addAttribute("oblasts", oblastRepo.findAll());
        model.addAttribute("rayons", rayonRepo.findAll());
        model.addAttribute("placeNames", placeNameRepo.findAll());
        model.addAttribute("typePensiya", typePensiyaRepo.findAll());
        return "soz/form";
    }

    @PostMapping("/szu/edit")
    public String getszuEdit(@ModelAttribute("szu") Szu szu) {
        szuRepo.save(szu);
        return "redirect:/szu/list";
    }
}
