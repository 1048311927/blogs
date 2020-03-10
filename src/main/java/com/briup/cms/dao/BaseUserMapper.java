package com.briup.cms.dao;

import com.briup.cms.bean.BaseUser;
import com.briup.cms.bean.BaseUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    long countByExample(BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int deleteByExample(BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int insert(BaseUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int insertSelective(BaseUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    List<BaseUser> selectByExample(BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    BaseUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByExampleSelective(@Param("record") BaseUser record, @Param("example") BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByExample(@Param("record") BaseUser record, @Param("example") BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByPrimaryKeySelective(BaseUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByPrimaryKey(BaseUser record);
}