package test;

public class newTest {
    public static void main(String[] args) {
        String allocateFz = "110";
        if (allocateFz != null && allocateFz.matches("^([1-9][0-9]*)+(.00)?$")) {
            if (allocateFz.indexOf(".") != -1) {
                allocateFz = allocateFz.substring(0, allocateFz.indexOf("."));
            }
            System.out.println("符合" + allocateFz);
        }else {
            System.out.println("不符合");
        }
    }
}
