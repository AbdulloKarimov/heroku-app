//package kg.inai.socfond.bootstrap;
//
//import kg.inai.socfond.entities.*;
//import kg.inai.socfond.models.CoateModel;
//import kg.inai.socfond.repos.*;
//import org.apache.poi.ss.usermodel.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class Bootstrap implements CommandLineRunner {
//    @Autowired
//    private UserRoleRepo userRoleRepo;
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private OblastRepo oblastRepo;
//
//    @Autowired
//    private RayonRepo rayonRepo;
//
//    @Autowired
//    private PlaceNameRepo placeNameRepo;
//
//    @Autowired
//    private PlaceTypeRepo placeTypeRepo;
//
//    @Autowired
//    private CountryRepo countryRepo;
//
//    @Value("${filespath}")
//    private String filespath;
//
//    @Override
//    public void run(String... args) throws Exception {
//        UserRole admin = UserRole.builder()
//                .name("ROLE_ADMIN")
//                .description("Администратор")
//                .build();
//        userRoleRepo.save(admin);
//
//        User userAdmin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("123"))
//                .firstName("Admin")
//                .lastName("Admin")
//                .phoneNumber("0555000000")
//                .email("admin@gmail.com")
//                .userRoles(new ArrayList<>(Arrays.asList(
//                        admin
//                )))
//                .build();
//        userRepo.save(userAdmin);
//
//        //СКРИПТ ДЛЯ ДОБАВЛЕНИЯ ВСЕХ СТРАН
//        try (InputStream inp = new FileInputStream(filespath + "countries.xlsx")) {
//            Workbook wb = WorkbookFactory.create(inp);
//            Sheet sheet = wb.getSheetAt(1);
//
//            for (int i = 1; i < 252; i++) {
//                Row row = sheet.getRow(i);
//                Cell codeISO = row.getCell(0);
//                Cell name = row.getCell(1);
//                String codeISOStr = String.valueOf(codeISO);
//                float codeISOfl = Float.parseFloat(codeISOStr);
//                if (name != null) {
//                    Country country = Country.builder()
//                            .name(String.valueOf(name))
//                            .codeISO(String.valueOf((int)codeISOfl))
//                            .build();
//                    countryRepo.save(country);
//                }
//            }
//            System.out.println("Добавлены все страны");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        //СКРИПТ ДЛЯ ДОБАВЛЕНИЯ ВСЕХ ОБЛАСТЕЙ
//        try (InputStream inp = new FileInputStream(filespath + "oblasts.xlsx")) {
//            Workbook wb = WorkbookFactory.create(inp);
//            Sheet sheet = wb.getSheetAt(0);
//
//            for (int i = 1; i < 10; i++) {
//                Row row = sheet.getRow(i);
//                Cell oblCode = row.getCell(0);
//                Cell name = row.getCell(1);
//                Cell ate = row.getCell(2);
//                String oblCodeStr = String.valueOf(oblCode);
//                float oblCodeFl = Float.parseFloat(oblCodeStr);
//                String ateStr = String.valueOf(ate);
//                float ateFl = Float.parseFloat(ateStr);
//                if (name != null) {
//                    Oblast oblast = Oblast.builder()
//                            .name(String.valueOf(name))
//                            .code(String.valueOf((int) oblCodeFl))
//                            .ateCode((int) ateFl)
//                            .build();
//                    oblastRepo.save(oblast);
//                }
//            }
//            System.out.println("Добавлены все области");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        //СКРИПТ ДЛЯ ДОБАВЛЕНИЯ ВСЕХ РАЙОНОВ
//        try (InputStream inp = new FileInputStream(filespath + "rayons.xlsx")) {
//            Workbook wb = WorkbookFactory.create(inp);
//            Sheet sheet = wb.getSheetAt(0);
//
//            for (int i = 1; i < 57; i++) {
//                Row row = sheet.getRow(i);
//                Cell name = row.getCell(2);
//                Cell rayonCode = row.getCell(0);
//                Cell oblId = row.getCell(1);
//                Cell codeS = row.getCell(3);
//                if (name != null && oblId != null) {
//                    String oblIdStr = String.valueOf(oblId);
//                    float oblIdfl = Float.parseFloat(oblIdStr);
//                    String rayonCodeStr = String.valueOf(rayonCode);
//                    float rayonCodeFl = Float.parseFloat(rayonCodeStr);
//                    String codeSStr = String.valueOf(codeS);
//                    float codeSfl = Float.parseFloat(codeSStr);
//                    Rayon rayon = Rayon.builder()
//                            .name(String.valueOf(name))
//                            .code(String.valueOf((int) rayonCodeFl))
//                            .oblast(oblastRepo.getByCode(String.valueOf((int) oblIdfl)))
//                            .codeSF(String.valueOf((int) codeSfl))
//                            .build();
//                    rayonRepo.save(rayon);
//                }
//            }
//            System.out.println("Добавлены все районы");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        //СКРИПТ ДЛЯ ДОБАВЛЕНИЯ ateCode для ВСЕХ РАЙОНОВ
//        try (InputStream inp = new FileInputStream(filespath + "rayonsSOATE.xlsx")) {
//            Workbook wb = WorkbookFactory.create(inp);
//            Sheet sheet = wb.getSheetAt(0);
//
//            for (int i = 1; i < 45; i++) {
//                Row row = sheet.getRow(i);
//                Cell ate = row.getCell(0);
//                Cell name = row.getCell(2);
//                String ateStr = String.valueOf(ate);
//                float ateFl = Float.parseFloat(ateStr);
//
//                Rayon rayon = rayonRepo.getRayByName(String.valueOf(name));
//                rayon.setAteCode((int) ateFl);
//                rayonRepo.save(rayon);
//            }
//            System.out.println("Добавлены ATE CODE для всех районов");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        PlaceType selo = PlaceType.builder()
//                .name("Село")
//                .ateTypeCode(8L)
//                .build();
//        placeTypeRepo.save(selo);
//        PlaceType gorod = PlaceType.builder()
//                .name("Город")
//                .ateTypeCode(7L)
//                .build();
//        placeTypeRepo.save(gorod);
//        PlaceType pgt = PlaceType.builder()
//                .name("ПГТ")
//                .ateTypeCode(9L)
//                .build();
//        placeTypeRepo.save(pgt);
//
//        //СКРИПТ ДЛЯ ДОБАВЛЕНИЯ ВСЕХ населенных пунктов
//        try (InputStream inp = new FileInputStream(filespath + "COATE.xlsx")) {
//            Workbook wb = WorkbookFactory.create(inp);
//            Sheet sheet = wb.getSheetAt(1);
//            List<CoateModel> coateModelList = new ArrayList<>();
//            for (int i = 2; i < 5801; i++) {
//                Row row = sheet.getRow(i);
//                Cell ate = row.getCell(2);
//                Cell ateType = row.getCell(3);
//                Cell name = row.getCell(5);
//                Cell parentId = row.getCell(7);
//
//                String ateStr = String.valueOf(ate);
//                float ateFl = Float.parseFloat(ateStr);
//                String ateTypeStr = String.valueOf(ateType);
//                float ateTypeFl = Float.parseFloat(ateTypeStr);
//                String parentStr = String.valueOf(parentId);
//                if (!parentStr.equals("<NULL>")) {
//                    float parentFl = Float.parseFloat(parentStr);
//                    CoateModel coateModel = CoateModel.builder()
//                            .ate((int) ateFl)
//                            .ateType((int) ateTypeFl)
//                            .parentId((int) parentFl)
//                            .name(String.valueOf(name))
//                            .build();
//                    coateModelList.add(coateModel);
//                }
//            }
//            //СЕЛО
//            for (CoateModel coateModel : coateModelList) {
//                if (coateModel.getAteType() == 8) {
//                    PlaceName placeName = PlaceName.builder()
//                            .name(coateModel.getName())
//                            .placeType(selo)
//                            .build();
//                    for (CoateModel coateModel2 : coateModelList) {
//                        if (coateModel2.getAteType() == 4 && coateModel.getParentId().equals(coateModel2.getAte())) {
//
//                            for (CoateModel coateModel3 : coateModelList) {
//                                if (coateModel3.getAteType() == 3 && coateModel2.getParentId().equals(coateModel3.getAte())) {
//                                    placeName.setRayon(rayonRepo.getRayonByAteCode(coateModel3.getAte()));
//                                    placeNameRepo.save(placeName);
//                                }
//                            }
//
//
//                        }
//                    }
//                }
//            }
//            //ПГТ
//            for (CoateModel coateModel : coateModelList) {
//                if (coateModel.getAteType() == 9) {
//                    PlaceName placeName = PlaceName.builder()
//                            .name(coateModel.getName())
//                            .placeType(pgt)
//                            .build();
//                    for (CoateModel coateModel2 : coateModelList) {
//                        if (coateModel2.getAteType() == 3 && coateModel.getParentId().equals(coateModel2.getAte())) {
//                            placeName.setRayon(rayonRepo.getRayonByAteCode(coateModel2.getAte()));
//                            placeNameRepo.save(placeName);
//                        }
//
//                        if (coateModel2.getAteType() == 7 && coateModel.getParentId().equals(coateModel2.getAte())) {
//
//                            for (CoateModel coateModel3 : coateModelList) {
//                                if (coateModel3.getAteType() == 3 && coateModel2.getParentId().equals(coateModel3.getAte())) {
//                                    placeName.setRayon(rayonRepo.getRayonByAteCode(coateModel3.getAte()));
//                                    placeNameRepo.save(placeName);
//                                }
//                            }
//                        }
//                        if (coateModel2.getAteType() == 6 && coateModel.getParentId().equals(coateModel2.getAte())) {
//
//                            for (CoateModel coateModel3 : coateModelList) {
//                                if (coateModel3.getAteType() == 2 && coateModel2.getParentId().equals(coateModel3.getAte())) {
//                                    placeName.setOblast(oblastRepo.getOblastByAteCode(coateModel3.getAte()));
//                                    placeNameRepo.save(placeName);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//            //город
//            for (CoateModel coateModel : coateModelList) {
//                if (coateModel.getAteType() == 6 || coateModel.getAteType() == 7) {
//                    PlaceName placeName = PlaceName.builder()
//                            .name(coateModel.getName())
//                            .placeType(gorod)
//                            .build();
//                    for (CoateModel coateModel2 : coateModelList) {
//
//                        if (coateModel2.getAteType() == 3 && coateModel.getParentId().equals(coateModel2.getAte())) {
//                            placeName.setRayon(rayonRepo.getRayonByAteCode(coateModel2.getAte()));
//                            placeNameRepo.save(placeName);
//                        }
//                        if (coateModel2.getAteType() == 2 && coateModel.getParentId().equals(coateModel2.getAte())) {
//                            placeName.setOblast(oblastRepo.getOblastByAteCode(coateModel2.getAte()));
//                            placeNameRepo.save(placeName);
//                        }
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("Добавлены все населенные пункты по COATE");
//
//    }
//}
