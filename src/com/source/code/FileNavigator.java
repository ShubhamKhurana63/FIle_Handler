package com.source.code;

import java.io.File;

public class FileNavigator {

	File destinationFile = null;

	/*
	 * MethodName:navigateFile() 
	 * Input:FIleDTO(Data regarding file with category) 
	 * Description:It is responsible for moving files to another
	 * folder depending upon the category and deleting the files in the old
	 * folder
	 */

	public void navigateFile(FileDTO fileDTO) {
		if (("category1").equals(fileDTO.getCategory())) {
			destinationFile = new File(Constants.destPath + "category1/" + fileDTO.getFile().getName());
		} else if (("category2").equals(fileDTO.getCategory())) {
			destinationFile = new File(Constants.destPath + "category2/" + fileDTO.getFile().getName());

		} else if (("category3").equals(fileDTO.getCategory())) {
			destinationFile = new File(Constants.destPath + "category3/" + fileDTO.getFile().getName());
		}
		fileDTO.getFile().renameTo(destinationFile);
		fileDTO.getFile().delete();
	}

}
