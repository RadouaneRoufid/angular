package com.roufid.tutorials.controller;

import com.roufid.tutorials.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class FileController {

	private final FileService fileService;

	@Autowired
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}

	@GetMapping(value = "/api/files/system/{filename}", produces = "text/csv; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public Resource getFileFromFileSystem(@PathVariable String filename, HttpServletResponse response) {
		return fileService.getFileSystem(filename, response);
	}

	@GetMapping(value = "/api/files/classpath/{filename}", produces = "text/csv; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public Resource getFileFromClasspath(@PathVariable String filename, HttpServletResponse response) {
		return fileService.getClassPathFile(filename, response);
	}
}
