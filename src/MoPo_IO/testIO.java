package MoPo_IO;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class testIO {
    @Test
    public void t1(){
        File f1 = new File("");
        //获取当前文件的位置
        System.out.println(f1.getAbsolutePath());
        File f2 = new File("D:\\Github\\src\\MoPo_Data\\IO.txt");
        System.out.println(f2.exists());
    }
    @Test
    //打印文件夹所有文件名;
    public void t2(){
        File f3 = new File("D:\\Github\\src");
        List<File> files = List(f3);
        for (File file : files){
            System.out.println(file.getName());
        }
    }
    public static List<File> List(File file){
        List<File> filename = new ArrayList<>();
        if (file.isFile()){
            filename.add(file);
        }else {
            //下一级子文件,子文件夹;
            File[] children = file.listFiles();
            for (File f : children){
                List<File> sub = List(f);
                filename.addAll(sub);
            }
        }
        return filename;
    }
    @Test
    public void t3(){
        //通过class获取资源或IO流,以当前class编译类的路径作为相对位置;
        InputStream is1 = this.getClass().getResourceAsStream("../IO.txt");
        System.out.println(is1);
        //通过classLoader获取资源或IO流,以当前项目的根路径为相对位置;
        //项目中通过相对路径获取资源和IO流时,一般使用classLoader;
        InputStream is2 = this.getClass().getClassLoader().getResourceAsStream("IO.txt");
        System.out.println(is2);
    }
    @Test
    public void t4() throws IOException {
        //读取文件内容;
        //字节流;
        InputStream file = null;
        try {
            file = this.getClass().getClassLoader().getResourceAsStream("IO.txt");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = file.read(bytes)) != -1){
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } finally {
            if (file == null){
                file.close();
            }
        }
    }
    @Test
    //字符流;
    public void t5() throws IOException {
        FileReader reader = new FileReader("D:\\Github\\src\\MoPo_Data\\IO.txt");
        char[] chars = new char[1024];
        int len;
        while ((len = reader.read(chars)) != -1){
            String s = new String(chars,0,len);
            System.out.println(s);
        }
    }
    @Test
    public void t6() throws IOException {
        //字节流;
        FileInputStream  fis = new FileInputStream("D:\\Github\\src\\MoPo_Data\\IO.txt") ;
        //字符流;
        InputStreamReader isr = new InputStreamReader(fis);
        //缓冲流;
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}
