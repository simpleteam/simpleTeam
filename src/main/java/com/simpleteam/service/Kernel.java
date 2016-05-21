package com.simpleteam.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Kernel {

	private String folderPath ;
	private List<String> listOfPhotoesPath = new ArrayList<>();
	
	public List<String> getPhotoesPathes(){
		
		File file = new File(folderPath);
		String[] list = file.list();
		
		for(String s : list){
			if(s.endsWith("png")){
				listOfPhotoesPath.add(s);
			}
		}
		
		return listOfPhotoesPath;
	}

	public int numberOfPhotos(){
		return listOfPhotoesPath.size();
	}
	

	public String getFolderPath() {
		return folderPath;
	}


	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	
	
	
	
	
	
	
}
