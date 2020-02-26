package co.com.todo1.kardex.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.interfaces.IProductSvc;
import co.com.todo1.kardex.abstracts.ASvc;
import co.com.todo1.kardex.pojo.ProductRequestPOJO;
import co.com.todo1.kardex.pojo.ProductResponsePOJO;
import co.com.todo1.kardex.utils.POJOUtils;
import co.com.todo1.procces.utils.InstaceSvc;
import co.com.todo1.utils.constants.StateResponse;

@RestController
@RequestMapping("products")
public class ProductSvc extends ASvc {
	private IProductSvc productSvc = InstaceSvc.getInstance(IProductSvc.class);
	
	@PostMapping("create")
	public ProductResponsePOJO add(@RequestBody ProductRequestPOJO product) {
		String user = "user get api-key";
		ProductResponsePOJO response = POJOUtils.convertReqToRespProduct(product);
		try {
			ProductDto productDto = new ProductDto();
			logger.info("Agregando registro "+productSvc);
			Boolean result = productSvc.add(productDto,user);
			response.setStatus(result?StateResponse.CONST_ANSWER_GOOD:null);
			logger.info("producto agregado correctamente.");
		}catch(NullPointerException e) {
			response.setStatus(i18n("err.productsvc.product.error.nullpointerexception"));
		}catch(RuntimeException e) {
			response.setStatus(e.getMessage());
			logger.error(e.getMessage());
		}catch(Exception e) {
			response.setStatus(e.getMessage());
			logger.error(e.getMessage());
		}
		return response;
	}
	
	@GetMapping("product/{reference}")
	public ProductResponsePOJO get(@PathVariable("reference") String refProduct) {
		String user = "user get api-key";
		ProductResponsePOJO response = new ProductResponsePOJO ();
		response.setReferences(refProduct);
		try {
			ProductDto result = productSvc.get(new ProductDto(refProduct),user);
			return POJOUtils.convertDtoToRespProduct(result);
		}catch(RuntimeException e) {
			response.setStatus(e.getMessage());
		}catch(Exception e) {
			response.setStatus(e.getMessage());
		}
		return response;
	}
	
	@GetMapping("products")
	public List<ProductResponsePOJO> getAll(){
		String user = "user get api-key";
		List<ProductResponsePOJO> listError = new ArrayList<>();
		try {
			List<ProductDto> list = productSvc.getAll(user);
			return (List<ProductResponsePOJO>)list.stream().map(POJOUtils::convertDtoToRespProduct);
		}catch(RuntimeException e) {
			listError.add(errorReturn(e, ProductResponsePOJO.class));
		}catch(Exception e) {
			listError.add(errorReturn(e, ProductResponsePOJO.class));
		}
		if(listError.size() == 0) {
			listError.add(errorReturn(i18n("warn.products.getallproduct.not.found"),ProductResponsePOJO.class));
		}
		return listError;
	}
	
	@PostMapping("adds")
	public List<ProductResponsePOJO> addAll(@RequestBody List<ProductRequestPOJO> list){
		String user = "user get api-key";
		List<ProductResponsePOJO> listResponse = new ArrayList<>();
		for(ProductRequestPOJO pojo : list) {
			ProductResponsePOJO out  = POJOUtils.convertReqToRespProduct(pojo);
			try {
				ProductDto productDto = POJOUtils.convertReqToDtoProduct(pojo);
				Boolean result = productSvc.add(productDto,user);
				out.setStatus(result?StateResponse.CONST_ANSWER_GOOD:null);
				listResponse.add(out);
			}catch(Exception e) {
				out.setStatus(e.getMessage());
				listResponse.add(out);
			}
		}
		return listResponse;
	}
	
}
