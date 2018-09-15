package qiuzhao.xinlang;

/**
 * Created by Huangsky on 2018/9/15.
 */


import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 代码统计工具
 * 注释：包括单行注释（//）、多行注释、文档注释
 */
public class Main_1 {

    // 记录注释行数
    static long annotationLine = 0;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("请输入要统计代码量的java文件或java目录：");
        Scanner in = new Scanner(System.in);
        String filePath = in.nextLine();

        File file = new File(filePath);
        // 根据用户输入的文件名和目录执行代码量统计
        codeStat(file);

        System.out.println("－－－－－－－－－－统计结果－－－－－－－－－");
        System.out.println("注释行数：" + annotationLine);


    }

    private static void codeStat(File file) throws FileNotFoundException {
        if (file == null || !file.exists())
            throw new FileNotFoundException(file + "，文件不存在！");

        if (file.isDirectory()) {
            File[] files = file.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".java") || pathname.isDirectory();
                }
            });

            for (File target : files) {
                codeStat(target);
            }
        } else {
            BufferedReader bufr = null;
            try {
                // 将指定路径的文件与字符流绑定
                bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException(file + "，文件不存在！" + e);
            }

            // 定义匹配每一行的正则匹配器
            Pattern annotationLinePattern = Pattern.compile("((//)|(/\\*+)|((^\\s)*\\*)|((^\\s)*\\*+/))+",
                    Pattern.MULTILINE + Pattern.DOTALL);    // 注释匹配器(匹配单行、多行、文档注释)


            // 遍历文件中的每一行，并根据正则匹配的结果记录每一行匹配的结果
            String line = null;
            try {
                while ((line = bufr.readLine()) != null) {
                    if (annotationLinePattern.matcher(line).find()) {
                        annotationLine++;
                    }

                }

            } catch (IOException e) {
                throw new RuntimeException("读取文件失败！" + e);
            } finally {
                try {
                    bufr.close();    // 关闭文件输入流并释放系统资源
                } catch (IOException e) {
                    throw new RuntimeException("关闭文件输入流失败！");
                }
            }
        }
    }
}