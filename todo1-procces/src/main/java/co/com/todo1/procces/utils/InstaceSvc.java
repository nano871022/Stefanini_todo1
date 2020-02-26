package co.com.todo1.procces.utils;

import co.com.todo1.interfaces.interfaces.IMovementsSvc;
import co.com.todo1.interfaces.interfaces.IProductSvc;
import co.com.todo1.interfaces.interfaces.ISummarySvc;
import co.com.todo1.interfaces.interfaces.IUserSvc;
import co.com.todo1.procces.MovementsSvc;
import co.com.todo1.procces.ProductSvc;
import co.com.todo1.procces.SummarySvc;
import co.com.todo1.procces.UserSvc;

public class InstaceSvc {
	
	@SuppressWarnings("unchecked")
	public static <I,O> O getInstance(I svc) {
		if(svc == IMovementsSvc.class) {
			return (O) new MovementsSvc();
		}
		if(svc == IProductSvc.class) {
			return (O) new ProductSvc();
		}
		if(svc == ISummarySvc.class) {
			return (O) new SummarySvc();
		}
		if(svc == IUserSvc.class) {
			return (O) new UserSvc();
		}
		return null;
	}

}
