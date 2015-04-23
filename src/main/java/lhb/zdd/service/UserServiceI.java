package lhb.zdd.service;

import lhb.zdd.model.ZddUser;

public interface UserServiceI {

	public ZddUser selectByPrimaryKey(Integer id);
	public ZddUser selectWhenUserlogin(ZddUser user);
	public Boolean updateByPrimaryKeySelective(ZddUser record);
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public Boolean userRegister(ZddUser user);
	/**
	 * 通过实体类查询
	 * @param record
	 * @return
	 */
	public Boolean selectByEntity(ZddUser record);
}
