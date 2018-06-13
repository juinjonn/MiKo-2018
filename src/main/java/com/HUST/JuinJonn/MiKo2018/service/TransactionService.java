package com.HUST.JuinJonn.MiKo2018.service;

import com.HUST.JuinJonn.MiKo2018.constant.PetConstant;
import com.HUST.JuinJonn.MiKo2018.dao.MikoDogDao;
import com.HUST.JuinJonn.MiKo2018.dao.MikoTransactionRecordDao;
import com.HUST.JuinJonn.MiKo2018.dao.MikoTransactionUXTODao;
import com.HUST.JuinJonn.MiKo2018.dao.MikoUserDao;
import com.HUST.JuinJonn.MiKo2018.dto.SaleDogsDto;
import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import com.HUST.JuinJonn.MiKo2018.model.MikoTransactionRecord;
import com.HUST.JuinJonn.MiKo2018.model.MikoTransactionUXTO;
import com.HUST.JuinJonn.MiKo2018.model.MikoUser;
import com.HUST.JuinJonn.MiKo2018.util.StringUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    MikoDogDao mikoDogDao;
    @Autowired
    MikoUserDao mikoUserDao;
    @Autowired
    MikoTransactionUXTODao mikoTransactionUXTODao;
    @Autowired
    MikoTransactionRecordDao mikoTransactionRecordDao;

    private List<MikoTransactionUXTO> list = Lists.newArrayList();
    @Transactional
    public String transacteDogs(String buyerAccount, String transactionDogNum){
        MikoUser buyerUser = mikoUserDao.selectMikoUserByAccount(buyerAccount);
        MikoDog transactionDog = mikoDogDao.selectDogByDogNum(transactionDogNum);
        MikoUser sellerUser = mikoUserDao.selectMikoUserByCipher(transactionDog.getCiphertext());
        if (buyerUser.equals(sellerUser)){
            return "自己不能购买自己的狗狗";
        }
        if (!transactionDog.getIsSale()){
            return "购买失败";
        }
        if (buyerUser.getUserBalance() < transactionDog.getPetPrice()){
            return "您的金钱不够";
        }
        buyerUser.setUserBalance(buyerUser.getUserBalance()-transactionDog.getPetPrice());
        mikoUserDao.updateUserBalance(buyerUser.getUserBalance(),buyerUser.getCipherText());
        sellerUser.setUserBalance(sellerUser.getUserBalance()+transactionDog.getPetPrice());
        mikoUserDao.updateUserBalance(sellerUser.getUserBalance(),sellerUser.getCipherText());
        transactionDog.setCiphertext(buyerUser.getCipherText());
        mikoDogDao.updateUserCipherText(transactionDog.getCiphertext(),transactionDog.getDogNumber());
        transactionDog.setIsSale(PetConstant.NOTSALE);
        transactionDog.setIsFlag(PetConstant.ONFLAG);
        mikoDogDao.updateDogIsSale(transactionDog.getIsSale(),transactionDog.getDogNumber());
        mikoDogDao.updateDogIsFlag(transactionDog.getIsFlag(),transactionDog.getDogNumber());
        insertUXTO(buyerUser,sellerUser,transactionDog);
        return "购买成功";
    }


    public void insertUXTO(MikoUser buyer,MikoUser seller,MikoDog mikoDog){
        MikoTransactionUXTO mikoTransactionUXTO = new MikoTransactionUXTO();
        mikoTransactionUXTO.setBuyerBalance(buyer.getUserBalance());
        mikoTransactionUXTO.setSellerBalance(seller.getUserBalance());
        mikoTransactionUXTO.setTransactionDogsNum(mikoDog.getDogNumber());
        mikoTransactionUXTO.setTransactionInput(buyer.getPublicText());
        mikoTransactionUXTO.setTransactionOutput(seller.getPublicText());
        Integer id = mikoTransactionUXTODao.selectTransactionId();
       if (id != null){
           id ++;
       }else {
           id = 0;
       }
        mikoTransactionUXTO.setTransactionId(id);
        mikoTransactionUXTODao.insertUXTO(mikoTransactionUXTO);
        insertRecord(mikoTransactionUXTO);
    }

    public void insertRecord(MikoTransactionUXTO mikoTransactionUXTO){
        MikoTransactionRecord mikoTransactionRecord = new MikoTransactionRecord();
        StringBuilder sb = new StringBuilder();
        StringBuilder orders = new StringBuilder();
        if (list.size() != 0 && list.size() % 6 == 0){
            for (MikoTransactionUXTO item : list){
                sb.append(item.toString());
                orders.append(item.getTransactionId().toString());
                orders.append(";");
                mikoDogDao.updateDogIsFlag(PetConstant.NOTFLAG,item.getTransactionDogsNum());
            }
            Integer areaNum = mikoTransactionRecordDao.selectAreaNumLast();
            mikoTransactionRecord.setPreRecordHashCode(mikoTransactionRecordDao.selectPreRecordHash());
            mikoTransactionRecord.setRecordHashCode(new Integer(sb.hashCode()).toString());
            mikoTransactionRecord.setTransactionOrders(orders.toString());
            mikoTransactionRecord.setAreaNum(areaNum+1);
            mikoTransactionRecordDao.insertTransactionRecord(mikoTransactionRecord);
            list.clear();
        }
        list.add(mikoTransactionUXTO);
    }

   public Boolean saleDog(SaleDogsDto saleDogsDto){
        mikoDogDao.updateDogPrice(new Integer(StringUtil.splitPrice(saleDogsDto.getPetPrice())),saleDogsDto.getDogNumber());
        MikoDog mikoDog = mikoDogDao.selectDogByDogNum(saleDogsDto.getDogNumber());
        if (mikoDog.getIsFlag()){
            return false;
        }
        mikoDogDao.updateDogIsSale(PetConstant.SAlEING,saleDogsDto.getDogNumber());
        return true;
    }
}
