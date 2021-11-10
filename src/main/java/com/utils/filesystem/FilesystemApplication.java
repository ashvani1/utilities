package com.utils.filesystem;

import com.utils.filesystem.repository.LogsRepository;
import com.utils.filesystem.services.LogsService;
import com.utils.filesystem.services.ProcessFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class FilesystemApplication {

	public static void main(String[] args) throws IOException {
		String name = args[0];
		ConfigurableApplicationContext appContext = SpringApplication.run(FilesystemApplication.class, args);
		ProcessFile processFile = appContext.getBean(ProcessFile.class);
		processFile.fileProcess(name);

	}

}
