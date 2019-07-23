package in.tp.scd.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import in.tp.scd.service.Conversion;

@Service("gs")

public class ConversionServiceImp implements Conversion {
	
	@Value("#{${denomination}}")
	private  HashMap<String,Double > hash_map ; 


	public ConversionServiceImp( ) {}

public String CovertOperation(Double denomination_input,String fromCurrency , String toCurrency) {

	Double frmcurrency = hash_map.get(fromCurrency);
	Double tocurrency  = hash_map.get(toCurrency);
	
	Double value = ((denomination_input * frmcurrency) / tocurrency);
	return denomination_input.toString()+fromCurrency+ " = "+ value.toString() +toCurrency ;
}


}
