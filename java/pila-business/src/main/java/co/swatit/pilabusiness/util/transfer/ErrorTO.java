package co.swatit.pilabusiness.util.transfer;

public class ErrorTO {
	
	private String code;
	
	private String messageError;
	
	private String functionFail;
	
	private String stackTrace;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public String getFunctionFail() {
		return functionFail;
	}

	public void setFunctionFail(String functionFail) {
		this.functionFail = functionFail;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

}
