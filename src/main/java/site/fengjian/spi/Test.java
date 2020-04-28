package site.fengjian.spi;

import java.util.ServiceLoader;

/**
 * https://www.cnblogs.com/jy107600/p/11464985.html
 */
public class Test {
    public static void main(String[] args) {

        ServiceLoader<UploadCDN> uploadCDN = ServiceLoader.load(UploadCDN.class);
        uploadCDN.forEach(e-> e.upload("filePath"));
    }
}
