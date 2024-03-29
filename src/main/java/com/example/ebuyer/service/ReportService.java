package com.example.ebuyer.service;

import com.example.ebuyer.data.SearchItemResult;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Service
public class ReportService {
    @Autowired
    private BrowseService browseService;

    public byte[] createExcelReport() {
        List<SearchItemResult> resultList = browseService.findSuitable();

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            // Creating a blank Excel sheet
            XSSFSheet sheet = workbook.createSheet(toUTF8("Оголошення"));

            // Creating fonts and styles
            Font fontHeader = createFont(workbook, 14, true);
            CellStyle headerStyle = createCellStyle(workbook, fontHeader, false);

            Font font = createFont(workbook, 12, false);
            CellStyle commonStyle = createCellStyle(workbook, font, true);

            Font valueFont = createFont(workbook, 12, true);
            CellStyle valueStyle = createCellStyle(workbook, valueFont, true);

            Font linkFont = createLinkFont(workbook, 12);
            CellStyle linkCellStyle = createCellStyle(workbook, linkFont, false);

            // main loop
            for (int itemNum = 0; itemNum < resultList.size(); itemNum++) {
                int startRowNumber = itemNum * 6;
                SearchItemResult item = resultList.get(itemNum);

                createFirstRow(sheet, startRowNumber, headerStyle, itemNum, item);
                createSecondRow(sheet, startRowNumber, linkCellStyle, workbook, item);
                createThirdRow(sheet, startRowNumber, commonStyle, valueStyle, item);
                createFourthRow(sheet, startRowNumber, commonStyle, item);
                createFifthRow(sheet, startRowNumber, commonStyle, item);
            }

            alignColumns(sheet);

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                workbook.write(baos);
                return baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFirstRow(XSSFSheet sheet, int startRowNumber, CellStyle headerStyle, int itemNum, SearchItemResult item) {
        // ================== First row ==================
        XSSFRow firstRow = sheet.createRow(startRowNumber);
        // announcement number
        XSSFCell cellItemNumber = firstRow.createCell(0);
        cellItemNumber.setCellStyle(headerStyle);
        cellItemNumber.setCellValue((itemNum + 1) + ".");
        // title
        XSSFCell cellTitle = firstRow.createCell(1);
        cellTitle.setCellStyle(headerStyle);
        cellTitle.setCellValue(item.getTitle());
    }

    private void createSecondRow(XSSFSheet sheet, int startRowNumber, CellStyle linkCellStyle, XSSFWorkbook workbook, SearchItemResult item) {
        // ================== Second row ==================
        XSSFRow secondRow = sheet.createRow(startRowNumber + 1);
        // link
        XSSFCell webUrlCell = secondRow.createCell(1);
        webUrlCell.setCellStyle(linkCellStyle);
        XSSFHyperlink link = workbook.getCreationHelper().createHyperlink(HyperlinkType.URL);
        link.setAddress(item.getItemWebUrl());
        webUrlCell.setCellValue(toUTF8("Посилання на eBay"));
        webUrlCell.setHyperlink(link);
    }

    private void createThirdRow(XSSFSheet sheet, int startRowNumber, CellStyle commonStyle, CellStyle valueStyle, SearchItemResult item) {
        // ================== Third row ==================
        XSSFRow thirdRow = sheet.createRow(startRowNumber + 2);
        thirdRow.setRowStyle(commonStyle);
        // price title
        XSSFCell priceTileCell= thirdRow.createCell(1);
        priceTileCell.setCellValue(toUTF8("Ціна"));
        // price
        XSSFCell priceCell= thirdRow.createCell(2);
        priceCell.setCellStyle(valueStyle);
        priceCell.setCellValue(item.getPrice());
        // qty title
        XSSFCell qtyTileCell= thirdRow.createCell(3);
        qtyTileCell.setCellValue(toUTF8("К-ть"));
        // qty
        XSSFCell qtyCell = thirdRow.createCell(4);
        qtyCell.setCellStyle(valueStyle);
        qtyCell.setCellValue(item.getQty());
        // price per unit title
        XSSFCell unitPriceTileCell = thirdRow.createCell(5);
        unitPriceTileCell.setCellValue(toUTF8("Ціна за шт.:"));
        // price per unit
        XSSFCell unitPriceCell = thirdRow.createCell(6);
        unitPriceCell.setCellStyle(valueStyle);
        unitPriceCell.setCellValue(item.getUnitPrice());
    }

    private void createFourthRow(XSSFSheet sheet, int startRowNumber, CellStyle commonStyle, SearchItemResult item) {
        // ================== Fourth row ==================
        XSSFRow fourthRow = sheet.createRow(startRowNumber + 3);
        fourthRow.setRowStyle(commonStyle);
        // seller title
        XSSFCell sellerTitleCell = fourthRow.createCell(1);
        sellerTitleCell.setCellValue(toUTF8("Продавець:"));
        // seller
        XSSFCell sellerCell = fourthRow.createCell(2);
        sellerCell.setCellValue(item.getSeller());
        // seller rate title
        XSSFCell sellerRateTitleCell = fourthRow.createCell(3);
        sellerRateTitleCell.setCellValue(toUTF8("Рейтинг:"));
        // seller rate
        XSSFCell sellerRateCell = fourthRow.createCell(4);
        sellerRateCell.setCellValue(item.getSellerFeedback());
    }

    private void createFifthRow(XSSFSheet sheet, int startRowNumber, CellStyle commonStyle, SearchItemResult item) {
        // ================== Fifth row ==================
        XSSFRow fifthRow = sheet.createRow(startRowNumber + 4);
        fifthRow.setRowStyle(commonStyle);
        // shipment cost title
        XSSFCell shipmentTitleCell = fifthRow.createCell(1);
        shipmentTitleCell.setCellValue(toUTF8("Доставка:"));
        // shipment cost
        XSSFCell shipmentCell = fifthRow.createCell(2);
        shipmentCell.setCellValue(item.getShippingCost());
    }

    private void alignColumns(XSSFSheet sheet) {
        sheet.autoSizeColumn(0);
        sheet.setColumnWidth(1, 256*12);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(6);
    }

    private Font createFont(XSSFWorkbook workbook, int size, boolean bold) {
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) size);
        font.setFontName("Arial");
        font.setBold(bold);

        return font;
    }

    private Font createLinkFont(XSSFWorkbook workbook, int size) {
        Font font = createFont(workbook, size, false);
        font.setColor(IndexedColors.BLUE.getIndex());
        font.setUnderline(Font.U_SINGLE);

        return font;
    }

    private CellStyle createCellStyle(XSSFWorkbook workbook, Font font, boolean wrapText) {
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(wrapText);
        style.setFont(font);

        return style;
    }

    private String toUTF8(String str) {
        return new String(str.getBytes(), StandardCharsets.UTF_8);
    }
}
