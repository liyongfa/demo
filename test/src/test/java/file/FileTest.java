package file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: lyf
 * @Date: 2019-08-05 19:05
 * @Description:commons.io包下面的FilenameUtils,FileUtils包的使用方法
 */
public class FileTest {

    //文件名的相关操作

    @Test
    public void test1() {
        //获取文件的扩展名
        String extension = FilenameUtils.getExtension("E://gshgs//gsagha//ga//fa.txt");
        System.out.println(extension);//输出txt
        //判断文件名是否是指定的扩展名
        boolean flag = FilenameUtils.isExtension("E://gshgs//gsagha//ga//fa.txt", "txt");
        System.out.println(flag);
    }

    @Test
    public void test2() {
        //获取文件名
        String name = FilenameUtils.getName("E://gshgs//gsagha//ga//fa.txt");
        System.out.println(name); //输出fa.txt
    }

    @Test
    public void test3() {
        //将路径分隔符替换成当前系统所使用的路径分隔符
        String s = FilenameUtils.separatorsToSystem("E://gshgs//gsagha//ga//fa.txt");
        System.out.println(s);
    }

    @Test
    public void test4() {
        //进行文件路径的拼接操作
        System.out.println(FilenameUtils.concat("E://abc//", "abc.png"));
    }

}
