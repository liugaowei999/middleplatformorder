package com.ly.traffic.middleplatform.service.assembler;

import com.ly.traffic.middleplatform.domain.paycallback.entity.PayWriteBackLog;
import com.ly.traffic.middleplatform.interfaces.dto.PaidInfoDto;
import org.springframework.beans.BeanUtils;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.service.assembler
 * @Description: ${TODO}
 * @date 2020/8/26 15:00
 */
public class PayBackAssembler {
    public static PayWriteBackLog dtoToDo(PaidInfoDto paidInfoDto) {
        PayWriteBackLog payWriteBackLog = new PayWriteBackLog();
        BeanUtils.copyProperties(paidInfoDto, payWriteBackLog);
        return payWriteBackLog;
    }
}
