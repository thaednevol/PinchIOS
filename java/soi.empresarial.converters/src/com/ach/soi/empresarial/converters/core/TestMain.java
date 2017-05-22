package com.ach.soi.empresarial.converters.core;

import com.ach.soi.empresarial.converters.model.ErrorLiquidacionTO;
import com.ach.soi.empresarial.converters.model.RegistroErrorTO;
import com.google.gson.Gson;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegistroErrorTO[] erroresTest = new RegistroErrorTO[2];
		erroresTest[0] = new RegistroErrorTO();
		erroresTest[1] = new RegistroErrorTO();
		for ( RegistroErrorTO e:erroresTest ){
			for ( int i=0;i<2;i++ ){
				e.getErrores()[i]=new ErrorLiquidacionTO();
			}
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(erroresTest);
		System.out.println(json);
	}

}
