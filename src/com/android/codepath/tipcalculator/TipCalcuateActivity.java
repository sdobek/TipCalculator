package com.android.codepath.tipcalculator;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalcuateActivity extends Activity {
	private final double TEN_PRCNT = .1;
	private final double FIFTEEN_PRCNT = .15;
	private final double TWENTY_PRCNT = .2;
	
	EditText etTipAmount;
	TextView tvDisplayTip;
	double tipValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calcuate);
		
		etTipAmount = (EditText) findViewById(R.id.tcAmountInput);
		tvDisplayTip = (TextView) findViewById(R.id.tvDisplayTip);
	}
	
	public void displayTipTenPrcnt(View v){
		String tipString = etTipAmount.getText().toString();
		tipValue = Double.parseDouble(tipString) * TEN_PRCNT;
		BigDecimal bmTipValue = new BigDecimal(tipValue).setScale(2, BigDecimal.ROUND_HALF_UP);
		tvDisplayTip.setText("Tip is:   $"+bmTipValue);
		
	}
	
	public void displayTipFifteenPrcnt(View v){
		String tipString = etTipAmount.getText().toString();
		tipValue = Double.parseDouble(tipString) * FIFTEEN_PRCNT;
		BigDecimal bmTipValue = new BigDecimal(tipValue).setScale(2, BigDecimal.ROUND_HALF_UP);
		tvDisplayTip.setText("Tip is:   $"+bmTipValue);
	}

	public void displayTipTwentyPrcnt(View v){
		String tipString = etTipAmount.getText().toString();
		tipValue = Double.parseDouble(tipString) * TWENTY_PRCNT;
		BigDecimal bmTipValue = new BigDecimal(tipValue).setScale(2, BigDecimal.ROUND_HALF_UP);
		tvDisplayTip.setText("Tip is:   $"+bmTipValue);
	}
	
	//Custom tip amount event handler
	public void displayCustomPrcnt(View v){
		String tipString = etTipAmount.getText().toString();
		EditText customTip = (EditText) findViewById(R.id.evCustomTip);
		try {
			double customTipAmount = 
					Integer.parseInt(customTip.getText().toString()) / 100.0;
			tipValue = Double.parseDouble(tipString) * customTipAmount;
			BigDecimal bmTipValue = new BigDecimal(tipValue).setScale(2, BigDecimal.ROUND_HALF_UP);
			tvDisplayTip.setText("Tip is:   $"+bmTipValue);
		}
		catch (NumberFormatException e){
			tvDisplayTip.setText("Select or enter valid tip amount");
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calcuate, menu);
		return true;
	}

}
