package doubleUtils;

/**
 * @Auther: lyf
 * @Date: 2019-08-02 12:50
 * @Description:
 */
public class DoubleMainTest {

    public static void main(String[] args) {
        //保留小数的位数
        System.out.println(DoubleUtils.retainOne(556.215456));
        System.out.println(DoubleUtils.retainTwo(556.215456));
        System.out.println(DoubleUtils.retainThree(556.215456));
        //将double转变成美元的表示形式,并用分隔符尽心分割
        System.out.println(DoubleUtils.toStringWithThree(565655656.565656));
    }
}
