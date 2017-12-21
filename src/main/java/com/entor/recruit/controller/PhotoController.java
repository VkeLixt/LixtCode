package com.entor.recruit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entor.recruit.domain.Photo;
import com.entor.recruit.service.PhotoService;

@Controller
public class PhotoController {

	private static final String SAVEPATH = "D:\\jsd1707\\zhangzhitao\\photo";

	@Resource
	private PhotoService photoService;

	/**
	 * 根据用户id查询用户相片
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/photo/{userId}/isExist")
	public @ResponseBody Boolean isExist(@PathVariable Integer userId) {
		return photoService.isExistPhoto(userId);
	}

	/**
	 * 根据用户id获取相片
	 * 
	 * @param userId
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/photo/{userId}/get")
	public void getPhotoByUserId(@PathVariable Integer userId, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 1.获取相片相对路径
		Photo photo = photoService.findPhotoByUserId(userId);
		if (photo == null) {
			return;
		}
		// 2.获取相片保存路径
		String savePath = SAVEPATH + photo.getPath();
		// 3.读取相片并输出到响应流
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(savePath));
		BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
		byte[] bytes = new byte[1000];
		int length;
		while ((length = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, length);
		}
		outputStream.flush();
		outputStream.close();
		inputStream.close();
	}

	/**
	 * 根据用户id新增用户相片
	 * 
	 * @param userId
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "photo/{userId}/uploadSave", method = RequestMethod.POST)
	public @ResponseBody String uploadSave(@PathVariable Integer userId, MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			// 第一步：上传文件
			String path = "/"+ userId + ".jpg";
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(SAVEPATH + path));
			// 第二步：将文件部分路径保存到数据库
			photoService.savePhotoByUserId(userId, path);
			return "{\"status\":true,\"message\":\"上传成功！\"}";
		} else {
			return "{\"status\":false,\"message\":\"请选择正确的文件后，再上传！\"}";
		}
	}

	/**
	 * 根据用户id更新用户相片
	 * @param userId
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "photo/{userId}/uploadUpdate", method = RequestMethod.POST)
	public @ResponseBody String uploadUpdate(@PathVariable Integer userId, MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			// 第一步：上传文件
			String path = "/" + System.currentTimeMillis() + "_" + userId + ".jpg";
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(SAVEPATH + path));
			// 第二步：将文件部分路径更新到数据库
			photoService.uploadPhotoByUserId(userId, path);
			return "{\"status\":true,\"message\":\"上传成功！\"}";
		} else {
			return "{\"status\":false,\"message\":\"请选择正确的文件后，再上传！\"}";
		}
	}
}
