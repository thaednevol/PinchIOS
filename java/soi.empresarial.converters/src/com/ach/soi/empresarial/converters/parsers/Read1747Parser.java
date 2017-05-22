package com.ach.soi.empresarial.converters.parsers;

import java.io.IOException;
import java.io.Reader;

import org.beanio.stream.RecordIOException;
import org.beanio.stream.RecordReader;
import org.beanio.stream.fixedlength.FixedLengthRecordParserFactory;

public class Read1747Parser extends FixedLengthRecordParserFactory {
	
	
	private Integer recordTp01Length;
	private Integer recordTp02Length;
	private Integer recordTp03Length;
	private Integer recordTp04Length;
	private Integer recordTp05Length;
	private Integer recordTp06Length;
	private Integer recordTp07Length;
	private Integer recordTp08Length;
	private Integer recordTp09Length;
	private Integer recordTp10Length;
	private Integer recordTp11Length;
	
    
    @Override
    public RecordReader createReader(Reader in) throws IllegalArgumentException {
        final RecordReader reader = super.createReader(in);
        return new RecordReader() {
            public Object read() throws IOException, RecordIOException {
                String record = (String) reader.read();                
                if (record != null) {
                	String firstChars = record.substring(0, 2);
                	try{
                		Integer recordType = Integer.valueOf(firstChars);
                		int recordLenght = 0;
                		switch (recordType) {
						case 1:
							recordLenght = recordTp01Length;
							break;
						case 2:
							recordLenght = recordTp02Length;
							break;
						case 3:
							recordLenght = recordTp03Length;
							break;
						case 4:
							recordLenght = recordTp04Length;
							break;

						case 5:
							recordLenght = recordTp05Length;
							break;

						case 6:
							recordLenght = recordTp06Length;
							break;

						case 7:
							recordLenght = recordTp07Length;
							break;

						case 8:
							recordLenght = recordTp08Length;
							break;

						case 9:
							recordLenght = recordTp09Length;
							break;

						case 10:
							recordLenght = recordTp10Length;
							break;

						case 11:
							recordLenght = recordTp11Length;
							break;
						default:
							return record;
						}
                		
                		record = pad(record,recordLenght);
                	}catch ( Exception e ){
                		e.printStackTrace();
                		return record;
                	}
                }
                return record;
            }
            public void close() throws IOException {
                reader.close();
            }
            public int getRecordLineNumber() {
                return reader.getRecordLineNumber();
            }
            public String getRecordText() {
                return reader.getRecordText();
            }
        };
    }
    
    private String pad(String record, int recordLength) {
            	
    	
        int n = recordLength - record.length();
        if (n <= 0) {
            return record;
        }
        StringBuilder s = new StringBuilder(record);
        for (int i=0; i<n; i++) {
            s.append(' ');
        }
        
        return s.toString();
    }

	public Integer getRecordTp01Length() {
		return recordTp01Length;
	}

	public void setRecordTp01Length(Integer recordTp01Length) {
		this.recordTp01Length = recordTp01Length;
	}

	public Integer getRecordTp02Length() {
		return recordTp02Length;
	}

	public void setRecordTp02Length(Integer recordTp02Length) {
		this.recordTp02Length = recordTp02Length;
	}

	public Integer getRecordTp03Length() {
		return recordTp03Length;
	}

	public void setRecordTp03Length(Integer recordTp03Length) {
		this.recordTp03Length = recordTp03Length;
	}

	public Integer getRecordTp04Length() {
		return recordTp04Length;
	}

	public void setRecordTp04Length(Integer recordTp04Length) {
		this.recordTp04Length = recordTp04Length;
	}

	public Integer getRecordTp05Length() {
		return recordTp05Length;
	}

	public void setRecordTp05Length(Integer recordTp05Length) {
		this.recordTp05Length = recordTp05Length;
	}

	public Integer getRecordTp06Length() {
		return recordTp06Length;
	}

	public void setRecordTp06Length(Integer recordTp06Length) {
		this.recordTp06Length = recordTp06Length;
	}

	public Integer getRecordTp07Length() {
		return recordTp07Length;
	}

	public void setRecordTp07Length(Integer recordTp07Length) {
		this.recordTp07Length = recordTp07Length;
	}

	public Integer getRecordTp08Length() {
		return recordTp08Length;
	}

	public void setRecordTp08Length(Integer recordTp08Length) {
		this.recordTp08Length = recordTp08Length;
	}

	public Integer getRecordTp09Length() {
		return recordTp09Length;
	}

	public void setRecordTp09Length(Integer recordTp09Length) {
		this.recordTp09Length = recordTp09Length;
	}

	public Integer getRecordTp10Length() {
		return recordTp10Length;
	}

	public void setRecordTp10Length(Integer recordTp10Length) {
		this.recordTp10Length = recordTp10Length;
	}

	public Integer getRecordTp11Length() {
		return recordTp11Length;
	}

	public void setRecordTp11Length(Integer recordTp11Length) {
		this.recordTp11Length = recordTp11Length;
	}

    
}
