/*
package com.longhu.utils;


import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

*/
/**
 * @author: houyong
 * @description:poi工具类
 * @create: 2019-05-17 10:50
 *//*

@NoArgsConstructor
public class PoiUtils {
    public static PoiUtils.ExcelData resovle(String[] fields, InputStream io) throws Exception {
        Workbook wb = WorkbookFactory.create(io);
        Sheet sheet = wb.getSheetAt(0);
        List<Map<String, Object>> retList = new ArrayList();
        Map<String, Object> titleMap = new LinkedHashMap();
        boolean isFirst = true;
        Iterator var7 = sheet.iterator();

        while (var7.hasNext()) {
            Row row = (Row) var7.next();
            if (Objects.isNull(row)) {
                break;
            }

            if (isFirst) {
                isFirst = false;

                for (int i = 0; i < fields.length; ++i) {
                    Cell cell = row.getCell(i);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String value = cell.getStringCellValue();
                    titleMap.put(fields[i], value);
                }
            } else {
                Map<String, Object> dataMap = new LinkedHashMap();

                for (int i = 0; i < fields.length; ++i) {
                    Cell cell = row.getCell(i);
                    String value = "";
                    if (Objects.nonNull(cell)) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        value = StringUtils.trimToEmpty(cell.getStringCellValue());
                    }

                    dataMap.put(fields[i], value);
                }

                String value = (String) dataMap.values().stream().map(Object::toString).reduce((o, n) -> {
                    return o + n;
                }).get();
                if (StringUtils.isBlank(value)) {
                    break;
                }

                retList.add(dataMap);
            }
        }

        PoiUtils.ExcelData excelData = new PoiUtils.ExcelData();
        excelData.setDataList(retList);
        excelData.setTitleMap(titleMap);
        return excelData;
    }

    public static ByteArrayOutputStream export(Map<String, Object> titleMap, List<Map<String, Object>> dataMapList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        Map<String, Integer> fieldIndex = new LinkedHashMap();
        AtomicInteger index = new AtomicInteger(0);
        titleMap.forEach((key, value) -> {
            fieldIndex.put(key, index.get());
            XSSFCell cell = row.createCell(index.getAndIncrement());
            XSSFRichTextString text = new XSSFRichTextString(value.toString());
            cell.setCellValue(text);
        });
        index.set(1);
        dataMapList.forEach((item) -> {
            XSSFRow dataRow = sheet.createRow(index.getAndIncrement());
            item.forEach((key, value) -> {
                Integer itemIndex = (Integer) fieldIndex.get(key);
                if (!Objects.isNull(itemIndex)) {
                    XSSFCell cell = dataRow.createCell(itemIndex);
                    if (value instanceof Date) {
                        cell.setCellValue((Date) value);
                    } else if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof Boolean) {
                        cell.setCellValue((Boolean) value);
                    } else if (value instanceof Number) {
                        cell.setCellValue((Double) value);
                    }

                }
            });
        });

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);
            return byteArrayOutputStream;
        } catch (IOException var8) {
            return null;
        }
    }

    public static class ExcelData {
        private Map<String, Object> titleMap;
        private List<Map<String, Object>> dataList;

        public ExcelData() {
        }

        public List<Map<String, Object>> getDataList() {
            return this.dataList;
        }

        public PoiUtils.ExcelData setDataList(List<Map<String, Object>> dataList) {
            this.dataList = dataList;
            return this;
        }

        public Map<String, Object> getTitleMap() {
            return this.titleMap;
        }

        public PoiUtils.ExcelData setTitleMap(Map<String, Object> titleMap) {
            this.titleMap = titleMap;
            return this;
        }
    }
}

*/
