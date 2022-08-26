package com.services.core.bo.tencent.cloud;

import com.alibaba.fastjson.annotation.JSONField;

public class CompareFaceRequestBO
{
    /**
     * A 图片 base64 数据，base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    @JSONField(name = "ImageA")
    private String imageA;

    /**
     * B 图片 base64 数据，base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    @JSONField(name = "ImageB")
    private String imageB;

    /**
     * A 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     A 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
     图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
     非腾讯云存储的Url速度和稳定性可能受一定影响。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    @JSONField(name = "UrlA")
    private String urlA;

    /**
     * B 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     B 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
     图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
     非腾讯云存储的Url速度和稳定性可能受一定影响。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    @JSONField(name = "UrlB")
    private String urlB;

    /**
     * 人脸识别服务所用的算法模型版本。目前入参支持 “2.0”和“3.0“ 两个输入。
     2020年4月2日开始，默认为“3.0”，之前使用过本接口的账号若未填写本参数默认为“2.0”。
     不同算法模型版本对应的人脸识别算法不同，新版本的整体效果会优于旧版本，建议使用“3.0”版本。
     */
    @JSONField(name = "FaceModelVersion")
    private String faceModelVersion;

    /**
     * 图片质量控制。
     0: 不进行控制；
     1:较低的质量要求，图像存在非常模糊，眼睛鼻子嘴巴遮挡至少其中一种或多种的情况；
     2: 一般的质量要求，图像存在偏亮，偏暗，模糊或一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，至少其中三种的情况；
     3: 较高的质量要求，图像存在偏亮，偏暗，一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，其中一到两种的情况；
     4: 很高的质量要求，各个维度均为最好或最多在某一维度上存在轻微问题；
     默认 0。
     若图片质量不满足要求，则返回结果中会提示图片质量检测不符要求。
     */
    @JSONField(name = "QualityControl")
    private Long qualityControl;

    /**
     * 是否开启图片旋转识别支持。0为不开启，1为开启。默认为0。本参数的作用为，当图片中的人脸被旋转且图片没有exif信息时，如果不开启图片旋转识别支持则无法正确检测、识别图片中的人脸。若您确认图片包含exif信息或者您确认输入图中人脸不会出现被旋转情况，请不要开启本参数。开启后，整体耗时将可能增加数百毫秒。
     */
    @JSONField(name = "NeedRotateDetection")
    private Long needRotateDetection;

    /**
     * Get A 图片 base64 数据，base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     * @return imageA A 图片 base64 数据，base64 编码后大小不可超过5M。
    jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
    若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
    支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    public String getImageA() {
        return this.imageA;
    }

    /**
     * Set A 图片 base64 数据，base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     * @param imageA A 图片 base64 数据，base64 编码后大小不可超过5M。
    jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
    若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
    支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    public void setImageA(String imageA) {
        this.imageA = imageA;
    }

    /**
     * Get B 图片 base64 数据，base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     * @return imageB B 图片 base64 数据，base64 编码后大小不可超过5M。
    jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
    若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
    支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    public String getImageB() {
        return this.imageB;
    }

    /**
     * Set B 图片 base64 数据，base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     * @param imageB B 图片 base64 数据，base64 编码后大小不可超过5M。
    jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
    若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
    支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    public void setImageB(String imageB) {
        this.imageB = imageB;
    }

    /**
     * Get A 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     A 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
     图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
     非腾讯云存储的Url速度和稳定性可能受一定影响。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     * @return urlA A 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
    jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
    A 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
    图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
    非腾讯云存储的Url速度和稳定性可能受一定影响。
    若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
    支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    public String getUrlA() {
        return this.urlA;
    }

    /**
     * Set A 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     A 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
     图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
     非腾讯云存储的Url速度和稳定性可能受一定影响。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     * @param urlA A 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
    jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
    A 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
    图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
    非腾讯云存储的Url速度和稳定性可能受一定影响。
    若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
    支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    public void setUrlA(String urlA) {
        this.urlA = urlA;
    }

    /**
     * Get B 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     B 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
     图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
     非腾讯云存储的Url速度和稳定性可能受一定影响。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     * @return urlB B 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
    jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
    B 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
    图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
    非腾讯云存储的Url速度和稳定性可能受一定影响。
    若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
    支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    public String getUrlB() {
        return this.urlB;
    }

    /**
     * Set B 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
     jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
     B 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
     图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
     非腾讯云存储的Url速度和稳定性可能受一定影响。
     若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
     支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     * @param urlB B 图片的 Url ，对应图片 base64 编码后大小不可超过5M。
    jpg格式长边像素不可超过4000，其他格式图片长边像素不可超2000。
    B 图片的 Url、Image必须提供一个，如果都提供，只使用 Url。
    图片存储于腾讯云的Url可保障更高下载速度和稳定性，建议图片存储于腾讯云。
    非腾讯云存储的Url速度和稳定性可能受一定影响。
    若图片中包含多张人脸，只选取其中人脸面积最大的人脸。
    支持PNG、JPG、JPEG、BMP，不支持 GIF 图片。
     */
    public void setUrlB(String urlB) {
        this.urlB = urlB;
    }

    /**
     * Get 人脸识别服务所用的算法模型版本。目前入参支持 “2.0”和“3.0“ 两个输入。
     2020年4月2日开始，默认为“3.0”，之前使用过本接口的账号若未填写本参数默认为“2.0”。
     不同算法模型版本对应的人脸识别算法不同，新版本的整体效果会优于旧版本，建议使用“3.0”版本。
     * @return faceModelVersion 人脸识别服务所用的算法模型版本。目前入参支持 “2.0”和“3.0“ 两个输入。
    2020年4月2日开始，默认为“3.0”，之前使用过本接口的账号若未填写本参数默认为“2.0”。
    不同算法模型版本对应的人脸识别算法不同，新版本的整体效果会优于旧版本，建议使用“3.0”版本。
     */
    public String getFaceModelVersion() {
        return this.faceModelVersion;
    }

    /**
     * Set 人脸识别服务所用的算法模型版本。目前入参支持 “2.0”和“3.0“ 两个输入。
     2020年4月2日开始，默认为“3.0”，之前使用过本接口的账号若未填写本参数默认为“2.0”。
     不同算法模型版本对应的人脸识别算法不同，新版本的整体效果会优于旧版本，建议使用“3.0”版本。
     * @param faceModelVersion 人脸识别服务所用的算法模型版本。目前入参支持 “2.0”和“3.0“ 两个输入。
    2020年4月2日开始，默认为“3.0”，之前使用过本接口的账号若未填写本参数默认为“2.0”。
    不同算法模型版本对应的人脸识别算法不同，新版本的整体效果会优于旧版本，建议使用“3.0”版本。
     */
    public void setFaceModelVersion(String faceModelVersion) {
        this.faceModelVersion = faceModelVersion;
    }

    /**
     * Get 图片质量控制。
     0: 不进行控制；
     1:较低的质量要求，图像存在非常模糊，眼睛鼻子嘴巴遮挡至少其中一种或多种的情况；
     2: 一般的质量要求，图像存在偏亮，偏暗，模糊或一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，至少其中三种的情况；
     3: 较高的质量要求，图像存在偏亮，偏暗，一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，其中一到两种的情况；
     4: 很高的质量要求，各个维度均为最好或最多在某一维度上存在轻微问题；
     默认 0。
     若图片质量不满足要求，则返回结果中会提示图片质量检测不符要求。
     * @return qualityControl 图片质量控制。
    0: 不进行控制；
    1:较低的质量要求，图像存在非常模糊，眼睛鼻子嘴巴遮挡至少其中一种或多种的情况；
    2: 一般的质量要求，图像存在偏亮，偏暗，模糊或一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，至少其中三种的情况；
    3: 较高的质量要求，图像存在偏亮，偏暗，一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，其中一到两种的情况；
    4: 很高的质量要求，各个维度均为最好或最多在某一维度上存在轻微问题；
    默认 0。
    若图片质量不满足要求，则返回结果中会提示图片质量检测不符要求。
     */
    public Long getQualityControl() {
        return this.qualityControl;
    }

    /**
     * Set 图片质量控制。
     0: 不进行控制；
     1:较低的质量要求，图像存在非常模糊，眼睛鼻子嘴巴遮挡至少其中一种或多种的情况；
     2: 一般的质量要求，图像存在偏亮，偏暗，模糊或一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，至少其中三种的情况；
     3: 较高的质量要求，图像存在偏亮，偏暗，一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，其中一到两种的情况；
     4: 很高的质量要求，各个维度均为最好或最多在某一维度上存在轻微问题；
     默认 0。
     若图片质量不满足要求，则返回结果中会提示图片质量检测不符要求。
     * @param qualityControl 图片质量控制。
    0: 不进行控制；
    1:较低的质量要求，图像存在非常模糊，眼睛鼻子嘴巴遮挡至少其中一种或多种的情况；
    2: 一般的质量要求，图像存在偏亮，偏暗，模糊或一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，至少其中三种的情况；
    3: 较高的质量要求，图像存在偏亮，偏暗，一般模糊，眉毛遮挡，脸颊遮挡，下巴遮挡，其中一到两种的情况；
    4: 很高的质量要求，各个维度均为最好或最多在某一维度上存在轻微问题；
    默认 0。
    若图片质量不满足要求，则返回结果中会提示图片质量检测不符要求。
     */
    public void setQualityControl(Long qualityControl) {
        this.qualityControl = qualityControl;
    }

    /**
     * Get 是否开启图片旋转识别支持。0为不开启，1为开启。默认为0。本参数的作用为，当图片中的人脸被旋转且图片没有exif信息时，如果不开启图片旋转识别支持则无法正确检测、识别图片中的人脸。若您确认图片包含exif信息或者您确认输入图中人脸不会出现被旋转情况，请不要开启本参数。开启后，整体耗时将可能增加数百毫秒。
     * @return needRotateDetection 是否开启图片旋转识别支持。0为不开启，1为开启。默认为0。本参数的作用为，当图片中的人脸被旋转且图片没有exif信息时，如果不开启图片旋转识别支持则无法正确检测、识别图片中的人脸。若您确认图片包含exif信息或者您确认输入图中人脸不会出现被旋转情况，请不要开启本参数。开启后，整体耗时将可能增加数百毫秒。
     */
    public Long getNeedRotateDetection() {
        return this.needRotateDetection;
    }

    /**
     * Set 是否开启图片旋转识别支持。0为不开启，1为开启。默认为0。本参数的作用为，当图片中的人脸被旋转且图片没有exif信息时，如果不开启图片旋转识别支持则无法正确检测、识别图片中的人脸。若您确认图片包含exif信息或者您确认输入图中人脸不会出现被旋转情况，请不要开启本参数。开启后，整体耗时将可能增加数百毫秒。
     * @param needRotateDetection 是否开启图片旋转识别支持。0为不开启，1为开启。默认为0。本参数的作用为，当图片中的人脸被旋转且图片没有exif信息时，如果不开启图片旋转识别支持则无法正确检测、识别图片中的人脸。若您确认图片包含exif信息或者您确认输入图中人脸不会出现被旋转情况，请不要开启本参数。开启后，整体耗时将可能增加数百毫秒。
     */
    public void setNeedRotateDetection(Long needRotateDetection) {
        this.needRotateDetection = needRotateDetection;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("CompareFaceRequestBO{");
        sb.append("imageA='").append(imageA).append('\'');
        sb.append(", imageB='").append(imageB).append('\'');
        sb.append(", urlA='").append(urlA).append('\'');
        sb.append(", urlB='").append(urlB).append('\'');
        sb.append(", faceModelVersion='").append(faceModelVersion).append('\'');
        sb.append(", qualityControl=").append(qualityControl);
        sb.append(", needRotateDetection=").append(needRotateDetection);
        sb.append('}');
        return sb.toString();
    }
}
