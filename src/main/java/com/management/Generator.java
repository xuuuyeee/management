package com.management;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("sys_part");
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/management?serverTimezone=Asia/Shanghai","root","Ff332626")
                         .globalConfig(builder -> {
                              builder.author("xuuuyeee")
                                     .fileOverride()
                                     .outputDir(System.getProperty("user.dir")+"\\src\\main\\java");
                         })
                         .packageConfig(builder -> {
                             builder.parent("com.management")
                                     .moduleName("practise")
                                     .entity("domain");
//                                     .service("service")
//                                     .serviceImpl("serviceImpl")
//                                     .controller("controller")
//                                     .mapper("mapper")
//                                     .xml("mapper")
//                                     .pathInfo(Collections.singletonMap(OutputFile.xml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
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
