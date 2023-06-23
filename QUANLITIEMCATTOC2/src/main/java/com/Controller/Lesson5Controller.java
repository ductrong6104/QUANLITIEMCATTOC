package com.Controller;
/*
 * package ptit.controller;
 * 
 * import java.io.File; import java.time.LocalDateTime; import
 * java.time.format.DateTimeFormatter;
 * 
 * import javax.mail.internet.MimeMessage; import javax.servlet.ServletContext;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.core.io.FileSystemResource; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.mail.javamail.MimeMessageHelper; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import ptit.bean.Company; import ptit.bean.UploadFile; import
 * ptithcm.model.MailModel; import ptithcm.model.Product;
 * 
 * @Controller
 * 
 * @RequestMapping("Lesson5/") public class Lesson5Controller {
 * 
 * // public static String uploadDirectory = System.getProperty("user.dir"); //
 * public static String uploadDirectory = //
 * System.getProperty("catalina.home");rootPath=System.getProperty(
 * "catalina.home");
 * 
 * @Autowired
 * 
 * @Qualifier("ptithcm") Company company;
 * 
 * @Autowired
 * 
 * @Qualifier("ptit") Company company1;
 * 
 * @Autowired
 * 
 * @Qualifier("uploadfile") UploadFile baseUploadfile;
 * 
 * @Autowired
 * 
 * @Qualifier("attachefile") UploadFile baseUpAttachFile;
 * 
 * @Autowired public JavaMailSender mailer;
 * 
 * @Autowired ServletContext context;
 * 
 * 
 * @RequestMapping("index") public String demo1(ModelMap model) {
 * 
 * model.addAttribute("company", company); model.addAttribute("company1",
 * company1);
 * 
 * return "Lesson5/demo1"; }
 * 
 * 
 * @RequestMapping(value = "demo2", method = RequestMethod.GET) public String
 * demo2(ModelMap model) {
 * 
 * // model.addAttribute("company",company); // model.addAttribute("company1",
 * company1); return "Lesson5/demo2"; }
 * 
 * @RequestMapping(value = "showsanpham", method = RequestMethod.GET) public
 * String showsanpham(ModelMap model) {
 * 
 * // model.addAttribute("company",company); // model.addAttribute("company1",
 * company1); return "Lesson5/showsanpham"; }
 * 
 *//**
	 * @param model
	 * @param file
	 * @param product
	 * @return
	 *//*
		 * 
		 * @RequestMapping(value="demo2", method = RequestMethod.POST) public String
		 * showdemo2(ModelMap model, @RequestParam("name") String name,
		 * 
		 * @RequestParam("untiPrice") String untiPrice,
		 * 
		 * @RequestParam("discount") String discount,
		 * 
		 * @RequestParam("file") MultipartFile file,
		 * 
		 * @ModelAttribute("product") Product product ) {
		 * 
		 * if(file.isEmpty())
		 * 
		 * { model.addAttribute("message","Vui lòng chọn file upload"); } else {
		 * 
		 * // String filename = saveImage(file); // if (filename == null) { //
		 * model.addAttribute("message","lổi file upload"); // } // else // { //
		 * product.setPhoto(filename); // System.out.println(product.getPhoto()); //
		 * model.addAttribute("product",product); // // return "Lesson5/showsanpham"; //
		 * } //
		 * 
		 * try { String date =
		 * LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
		 * String fileName = date + file.getOriginalFilename(); // byte[] bytes =
		 * file.getBytes(); //Path photoPath=
		 * Paths.get(context.getRealPath("resources/hinhsp/" +
		 * photo.getOriginalFilename())); //Path photoPath=
		 * Paths.get(baseUploadfile.basePath + File.separator +
		 * file.getOriginalFilename()); String photoPath = baseUploadfile.basePath +
		 * File.separator + fileName; System.out.println("Pathfile is: "+ photoPath);
		 * file.transferTo(new File(photoPath)); //Files.write(photoPath,bytes);
		 * 
		 * //String type = file.getOriginalFilename().split("\\.")[1];
		 * 
		 * BufferedOutputStream stream = new BufferedOutputStream( new
		 * FileOutputStream(new File(photoPath)));
		 * FileCopyUtils.copy(file.getInputStream(), stream); stream.close();
		 * 
		 * 
		 * Thread.sleep(2500); product.setPhoto(fileName);;
		 * model.addAttribute("product",product);
		 * 
		 * return "Lesson5/showsanpham";
		 * 
		 * } catch (Exception e) { model.addAttribute("message","Lổi upload file"); } }
		 * 
		 * return"Lesson5/demo2";
		 * 
		 * }
		 * 
		 * private String saveImage(MultipartFile multipartFile) {
		 * 
		 * try {
		 * 
		 * String date =
		 * LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
		 * String fileName = date + multipartFile.getOriginalFilename(); //byte[] bytes
		 * photo.getBytes(); //Path photoPath=
		 * Paths.get(context.getRealPath("resources/hinhsp/" +
		 * photo.getOriginalFilename())); //Path photoPath= Paths.get(baseUploadfile +
		 * File.separator + fileName); String photoPath = baseUploadfile.basePath + "\\"
		 * + fileName; System.out.println("Pathfile is: "+ photoPath);
		 * multipartFile.transferTo(new File(photoPath)); return fileName;
		 * 
		 * } catch (Exception e) { return null; // TODO: handle exception }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * @RequestMapping(value="demo3",method = RequestMethod.GET) public String
		 * 
		 * demo3(@ModelAttribute("mailObject") MailModel mailObject) {
		 * 
		 * 
		 * return "Lesson5/demo3"; }
		 * 
		 * @RequestMapping(value = "sendmail", method = RequestMethod.POST) public
		 * String sendMail(ModelMap model,
		 * 
		 * @ModelAttribute("mailObject") MailModel mailObject,
		 * 
		 * @RequestParam("attachFile") MultipartFile attachFile, HttpServletRequest
		 * request, HttpSession session) { try { MimeMessage mail =
		 * mailer.createMimeMessage(); MimeMessageHelper helper = new
		 * MimeMessageHelper(mail, true);
		 * 
		 * helper.setFrom("hieuptithcm@gmail.com", mailObject.getSender());
		 * 
		 * helper.setTo(mailObject.getMailRecepient());
		 * 
		 * helper.setReplyTo("hieuptithcm@gmail.com");
		 * 
		 * helper.setSubject(mailObject.getSubject());
		 * 
		 * helper.setText(mailObject.getMessagebody(), true);
		 * 
		 * if (!attachFile.isEmpty()) {
		 * 
		 * File dir = new File(baseUpAttachFile.basePath); if (!dir.exists()) {
		 * dir.mkdir(); } String uploadBaseDir = baseUpAttachFile.basePath +
		 * File.separator + attachFile.getOriginalFilename(); attachFile.transferTo(new
		 * File(uploadBaseDir)); FileSystemResource file1 = new FileSystemResource(new
		 * File(uploadBaseDir)); helper.addAttachment(attachFile.getOriginalFilename(),
		 * file1); }
		 * 
		 * mailer.send(mail); model.addAttribute("masseage", "Gửi mail thành công");
		 * mailObject.setSender(""); mailObject.setMailRecepient("");
		 * mailObject.setMessagebody(""); mailObject.setSubject("");
		 * 
		 * } catch (Exception e) { model.addAttribute("masseage",
		 * "Xin lổi ko thể gửi mail được"); } return "Lesson5/demo3"; }
		 * 
		 * }
		 */