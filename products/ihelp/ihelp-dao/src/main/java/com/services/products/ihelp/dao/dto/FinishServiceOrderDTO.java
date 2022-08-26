package com.services.products.ihelp.dao.dto;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class FinishServiceOrderDTO
{
    /**
     * tip : 100
     */

    @DecimalMin(value = "0",message = "小费的值必须是一个大于等于0的数")
    private BigDecimal tip;

    public BigDecimal getTip()
    {
        return tip;
    }

    public void setTip(BigDecimal tip)
    {
        this.tip = tip;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("FinishServiceOrderDTO{");
        sb.append("tip=").append(tip);
        sb.append('}');
        return sb.toString();
    }
}
