package model;

import java.util.List;

import dao.SalesRecordDAO;

public class SalesRecordLogic {
	//すべての販売記録データを得て、コレクションとして返す
	public List<SalesRecord> executeFindAll() {
		SalesRecordDAO salesRecordDAO = new SalesRecordDAO();
		return salesRecordDAO.findAll();
	}

	//一つの販売記録データを得て、単体の商品として返す
	public SalesRecord executeFind(int salesRecordNumber) {
		SalesRecordDAO salesRecordDAO = new SalesRecordDAO();
		SalesRecord sr = salesRecordDAO.find(salesRecordNumber);
		return sr;
	}

	//販売記録の追加および在庫数量の調整
	public String Insert(String productId, String amount, String customer) {
		//Stringをintにキャスト（販売数量）
		int minusAmount = Integer.parseInt(amount);

		//特定のデータを検索してから、在庫数量を更新（減らす、在庫数量-販売数量）
		StockCheckLogic scl = new StockCheckLogic();
		Stock stock = scl.executeFind(productId);
		scl.executeMinusStock(stock, minusAmount);

		//販売記録データのインスタンスを生成し、データベースに追加
		SalesRecord sr = new SalesRecord(customer, stock.getProductId(), stock.getProductName(), minusAmount, stock.getProductPrice());
		SalesRecordDAO srDao =new SalesRecordDAO();
		boolean success = srDao.create(sr);

		if(!success) {
			return "追加できませんでした。";
		}
		return "追加しました。";
	}

	//販売記録の削除および在庫数量の調整
	public String executeDelete(String[] numbers) {
		SalesRecordDAO salesRecordDAO = new SalesRecordDAO();
		SalesRecord salesRecord = null;
		boolean success = false;

		//複数がある場合、forループで一つずつ削除していく
		int[] recordNumber = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			//選んだチェックボックスバリューをintにキャスト
			recordNumber[i] = Integer.parseInt(numbers[i]);

			//販売記録のすべてのデータを得る
			salesRecord = executeFind(recordNumber[i]);
			//販売記録を削除
			success = salesRecordDAO.delete(salesRecord);

			//在庫確認ロジックのインスタンスを生成し、
			//商品データを検索し、生成したインスタンスのexecutePlusStock()メソッドで在庫数量を増やす
			StockCheckLogic scl = new StockCheckLogic();
			Stock stock = scl.executeFind(salesRecord.getProductId());
			scl.executePlusStock(stock, salesRecord.getProductAmount());

			if (!success) {
				return "削除に失敗しました。";
			}
		}
		return "削除に成功しました。";
	}
}
