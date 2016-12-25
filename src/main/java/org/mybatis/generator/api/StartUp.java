package org.mybatis.generator.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class StartUp {
	public static void main(String[] args) {
		try {
			List<String> warnings = new ArrayList<String>();
			   boolean overwrite = true;
			   File configFile = new File("src\\main\\resources\\generatorConfig.xml");
			   ConfigurationParser cp = new ConfigurationParser(warnings);
			   Configuration config = cp.parseConfiguration(configFile);			 
			   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			   String path = System.getProperty("user.dir")+"\\lib\\mysql-connector-java-5.1.38.jar";
			   config.addClasspathEntry(path);
			   myBatisGenerator.generate(null);
			   System.out.println(warnings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
