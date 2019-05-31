package com.xfqb.rollcall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xfqb.rollcall.entity.IpFilter;
@Mapper
public interface IpFilterMapper {
	int deleteByPrimaryKey(Long id);

	int insert(IpFilter record);

	int insertSelective(IpFilter record);

	IpFilter selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(IpFilter record);

	int updateByPrimaryKey(IpFilter record);
	
	List<IpFilter> select(IpFilter record);
}