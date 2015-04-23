package lhb.zdd.service.impl;

import lhb.zdd.dao.ZddUserMapper;
import lhb.zdd.model.ZddUser;
import lhb.zdd.service.UserServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private ZddUserMapper zddUserMapper;
	
	@Override
	public ZddUser selectByPrimaryKey(Integer id) {
		return zddUserMapper.selectByPrimaryKey(id);
	}
	@Override
	public ZddUser selectWhenUserlogin(ZddUser user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean updateByPrimaryKeySelective(ZddUser record) {
		return zddUserMapper.updateByPrimaryKeySelective(record)>0;
	}
	@Override
	public Boolean userRegister(ZddUser user) {
		return zddUserMapper.insertSelective(user)>0;
	}
	@Override
	public Boolean selectByEntity(ZddUser record) {
		ZddUser user = zddUserMapper.selectByEntity(record);
		if(null==user)//用户不存在，返回true;
			return true;
		return false;
	}

}
