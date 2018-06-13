package com.HUST.JuinJonn.MiKo2018.Util;

import com.HUST.JuinJonn.MiKo2018.model.MikoTransactionUXTO;
import com.HUST.JuinJonn.MiKo2018.service.TransactionService;
import com.HUST.JuinJonn.MiKo2018.util.GetRandStringUtil;
import com.HUST.JuinJonn.MiKo2018.util.StringUtil;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class utils {

    @Test
    public void testUtils() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String charAt = GetRandStringUtil.getRandomString(10);
        System.out.println(charAt);
        System.out.println(GetRandStringUtil.EncoderByMd5(charAt));
    }

    @Test
    public void add() {
        List<Integer> list = Lists.newArrayList();
        for (Integer i = 0; i < 100; i++) {
            list.add(i);
        }
        Integer toal = 0;
        toal = list.stream().mapToInt(x -> x).sum();
        System.out.println(toal);
    }

    @Test
    public void testString() {
        String a = "dsadasdasdasd50000M币";
        System.out.println(StringUtil.splitPrice(a));
    }

}
