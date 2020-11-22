package pack;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static StringBuffer ReadTxt(String path) {
        StringBuffer s = new StringBuffer();
        // 读取文件内容 (输入流)
        try {
            FileInputStream out = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(out);
            char[] chars = new char[9999999];
            int ch = 0;
            int i = 0;
            while ((ch = isr.read()) != -1) {
                chars[i] = (char) ch;
                i++;
            }
            for (int j = 0; j < i; j++) {
                s.append(chars[j]);
                if ((j + 1) % 7 == 0 && (j + 1) % 2 == 0) {
                    s.append("。" + "\n");
                }
                if ((j + 1) % 7 == 0 && (j + 1) % 2 != 0) {
                    s.append("，");
                }
            }
        } catch (Exception e) {
            System.out.println("1");
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner;
        // 读取文件内容 (输入流)
        try {
            StringBuffer s = ReadTxt("D:\\StartJava\\src\\Experiment4\\1.txt");
            a:
            while (true) {
                System.out.println("输入功能编号:" + "\n" + "1:查询古诗中的字或词" + "2:退出程序");
                Scanner o = new Scanner(System.in);
                int m = o.nextInt();
                switch (m) {
                    case 1:
                        System.out.println("输入你想要查询的字或词");
                        Scanner scanner1 = new Scanner(System.in);
                        String s1 = scanner1.nextLine();
                        Pattern pattern = Pattern.compile(s1);
                        Matcher matcher = pattern.matcher(s);
                        if (matcher.find()) {
                            int num = 1;
                            while (matcher.find()) {
                                num++;
                            }
                            System.out.println("次数为" + num);
                        } else {
                            System.out.println("文本中没有该字符");
                        }
                        break;
                    case 2:
                        break a;
                    default:
                        System.out.println("您输入的编号有误，请重新输入");
                }
            }

            Student student = new Student();
            while (true) {
                try {
                    System.out.println("姓名");
                    scanner = new Scanner(System.in);
                    String S = scanner.nextLine();
                    if (S.matches("[0-9a-zA-Z]"))
                        throw new AException();
                    else
                        student.setName(S);
                    break;
                } catch (AException e) {
                    System.out.println("您输入的姓名有误，请重新输入");
                }
            }
            System.out.println("班级");
            student.setTeam(scanner.next());
            while (true) {
                try {
                    System.out.println("学号");
                    scanner = new Scanner(System.in);
                    String S = scanner.next();
                    if (S.matches("[^0-9]"))
                        throw new AException();
                    else
                        student.setNumber(S);
                    break;
                } catch (AException e) {
                    System.out.println("您输入的学号有误，请重新输入");
                }
            }
            System.out.println(student);
            s.append(student);
            File file = new File("D:\\StartJava\\src\\Experiment4\\2.txt");
            if (!file.exists())
                file.createNewFile();
            FileOutputStream p = new FileOutputStream(file);
            p.write(s.toString().getBytes("utf-8"));
            p.close();
        } catch (Exception e) {
            System.out.println("1");
        }
    }
}