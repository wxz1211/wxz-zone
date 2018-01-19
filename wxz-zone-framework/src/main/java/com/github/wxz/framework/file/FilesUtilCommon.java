package com.github.wxz.framework.file;

import com.github.wxz.common.util.CloseUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * @author xianzhi.wang
 * @date 2018/1/18 -16:51
 */
@Component
public class FilesUtilCommon {
    private static Logger LOGGER = LoggerFactory.getLogger(FilesUtilCommon.class);

    @Value("${pic.path}")
    private String path;

    public String getPath(MultipartFile multipartFile, Integer uid) {
        String fileName = multipartFile.getOriginalFilename();
        String format = DateFormatUtils.format(new Date(), "YYYY_MM_ddHHmmssSSS");
        String filePath = format + "_" + uid + "_" + fileName;
        LOGGER.info("fileName {} ", fileName);
        uploadFilesUtil(filePath, multipartFile);
        return getImagePath(filePath);
    }

    private String getImagePath(String filePath) {
        return "http://www.wangxianzhi.xyz/static/" + filePath;
    }

    /**
     * 上传图片
     *
     * @param fileUrl
     * @param file
     */
    public void uploadFilesUtil(String fileUrl, MultipartFile file) {
        InputStream in = null;
        FileOutputStream out = null;
        String url = path + fileUrl;
        try {
            File file1 = new File(url);
            String template = "chmod 777 %s";
            String command = String.format(template, url);
            String[] cmd = new String[]{"/bin/sh", "-c", command};
            LOGGER.info("url {} command {} cmd {} ", url, command, cmd);
            try {
                // chmod 777 /data/pic/do/....
                Runtime.getRuntime().exec(cmd);
            } catch (Exception e) {
                LOGGER.info("Runtime.getRuntime().exec(cmd) error .....");
            }
            String fp = file1.getParent();
            File fParent = new File(fp);
            if (!fParent.isDirectory()) {
                fParent.mkdir();
            }
            in = file.getInputStream();
            out = new FileOutputStream(url);
            int n;
            byte[] b = new byte[1024];
            while ((n = in.read(b)) != -1) {
                out.write(b, 0, n);
            }
        } catch (Exception e) {
            LOGGER.error("upload pic error pic url {} ", url);
        } finally {
            CloseUtils.close(out);
            CloseUtils.close(in);
        }
    }
}
