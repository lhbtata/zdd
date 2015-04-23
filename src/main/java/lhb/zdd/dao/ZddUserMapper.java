package lhb.zdd.dao;

import lhb.zdd.model.ZddUser;

public interface ZddUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZddUser record);

    int insertSelective(ZddUser record);

    ZddUser selectByPrimaryKey(Integer id);
    /**
     * 通过实体类查询
     * @param record
     * @return
     */
    ZddUser selectByEntity(ZddUser record);

    int updateByPrimaryKeySelective(ZddUser record);

    int updateByPrimaryKey(ZddUser record);
}