package com.roufid.tutorials.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class FileService {

	private enum ResourceType {
		FILE_SYSTEM,
		CLASSPATH
	}

	private static final String FILE_DIRECTORY = "/var/files";

	/**
	 * @param filename filename
	 * @param response Http response.
	 * @return file from system.
	 */
	public Resource getFileSystem(String filename, HttpServletResponse response) {
		return getResource(filename, response, ResourceType.FILE_SYSTEM);
	}

	/**
	 * @param filename filename
	 * @param response Http response.
	 * @return file from classpath.
	 */
	public Resource getClassPathFile(String filename, HttpServletResponse response) {
		return getResource(filename, response, ResourceType.CLASSPATH);
	}

	private Resource getResource(String filename, HttpServletResponse response, ResourceType resourceType) {
		response.setContentType("text/csv; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		response.setHeader("filename", filename);

		Resource resource = null;
		switch (resourceType) {
			case FILE_SYSTEM:
				resource = new FileSystemResource(FILE_DIRECTORY + filename);
				break;
			case CLASSPATH:
				resource = new ClassPathResource("data/" + filename);
				break;
		}

		return resource;
	}
}
