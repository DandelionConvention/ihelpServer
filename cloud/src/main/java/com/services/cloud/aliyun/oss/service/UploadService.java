package com.services.cloud.aliyun.oss.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.services.cloud.aliyun.oss.config.OssConfig;
import com.services.core.bo.aliyun.oss.PutBytesRequestBO;
import com.services.core.bo.aliyun.oss.PutUrlRequestBO;
import com.services.core.exception.ErrorException;
import com.services.core.vo.ResponseVO;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class UploadService
{
    private final OssConfig ossConfig;

    public UploadService(OssConfig ossConfig)
    {
        this.ossConfig = ossConfig;
    }

    public ResponseVO putUrl(PutUrlRequestBO putUrlRequestBO)
    {
        // 上传网络流。
        InputStream inputStream;
        try
        {
            inputStream = new URL(putUrlRequestBO.getUrl()).openStream();
        } catch (IOException e)
        {
            throw new ErrorException(e);
        }
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(),
                ossConfig.getAccessKeySecret());
        ossClient.putObject(ossConfig.getBucketName(), putUrlRequestBO.getObjectName(), inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
        return new ResponseVO();
    }

    public ResponseVO putBytes(PutBytesRequestBO putBytesRequestBO)
    {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(),
                ossConfig.getAccessKeySecret());

        // 创建PutObjectRequest对象。
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossConfig.getBucketName(),
                putBytesRequestBO.getObjectName(), new ByteArrayInputStream(putBytesRequestBO.getBytes()));

        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
        return new ResponseVO();
    }
}
