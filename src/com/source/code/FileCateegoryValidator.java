package com.source.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileCateegoryValidator {

	FileReader fileReader = null;
	File file = null;
	BufferedReader bufferedReader = null;
	String looper;
	FileDTO fileDTO = new FileDTO();;
	FileNavigator fileNavigator = null;

	/*
	 * MethodName:validateFileForCategory Input: output:void Description:
	 * Description:The method reads and checks the category to which a
	 * particular file belongs.
	 */

	public void validateFileForCategory() {
		file = new File(Constants.sourcePATH);
		for (File fileInFolder : file.listFiles()) {

			try {
				fileReader = new FileReader(fileInFolder);
				bufferedReader = new BufferedReader(fileReader);

				while ((looper = bufferedReader.readLine()) != null) {

					if (looper.indexOf(Constants.qualifierFirst) > -1) {
						fileDTO.setFile(fileInFolder);
						fileDTO.setCategory("category1");
						break;
					} else if (looper.indexOf(Constants.qualifierSecond) > -1) {
						fileDTO.setFile(fileInFolder);
						fileDTO.setCategory("category2");
						break;
					} else if (looper.indexOf(Constants.qualifierThird) > -1) {
						fileDTO.setFile(fileInFolder);
						fileDTO.setCategory("category3");
						break;
					}
				}
				fileReader.close();
				fileNavigator = new FileNavigator();
				fileNavigator.navigateFile(fileDTO);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
