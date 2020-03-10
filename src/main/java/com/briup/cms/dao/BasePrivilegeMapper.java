package com.briup.cms.dao;

import com.briup.cms.bean.BasePrivilege;
import com.briup.cms.bean.BasePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasePrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    long countByExample(BasePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int deleteByExample(BasePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int insert(BasePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int insertSelective(BasePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    List<BasePrivilege> selectByExample(BasePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    BasePrivilege selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByExampleSelective(@Param("record") BasePrivilege record, @Param("example") BasePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByExample(@Param("record") BasePrivilege record, @Param("example") BasePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByPrimaryKeySelective(BasePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Sun Mar 08 19:28:12 CST 2020
     */
    int updateByPrimaryKey(BasePrivilege record);
}