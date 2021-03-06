package com.xsw.neo.service.easyexcel;

import lombok.Data;

/**
 * 导入
 *
 * @author xueshengwen
 * @since 2020/12/30 10:37
 */
@Data
public class ImportData {
    /**
     * 姓名
     */
    private String name;

    /**
     * 工资
     */
    private Double wage;
}
