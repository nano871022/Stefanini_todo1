package co.com.todo1.procces.utils;

import co.com.todo1.interfaces.interfaces.IMovementsSvc;
import co.com.todo1.interfaces.interfaces.IProductSvc;
import co.com.todo1.interfaces.interfaces.ISummarySvc;
import co.com.todo1.interfaces.interfaces.IUserSvc;
import co.com.todo1.procces.MovimientosSvc;
import co.com.todo1.procces.ProductosSvc;
import co.com.todo1.procces.ResumenesSvc;
import co.com.todo1.procces.UsuariosSvc;

public class InstaceSvc {
	
	@SuppressWarnings("unchecked")
	public static <I,O> O getInstance(I svc) {
		if(svc == IMovementsSvc.class) {
			return (O) new MovimientosSvc();
		}
		if(svc == IProductSvc.class) {
			return (O) new ProductosSvc();
		}
		if(svc == ISummarySvc.class) {
			return (O) new ResumenesSvc();
		}
		if(svc == IUserSvc.class) {
			return (O) new UsuariosSvc();
		}
		return null;
	}

}
