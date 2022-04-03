/**
 * 更多String的API见书50页，和java api文档
 */

public class StringTest {
    public static void main(String[] args) {
        String greetings = "Hello";

        //截取字符串
        String s = greetings.substring(0,3);    //从0开始，截取3个字符
        System.out.println(s);      //Hel

        //利用join拼接字符串
        String all = String.join("/", "1", "2", "3");
        System.out.println(all);            //  1/2/3

        //检测字符串是否相等
        System.out.println("Hello".equals(greetings));
        //不要这么用！==对比的是地址想不想等，很有可能不相等！
        System.out.println(greetings == "Hello");

        //50页的api 随便用用
        System.out.println(greetings.charAt(3));
        System.out.println(greetings.codePointAt(3));
        System.out.println(greetings.compareTo("absolute"));
        System.out.println(greetings.indexOf("e"));
    }
}
