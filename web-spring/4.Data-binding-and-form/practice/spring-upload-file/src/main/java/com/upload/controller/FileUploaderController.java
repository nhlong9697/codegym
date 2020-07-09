package com.upload.controller;

import com.upload.model.UploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileUploaderController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == UploadForm.class) {
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }

    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
    public String uploadOneFileHandler(Model model) {

        UploadForm uploadForm = new UploadForm();
        model.addAttribute("uploadForm", uploadForm);

        return "uploadOneFile";
    }

    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
    public String uploadOneFileHandlerPOST(HttpServletRequest request, Model model,
                                           @ModelAttribute("uploadForm") UploadForm uploadForm) {
        return this.doUpload(request, model, uploadForm);
    }

    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.GET)
    public String uploadMultipleFileHandler(Model model) {
        UploadForm uploadForm = new UploadForm();
        model.addAttribute("uploadForm", uploadForm);
        return "uploadMultipleFile";
    }

    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    public String uploadMultipleFileHandlerPOST(HttpServletRequest request, Model model,
                                                @ModelAttribute("uploadForm") UploadForm uploadForm) {
        return this.doUpload(request,model,uploadForm);
    }

    private String doUpload(HttpServletRequest request, Model model, UploadForm uploadForm) {

        String description = uploadForm.getDescription();
        System.out.println("1Description: " + description);
        //set up upload folder at server
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("2uploadRootPath=" + uploadRootPath);
        File uploadRootDir = new File(uploadRootPath);

        //create upload folder if not exists
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }

        CommonsMultipartFile[] files = uploadForm.getFiles();
        Map<File, String> uploadedFiles = new HashMap<>();
        //get each file from upload form
        for (CommonsMultipartFile file: files) {
            String originalFilename = file.getOriginalFilename();
            System.out.println("3Client file name is " + originalFilename);
            if (originalFilename != null && originalFilename.length() > 0) {
                //write the file to server
                try {
                    File serverFile =
                            new File(uploadRootDir.getAbsolutePath() + File.pathSeparator
                                    + originalFilename);
                    BufferedOutputStream outputStream =
                            new BufferedOutputStream(new FileOutputStream(serverFile));
                    outputStream.write(file.getBytes());
                    outputStream.close();
                    uploadedFiles.put(serverFile,"copy of " + originalFilename);
                    System.out.println("4Write file: " + serverFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //add to model
        model.addAttribute("description",description);
        model.addAttribute("uploadedFiles", uploadedFiles);
        return "uploadResult";
    }
}
