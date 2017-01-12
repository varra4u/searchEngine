package com.search.spring.web.dao;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author RAJASEKHAR <h2>Excel Parser for the ASSIA Bean Object</h2>
 *
 *         <ol>
 *         Make sure to remove the first title line else it will get added to
 *         the List as an Object</ol>
 */
public class ASSIAExcelParcer {

	@SuppressWarnings({ "deprecation"})
	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}

	public List<TitleListASSIA> readBooksFromExcelFile(String excelFilePath)
			throws IOException {
		List<TitleListASSIA> listBooks = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(
				excelFilePath));

		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			TitleListASSIA aBook = new TitleListASSIA();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					aBook.setSerialTitle((String) getCellValue(nextCell));
					break;
				case 1:
					aBook.setISSNPrint((String) getCellValue(nextCell));
					break;
				case 2:
					aBook.setISSNElectronic((String) getCellValue(nextCell));
					break;
				case 3:
					aBook.setPublisherName((String) getCellValue(nextCell));
					break;
				case 4:
					aBook.setCountryOfPublication((String) getCellValue(nextCell));
					break;
				case 5:
					aBook.setASSIA((String) getCellValue(nextCell));
					break;
				}

			}
			listBooks.add(aBook);
		}

		workbook.close();
		inputStream.close();

		return listBooks;
	}
}
