package com.example.demo;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

	public static void main(String[] args) {
		
		String outPutDir="D:\\workspace\\tempCode";
		String packageName = "com.qqxhb.mybatis";
		String[] tableNames = { "news" };
		generateCode(outPutDir, packageName, tableNames);
	}

	private static void generateCode(String outPutDir, String packageName, String[] tableNames) {

		// 数据源配置
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig
				.setUrl("jdbc:mysql://127.0.0.1/demo?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
		dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
		dataSourceConfig.setUsername("root");
		dataSourceConfig.setPassword("root");

		// 策略配置
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setCapitalMode(true).setEntityLombokModel(false).setNaming(NamingStrategy.underline_to_camel)
				.setInclude(tableNames);

		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(false).setOutputDir(outPutDir).setFileOverride(true).setEnableCache(false);
		// 代码生成器
		AutoGenerator autoGenerator = new AutoGenerator();
		autoGenerator.setGlobalConfig(config).setDataSource(dataSourceConfig).setStrategy(strategyConfig)
				.setPackageInfo(new PackageConfig().setParent(packageName)).execute();
	}

}