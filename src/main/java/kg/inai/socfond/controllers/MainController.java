package kg.inai.socfond.controllers;

import kg.inai.socfond.entities.*;
import kg.inai.socfond.repos.*;
import kg.inai.socfond.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private PrichinaObrasheniyaRepo prichinaObrasheniyaRepo;

    @Autowired
    private TypeRodstvaRepo typeRodstvaRepo;

    @Autowired
    private TypeUchastnikRepo typeUchastnikRepo;

    @Autowired
    private TypeDocumentRepo typeDocumentRepo;

    @Autowired
    private TypePensiyaRepo typePensiyaRepo;

    @Autowired
    private OblastRepo oblastRepo;

    @Autowired
    private RayonRepo rayonRepo;

    @Autowired
    private PlaceNameRepo placeNameRepo;

    @Autowired
    private PlaceTypeRepo placeTypeRepo;

    @Autowired
    private CompetentOrganOtpravitelRepo competentOrganOtpravitelRepo;

    @Autowired
    private CompetentOrganPoluchatelRepo competentOrganPoluchatelRepo;

    @Autowired
    private BankingRekvisitsRepo bankingRekvisitsRepo;

    @Autowired
    private DocumentBrakRepo documentBrakRepo;

    @Autowired
    private PersonalAcceptDocumentRepo personalAcceptDocumentRepo;

    @Autowired
    private PersonalDataRepo personalDataRepo;

    @Autowired
    private PersonalDocumentRepo personalDocumentRepo;

    @Autowired
    private PolnomochiyaDocumentRepo polnomochiyaDocumentRepo;

    @Autowired
    private PredstavitelDataRepo predstavitelDataRepo;

    @Autowired
    private StajRepo stajRepo;

    @Autowired
    private CurrencyRepo currencyRepo;

    @Autowired
    private ZnachimoeObstoyatelstvoRepo znachimoeObstoyatelstvoRepo;

    @Autowired
    private TrudovayaDeyatelnostRepo trudovayaDeyatelnostRepo;

    @Autowired
    private SvedForVyplatyPensiyaRepo svedForVyplatyPensiyaRepo;

    @GetMapping("/success")
    public String getPagesWithRole() {
        return "index";
    }

    /*Users*/
    @GetMapping("/user/list")
    public String getUserList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "user/list";
    }

    @GetMapping("/user/add")
    public String getUserFormAdd(Model model) {
        model.addAttribute("userRoles", userRoleRepo.findAll());
        return "user/form";
    }

    @PostMapping("/user/add")
    public String userAdd(@ModelAttribute("user") User user) {
        userRepo.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/user/{userId}")
    public String getUserFormEdit(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("user", userRepo.getById(userId));
        model.addAttribute("userRoles", userRoleRepo.findAll());
        return "user/form";
    }

    @PostMapping("/user/edit")
    public String getUserEdit(@ModelAttribute("user") User user) {
        User userFromRepo = userRepo.getById(user.getId());
        if (user.getPassword() == null)
            user.setPassword(passwordEncoder.encode(userFromRepo.getPassword()));
        userRepo.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long userId) {
        userRepo.deleteById(userId);
        return "redirect:/user/list";
    }

    /*Country*/
    @GetMapping("/country/list")
    public String getCountryList(Model model) {
        model.addAttribute("countries", countryRepo.findAll());
        return "country/list";
    }

    @GetMapping("/country/add")
    public String getCountryFormAdd(Model model) {
        return "country/form";
    }

    @PostMapping("/country/add")
    public String countryAdd(@ModelAttribute("country") Country country) {
        countryRepo.save(country);
        return "redirect:/country/list";
    }

    @GetMapping("/country/{id}")
    public String getCountryFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("country", countryRepo.getById(id));
        return "country/form";
    }

    @PostMapping("/country/edit")
    public String getCountryEdit(@ModelAttribute("country") Country country) {
        countryRepo.save(country);
        return "redirect:/country/list";
    }

    @GetMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable("id") Long id) {
        countryRepo.deleteById(id);
        return "redirect:/country/list";
    }

    /* Валюта */
    @GetMapping("/currency/list")
    public String getcurrencyList(Model model) {
        model.addAttribute("currencies", currencyRepo.findAll());
        return "currency/list";
    }

    @GetMapping("/currency/add")
    public String getcurrencyFormAdd() {
        return "currency/form";
    }

    @PostMapping("/currency/add")
    public String currencyAdd(@ModelAttribute("currency") Currency currency) {
        currencyRepo.save(currency);
        return "redirect:/currency/list";
    }

    @GetMapping("/currency/{id}")
    public String getcurrencyFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("currency", currencyRepo.getById(id));
        return "currency/form";
    }

    @PostMapping("/currency/edit")
    public String getcurrencyEdit(@ModelAttribute("country") Currency currency) {
        currencyRepo.save(currency);
        return "redirect:/currency/list";
    }

    @GetMapping("/currency/delete/{id}")
    public String deletecurrency(@PathVariable("id") Long id) {
        currencyRepo.deleteById(id);
        return "redirect:/currency/list";
    }

    /* Значимые обстоятельства */
    @GetMapping("/znachimobstoyat/list")
    public String getznachimobstoyatList(Model model) {
        model.addAttribute("znachimobstoyats", znachimoeObstoyatelstvoRepo.findAll());
        return "znachimobstoyat/list";
    }

    @GetMapping("/znachimobstoyat/add")
    public String getznachimobstoyatFormAdd() {
        return "znachimobstoyat/form";
    }

    @PostMapping("/znachimobstoyat/add")
    public String znachimobstoyatAdd(@ModelAttribute("country") ZnachimoeObstoyatelstvo znachimoeObstoyatelstvo) {
        znachimoeObstoyatelstvoRepo.save(znachimoeObstoyatelstvo);
        return "redirect:/znachimobstoyat/list";
    }

    @GetMapping("/znachimobstoyat/{id}")
    public String getznachimobstoyatFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("znachimobstoyat", znachimoeObstoyatelstvoRepo.getById(id));
        return "znachimobstoyat/form";
    }

    @PostMapping("/znachimobstoyat/edit")
    public String getznachimobstoyatEdit(@ModelAttribute("znachimobstoyat") ZnachimoeObstoyatelstvo znachimobstoyat) {
        znachimoeObstoyatelstvoRepo.save(znachimobstoyat);
        return "redirect:/znachimobstoyat/list";
    }

    @GetMapping("/znachimobstoyat/delete/{id}")
    public String deleteznachimobstoyat(@PathVariable("id") Long id) {
        znachimoeObstoyatelstvoRepo.deleteById(id);
        return "redirect:/znachimobstoyat/list";
    }

    /* Трудовая деятельность (TrudovayaDeyatelnost) */
    @GetMapping("/truddeyatelnost/list")
    public String gettruddeyatelnostList(Model model) {
        model.addAttribute("truddeyatelnosts", trudovayaDeyatelnostRepo.findAll());
        return "truddeyatelnost/list";
    }

    @GetMapping("/truddeyatelnost/add")
    public String gettruddeyatelnostFormAdd() {
        return "truddeyatelnost/form";
    }

    @PostMapping("/truddeyatelnost/add")
    public String truddeyatelnostAdd(@ModelAttribute("country") TrudovayaDeyatelnost trudovayaDeyatelnost) {
        trudovayaDeyatelnostRepo.save(trudovayaDeyatelnost);
        return "redirect:/truddeyatelnost/list";
    }

    @GetMapping("/truddeyatelnost/{id}")
    public String gettruddeyatelnostFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("truddeyatelnost", trudovayaDeyatelnostRepo.getById(id));
        return "truddeyatelnost/form";
    }

    @PostMapping("/truddeyatelnost/edit")
    public String gettruddeyatelnostEdit(@ModelAttribute("truddeyatelnost") TrudovayaDeyatelnost truddeyatelnost) {
        trudovayaDeyatelnostRepo.save(truddeyatelnost);
        return "redirect:/truddeyatelnost/list";
    }

    @GetMapping("/truddeyatelnost/delete/{id}")
    public String deletetruddeyatelnost(@PathVariable("id") Long id) {
        trudovayaDeyatelnostRepo.deleteById(id);
        return "redirect:/truddeyatelnost/list";
    }

    /*PrichinaObrasheniya*/
    @GetMapping("/prichinaObrasheniya/list")
    public String getPrichinaObrasheniyaList(Model model) {
        model.addAttribute("prichinaObrasheniyas", prichinaObrasheniyaRepo.findAll());
        return "prichinaObrasheniya/list";
    }

    @GetMapping("/prichinaObrasheniya/add")
    public String getPrichinaObrasheniyaFormAdd() {
        return "prichinaObrasheniya/form";
    }

    @PostMapping("/prichinaObrasheniya/add")
    public String prichinaObrasheniyaAdd(@ModelAttribute("prichinaObrasheniya") PrichinaObrasheniya prichinaObrasheniya) {
        prichinaObrasheniyaRepo.save(prichinaObrasheniya);
        return "redirect:/prichinaObrasheniya/list";
    }

    @GetMapping("/prichinaObrasheniya/{id}")
    public String getPrichinaObrasheniyaFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("prichinaObrasheniya", prichinaObrasheniyaRepo.getById(id));
        return "prichinaObrasheniya/form";
    }

    @PostMapping("/prichinaObrasheniya/edit")
    public String getPrichinaObrasheniyaEdit(@ModelAttribute("prichinaObrasheniya") PrichinaObrasheniya prichinaObrasheniya) {
        prichinaObrasheniyaRepo.save(prichinaObrasheniya);
        return "redirect:/prichinaObrasheniya/list";
    }

    @GetMapping("/prichinaObrasheniya/delete/{id}")
    public String deletePrichinaObrasheniya(@PathVariable("id") Long id) {
        prichinaObrasheniyaRepo.deleteById(id);
        return "redirect:/prichinaObrasheniya/list";
    }

    /*TypeUchastnik*/
    @GetMapping("/typeUchastnik/list")
    public String getTypeUchastnikList(Model model) {
        model.addAttribute("typeUchastniks", typeUchastnikRepo.findAll());
        return "typeUchastnik/list";
    }

    @GetMapping("/typeUchastnik/add")
    public String getTypeUchastnikFormAdd() {
        return "typeUchastnik/form";
    }

    @PostMapping("/typeUchastnik/add")
    public String typeUchastnikAdd(@ModelAttribute("typeUchastnik") TypeUchastnik typeUchastnik) {
        typeUchastnikRepo.save(typeUchastnik);
        return "redirect:/typeUchastnik/list";
    }

    @GetMapping("/typeUchastnik/{id}")
    public String getTypeUchastnikFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("typeUchastnik", typeUchastnikRepo.getById(id));
        return "typeUchastnik/form";
    }

    @PostMapping("/typeUchastnik/edit")
    public String getTypeUchastnikEdit(@ModelAttribute("typeUchastnik") TypeUchastnik typeUchastnik) {
        typeUchastnikRepo.save(typeUchastnik);
        return "redirect:/typeUchastnik/list";
    }

    @GetMapping("/typeUchastnik/delete/{id}")
    public String deleteTypeUchastnik(@PathVariable("id") Long id) {
        typeUchastnikRepo.deleteById(id);
        return "redirect:/typeUchastnik/list";
    }

    /*TypeRodstva*/
    @GetMapping("/typeRodstva/list")
    public String getTypeRodstvaList(Model model) {
        model.addAttribute("typeRodstvas", typeRodstvaRepo.findAll());
        return "typeRodstva/list";
    }

    @GetMapping("/typeRodstva/add")
    public String getTypeRodstvaFormAdd() {
        return "typeRodstva/form";
    }

    @PostMapping("/typeRodstva/add")
    public String typeRodstvaAdd(@ModelAttribute("typeRodstva") TypeRodstva typeRodstva) {
        typeRodstvaRepo.save(typeRodstva);
        return "redirect:/typeRodstva/list";
    }

    @GetMapping("/typeRodstva/{id}")
    public String getTypeRodstvaFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("typeRodstva", typeRodstvaRepo.getById(id));
        return "typeRodstva/form";
    }

    @PostMapping("/typeRodstva/edit")
    public String getTypeRodstvaEdit(@ModelAttribute("typeRodstva") TypeRodstva typeRodstva) {
        typeRodstvaRepo.save(typeRodstva);
        return "redirect:/typeRodstva/list";
    }

    @GetMapping("/typeRodstva/delete/{id}")
    public String deleteTypeRodstva(@PathVariable("id") Long id) {
        typeRodstvaRepo.deleteById(id);
        return "redirect:/typeRodstva/list";
    }

    /*TypePensiya*/
    @GetMapping("/typePensiya/list")
    public String getTypePensiyaList(Model model) {
        model.addAttribute("typePensiyas", typePensiyaRepo.findAll());
        return "typePensiya/list";
    }

    @GetMapping("/typePensiya/add")
    public String getTypePensiyaFormAdd() {
        return "typePensiya/form";
    }

    @PostMapping("/typePensiya/add")
    public String typePensiyaAdd(@ModelAttribute("typePensiya") TypePensiya typePensiya) {
        typePensiyaRepo.save(typePensiya);
        return "redirect:/typePensiya/list";
    }

    @GetMapping("/typePensiya/{id}")
    public String getTypePensiyaFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("typePensiya", typePensiyaRepo.getById(id));
        return "typePensiya/form";
    }

    @PostMapping("/typePensiya/edit")
    public String getTypePensiyaEdit(@ModelAttribute("typePensiya") TypePensiya typePensiya) {
        typePensiyaRepo.save(typePensiya);
        return "redirect:/typePensiya/list";
    }

    @GetMapping("/typePensiya/delete/{id}")
    public String deleteTypePensiya(@PathVariable("id") Long id) {
        typePensiyaRepo.deleteById(id);
        return "redirect:/typePensiya/list";
    }

    /*TypeDocument*/
    @GetMapping("/typeDocument/list")
    public String gettypeDocumentList(Model model) {
        model.addAttribute("typeDocuments", typeDocumentRepo.findAll());
        return "typeDocument/list";
    }

    @GetMapping("/typeDocument/add")
    public String gettypeDocumentFormAdd() {
        return "typeDocument/form";
    }

    @PostMapping("/typeDocument/add")
    public String typeDocumentAdd(@ModelAttribute("typeDocument") TypeDocument typeDocument) {
        typeDocumentRepo.save(typeDocument);
        return "redirect:/typeDocument/list";
    }

    @GetMapping("/typeDocument/{id}")
    public String gettypeDocumentFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("typeDocument", typeDocumentRepo.getById(id));
        return "typeDocument/form";
    }

    @PostMapping("/typeDocument/edit")
    public String gettypeDocumentEdit(@ModelAttribute("typeDocument") TypeDocument typeDocument) {
        typeDocumentRepo.save(typeDocument);
        return "redirect:/typeDocument/list";
    }

    @GetMapping("/typeDocument/delete/{id}")
    public String deletetypeDocument(@PathVariable("id") Long id) {
        typeDocumentRepo.deleteById(id);
        return "redirect:/typeDocument/list";
    }

    /* Oblast */
    @GetMapping("/oblast/list")
    public String getListOfOblast(Model model) {
        model.addAttribute("oblasts", oblastRepo.findAll());
        return "oblast/list";
    }

    /*Rayons*/
    @GetMapping("/rayon/list")
    public String getrayonList(Model model) {
        model.addAttribute("rayons", rayonRepo.findAll());
        return "rayon/list";
    }

    @GetMapping("/rayon/add")
    public String getrayonFormAdd(Model model) {
        model.addAttribute("oblasts", oblastRepo.findAll());
        return "rayon/form";
    }

    @PostMapping("/rayon/add")
    public String rayonAdd(@ModelAttribute("rayon") Rayon rayon) {
        rayonRepo.save(rayon);
        return "redirect:/rayon/list";
    }

    @GetMapping("/rayon/{id}")
    public String getrayonFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("rayon", rayonRepo.getById(id));
        model.addAttribute("oblasts", oblastRepo.findAll());
        return "rayon/form";
    }

    @PostMapping("/rayon/edit")
    public String getrayonEdit(@ModelAttribute("rayon") Rayon rayon) {
        Rayon rayonFromRepo = rayonRepo.getById(rayon.getId());
        if (rayon.getOblast() != null)
            rayon.setOblast(rayonFromRepo.getOblast());
        rayonRepo.save(rayon);
        return "redirect:/rayon/list";
    }

    @GetMapping("/rayon/delete/{id}")
    public String deleterayon(@PathVariable("id") Long id) {
        rayonRepo.deleteById(id);
        return "redirect:/rayon/list";
    }

    /*CompetentOrganOtpravitel*/
    @GetMapping("/competentOrganOtpravitel/list")
    public String getCompetentOrganOtpravitelList(Model model) {
        model.addAttribute("competentOrganOtpravitels", competentOrganOtpravitelRepo.findAll());
        return "competentOrganOtpravitel/list";
    }

    @GetMapping("/competentOrganOtpravitel/add")
    public String getCompetentOrganOtpravitelFormAdd(Model model) {
         model.addAttribute("countries", countryRepo.findAll());
        return "competentOrganOtpravitel/form";
    }

    @PostMapping("/competentOrganOtpravitel/add")
    public String competentOrganOtpravitelAdd(@ModelAttribute("competentOrganOtpravitel") CompetentOrganOtpravitel competentOrganOtpravitel) {
        competentOrganOtpravitelRepo.save(competentOrganOtpravitel);
        return "redirect:/competentOrganOtpravitel/list";
    }

    @GetMapping("/competentOrganOtpravitel/{id}")
    public String getCompetentOrganOtpravitelFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("countries", countryRepo.findAll());
        model.addAttribute("competentOrganOtpravitel", competentOrganOtpravitelRepo.getById(id));
        return "competentOrganOtpravitel/form";
    }

    @PostMapping("/competentOrganOtpravitel/edit")
    public String getCompetentOrganOtpravitelEdit(@ModelAttribute("competentOrganOtpravitel") CompetentOrganOtpravitel competentOrganOtpravitel) {
        competentOrganOtpravitelRepo.save(competentOrganOtpravitel);
        return "redirect:/competentOrganOtpravitel/list";
    }

    @GetMapping("/competentOrganOtpravitel/delete/{id}")
    public String deleteCompetentOrganOtpravitel(@PathVariable("id") Long id) {
        competentOrganOtpravitelRepo.deleteById(id);
        return "redirect:/competentOrganOtpravitel/list";
    }

    /*CompetentOrganPoluchatel*/
    @GetMapping("/competentOrganPoluchatel/list")
    public String getCompetentOrganPoluchatelList(Model model) {
        model.addAttribute("competentOrganPoluchatels", competentOrganPoluchatelRepo.findAll());
        return "competentOrganPoluchatel/list";
    }

    @GetMapping("/competentOrganPoluchatel/add")
    public String getCompetentOrganPoluchatelFormAdd(Model model) {
        model.addAttribute("countries", countryRepo.findAll());
        return "competentOrganPoluchatel/form";
    }

    @PostMapping("/competentOrganPoluchatel/add")
    public String competentOrganPoluchatelAdd(@ModelAttribute("competentOrganPoluchatel") CompetentOrganPoluchatel competentOrganPoluchatel) {
        competentOrganPoluchatelRepo.save(competentOrganPoluchatel);
        return "redirect:/competentOrganPoluchatel/list";
    }

    @GetMapping("/competentOrganPoluchatel/{id}")
    public String getCompetentOrganPoluchatelFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("countries", countryRepo.findAll());
        model.addAttribute("competentOrganPoluchatel", competentOrganPoluchatelRepo.getById(id));
        return "competentOrganPoluchatel/form";
    }

    @PostMapping("/competentOrganPoluchatel/edit")
    public String getCompetentOrganPoluchatelEdit(@ModelAttribute("competentOrganPoluchatel") CompetentOrganPoluchatel competentOrganPoluchatel) {
        competentOrganPoluchatelRepo.save(competentOrganPoluchatel);
        return "redirect:/competentOrganPoluchatel/list";
    }

    @GetMapping("/competentOrganPoluchatel/delete/{id}")
    public String deleteCompetentOrganPoluchatel(@PathVariable("id") Long id) {
        competentOrganPoluchatelRepo.deleteById(id);
        return "redirect:/competentOrganPoluchatel/list";
    }
    /*NasPunkts ALL*/
    @GetMapping("/naspunkt/list")
    public String getnaspunktList(Model model) {
        model.addAttribute("naspunkts", placeNameRepo.findAll());
        return "naspunkt/list";
    }

    @GetMapping("/naspunkt/add")
    public String getnaspunktFormAdd(Model model) {
        model.addAttribute("rayons", rayonRepo.findAll());
        model.addAttribute("placeTypes", placeTypeRepo.findAll());
        return "naspunkt/form";
    }

    @PostMapping("/naspunkt/add")
    public String naspunktAdd(@ModelAttribute("naspunkt") PlaceName placeName) {
        placeNameRepo.save(placeName);
        return "redirect:/naspunkt/list";
    }

    @GetMapping("/naspunkt/{id}")
    public String getnaspunktFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("placename", placeNameRepo.getById(id));
        model.addAttribute("rayons", rayonRepo.findAll());
        model.addAttribute("placeTypes", placeTypeRepo.findAll());
        return "naspunkt/form";
    }

    @PostMapping("/naspunkt/edit")
    public String getnaspunktEdit(@ModelAttribute("naspunkt") PlaceName placeName) {
        PlaceName placeNameFromRepo = placeNameRepo.getById(placeName.getId());
        if (placeName.getRayon() == null) {
            placeName.setRayon(placeNameFromRepo.getRayon());
        } else if (placeName.getPlaceType() == null){
            placeName.setPlaceType(placeNameFromRepo.getPlaceType());
        }
        placeNameRepo.save(placeName);
        return "redirect:/naspunkt/list";
    }

    @GetMapping("/naspunkt/delete/{id}")
    public String deletenaspunkt(@PathVariable("id") Long id) {
        placeNameRepo.deleteById(id);
        return "redirect:/naspunkt/list";
    }

    @GetMapping("/svedForVyplaty/add")
    public String getFormSvedForVyplaty(Model model){
        model.addAttribute("competentOrganPoluchatels", competentOrganPoluchatelRepo.findAll());
        model.addAttribute("competentOrganOtpravitels", competentOrganOtpravitelRepo.findAll());
        model.addAttribute("prichinaObrasheniyas", prichinaObrasheniyaRepo.findAll());
        model.addAttribute("typeUchastniks", typeUchastnikRepo.findAll());
        model.addAttribute("typeRodstvas", typeRodstvaRepo.findAll());
        model.addAttribute("typePensiya", typePensiyaRepo.findAll());
        model.addAttribute("countries", countryRepo.findAll());
        model.addAttribute("oblasts", oblastRepo.findAll());
        model.addAttribute("rayons", rayonRepo.findAll());
        model.addAttribute("placeNames", placeNameRepo.findAll());
        model.addAttribute("sexs", Sex.values());
        model.addAttribute("typeDocuments", typeDocumentRepo.findAll());
        return "svedForVyplaty/form";
    }

    @GetMapping("/svedForVyplaty/list")
    public String getListOfSvedForVyplaty(Model model){
        model.addAttribute("svedForVyplaties",svedForVyplatyPensiyaRepo.findAll());
        return "svedForVyplaty/list";
    }

        @PostMapping("/svedForVyplaty/add")
    public String addFormSvedForVyplaty(@ModelAttribute SvedForVyplatyPensiya svedForVyplatyPensiya){
        svedForVyplatyPensiyaRepo.save(svedForVyplatyPensiya);
        return "redirect:/svedForVyplaty/list";
    }
}
