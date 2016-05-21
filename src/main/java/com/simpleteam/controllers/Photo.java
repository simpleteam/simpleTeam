package com.simpleteam.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simpleteam.service.Kernel;
import com.simpleteam.util.Size;
import com.simpleteam.util.Transformer;

/**
 * Photo controller.
 * Also redirect '/' to photo...
 */
@Controller
public class Photo {
    /**
     * get logger.
     */
    private final Logger log = Logger.getLogger(Photo.class);

    @Autowired
    private Kernel kernel;
    
    /**
     * Just redirect to '/photo'.
     * @return 'photo' template
     */
    @RequestMapping("/")
    public final String home() {
        log.info("redirect to '/photo' ");

        return "redirect:/photo";
    }

    /**
     * Catches GET request to '/photo'.
     * @return 'photo' template
     */
    @RequestMapping(value = "/photo")
    public final String photo() {
        log.info("Photo - GET");

        return "photo";
    }

    /**
     * Catches POST request to '/photo'.
     * @return 'photo' template
     */
    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    public final String photoHandler(HttpServletRequest request, Model model) {
        log.info("Photo - POST");

        String path = request.getParameter("photoDir");
        kernel.setFolderPath(path);
        model.addAttribute("photos",kernel.getPhotoesPathes());
        model.addAttribute("count", kernel.numberOfPhotos());
       
        return "photo";
    }
    
    
    @RequestMapping(value = "/photo/original", method = RequestMethod.GET)
    public String original(Model model){
    	
    	model.addAttribute("photos",kernel.getPhotoesPathes());
    	model.addAttribute("count", kernel.numberOfPhotos());
    	
    	return "photo";
    }
    
    
    @RequestMapping(value = "/photo/row/{id}", method = RequestMethod.GET)
    public String original(@PathVariable("id") int id , Model model){
    	model.addAttribute("row",id);
    	model.addAttribute("photos",kernel.getPhotoesPathes());
    	model.addAttribute("count", kernel.numberOfPhotos());
    	
    	return "photo";
    }

    
    @RequestMapping(value = "/photo/wh/{size}", method = RequestMethod.GET)
    public String wh( @PathVariable("size") String size , Model model){
    	
    	Size s = Transformer.toSize(size);
    	
    	model.addAttribute("wh",Transformer.toSize(size));
    	model.addAttribute("photos",kernel.getPhotoesPathes());
    	model.addAttribute("count", kernel.numberOfPhotos());

    	return "photo";
    }
    
    
    @RequestMapping(value = "/photo/blackbackground", method = RequestMethod.GET)
    public String wh(Model model){
    		
    	model.addAttribute("background","black");
    	model.addAttribute("photos",kernel.getPhotoesPathes());
    	model.addAttribute("count", kernel.numberOfPhotos());
    	
    	return "photo";
    }
    
    
    
}
