package lhb.zdd.dao;

import lhb.zdd.model.ZddArea;

public interface ZddAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZddArea record);

    int insertSelective(ZddArea record);

    ZddArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZddArea record);

    int updateByPrimaryKey(ZddArea record);
}