package com.HUST.JuinJonn.MiKo2018.util;

import com.HUST.JuinJonn.MiKo2018.constant.PetConstant;
import com.HUST.JuinJonn.MiKo2018.dto.SelectDogsDto;
import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SelectToDtoUtil {

    public static List<SelectDogsDto> selectDogsToDto(List<MikoDog> mikoDogs,String type){
        List<SelectDogsDto> list = mikoDogs.stream().map(x->new SelectDogsDto(x, PetConstant.SELECT_MY_DOG_CONROLLER)).collect(Collectors.toList());
        return list;
    }

    public static List<SelectDogsDto> selectDogsToDto(List<MikoDog> mikoDogs){
        List<SelectDogsDto> list = mikoDogs.stream().map(x->new SelectDogsDto(x)).collect(Collectors.toList());
        return list;
    }
}
