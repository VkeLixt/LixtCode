
package com.entor.recruit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entor.recruit.dao.PhotoMapper;
import com.entor.recruit.domain.Photo;
import com.entor.recruit.service.PhotoService;




/**
 * �û���Ƭҵ���߼���
 * 
 * @author entor11
 *
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("photoService")
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoMapper photoMapper;

	@Transactional(readOnly = true)
	@Override
	public Boolean isExistPhoto(Integer userId) {
		System.out.println(userId+"\n\n\n\n\n\n\n\n\n\n\n");
		
		boolean boo = photoMapper.selectByUserId(userId) != null;
		System.out.println("\n\n\n\n\n\n\n\n\n"+boo);
		return boo;
	}

	@Transactional(readOnly = true)
	@Override
	public Photo findPhotoByUserId(Integer userId) {
		return photoMapper.selectByUserId(userId);
	}

	@Override
	public void savePhotoByUserId(Integer userId, String path) {
		Photo photo = new Photo();
		photo.setDescription("�û�" + userId + "����Ƭ");
		photo.setPath(path);
		photo.setUserId(userId);
		photo.setRemark("����");
		photoMapper.save(photo);
	}

	@Override
	public void uploadPhotoByUserId(Integer userId, String path) {
		Photo photo = new Photo();
		photo.setUserId(userId);
		photo.setPath(path);
		photo.setRemark("����");
		photoMapper.update(photo);
	}

}