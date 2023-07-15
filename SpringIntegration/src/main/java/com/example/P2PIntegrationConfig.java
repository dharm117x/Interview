package com.example;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
@EnableIntegration
public class P2PIntegrationConfig {
	
	public String INPUT_DIR = "/programs/data/input";
	public String OUTPUT_DIR = "/programs/data/output";
	public String FILE_PATTERN = "*.txt";

	@Bean
	public MessageChannel fileChannel() {
		return new DirectChannel();
	}

	@Bean
	@InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedDelay = "5000"))
	public MessageSource<File> fileReadingMessageSource() {
		System.out.println("P2PIntegrationConfig.fileReadingMessageSource()");
		FileReadingMessageSource sourceReader = new FileReadingMessageSource();
		sourceReader.setDirectory(new File(INPUT_DIR));
		sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
		return sourceReader;
	}

	@Bean
	@ServiceActivator(inputChannel = "fileChannel")
	public MessageHandler fileWritingMessageHandler() {
		System.out.println("P2PIntegrationConfig.fileWritingMessageHandler()");
		FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR));
		handler.setFileExistsMode(FileExistsMode.REPLACE);
		handler.setExpectReply(false);
		return handler;
	}
}