package com.example;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.BridgeFrom;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
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
public class PubSubIntegrationConfig {
	
	public String INPUT_DIR = "/programs/data/input";
	public String OUTPUT_DIR1 = "/programs/data/output1";
	public String OUTPUT_DIR2 = "/programs/data/output2";
	
	public String FILE_PATTERN = "*.txt";

	
	@Bean
	public MessageChannel pubSubFileChannel() {
	    return new PublishSubscribeChannel();
	}

	@Bean
	@BridgeFrom(value = "pubSubFileChannel")
	public MessageChannel fileChannel1() {
	    return new DirectChannel();
	}

	@Bean
	@BridgeFrom(value = "pubSubFileChannel")
	public MessageChannel fileChannel2() {
	    return new DirectChannel();
	}

	@Bean
	@InboundChannelAdapter(value = "pubSubFileChannel", poller = @Poller(fixedDelay = "5000"))
	public MessageSource<File> fileReadingMessageSource() {
		System.out.println("PubSubIntegrationConfig.fileReadingMessageSource()");
	    FileReadingMessageSource sourceReader = new FileReadingMessageSource();
	    sourceReader.setDirectory(new File(INPUT_DIR));
	    sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
	    return sourceReader;
	}

	@Bean
	@ServiceActivator(inputChannel = "fileChannel1")
	public MessageHandler fileWritingMessageHandler1() {
		System.out.println("PubSubIntegrationConfig.fileWritingMessageHandler1()");
		FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR1));
		handler.setFileExistsMode(FileExistsMode.REPLACE);
		handler.setExpectReply(false);
		return handler;
	}
	
	@Bean
	@ServiceActivator(inputChannel = "fileChannel2")
	public MessageHandler fileWritingMessageHandler2() {
		System.out.println("PubSubIntegrationConfig.fileWritingMessageHandler2()");
		FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR2));
		handler.setFileExistsMode(FileExistsMode.REPLACE);
		handler.setExpectReply(false);
		return handler;
	}
	
}