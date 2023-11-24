package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**通用接口
 * @author liweihua
 * @classname CommonController
 * @description TODO
 * @date 2023/11/22 15:29
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/uploadLocalFile")
    @ApiOperation("文件上传到本地磁盘")
    public Result<String> uploadLocalFile(MultipartFile file) throws IOException {
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        //构造新的文件名
        String newFileName = UUID.randomUUID().toString() + originalFilename.substring(index);
        //将文件存储在服务器的磁盘目录中
        file.transferTo(new File("D:\\"+newFileName));
        return null;
    }


    @PostMapping("/upload")
    @ApiOperation("文件上传到阿里云")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传:{}",file);
       try{
           //获取原始文件名
           String originalFilename = file.getOriginalFilename();
           int index = originalFilename.lastIndexOf(".");
           //构造新的文件名
           String newFileName = UUID.randomUUID().toString() + originalFilename.substring(index);
           aliOssUtil.upload(file.getBytes(),newFileName);
       }catch (Exception e){
           log.error("文件上传失败:{}",e);
       }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
