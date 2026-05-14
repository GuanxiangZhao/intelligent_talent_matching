package com.example.intelligent_talent_matching.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

public class MybatisPlusGenerator {

    /**
     * 读取控制台输入内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");

        if (scanner.hasNext()) {
            String input = scanner.next();

            if (StringUtils.isNotBlank(input)) {
                return input.trim();
            }
        }

        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        // 当前项目路径
        String projectPath = System.getProperty("user.dir");

        // Java 文件输出路径
        String javaOutputDir = Paths.get(projectPath, "src", "main", "java").toString();

        // Mapper XML 输出路径
        String xmlOutputDir = Paths.get(projectPath, "src", "main", "resources", "mapper").toString();

        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/intelligent_talent_matching_platform"
                + "?useUnicode=true"
                + "&characterEncoding=utf8"
                + "&useSSL=false"
                + "&serverTimezone=Asia/Shanghai"
                + "&allowPublicKeyRetrieval=true";

        String username = "root";
        String password = "root";

        FastAutoGenerator.create(url, username, password)

                // 1. 全局配置
                .globalConfig(builder -> {
                    builder.author("Zhao")
                            .outputDir(javaOutputDir)
                            .disableOpenDir()
                            .dateType(DateType.ONLY_DATE)
                            .commentDate("yyyy-MM-dd");
                })

                // 2. 包配置
                .packageConfig(builder -> {
                    builder.parent("com.example.intelligent_talent_matching")
                            .entity("entity")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, xmlOutputDir));
                })

                // 3. 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(scanner("表名，多个表用英文逗号分隔").split(","))
                            // Entity 配置
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .idType(IdType.AUTO)
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)

                            // Mapper 配置
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()

                            // Service 配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")

                            // Controller 配置
                            .controllerBuilder()
                            .enableRestStyle()
                            .enableHyphenStyle();
                })

                // 4. 使用 Freemarker 模板
                .templateEngine(new FreemarkerTemplateEngine())

                // 5. 执行生成
                .execute();
    }
}