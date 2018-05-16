package com.example.fastclientdemo.service.impl;


import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.stereotype.Service;
import com.example.fastclientdemo.service.FastClientService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FastClientSeriviceImpl implements FastClientService {

    private String conf_filename = "fdfs_client.conf";

    public String uploadFile(MultipartFile multipartFile){
        System.out.println("java.version=" + System.getProperty("java.version"));

        String fileId = null;
        try {
            ClientGlobal.init(conf_filename);
            System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
            System.out.println("charset=" + ClientGlobal.g_charset);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

//            NameValuePair[] metaList = new NameValuePair[1];
          //  metaList[0] = new NameValuePair("fileName", local_filename);


            String typename = getExtensionName(multipartFile.getOriginalFilename());
            fileId = client.upload_file1(multipartFile.getBytes(), typename, null);

            trackerServer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(fileId != null){
            return fileId;
        } else {
            return "";
        }
    }

    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    public void downloadFile(String  fildid){

    }

}
