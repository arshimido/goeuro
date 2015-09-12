package com.goeuro.task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;

import com.goeuro.task.config.Configuration;


/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testMainMethod() {
    	App.main(new String[] {"berlin"});
    	

		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(Configuration.getInstance().getCSVFilePath()));
			List<String[]> list = reader.readAll();
			reader.close();
			Assert.assertNotNull(list);
			Assert.assertNotEquals(new ArrayList<String[]>(), list);
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
    }
}
