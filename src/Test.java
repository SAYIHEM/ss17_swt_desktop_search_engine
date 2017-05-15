public class Test {

    public static void main(String[] args) {

        String s = "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";

        s = s.replace("-\n", "");
        s = s.replace("\n", " ");

        s = s.replaceAll("[-+.^:,!]","");

        System.out.println(s);
        String[] splitted = s.split(" |[\\n]");

        for (String st : splitted) {

            System.out.println(st);
        }
    }
}
