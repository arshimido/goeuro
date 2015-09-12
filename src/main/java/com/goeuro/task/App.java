package com.goeuro.task;

import com.goeuro.task.model.exception.APIResponseException;
import com.goeuro.task.model.exception.FileGenerationException;
import com.goeuro.task.service.ApplicationLogicService;
import com.goeuro.task.service.ApplicationLogicServiceImpl;

/**
 *
 */
public class App {
	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			System.out.println("Please  enter valid city name as first argument.");
			return;
		}

		// This service should be injected using DI(Dependency injection)
		// container like "spring"
		ApplicationLogicService logicService = new ApplicationLogicServiceImpl();
		try {
			logicService.queryAndGenerateCSV(args[0]);
			System.out.println("DONE!");
		} catch (APIResponseException e) {
			System.out.println(e.getMessage());
		} catch (FileGenerationException e) {
			System.out.println(e.getMessage());
		}
	}
}
