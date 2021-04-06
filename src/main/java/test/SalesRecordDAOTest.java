package test;

import java.util.ArrayList;
import java.util.List;

import dao.SalesRecordDAO;
import model.SalesNumberMaker;
import model.SalesRecord;

public class SalesRecordDAOTest {
	public static void main(String[] args) {
		//findAllTest();
		//createTest();
		//deleteTest();
		//findTest();
	}

	public static void findAllTest() {
		List<SalesRecord> lists = new ArrayList<>();
		SalesRecordDAO srd = new SalesRecordDAO();
		lists = srd.findAll();
		for(SalesRecord sr : lists) {
			System.out.println(sr.getNumber());
			System.out.println(sr.getDate());
			System.out.println(sr.getCustomer());
			System.out.println(sr.getProductId());
			System.out.println(sr.getProductName());
			System.out.println(sr.getProductAmount());
			System.out.println(sr.getPrice());
		}

	}

	public static void findTest() {
		SalesRecordDAO salesRecordDAO = new SalesRecordDAO();
		SalesRecord sr = salesRecordDAO.find(4641744);
		System.out.println(sr.getNumber());
		System.out.println(sr.getDate());
		System.out.println(sr.getCustomer());
		System.out.println(sr.getProductId());
		System.out.println(sr.getProductName());
		System.out.println(sr.getProductAmount());
		System.out.println(sr.getPrice());
	}

	public static void createTest() {
		List<SalesRecord> lists = new ArrayList<>();
		lists.add(new SalesRecord(new SalesNumberMaker().makeNumber(),"public", "A104", "タブレット", 2, 100000));
		SalesRecordDAO srd = new SalesRecordDAO();
		boolean success = false;
		for(SalesRecord sr : lists) {
			success = srd.create(sr);
		}
		if (success) {
			System.out.println("追加成功");
		} else {
			System.out.println("追加失敗");
		}
	}

	public static void deleteTest() {
		List<Integer> numberList = new ArrayList<>();
		numberList.add(1234);
		numberList.add(2234);
		SalesRecord sr = null;
		boolean success = false;
		SalesRecordDAO srd = new SalesRecordDAO();
		for (Integer numbers : numberList) {
			sr = new SalesRecord(numbers.intValue());
			success = srd.delete(sr);
			if (success == false) {
				System.out.println("削除失敗");
				break;
			}
		}
		System.out.println("削除成功");
	}
}
