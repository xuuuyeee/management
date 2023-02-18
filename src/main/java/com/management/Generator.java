package com.management;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Generator {
    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("sys_member");
        tables.add("sys_part");
        tables.add("sys_address");
        tables.add("sys_device");
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/management?serverTimezone=Asia/Shanghai","root","Ff332626")
                         .globalConfig(builder -> {
                              builder.author("xuuuyeee")
                                     .fileOverride()
                                     .outputDir(System.getProperty("user.dir")+"\\src\\main\\java");
                         })
                         .packageConfig(builder -> {
                             builder.parent("com.management")
                                     .moduleName("practise")
                                     .entity("domain")
                                     .service("service")
                                     .serviceImpl("serviceImpl")
                                     .controller("controller")
                                     .mapper("mapper")
                                     .xml("mapper")
                                     .pathInfo(Collections.singletonMap(OutputFile.xml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
                         })
                         .strategyConfig(builder -> {
                             builder.addInclude(tables)
                                     .addTablePrefix("sys_")
                                     .serviceBuilder()
                                     .formatServiceFileName("%sService")
                                     .formatServiceImplFileName("%sServiceImpl")
                                     .entityBuilder()
                                     .enableLombok()
                                     .enableTableFieldAnnotation()
                                     .controllerBuilder()
                                     .enableRestStyle()
                                     .mapperBuilder()
                                     .superClass(BaseMapper.class)
                                     .formatMapperFileName("%sMapper")
                                     .enableMapperAnnotation()
                                     .formatXmlFileName("%sMapper");
                         }).execute();
    }
}
