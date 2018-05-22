package com.HUST.JuinJonn.MiKo2018.dao;

import com.HUST.JuinJonn.MiKo2018.dto.SelectDogByLimit;
import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface MikoDogDao {
    /**
     * 插入一只狗
     * @param mikoDog
     */
    @Insert("insert into miko_dog " +
            "(dog_number,generations_num,pet_eyes,pet_mouth,pet_pattern,pet_wing,,cipher_text,is_sale,is_reproduction)" +
            "values" +
            "(#{dogNumber},#{generationsNum},#{petEyes},#{petMouth},#{petPattern},#{petWing},#{ciphertext},#{isSale},#{isReproduction})")
    void insertDog(MikoDog mikoDog);

    /**
     * 根据链表插入狗狗
     * @param listDog
     */
    @Insert("<script>" +
            "insert into miko_dog" +
            "(dog_number,generations_num,pet_eyes,pet_mouth,pet_pattern,pet_wing,,cipher_text,is_sale,is_reproduction)" +
            "values" +
            "<foreach collection ='listDog' item='MikoDog'  separator =','> " +
            "(#{dogNumber},#{generationsNum},#{petEyes},#{petMouth},#{petPattern},#{petWing},#{ciphertext},#{isSale},#{isReproduction})" +
            "</foreach > "+
            "<script>")
    void insertListDogs(List<MikoDog> listDog);

    /**
     * 通过用户的密文,查出该用户所拥有的所有狗狗
     * @param userCipherText
     * @return
     */
    @Select("select * from miko_dog where ciphertext = #{userCipherText}")
    List<MikoDog> selectDogByUser(String userCipherText);

    /**
     * 根据代数查询狗狗列表
     * @param generationNum
     * @return
     */
    @Select("select * from miko_dog where generations_num = #{generationNum}")
    List<MikoDog> selectDogByGenerationsNum(Integer generationNum);

    /**
     * 根据是否已繁殖来查询狗狗列表
     * @param isReproduction
     * @return
     */
    @Select("select * from miko_dog where is_reproduction = #{isReproduction}")
    List<MikoDog> selectDogByIsReproduction(boolean isReproduction);

    /**
     * 根据是否被卖来查询狗狗列表
     * @param isSale
     * @return
     */
    @Select("select * from miko_dog where is_sale = #{isSale}")
    List<MikoDog> selectDogByIsSale(boolean isSale);

    /**
     * 根据条件查出当前符合的狗狗列表
     * @return
     */
    @Select("select * from miko_dog where pet_eyes = #{limit.petEyes} and pet_mouth = #{limit.petMouth} and pet_pattern = #{limit.petPattern} and pet_wing = #{limit.petWing}")
    List<MikoDog> selectDogByLimit(@Param("limit") SelectDogByLimit limit);
}
