package com.briup.cms.dao;

import com.briup.cms.bean.BaseRole;
import com.briup.cms.bean.BaseRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    long countByExample(BaseRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int deleteByExample(BaseRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int insert(BaseRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int insertSelective(BaseRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    List<BaseRole> selectByExample(BaseRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    BaseRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByExampleSelective(@Param("record") BaseRole record, @Param("example") BaseRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByExample(@Param("record") BaseRole record, @Param("example") BaseRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByPrimaryKeySelective(BaseRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByPrimaryKey(BaseRole record);
}