package com.ach.soi.empresarial.converters.error;

import java.util.ArrayList;
import java.util.Collection;

import org.beanio.BeanReaderErrorHandler;
import org.beanio.BeanReaderException;
import org.beanio.InvalidRecordException;

import com.ach.soi.empresarial.converters.model.ErrorValidacionTO;

public class ErrorHandlerReader2145 implements BeanReaderErrorHandler {

	private Collection<ErrorValidacionTO> errors = new ArrayList<ErrorValidacionTO>();
	
	@Override
	public void handleError(BeanReaderException exc) throws Exception {
ErrorValidacionTO errorTo = null;
		
		if ( exc instanceof InvalidRecordException ){
			for ( String key:exc.getRecordContext().getFieldErrors().keySet()){
				Collection<String> errorsTxt = exc.getRecordContext().getFieldErrors(key);
				for ( String error:errorsTxt ){
					errorTo = new ErrorValidacionTO();
					errorTo.setCampo(key);
					errorTo.setDetalleError(error);
					errorTo.setError(error);				
					errorTo.setLinea(exc.getRecordContext().getLineNumber());
					errors.add(errorTo);
				}
			}
			for ( String err:exc.getRecordContext().getRecordErrors() ){
				errorTo = new ErrorValidacionTO();
				errorTo.setCampo("-");
				errorTo.setDetalleError(err);
				errorTo.setError(err);				
				errorTo.setLinea(exc.getRecordContext().getLineNumber());
				errors.add(errorTo);
			}
		}
		else{
			for ( String error:exc.getRecordContext().getRecordErrors() ){
				errorTo = new ErrorValidacionTO();
				errorTo.setCampo("-");
				errorTo.setDetalleError(error);
				errorTo.setError(error);				
				errorTo.setLinea(exc.getRecordContext().getLineNumber());
				errors.add(errorTo);
			}
		}
	}

	public Collection<ErrorValidacionTO> getErrors ( ){
		return this.errors;
	}	
	
	public int getErrorCount(){
		return this.errors.size();
	}
	
	public boolean haveErrors ( ){
		return !this.errors.isEmpty();
	}
}
